/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.udl.omediadis.annotator.writer;

import cat.udl.omediadis.annotator.metadata.Fitxer;
import cat.udl.omediadis.annotator.metadata.JPEGMetadata;

/**
 *
 * @author nacho
 */
public class JpegOFMR extends OntologyForMediaResource{

    @Override
    public String imprimirInformacio(Fitxer fitxer) {
        JPEGMetadata jPEGMetadata = (JPEGMetadata) fitxer;
        return "<?xml version='1.0'?>"+
                "<rdf:RDF xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#' xmlns:ma='http://www.w3.org/ns/ma-ont'>"+
                    "<rdf:Description>"+
                        "<ma:identifier>"+ jPEGMetadata.getImageUniqueId() +"</ma:identifier>"+
                        "<ma:title>"+ jPEGMetadata.getImageDescription() +"</ma:title>"+
                        "<ma:title>"+ jPEGMetadata.getInam() +"</ma:title>"+
                        "<ma:language>"+ jPEGMetadata.getLanguage() +"</ma:language>"+
                        "<ma:locator>"+ jPEGMetadata.getLocator() +"</ma:locator>"+
                        "<ma:contributor>"+ jPEGMetadata.getIart() +"</ma:contributor>"+
                        "<ma:contributor>"+ jPEGMetadata.getIeng() +"</ma:contributor>"+
                        "<ma:contributor>"+ jPEGMetadata.getIsrc() +"</ma:contributor>"+
                        "<ma:contributor>"+ jPEGMetadata.getItch() +"</ma:contributor>"+
                        "<ma:creator>"+ jPEGMetadata.getIart() +"</ma:creator>"+
                        "<ma:creator>"+ jPEGMetadata.getIsrc() +"</ma:creator>"+
                        "<ma:createDate>"+ jPEGMetadata.getDateTime() +"</ma:createDate>"+
                        "<ma:createDate>"+ jPEGMetadata.getDateTimeOriginal() +"</ma:createDate>"+
                        "<ma:createDate>"+ jPEGMetadata.getIcrd() +"</ma:createDate>"+
                        "<ma:location>"+ jPEGMetadata.getGpsLatituteRef() +"</ma:location>"+
                        "<ma:location>"+ jPEGMetadata.getGpsLatitute() +"</ma:location>"+
                        "<ma:location>"+ jPEGMetadata.getGpsLongitudeRef() +"</ma:location>"+
                        "<ma:location>"+ jPEGMetadata.getGpsLongitude() +"</ma:location>"+
                        "<ma:location>"+ jPEGMetadata.getGpsAltitude() +"</ma:location>"+
                        "<ma:location>"+ jPEGMetadata.getGpsAltitudeRef() +"</ma:location>"+
                        "<ma:description>"+ jPEGMetadata.getIkey() +"</ma:description>"+
                        "<ma:description>"+ jPEGMetadata.getUserComment() +"</ma:description>"+
                        "<ma:description>"+ jPEGMetadata.getComments() +"</ma:description>"+
                        "<ma:keyword>"+ jPEGMetadata.getIsbj() +"</ma:keyword>"+
                        "<ma:genre>"+ jPEGMetadata.getIkey() +"</ma:genre>"+
                        "<ma:rating>"+ jPEGMetadata.getRating() +"</ma:rating>"+
                        "<ma:relation>"+ jPEGMetadata.getRelatedSoundFile() +"</ma:relation>"+
                        "<ma:collection>"+ jPEGMetadata.getCollection() +"</ma:collection>"+
                        "<ma:copyright>"+ jPEGMetadata.getCopyright() +"</ma:copyright>"+
                        "<ma:license>"+ jPEGMetadata.getLicense() +"</ma:license>"+
                        "<ma:publisher>"+ jPEGMetadata.getPublisher() +"</ma:publisher>"+
                        "<ma:targetAudience>"+ jPEGMetadata.getTargetAudience() +"</ma:targetAudience>"+
                        "<ma:description>"+ jPEGMetadata.getIkey() +"</ma:description>"+
                        "<ma:fragments>"+ jPEGMetadata.getFragments() +"</ma:fragments>"+
                        "<ma:namedFragments>"+ jPEGMetadata.getNamedFragments() +"</ma:namedFragments>"+
                        "<ma:frameSize>"+ jPEGMetadata.getImageWidth() +"</ma:frameSize>"+
                        "<ma:frameSize>"+ jPEGMetadata.getImageLength() +"</ma:frameSize>"+
                        "<ma:compression>"+ jPEGMetadata.getCompression() +"</ma:compression>"+
                        "<ma:duration>"+ jPEGMetadata.getDuration() +"</ma:duration>"+
                        "<ma:format>"+ jPEGMetadata.getFormat() +"</ma:format>"+
                        "<ma:samplingrate>"+ jPEGMetadata.getSamplingRate() +"</ma:samplingrate>"+
                        "<ma:framerate>"+ jPEGMetadata.getFrameRate() +"</ma:framerate>"+
                        "<ma:bitrate>"+ jPEGMetadata.getBitRate() +"</ma:bitrate>"+
                        "<ma:numTracks>"+ jPEGMetadata.getNumTracks() +"</ma:numTracks>"+
                    "</rdf:Description>"+
                "</rdf:RDF>";
    }

}
