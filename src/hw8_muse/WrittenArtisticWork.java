package hw8_muse;

import java.util.LinkedHashMap;

public abstract class WrittenArtisticWork extends ArtisticWork {
    private String language;
    private String text;  // the actual content
    //gets and sets for language and text
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String lang) {
        language = lang;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public WrittenArtisticWork() {
        language = "English";
        text = "This is the text of the written work.";
    }
    public WrittenArtisticWork(String creator, String date, String title, String description,
            String language, String text) {
        super(creator,date,title,description);
        setLanguage(language);
        setText(text);
    }
    public WrittenArtisticWork(LinkedHashMap<String,String> settings) {
        super(settings);
        setLanguage(settings.get("language"));
        setText(settings.get("text"));
    }
    @Override
    public String tabGenInfo(){//tab delimited string
        return String.format("%s\t%s\t%s",super.tabGenInfo(),language,text);
    }
    @Override
    public String getGeneralInfoString() {//gen info string
        return String.format("%s\nLanguage: %s",super.getGeneralInfoString(),language);
    }
    @Override
    public String getSpecificInfoString() {
        return text;
    }
}
