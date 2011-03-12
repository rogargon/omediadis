package cat.udl.omediadis.annotator.metadata;

public class JPEGMetadata extends ContentMetadata
{
    private String imageUniqueId;
    private String imageDescription;
    private String inam;
    private String language;
    private String locator;
    private String iart;
    private String ieng;
    private String isrc;
    private String itch;
    private String dateTime;
    private String dateTimeOriginal;
    private String icrd;
    private String gpsLatituteRef;
    private String gpsLatitute;
    private String gpsLongitudeRef;
    private String gpsLongitude;
    private String gpsAltitude;
    private String gpsAltitudeRef;
    private String ikey;
    private String userComment;
    private String comments;
    private String isbj;
    private String ignr;
    private String rating;
    private String relatedSoundFile;
    private String collection;
    private String copyright;
    private String license;
    private String publisher;
    private String targetAudience;
    private String fragments;
    private String namedFragments;
    private String imageWidth;
    private String imageLength;
    private String compression;
    private String duration;
    private String format;
    private String samplingRate;
    private String frameRate;
    private String bitRate;
    private String numTracks;

    public JPEGMetadata() {
    }

    public JPEGMetadata(String imageUniqueId, String imageDescription, String inam, String language, String locator, String iart, String ieng, String isrc, String itch, String dateTime, String dateTimeOriginal, String icrd, String gpsLatituteRef, String gpsLatitute, String gpsLongitudeRef, String gpsLongitude, String gpsAltitude, String gpsAltitudeRef, String ikey, String userComment, String comments, String isbj, String ignr, String rating, String relatedSoundFile, String collection, String copyright, String license, String publisher, String targetAudience, String fragments, String namedFragments, String imageWidth, String imageLength, String compression, String duration, String format, String samplingRate, String frameRate, String bitRate, String numTracks) {
        this.imageUniqueId = imageUniqueId;
        this.imageDescription = imageDescription;
        this.inam = inam;
        this.language = language;
        this.locator = locator;
        this.iart = iart;
        this.ieng = ieng;
        this.isrc = isrc;
        this.itch = itch;
        this.dateTime = dateTime;
        this.dateTimeOriginal = dateTimeOriginal;
        this.icrd = icrd;
        this.gpsLatituteRef = gpsLatituteRef;
        this.gpsLatitute = gpsLatitute;
        this.gpsLongitudeRef = gpsLongitudeRef;
        this.gpsLongitude = gpsLongitude;
        this.gpsAltitude = gpsAltitude;
        this.gpsAltitudeRef = gpsAltitudeRef;
        this.ikey = ikey;
        this.userComment = userComment;
        this.comments = comments;
        this.isbj = isbj;
        this.ignr = ignr;
        this.rating = rating;
        this.relatedSoundFile = relatedSoundFile;
        this.collection = collection;
        this.copyright = copyright;
        this.license = license;
        this.publisher = publisher;
        this.targetAudience = targetAudience;
        this.fragments = fragments;
        this.namedFragments = namedFragments;
        this.imageWidth = imageWidth;
        this.imageLength = imageLength;
        this.compression = compression;
        this.duration = duration;
        this.format = format;
        this.samplingRate = samplingRate;
        this.frameRate = frameRate;
        this.bitRate = bitRate;
        this.numTracks = numTracks;
    }

    public String getBitRate() {
        return bitRate;
    }

    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCompression() {
        return compression;
    }

    public void setCompression(String compression) {
        this.compression = compression;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTimeOriginal() {
        return dateTimeOriginal;
    }

    public void setDateTimeOriginal(String dateTimeOriginal) {
        this.dateTimeOriginal = dateTimeOriginal;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFragments() {
        return fragments;
    }

    public void setFragments(String fragments) {
        this.fragments = fragments;
    }

    public String getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    public String getGpsAltitude() {
        return gpsAltitude;
    }

    public void setGpsAltitude(String gpsAltitude) {
        this.gpsAltitude = gpsAltitude;
    }

    public String getGpsAltitudeRef() {
        return gpsAltitudeRef;
    }

    public void setGpsAltitudeRef(String gpsAltitudeRef) {
        this.gpsAltitudeRef = gpsAltitudeRef;
    }

    public String getGpsLatitute() {
        return gpsLatitute;
    }

    public void setGpsLatitute(String gpsLatitute) {
        this.gpsLatitute = gpsLatitute;
    }

    public String getGpsLatituteRef() {
        return gpsLatituteRef;
    }

    public void setGpsLatituteRef(String gpsLatituteRef) {
        this.gpsLatituteRef = gpsLatituteRef;
    }

    public String getGpsLongitudeRef() {
        return gpsLongitudeRef;
    }

    public void setGpsLongitudeRef(String gpsLongitudeRef) {
        this.gpsLongitudeRef = gpsLongitudeRef;
    }

    public String getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(String gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public String getIart() {
        return iart;
    }

    public void setIart(String iart) {
        this.iart = iart;
    }

    public String getIcrd() {
        return icrd;
    }

    public void setIcrd(String icrd) {
        this.icrd = icrd;
    }

    public String getIeng() {
        return ieng;
    }

    public void setIeng(String ieng) {
        this.ieng = ieng;
    }

    public String getIgnr() {
        return ignr;
    }

    public void setIgnr(String ignr) {
        this.ignr = ignr;
    }

    public String getIkey() {
        return ikey;
    }

    public void setIkey(String ikey) {
        this.ikey = ikey;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public String getImageLength() {
        return imageLength;
    }

    public void setImageLength(String imageLength) {
        this.imageLength = imageLength;
    }

    public String getImageUniqueId() {
        return imageUniqueId;
    }

    public void setImageUniqueId(String imageUniqueId) {
        this.imageUniqueId = imageUniqueId;
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getInam() {
        return inam;
    }

    public void setInam(String inam) {
        this.inam = inam;
    }

    public String getIsbj() {
        return isbj;
    }

    public void setIsbj(String isbj) {
        this.isbj = isbj;
    }

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    public String getItch() {
        return itch;
    }

    public void setItch(String itch) {
        this.itch = itch;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public String getNamedFragments() {
        return namedFragments;
    }

    public void setNamedFragments(String namedFragments) {
        this.namedFragments = namedFragments;
    }

    public String getNumTracks() {
        return numTracks;
    }

    public void setNumTracks(String numTracks) {
        this.numTracks = numTracks;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRelatedSoundFile() {
        return relatedSoundFile;
    }

    public void setRelatedSoundFile(String relatedSoundFile) {
        this.relatedSoundFile = relatedSoundFile;
    }

    public String getSamplingRate() {
        return samplingRate;
    }

    public void setSamplingRate(String samplingRate) {
        this.samplingRate = samplingRate;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }
    @Override
    public String toString(){
        return this.inam;
    }
}
