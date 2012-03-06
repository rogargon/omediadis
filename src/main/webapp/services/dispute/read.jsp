<%@page pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.io.StringReader"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Formatter"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URI"%>
<%@page import="com.hp.hpl.jena.rdf.model.*"%>
<%@page import="com.hp.hpl.jena.rdf.model.impl.*"%>
<%@page import="com.hp.hpl.jena.query.*"%>
<%@page import="com.hp.hpl.jena.vocabulary.*"%>
<%@page import="com.hp.hpl.jena.query.ResultSet"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.StringWriter"%>
<%@page import="javax.xml.transform.stream.StreamResult"%>
<%@page import="javax.xml.transform.stream.StreamSource"%>
<%@page import="javax.xml.transform.Transformer"%>
<%@page import="javax.xml.transform.TransformerFactory"%>
<% 
	request.setCharacterEncoding("UTF-8");
	
	final Resource Agree = new ResourceImpl("http://rhizomik.net/ontologies/2009/09/copyrightonto.owl#Agree");
	final Resource Disagree = new ResourceImpl("http://rhizomik.net/ontologies/2009/09/copyrightonto.owl#Disgree");
	final String querySelectAgreesDisagrees = 
		"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" +
		"PREFIX co:  <http://rhizomik.net/ontologies/2009/09/copyrightonto.owl#>\r\n" + 
		"PREFIX msp: <http://rhizomik.net/ontologies/2011/06/mspontology.owl#> \r\n" + 
		"SELECT ?action \n" +
		"WHERE \n" +
		"{ \n" + 
		"	?action a ?type \n" + 
		"	FILTER(?type = co:Agree || ?type = co:Disagree) \n" + 
		"}";
	final String queryTemplateDescribePatterns = 
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" +
    		"PREFIX co:  <http://rhizomik.net/ontologies/2009/09/copyrightonto.owl#>\r\n" + 
    		"PREFIX msp: <http://rhizomik.net/ontologies/2011/06/mspontology.owl#> \r\n" + 
    		"DESCRIBE ?pattern \n" +
    		"WHERE \n" +
    		"{ \n" + 
    		"	<%1$s> co:theme ?pattern. \n" +
    		"	FILTER(!isBlank(?pattern)) \n" + 
    		"}";
	
    StringWriter result = new StringWriter();
    		
	Model model = ModelFactory.createMemModelMaker().createDefaultModel();
	try { model.read(request.getInputStream(), ""); }
	catch (Exception e) { System.out.println(e.toString()); }

	Query query = QueryFactory.create(querySelectAgreesDisagrees, Syntax.syntaxARQ);
	QueryExecution qexec = QueryExecutionFactory.create(query, model);
	ResultSet results = qexec.execSelect();
	while (results.hasNext())
	{
	    String actionURI = results.next().getResource("action").getURI();
	    StringBuilder queryString = new StringBuilder();
	    Formatter f = new Formatter(queryString);
	    Object[] vars = {actionURI};
	    f.format(queryTemplateDescribePatterns, vars);
	    
	    URL requestURL = new URL(request.getRequestURL().toString());
	    URL sparqlQuery = new URL(requestURL.getProtocol()+"://"+requestURL.getHost()+
		    (requestURL.getPort()>0?":"+requestURL.getPort():"")+
		    request.getContextPath()+
		    "/?query="+URLEncoder.encode(queryString.toString()));
		URLConnection conn = sparqlQuery.openConnection();
		conn.setRequestProperty("accept", "application/rdf+xml");
		try { model.read(conn.getInputStream(), ""); }
		catch (Exception e) { System.out.println(e.toString()); }
	}
	
	ByteArrayOutputStream stringOut = new ByteArrayOutputStream();
	model.write(stringOut, "RDF/XML-ABBREV");
	stringOut.flush();

	TransformerFactory factory = TransformerFactory.newInstance();

	String jspPath = request.getPathInfo();
	String folderPath = jspPath.substring(0,jspPath.lastIndexOf('/'));
	String realPath = getServletConfig().getServletContext().getRealPath(folderPath);
    FileInputStream license2text = new FileInputStream(realPath + "/license2text.xsl");
	Transformer transformer = factory.newTransformer(new StreamSource(license2text));
	
	StreamSource inStream = new StreamSource(new StringReader(stringOut.toString()));
	StreamResult outStream = new StreamResult(result);
	
	transformer.setParameter("base", request.getContextPath()+folderPath+"/");
	//if (language!=null) transformer.setParameter("language", language);

	transformer.transform(inStream, outStream);
%>
<%= result.toString() %>
