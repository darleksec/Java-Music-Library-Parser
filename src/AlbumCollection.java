import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AlbumCollection {
    //initialise ArrayList for albums
    private ArrayList<Album> albums = new ArrayList<>();
    // Constructor to initialize the albums list
    public AlbumCollection() {
        this.albums = new ArrayList<>();
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }
    // Method to add a track to the album
    public void addAlbum(Album album) {
        albums.add(album);
    }
    // Sort album by artist name in alphabetical order ,then in ascending order by year (if same artist)
    public void sortAlbums() {
        albums.sort((a1, a2) -> {
            int artistCompare = a1.getArtist().compareTo(a2.getArtist());
            if (artistCompare == 0) {
                return Integer.compare(a1.getReleaseYear(), a2.getReleaseYear());
            }
            return artistCompare;
        });
    }

    //Total Duration
    public Duration getTotalDuration() {
        int totalHours = 0;
        int totalMinutes = 0;
        int totalSeconds = 0;
        for (Album album : albums) {
            totalHours += album.getTotalDuration().getHours();
            totalMinutes += album.getTotalDuration().getMinutes();
            totalSeconds += album.getTotalDuration().getSeconds();
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
        sb.append("Total Duration: " + getTotalDuration() + "\n");
        sb.append("Albums: " + "\n");

        for (Album album : albums) {
            sb.append(album).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Create a new AlbumCollection obj
        AlbumCollection albumCollection = new AlbumCollection();
        //Create duration track and album obj
        Duration duration = new Duration(5, 5, 5);
        System.out.println(duration);
        Track track1 = new Track("Track 1", duration);
        System.out.println(track1);
        Album album = new Album("Album", "Artist", 2018);
        album.addTrack(track1);
        System.out.println(album);

        Duration duration2 = new Duration(1, 5, 5);
        System.out.println(duration);
        Track track2 = new Track("Track 2", duration2);
        System.out.println(track2);
        Album album2 = new Album("Album", "Artist", 2010);
        album.addTrack(track2);
        System.out.println(album2);


        //Test for albumCollection and methods within the class
        albumCollection.addAlbum(album);
        albumCollection.addAlbum(album2);
        System.out.println("get album()  "+albumCollection.getAlbums());
        albumCollection.sortAlbums();
        System.out.println("sorted  "+albumCollection);
        System.out.println("total duration "+albumCollection.getTotalDuration());
    //testing
    }
}
