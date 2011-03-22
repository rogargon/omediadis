package cat.udl.omediadis.annotator.readers;

import java.io.File;

import org.apache.commons.fileupload.FileItem;

import cat.udl.omediadis.annotator.metadata.ContentMetadata;

public abstract class Reader 
{
    public static Reader getReader(String contenttype) throws InstantiationException, IllegalAccessException
    {
    	Reader reader = null;
        if ("image/jpeg".equals(contenttype))
        	reader = JPEGReader.class.newInstance();
        else if ("audio/mp3".equals(contenttype) || "audio/mpeg".equals(contenttype))
        	reader = MP3Reader.class.newInstance();
        return reader;
    }
    
    public abstract ContentMetadata readMetadata(File f) throws Exception;

    public abstract ContentMetadata readMetadata(FileItem item);
}
