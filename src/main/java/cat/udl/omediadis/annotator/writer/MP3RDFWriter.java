package cat.udl.omediadis.annotator.writer;

import cat.udl.omediadis.annotator.metadata.ContentMetadata;
import cat.udl.omediadis.annotator.metadata.MP3Metadata;

public class MP3RDFWriter
{
	public static String writeOMediaDis(ContentMetadata metadata)
	{
        MP3Metadata meta = (MP3Metadata) metadata;
        String name = meta.getFilename().substring(0, meta.getFilename().indexOf('.'));
		String triples = 
				"@prefix rdf:	<http://www.w3.org/1999/02/22-rdf-syntax-ns#> .\n" + 
				"@prefix owl:	<http://www.w3.org/2002/07/owl#> .\n" + 
				"@prefix rdfs:	<http://www.w3.org/2000/01/rdf-schema#> .\n" + 
				"@prefix dc:		<http://purl.org/dc/elements/1.1/> .\n" + 
				"@prefix ical:	<http://www.w3.org/2002/12/cal/icaltzd#> .\n" + 
				"@prefix co:		<http://rhizomik.net/ontologies/2009/09/copyrightonto.owl#> .\n" + 
				"@prefix ma:		<http://www.w3.org/ns/ma-ont#> .\n" + 
				"\n" + 
				"<http://omediadis.udl.cat/segre/radio/bulletin/"+name+"/>\n" + 
				"	rdf:type 		co:Communication ;\n" + 
				"	rdfs:label		\""+meta.getTitle()+"\" ;\n" + 
				"	dc:title		\""+meta.getTitle()+"\" ;\n" + 
				"	dc:date			\""+meta.getCreateDate()+"\" ;\n" + 
				"	dc:creator		<"+meta.getCreator()+"> ;\n" + 
				"	dc:language 	\"ca\" ;\n" + 
				"	co:hasRecording	<http://omediadis.udl.cat/segre/recording/bulletin/"+name+"/> .\n" + 
				"\n" + 
				"<http://omediadis.udl.cat/segre/recording/bulletin/"+name+"/>\n" + 
				"	rdf:type 		co:Recording ;\n" + 
				"	rdfs:label		\"Recording of "+meta.getTitle()+"\" ;\n" + 
				"	dc:title		\"Recording of "+meta.getTitle()+"\" ;\n" + 
				"	dc:creator		<"+meta.getCreator()+"> ;\n" + 
				"	dc:language 	\"ca\" ;\n" + 
				"	ma:hasAudioDescription	<http://omediadis.udl.cat/segre/text/bulletin/"+name+".xml> ;\n" + 
				"	co:hasInstance	<http://omediadis.udl.cat/segre/audio/bulletin/"+name+".mp3> .\n" + 
				"\n" + 
				"<http://omediadis.udl.cat/segre/text/bulletin/"+name+".xml>\n" + 
				"	rdf:type		ma:DataTrack ;\n" + 
				"	rdfs:label		\"Transcript of "+meta.getTitle()+"\" ;\n" + 
				"	dc:title		\"Transcript of "+meta.getTitle()+"\" ;\n" + 
				"	dc:creator		<"+meta.getCreator()+"> ;\n" + 
				"	dc:language 	\"ca\" .\n" + 
				"\n" + 
				"<http://omediadis.udl.cat/segre/audio/bulletin/"+name+".mp3>\n" + 
				"	rdf:type		ma:AudioTrack ;\n" + 
				"	rdfs:label		\"MP3 Copy of "+meta.getTitle()+"\" ;\n" + 
				"	dc:title		\"MP3 Copy of "+meta.getTitle()+"\" ;\n" + 
				"	dc:creator		<"+meta.getCreator()+"> ;\n" + 
				"	dc:language 	\"ca\" ;\n" + 
				"	dc:format		\"audio/mpeg\" ;\n" + 
				"	ma:bitrate  	\""+meta.getBitRate()+"\" ;\n" + 
				"	ma:duration 	\"PT00:"+meta.getDuration()+"\" ;\n" + 
				"	ma:samplingrate \""+meta.getSamplingRate()+"\" .";
		return triples;
	}
    public static String write(ContentMetadata metadata) 
    {
        MP3Metadata mP3Metadata = (MP3Metadata) metadata;
        String rdfxml = "<?xml version='1.0'?>"+
                "<rdf:RDF xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#' xmlns:dc='http://purl.org/dc/elements/1.1/' xmlns:ma='http://www.w3.org/ns/ma-ont#'>"+
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
