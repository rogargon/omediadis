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
	
	final String queryTemplate = 
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" +
    		"PREFIX co:  <http://rhizomik.net/ontologies/2009/09/copyrightonto.owl#>\r\n" + 
    		"PREFIX msp: <http://rhizomik.net/ontologies/2011/06/mspontology.owl#> \r\n" + 
    		"DESCRIBE <%1$s> ?agreement \n" +
    		"WHERE \n" +
    		"{ \n" + 
    		"	?agreement rdf:type co:Agree; \n" + 
    		"		co:theme <%1$s>. \n" +  
    		"}";
	
    StringBuilder queryString = new StringBuilder();
    Formatter f = new Formatter(queryString);
    Object[] vars = {request.getParameter("dealID")};
    f.format(queryTemplate, vars);
    
    URL requestURL = new URL("http://ec2-50-19-239-247.compute-1.amazonaws.com:8080/rhizomer/" +
	    	"?query=" + URLEncoder.encode(queryString.toString(), "UTF-8"));
    
	URLConnection conn = requestURL.openConnection();
	conn.setRequestProperty("accept", "application/rdf+xml");
	Model model = ModelFactory.createMemModelMaker().createDefaultModel();
	try { model.read(conn.getInputStream(), ""); }
	catch (Exception e) { System.out.println(e.toString()); }
	ByteArrayOutputStream stringOut = new ByteArrayOutputStream();
	model.write(stringOut, "RDF/XML-ABBREV");
	stringOut.flush();
	
	StringWriter result = new StringWriter();
	TransformerFactory factory = TransformerFactory.newInstance();

	String jspPath = request.getPathInfo();
	String folderPath = jspPath.substring(0,jspPath.lastIndexOf('/'));
	String realPath = getServletConfig().getServletContext().getRealPath(folderPath);
    FileInputStream license2text = new FileInputStream(realPath + "/license2text.xsl");
	Transformer transformer = factory.newTransformer(new StreamSource(license2text));
	
	StreamSource inStream = new StreamSource(new StringReader(stringOut.toString()));
	StreamResult outStream = new StreamResult(result);
	
	transformer.setParameter("base", request.getContextPath()+folderPath+"/");

	transformer.transform(inStream, outStream);

%>
<%= result.toString() %>
