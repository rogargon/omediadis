// SemDRMS - Semantic Digital Rights Management System
// Instantiation Test

package cat.udl.omediadis.semdrms;

import java.util.Iterator;

import org.mindswap.pellet.jena.PelletReasonerFactory;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.reasoner.ValidityReport;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

/**
 * @author http://rhizomik.net/~roberto
 */
public class InstantiationTest 
{
	private static final String LICENSESF = "file:diffusion.lic.owl";
	private static final String CPR_NS = "http://rhizomik.net/ontologies/2006/01/copyrightonto.owl#";
	
	public static void main(String[] args) 
	{
		String file = LICENSESF;
		if (args.length > 0)
            file = args[1];
		
		System.out.println("Checking instaces for classes in: "+file);
		System.out.println("...");	
		System.out.println();
		doTest(file);
	}
	
	public static void doTest(String file)
	{
		OntModel model = ModelFactory.createOntologyModel(PelletReasonerFactory.THE_SPEC);
		model.read(file);

		ValidityReport report = model.validate();
		System.out.print("The ontology is ");
		if (report.isValid()) 
		{
			System.out.println("valid.");
			System.out.println();
			
			for(ExtendedIterator it = model.listClasses(); it.hasNext();)
			{
				Resource r = (Resource)it.next();
				OntClass c = (OntClass)r.as(OntClass.class);
				if (c.hasSuperClass(model.getResource(CPR_NS+"Copy")) &&
					c.isAnon() == false && !c.getLocalName().equals("Nothing"))
					printIterator(c.listInstances(), "All instances of " + c.getLocalName());
			}
		}
		else 
		{
			System.out.println("invalid.");
			printIterator(report.getReports(), "Validation Results");
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
				System.out.println( ((Resource)i.next()).getLocalName() );
		}       
		else
			System.out.println("<EMPTY>");
		System.out.println();
	}
}