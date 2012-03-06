package cat.udl.omediadis.semdrms;

import com.hp.hpl.jena.ontology.AllValuesFromRestriction;
import com.hp.hpl.jena.ontology.IntersectionClass;
import com.hp.hpl.jena.ontology.MaxCardinalityRestriction;
import com.hp.hpl.jena.ontology.MinCardinalityRestriction;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.Restriction;
import com.hp.hpl.jena.ontology.SomeValuesFromRestriction;
import com.hp.hpl.jena.ontology.UnionClass;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFList;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * @author  : http://rhizomik.net/~roberto
 */
public class AndNotPattern 
{
	private OntModel model = null;
	private OntClass andNotPattern = null;
	private UnionClass andNotUnion = null;
	private OntClass pattern = null;
	
	public AndNotPattern(OntClass pattern, OntModel model) 
	{
		this.pattern = pattern;
		this.model = model;
	}
	
	public void addMaxCardinality(Restriction restr, IntersectionClass intersection)
	{
		MaxCardinalityRestriction maxRestr = restr.asMaxCardinalityRestriction();
		int card = maxRestr.getMaxCardinality();
		
		maxRestr.removeMaxCardinality(card);
		MinCardinalityRestriction minRestr = maxRestr.convertToMinCardinalityRestriction(card+1);
		
		intersection.removeOperand(maxRestr);
		
		if (andNotPattern == null)
			initAndNotPattern();
		
		andNotUnion.addOperand(minRestr);
	}
	
	public void addAllValues(Restriction restr, IntersectionClass intersection)
	{
		AllValuesFromRestriction allRestr = restr.asAllValuesFromRestriction();
		Resource all = allRestr.getAllValuesFrom();
				
		OntClass notAll = model.createComplementClass(null, all);
		
		allRestr.removeAllValuesFrom(all);
		SomeValuesFromRestriction someRestr = 
			allRestr.convertToSomeValuesFromRestriction(notAll);
		
		intersection.removeOperand(allRestr);
		
		if (andNotPattern == null)
			initAndNotPattern();
		
		andNotUnion.addOperand(someRestr);
	}
	
	private void initAndNotPattern()
	{
		//Create the class for the AndNotPattern
		andNotPattern = model.createClass(pattern.getURI()+"AndNot");
		//The AndNotPattern is the intersection of Pattern and ...
		RDFList listIntersection = model.createList();
		IntersectionClass andNotIntersection = model.createIntersectionClass(null, listIntersection);
		andNotIntersection.addOperand(pattern);
		//the union of all the maxCardinality and allValuesFrom transformed in order to avoid OWA
		RDFList listUnion = model.createList();
		andNotUnion = model.createUnionClass(null, listUnion);
		andNotIntersection.addOperand(andNotUnion);
		//The AndNotPattern is equivalent to that intersection
		andNotPattern.addEquivalentClass(andNotIntersection);
		//Link AndNotPattern to the Pattern
		Property andNot = model.getProperty("http://rhizomik.net/ontologies/2008/05/copyrightonto.owl#andNot");
		pattern.addProperty(andNot, andNotPattern);
	}
}
