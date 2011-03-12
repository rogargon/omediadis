package cat.udl.omediadis.annotator.metadata;

public class MP3Metadata extends ContentMetadata
{
    private String contributor;
    private String creator;
    private String description;
    private String format;
    private String identifier;
    private String language;
    private String publisher;
    private String relationLink;
    private String relationApic;
    private String keyword;
    private String title;
    private String titleAlbum;
    private String titleGroupDesc;
    private String titleOrig;
    private String genre;
    private String createDate;
    private String rating;
    private String collection;
    private String duration;
    private String copyright;
    private String license;
    private String location;
    private String fragments;
    private String namedFragments;
    private String compression;
    private String frameSize;
    private String targetAudience;
    private String locator;
    private String samplingRate;
    private String frameRate;
    private String bitRate;
    private String numTracks;

    public MP3Metadata() {
            super();
            this.contributor = null;
            this.creator = null;
            this.description = null;
            this.format = null;
            this.identifier = null;
            this.language = null;
            this.publisher = null;
            this.relationLink = null;
            this.relationApic = null;
            this.keyword = null;
            this.title = null;
            this.titleAlbum = null;
            this.titleGroupDesc = null;
            this.titleOrig = null;
            this.genre = null;
            this.createDate = null;
            this.rating = null;
            this.collection = null;
            this.duration = null;
            this.copyright = null;
            this.license = null;
            this.location = null;
            this.fragments = null;
            this.namedFragments = null;
            this.compression = null;
            this.frameSize = null;
            this.targetAudience = null;
            this.locator = null;
            this.samplingRate = null;
            this.frameRate = null;
            this.bitRate = null;
            this.numTracks = null;
    }

    public MP3Metadata(String contributor,
                    String creator, String description, String format,
                    String identifier, String language, String publisher,
                    String relationLink, String relationApic, String keyword, String title, String titleAlbum,
                    String titleGroupDesc, String titleOrig, String genre, String createDate, String rating,
                    String collection, String duration, String copyright, String license,
                    String location, String fragments, String namedFragments, String compression, String frameSize,
                    String targetAudience, String locator, String samplingRate, String frameRate,
                    String bitRate, String numTracks) {
            super();
            this.contributor = contributor;
            this.creator = creator;
            this.description = description;
            this.format = format;
            this.identifier = identifier;
            this.language = language;
            this.publisher = publisher;
            this.relationLink = relationLink;
            this.relationApic = relationApic;
            this.keyword = keyword;
            this.title = title;
            this.titleAlbum = titleAlbum;
            this.titleGroupDesc = titleGroupDesc;
            this.titleOrig = titleOrig;
            this.genre = genre;
            this.createDate = createDate;
            this.rating = rating;
            this.collection = collection;
            this.duration = duration;
            this.copyright = copyright;
            this.license = license;
            this.location = location;
            this.fragments = fragments;
            this.namedFragments = namedFragments;
            this.compression = compression;
            this.frameSize = frameSize;
            this.targetAudience = targetAudience;
            this.locator = locator;
            this.samplingRate = samplingRate;
            this.frameRate = frameRate;
            this.bitRate = bitRate;
            this.numTracks = numTracks;
    }

    public String getContributor() {
            return contributor;
    }

    public void setContributor(String contributor) {
            this.contributor = contributor;
    }

    public String getCreator() {
            return creator;
    }

    public void setCreator(String creator) {
            this.creator = creator;
    }

    public String getDescription() {
            return description;
    }

    public void setDescription(String description) {
            this.description = description;
    }

    public String getFormat() {
            return format;
    }

    public void setFormat(String format) {
            this.format = format;
    }

    public String getIdentifier() {
            return identifier;
    }

    public void setIdentifier(String identifier) {
            this.identifier = identifier;
    }

    public String getLanguage() {
            return language;
    }

    public void setLanguage(String language) {
            this.language = language;
    }

    public String getPublisher() {
            return publisher;
    }

    public void setPublisher(String publisher) {
            this.publisher = publisher;
    }

    public String getRelationLink() {
            return relationLink;
    }

    public void setRelationLink(String relationLink) {
            this.relationLink = relationLink;
    }

    public String getRelationApic() {
            return relationApic;
    }

    public void setRelationApic(String relationApic) {
            this.relationApic = relationApic;
    }
    
    public String getKeyword() {
            return keyword;
    }

    public void setKeyword(String keyword) {
            this.keyword = keyword;
    }

    public String getTitle() {
            return title;
    }

    public void setTitle(String title) {
            this.title = title;
    }

    public String getTitleAlbum() {
            return titleAlbum;
    }

    public void setTitleAlbum(String titleAlbum) {
            this.titleAlbum = titleAlbum;
    }

    public String getTitleGroupDesc() {
            return titleGroupDesc;
    }

    public void setTitleGroupDesc(String titleGroupDesc) {
            this.titleGroupDesc = titleGroupDesc;
    }

    public String getTitleOrig() {
            return titleOrig;
    }

    public void setTitleOrig(String titleOrig) {
            this.titleOrig = titleOrig;
    }
    public String getGenre() {
            return genre;
    }

    public void setGenre(String genre) {
            this.genre = genre;
    }

    public String getCreateDate() {
            return createDate;
    }

    public void setCreateDate(String createDate) {
            this.createDate = createDate;
    }

    public String getRating() {
            return rating;
    }

    public void setRating(String rating) {
            this.rating = rating;
    }

    public String getCollection() {
            return collection;
    }

    public void setCollection(String collection) {
            this.collection = collection;
    }

    public String getDuration() {
            return duration;
    }

    public void setDuration(String duration) {
            this.duration = duration;
    }

    public String getCopyright() {
            return copyright;
    }

    public void setCopyright(String copyright) {
            this.copyright = copyright;
    }

    public String getLicense() {
            return license;
    }

    public void setLicense(String license) {
            this.license = license;
    }

    public String getLocation() {
            return location;
    }

    public void setLocation(String location) {
            this.location = location;
    }
    
    public String getFragments() {
            return fragments;
    }

    public void setFragments(String fragments) {
            this.fragments = fragments;
    }

    public String getNamedFragments() {
            return namedFragments;
    }

    public void setNamedFragments(String namedFragments) {
            this.namedFragments = namedFragments;
    }

    public String getCompression() {
            return compression;
    }

    public void setCompression(String compression) {
            this.compression = compression;
    }

    public String getFrameSize() {
            return frameSize;
    }

    public void setFrameSize(String frameSize) {
            this.frameSize = frameSize;
    }

    public String getTargetAudience() {
            return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
            this.targetAudience = targetAudience;
    }

    public String getLocator() {
            return locator;
    }

    public void setLocator(String locator) {
            this.locator = locator;
    }

    public String getSamplingRate() {
            return locator;
    }

    public void setSamplingRate(String samplingRate) {
            this.samplingRate = samplingRate;
    }

    public String getFrameRate() {
            return frameRate;
    }

    public void setFrameRate(String frameRate) {
            this.frameRate = frameRate;
    }

    public String getBitRate() {
            return bitRate;
    }

    public void setBitRate(String bitRate) {
            this.bitRate = bitRate;
    }

    public String getNumTracks() {
            return numTracks;
    }

    public void setNumTracks(String numTracks) {
            this.numTracks = numTracks;
    }
}