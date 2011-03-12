package cat.udl.omediadis.annotator.writer;

import cat.udl.omediadis.annotator.metadata.ContentMetadata;
import cat.udl.omediadis.annotator.metadata.MP3Metadata;

public class MP3RDFWriter
{
    public static String write(ContentMetadata metadata) 
    {
        MP3Metadata mP3Metadata = (MP3Metadata) metadata;
        String rdfxml = "<?xml version='1.0'?>"+
                "<rdf:RDF xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#' xmlns:dc='http://purl.org/dc/elements/1.1/' xmlns:ma='http://www.w3.org/ns/ma-ont'>"+
                    "<rdf:Description>";
                    
        rdfxml += mP3Metadata.getCreator()!=null?"<dc:creator>"+ mP3Metadata.getCreator() +"</dc:creator>":"";
        rdfxml += mP3Metadata.getContributor()!=null?"<dc:contributor>"+ mP3Metadata.getContributor() +"</dc:contributor>":"";
        rdfxml += mP3Metadata.getPublisher()!=null?"<dc:publisher>"+ mP3Metadata.getPublisher() +"</dc:publisher>":"";
        rdfxml += mP3Metadata.getGenre()!=null?"<dc:subject>"+ mP3Metadata.getGenre() +"</dc:subject>":"";
        rdfxml += mP3Metadata.getDescription()!=null?"<dc:description>"+ mP3Metadata.getDescription() +"</dc:description>":"";
        rdfxml += mP3Metadata.getRelationLink()!=null?"<dc:relation>"+ mP3Metadata.getRelationLink() +"</dc:relation>":"";
        rdfxml += mP3Metadata.getRelationApic()!=null?"<dc:relation>"+ mP3Metadata.getRelationApic() +"</dc:relation>":"";
        rdfxml += mP3Metadata.getCopyright()!=null?"<dc:rights>"+ mP3Metadata.getCopyright() +"</dc:rights>":"";
        rdfxml += mP3Metadata.getFormat()!=null?"<dc:format>"+ mP3Metadata.getFormat() +"</dc:format>":"";
        rdfxml += mP3Metadata.getTitle()!=null?"<dc:title>"+ mP3Metadata.getTitle() +"</dc:title>":"";
        rdfxml += mP3Metadata.getCreateDate()!=null?"<dc:date>"+ mP3Metadata.getCreateDate() +"</dc:date>":"";
        rdfxml += mP3Metadata.getLanguage()!=null?"<dc:language>"+ mP3Metadata.getLanguage() +"</dc:language>":"";
                    
        rdfxml += mP3Metadata.getRating()!=null?"<ma:rating>"+ mP3Metadata.getRating() +"</ma:rating>":"";
        rdfxml += mP3Metadata.getCollection()!=null?"<ma:collection>"+ mP3Metadata.getCollection() +"</ma:collection>":"";
        rdfxml += mP3Metadata.getLicense()!=null?"<ma:license>"+ mP3Metadata.getLicense() +"</ma:license>":"";
        rdfxml += mP3Metadata.getCompression()!=null?"<ma:compression>"+ mP3Metadata.getCompression() +"</ma:compression>":"";
        rdfxml += mP3Metadata.getDuration()!=null?"<ma:duration>"+ mP3Metadata.getDuration() +"</ma:duration>":"";
        rdfxml += mP3Metadata.getSamplingRate()!=null?"<ma:samplingrate>"+ mP3Metadata.getSamplingRate() +"</ma:samplingrate>":"";
        rdfxml += mP3Metadata.getBitRate()!=null?"<ma:bitrate>"+ mP3Metadata.getBitRate() +"</ma:bitrate>":"";
        rdfxml += mP3Metadata.getNumTracks()!=null?"<ma:numTracks>"+ mP3Metadata.getNumTracks() +"</ma:numTracks>":"";
                    		
        rdfxml += "</rdf:Description>"+
                "</rdf:RDF>";
        return rdfxml;
    }
}
