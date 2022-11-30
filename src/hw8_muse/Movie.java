package hw8_muse;
import java.util.LinkedHashMap;
public class Movie extends RecordedArtisticWork {
    private int frameRate; // frames per second
    private String resolution;  // 720p, 1040p, 2048p, etc

    //gets and sets for framerate and res
    public int getFrameRate() {
        return frameRate;
    }
    public void setFrameRate(int frameRate) {
        if (frameRate < 0) {
            frameRate = 0;
        } else {
            this.frameRate = frameRate;
        }
    }
    public String getResolution() {
        return resolution;
    }
    public void setResolution(String res) {
        resolution = res;
    }
    //defult constructor
    public Movie() {
        frameRate = 30;
        resolution = "720p";
    }
    //non defult constructor
    public Movie(String creator, String date, String title, String description,
            int duration, String fileName, double fileSize, int frameRate, String resolution) {
        super(creator,date,title,description,duration,fileName,fileSize);
        setFrameRate(frameRate);
        setResolution(resolution);
    }
    public Movie(LinkedHashMap<String,String> settings) {
       super(settings);
       setFrameRate(Integer.parseInt(settings.get("framerate")));
       setResolution(settings.get("resolution"));
    }
    @Override
    public String getType() {
        return "movie";
    }
    @Override
    public String getSpecificInfoString() {
        return String.format("filmed with %s resolution at %d frames per second", resolution, frameRate);
    }
    @Override
    public String tabSpecInfo(){//tab del string
        return String.format("%s\t%s",resolution,frameRate);
    }
  
}
