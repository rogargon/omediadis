package cat.udl.omediadis.annotator.readers;


import java.io.File;
import java.io.IOException;

import org.apache.commons.fileupload.FileItem;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.ID3v24Frames;
import org.jaudiotagger.tag.id3.ID3v24Tag;

import cat.udl.omediadis.annotator.metadata.ContentMetadata;
import cat.udl.omediadis.annotator.metadata.MP3Metadata;

public class MP3Reader extends Reader
{
	private MP3Metadata metadata = new MP3Metadata();

	public ContentMetadata readMetadata(FileItem item)
	{
		try 
		{
			File tmp = File.createTempFile("OMediadisAnnotatorTmp", "mp3");
			tmp.deleteOnExit();
			item.write(tmp);
			readMetadata(tmp);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return metadata;
	}	
			
	public ContentMetadata readMetadata(File f) throws Exception
	{		
			MP3File mf = (MP3File)AudioFileIO.read(f);
			MP3AudioHeader mp3AudioHeader = mf.getMP3AudioHeader();
			ID3v24Tag v2tag  = mf.getID3v2TagAsv24();

			System.out.println("\n---------\n" + f.getAbsolutePath() + "\n---------\n");

			metadata.setFilename(f.getName());
			
			metadata.setBitRate(mp3AudioHeader.getBitRate());
			
			metadata.setSamplingRate(mp3AudioHeader.getSampleRate());
			
			metadata.setTitle(v2tag.getFirst(ID3v24Frames.FRAME_ID_TITLE));
			
			metadata.setLanguage(v2tag.getFirst(ID3v24Frames.FRAME_ID_LANGUAGE));
			
			/*metadata.setContributor(v2tag.getFirst(ID3v24Frames.FRAME_ID_ACCOMPANIMENT)+"/"+
								    v2tag.getFirst(ID3v24Frames.FRAME_ID_COMPOSER)+"/"+
									v2tag.getFirst(ID3v24Frames.FRAME_ID_ORIGARTIST));*/
			
			metadata.setCreator(v2tag.getFirst(ID3v24Frames.FRAME_ID_ARTIST));
			
			metadata.setCreateDate(v2tag.getFirst(ID3v24Frames.FRAME_ID_YEAR));

			//metadata.setLocation(v2tag.getFirst(ID3v24Frames.FRAME_ID_COPYRIGHTINFO));
			metadata.setCopyright(v2tag.getFirst(ID3v24Frames.FRAME_ID_COPYRIGHTINFO));
			metadata.setLicense(v2tag.getFirst(ID3v24Frames.FRAME_ID_FILE_OWNER));

			metadata.setDescription(v2tag.getFirst(ID3v24Frames.FRAME_ID_TITLE_REFINEMENT));
			
			//metadata.setKeyword(v2tag.getFirst(ID3v24Frames.FRAME_ID_GENRE));
			metadata.setGenre(v2tag.getFirst(ID3v24Frames.FRAME_ID_GENRE));

			metadata.setRating(v2tag.getFirst(ID3v24Frames.FRAME_ID_POPULARIMETER));
			
			metadata.setRelationLink(v2tag.getFirst(ID3v24Frames.FRAME_ID_LINKED_INFO));
			metadata.setRelationApic(v2tag.getFirst(ID3v24Frames.FRAME_ID_ATTACHED_PICTURE));

			metadata.setCollection(v2tag.getFirst(ID3v24Frames.FRAME_ID_ALBUM));

			metadata.setPublisher(v2tag.getFirst(ID3v24Frames.FRAME_ID_PUBLISHER));

			metadata.setCompression(v2tag.getFirst(ID3v24Frames.FRAME_ID_FILE_TYPE));

			metadata.setDuration(mp3AudioHeader.getTrackLengthAsString());

			metadata.setNumTracks(ID3v24Frames.FRAME_ID_TRACK);

		return metadata;
	}
}
