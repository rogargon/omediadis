package cat.udl.omediadis.annotator.readers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.fileupload.FileItem;
import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.Sanselan;
import org.apache.sanselan.common.IImageMetadata;
import org.apache.sanselan.formats.jpeg.JpegImageMetadata;
import org.apache.sanselan.formats.tiff.constants.TiffConstants;

import cat.udl.omediadis.annotator.metadata.ContentMetadata;
import cat.udl.omediadis.annotator.metadata.Fitxer;
import cat.udl.omediadis.annotator.metadata.JPEGMetadata;

public class JPEGReader extends Reader
{
    private JPEGMetadata metadata = new JPEGMetadata();

	public ContentMetadata readMetadata(FileItem item)
	{
		try 
		{
			File tmp = File.createTempFile("OMediadisAnnotatorTmp", "jpg");
			tmp.deleteOnExit();
			item.write(tmp);
			readMetadata(tmp);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}		
		return metadata;
	}


	@Override
	public ContentMetadata readMetadata(File item) 
	{
        try 
        {
            IImageMetadata metadata = Sanselan.getMetadata(file);
            //System.out.println(metadata);
            if (metadata instanceof JpegImageMetadata) {
                JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
                // JPEGMetadata EXIF metadata is stored in a TIFF-based directory structure
                // and is identified with TIFF tags.
                // Here we look for the "x resolution" tag, but
                // we could just as easily search for any other tag.
                //
                // see the TiffConstants file for a list of TIFF tags.
                System.out.println("file: " + file.getName());
                jPEGMetadata.setInam(file.getName());


                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_IMAGE_UNIQUE_ID) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_IMAGE_UNIQUE_ID).getValueDescription();
                    jPEGMetadata.setImageUniqueId(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_IMAGE_DESCRIPTION) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_IMAGE_DESCRIPTION).getValueDescription();
                    jPEGMetadata.setImageDescription(valor);
                }
                //if(jpegMetadata.findEXIFValue(INAM) != null){
                //    String valor = jpegMetadata.findEXIFValue(TiffConstants.INAM).getValueDescription();
                //}

                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_ARTIST) != null){ //Exif IART
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_ARTIST).getValueDescription();
                    jPEGMetadata.setIart(valor);
                }
                //if(jpegMetadata.findEXIFValue(TiffConstants.IENG) != null){
                //    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_IMAGE_DESCRIPTION).getValueDescription();
                //}
                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_FILE_SOURCE) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_FILE_SOURCE).getValueDescription();
                    jPEGMetadata.setIsrc(valor);
                }
                //if(jpegMetadata.findEXIFValue(TiffConstants.ITCH) != null){
                //    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_IMAGE_DESCRIPTION).getValueDescription();
                //}
                if(jpegMetadata.findEXIFValue(TiffConstants.TIFF_TAG_DATE_TIME) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.TIFF_TAG_DATE_TIME).getValueDescription();
                    jPEGMetadata.setDateTime(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_DATE_TIME_ORIGINAL) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_DATE_TIME_ORIGINAL).getValueDescription();
                    jPEGMetadata.setDateTimeOriginal(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_CREATE_DATE) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_CREATE_DATE).getValueDescription();
                    jPEGMetadata.setIcrd(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.GPS_TAG_GPS_LATITUDE_REF) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.GPS_TAG_GPS_LATITUDE_REF).getValueDescription();
                    jPEGMetadata.setGpsLatituteRef(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.GPS_TAG_GPS_LATITUDE) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.GPS_TAG_GPS_LATITUDE).getValueDescription();
                    jPEGMetadata.setGpsLatitute(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.GPS_TAG_GPS_LONGITUDE_REF) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.GPS_TAG_GPS_LONGITUDE_REF).getValueDescription();
                    jPEGMetadata.setGpsLongitudeRef(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.GPS_TAG_GPS_LONGITUDE) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.GPS_TAG_GPS_LONGITUDE).getValueDescription();
                    jPEGMetadata.setGpsLongitude(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.GPS_TAG_GPS_ALTITUDE) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.GPS_TAG_GPS_ALTITUDE).getValueDescription();
                    jPEGMetadata.setGpsAltitude(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.GPS_TAG_GPS_ALTITUDE_REF) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.GPS_TAG_GPS_ALTITUDE_REF).getValueDescription();
                    jPEGMetadata.setGpsAltitudeRef(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_XPKEYWORDS) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_XPKEYWORDS).getValueDescription();
                    jPEGMetadata.setIkey(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_USER_COMMENT) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_USER_COMMENT).getValueDescription();
                    jPEGMetadata.setUserComment(valor);
                }
                //if(jpegMetadata.findEXIFValue(IPTCConstants.COMMENTS) != null){
                //    String valor = jpegMetadata.findEXIFValue(TiffConstants.COMMENTS).getValueDescription();
                //}
                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_XPSUBJECT) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_XPSUBJECT).getValueDescription();
                    jPEGMetadata.setIsbj(valor);
                }
                //if(jpegMetadata.findEXIFValue(IPTCConstants.IGNR) != null){
                //    String valor = jpegMetadata.findEXIFValue(TiffConstants.IGNR).getValueDescription();
                //}
                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_RELATED_SOUND_FILE) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_RELATED_SOUND_FILE).getValueDescription();
                    jPEGMetadata.setRelatedSoundFile(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_COPYRIGHT) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_COPYRIGHT).getValueDescription();
                    jPEGMetadata.setCopyright(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_EXIF_IMAGE_WIDTH) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_EXIF_IMAGE_WIDTH).getValueDescription();
                    jPEGMetadata.setImageWidth(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_EXIF_IMAGE_LENGTH) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_EXIF_IMAGE_LENGTH).getValueDescription();
                    jPEGMetadata.setImageLength(valor);
                }
                if(jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_COMPRESSION) != null){
                    String valor = jpegMetadata.findEXIFValue(TiffConstants.EXIF_TAG_COMPRESSION).getValueDescription();
                    jPEGMetadata.setCompression(valor);
                }

                ArrayList items = jpegMetadata.getItems();
                for (int i = 0; i < items.size(); i++) {
                    Object item = items.get(i);
                    System.out.println("	" + "item: " + item);
                }
                System.out.println();
            }

        } catch (ImageReadException ex) {
            Logger.getLogger(JPEGReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JPEGReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jPEGMetadata;
	}

}
