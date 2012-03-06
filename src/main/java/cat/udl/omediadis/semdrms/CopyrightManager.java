package cat.udl.omediadis.semdrms;

import java.io.InputStream;
import java.io.StringReader;
import java.net.URI;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.mindswap.pellet.jena.PelletReasonerFactory;

import com.hp.hpl.jena.ontology.AllDifferent;
import com.hp.hpl.jena.ontology.IntersectionClass;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.Restriction;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.ModelMaker;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;

/**
 * @author  : http://rhizomik.net/~roberto
 */
public class CopyrightManager 
{
	static String coURL = "http://rhizomik.net/ontologies/2008/05/copyrightonto.owl";
	static String coFile = "file:ontologies/copyrightonto.owl";	
	private OntModel model = null;
	
	public CopyrightManager()
	{
		Logger.getRootLogger().setLevel(Level.ERROR);
        model = ModelFactory.createOntologyModel(PelletReasonerFactory.THE_SPEC);
        model.getDocumentManager().addAltEntry(coURL, coFile);
        model.read(coURL);
	}
	
	public boolean checkUse(String useURI)
	{
		StringBuilder queryString = new StringBuilder();
		Formatter f = new Formatter(queryString, Locale.ENGLISH);
		Object[] vars = {"ASK", useURI};
		f.format(queryPattern, vars);
		Query query = QueryFactory.create(queryString.toString());
		QueryExecution qexec = QueryExecutionFactory.create(query, model) ;		
		return qexec.execAsk();
	}
	
	public void registerAction(InputStream rdf)
	{
		model.read(rdf, "");
	}
	
	public void loadLicense(InputStream rdf)
	{
		OntModel tmp = ModelFactory.createOntologyModel();
		tmp.read(rdf, "");
		
		//Get all license pattern definitions
		for(ResIterator c = tmp.listSubjectsWithProperty(OWL.equivalentClass); c.hasNext();)
		{
			OntClass pattern = (OntClass)c.nextResource().as(OntClass.class);
			OntClass equivalent = (OntClass)pattern.getPropertyValue(OWL.equivalentClass).as(OntClass.class);
			if (equivalent.canAs(IntersectionClass.class))
			{
				IntersectionClass intersection = (IntersectionClass)equivalent.as(IntersectionClass.class);
				AndNotPattern andNot = new AndNotPattern(pattern, tmp);
				for(ExtendedIterator i = intersection.listOperands(); i.hasNext();)
				{
					OntClass n = (OntClass)i.next();
					if (n.canAs(Restriction.class))
					{
						Restriction restr = (Restriction)n.as(Restriction.class);
						if (restr.isMaxCardinalityRestriction())
							andNot.addMaxCardinality(restr, intersection);
						else if (restr.isAllValuesFromRestriction())
						{
							// The transformation is not necessary if the AllValuesFromRestriction is on a FunctionalProperty
							String uri = restr.getPropertyValue(OWL.onProperty).toString();
							if (!model.getOntProperty(uri).isFunctionalProperty())
								andNot.addAllValues(restr, intersection);
						}
					}
				}
			}
		}
		//tmp.write(System.out, "RDF/XML-ABBREV");
		model.add(tmp);
		
		AllDifferent diff = model.createAllDifferent();
		diff.addDistinctMembers(model.listIndividuals());
	}
	
	public OntModel getOntModel()
	{
		return model;
	}
	
	static private String NL = System.getProperty("line.separator");
	
	// SPARQL query pattern for use checking, 1st object "ASK" or "SELECT...FROM", 2nd use URI
	private static String queryPattern = 
		"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " + NL +  
		"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " + NL +
		"PREFIX owl: <http://www.w3.org/2002/07/owl#> " + NL +
        "PREFIX co:  <http://rhizomik.net/ontologies/2008/05/copyrightonto.owl#> " + NL +
		"%1$s { " + NL +
		"     ?agreement rdf:type co:Agree; " + NL +
		"          co:theme ?pattern. " + NL +
		"     <%2$s> rdf:type ?pattern; " + NL + 
		"          co:agent ?consumer. "+ NL + 
		"     ?pattern co:condition ?conditionPattern. " + NL +
		"     ?condition rdf:type ?conditionPattern;" + NL +
		"          co:agent ?consumer;" + NL +
		"          co:aim <%2$s>. " + NL +
		"     OPTIONAL { " + NL +
		"          ?pattern co:andNot ?andNotPattern. " + NL +
		"          <%2$s> rdf:type ?andNotPattern. }"+ NL +
		"     FILTER (!BOUND(?andNotPattern))"+ NL +
		" }";
	
	// Debug functions...
	
	// Debug how the query is resolved (get variable matchings)
	public void debugCheckUse(String useURI)
	{
		StringBuilder queryString = new StringBuilder();
		Formatter f = new Formatter(queryString, Locale.ENGLISH);
		Object[] vars = {"SELECT * WHERE", useURI};
		f.format(queryPattern, vars);
		Query queryS = QueryFactory.create(queryString.toString());
		QueryExecution qexecS = QueryExecutionFactory.create(queryS, model);
		System.out.println("\nResults for SPARQL query:");
		ResultSetFormatter.out(qexecS.execSelect());
		System.out.println("\n");		
	}

    // Demo differences between raw and inference models...
	public void debugPatternsInstances()
	{
		for (ResIterator agrees = model.listSubjectsWithProperty(RDF.type, model.getResource(coURL+"#Agree")); 
			 agrees.hasNext();)
		{
			Resource agree = agrees.nextResource();
			System.out.println("\nFor agreement "+agree+"...\n");
			for (NodeIterator agreePatterns = model.listObjectsOfProperty(agree, model.getProperty(coURL+"#theme")); agreePatterns.hasNext();)
			{
				OntClass agreePattern = (OntClass)agreePatterns.nextNode().as(OntClass.class);
				printIterator(agreePattern.listInstances(), "...instances of agree pattern " + agreePattern.getLocalName());
				OntClass andNotPattern = (OntClass)agreePattern.getPropertyValue(model.getProperty(coURL+"#andNot")).as(OntClass.class);
				printIterator(andNotPattern.listInstances(), "...instances of and not pattern " + andNotPattern.getLocalName()+" in inference model");
				OntClass conditionPattern = (OntClass)agreePattern.getPropertyValue(model.getProperty(coURL+"#condition")).as(OntClass.class);
				printIterator(conditionPattern.listInstances(), "...instances of condition pattern " + conditionPattern.getLocalName()+" in inference model");
			}
		}
	}
	
	public static void printIterator(Iterator i, String header) 
	{
        System.out.println(header);
        for(int c = 0; c < header.length(); c++)
            System.out.print("=");
        System.out.println();
        
        if(i.hasNext()) {
	        while (i.hasNext()) 
	            System.out.println( i.next() );
        }       
        else
            System.out.println("<EMPTY>");
        
        System.out.println();
    }
}
