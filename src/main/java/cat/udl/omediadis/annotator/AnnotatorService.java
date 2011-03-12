package cat.udl.omediadis.annotator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cat.udl.omediadis.annotator.metadata.ContentMetadata;
import cat.udl.omediadis.annotator.readers.Reader;
import cat.udl.omediadis.annotator.writer.MP3RDFWriter;

@SuppressWarnings("serial")
public class AnnotatorService extends HttpServlet 
{
    @Override
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    PrintWriter out = response.getWriter();
	    
        // Set the size threshold, above which content will be stored on disk, 
        // and the temporary directory to store these uploaded files
	    DiskFileItemFactory  fileItemFactory = new DiskFileItemFactory ();
	    fileItemFactory.setSizeThreshold(1*1024*1024); //1 MB
	    //fileItemFactory.setRepository(tmpDir);

	    ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
	    try
	    {
	    	List<FileItem> items = uploadHandler.parseRequest(request);
	    	Iterator<FileItem> itr = items.iterator();
	    	while(itr.hasNext()) 
	    	{
	    		FileItem item = itr.next();
	    		if(!item.isFormField()) 
	    		{
	    			//File file = new File(destinationDir, item.getName());
	    			String contenttype = item.getContentType();
	    			Reader reader = Reader.getReader(contenttype);
	    			ContentMetadata metadata = reader.readMetadata(item);
	    			String rdfxml = MP3RDFWriter.write(metadata);

	    			response.setContentType("application/rdf+xml");
	    			out.println(rdfxml);
	    		}
	    		out.close();
	    	}
	    }
	    catch (Exception e)
	    { throw new ServletException(e); }
	}
    
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException
	{
    	String fileOrDir = null;
    	if (args.length > 0)
			fileOrDir = args[0];  
		
    	System.out.println("Processing metadata from "+fileOrDir);
        File fod = new File(fileOrDir);
        
        File[] files = {fod};
        if (fod.isDirectory())
        	files = fod.listFiles();
        	
        for (File f: files) 
        {
        	String contenttype = "audio/mp3";
			Reader reader = Reader.getReader(contenttype);
			ContentMetadata metadata = reader.readMetadata(f);
			String rdfxml = MP3RDFWriter.write(metadata);

			System.out.println(rdfxml);
			//FileWriter fw = new FileWriter(new File(f.getParent(), f.getName()+".rdf"));
			//BufferedWriter bw = new BufferedWriter(fw);
			//bw.write(rdfxml);
		}
	}
}
