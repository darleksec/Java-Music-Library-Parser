public class Track {
    //initialise instance variables
    private String title;
    private Duration duration;
    //initialise Track obj
    public Track(String title, Duration duration) {
        this.title = title;
        this.duration = duration;
    }
    //getter function
    public String getTitle() {
        return title;
    }

    public Duration getDuration() {
        return duration;
    }
    //Override toString method to change string format to desired format
    @Override
    public String toString() {
        return String.format("%s %s", title , duration);
    }

    public static void main(String[] args) {
        //Create new duration obj
        Duration duration = new Duration(3,2,1);
        //Create a new track obj with above duration as argument
        Track track = new Track("Song 1", duration);
        //Test for track obj and methods within the class
        System.out.println(track);
        System.out.println(track.getDuration());
        System.out.println(track.getTitle());
    //testing code
    }
}
