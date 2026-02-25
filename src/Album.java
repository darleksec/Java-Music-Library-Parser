import java.util.ArrayList;

public class Album {
    //initialise instance variables
    private String AlbumName;
    private String Artist;
    private int ReleaseYear;
    private ArrayList<Track> tracks = new ArrayList<>();
    //initialise Album obj
    public Album(String AlbumName, String Artist, int ReleaseYear) {
        this.AlbumName = AlbumName;
        this.Artist = Artist;
        this.ReleaseYear = ReleaseYear;
        this.tracks = new ArrayList<>();
    }

    //get Functions
    public String getAlbumName() {
        return AlbumName;
    }

    public String getArtist() {
        return Artist;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    // Method to add a track to the album
    public void addTrack(Track track) {
        tracks.add(track);
    }

    //calculate and get Total Duration of album
    public Duration getTotalDuration() {
        int totalHours = 0;
        int totalMinutes = 0;
        int totalSeconds = 0;
        // Loop through each track and accumulate its duration
        for (Track track : tracks) {
            totalHours += track.getDuration().getHours();
            totalMinutes += track.getDuration().getMinutes();
            totalSeconds += track.getDuration().getSeconds();
        }
        totalMinutes += totalSeconds / 60;
        totalSeconds = totalSeconds % 60;
        totalHours += totalMinutes / 60;
        totalMinutes = totalMinutes % 60;
        return new Duration(totalHours, totalMinutes, totalSeconds);
    }
    //Override toString method using String builder to change string format to desired format
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n"+"Album Name: " + AlbumName + "\n");
        sb.append("Artist: " + Artist + "\n");
        sb.append("ReleaseYear: " + ReleaseYear + "\n");
        sb.append("Total Duration: " + getTotalDuration() + "\n");
        sb.append("Track: " + "\n");

        for (Track track : tracks) {
            sb.append("- ").append(track).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //Create new duration obj
        Duration duration = new Duration(3,2,1);
        //Create a new track obj with above duration as argument
        Track track = new Track("Song 1", duration);
        //Create a new album obj
        Album album = new Album("Album", "Artist", 2018);
        //add above track obj to album obj
        album.addTrack(track);
        //Test for album and methods within class album
        System.out.println(album);
        System.out.println(album.getTotalDuration());
        System.out.println(album.getAlbumName());
        System.out.println(album.getArtist());

    }
}