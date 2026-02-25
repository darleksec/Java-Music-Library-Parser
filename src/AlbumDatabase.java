import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AlbumDatabase {
    public static void main(String[] args) {
        //constructors
        AlbumDatabase db = new AlbumDatabase();
        AlbumCollection collection = new AlbumCollection();
        try {

            //constructors
            File Database = new File("albums.txt");
            Scanner scanner = new Scanner(Database);
            Album currentAlbum = null;
            Album shortestAlbum = null;
            Track currentTrack = null;
            Track longestTrack = new Track("", new Duration(0, 0, 0));
            Duration artistPlayTime = new Duration(0, 0, 0); //Kraftwerk test
            String artistName = "Kraftwerk";

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                char firstChar = data.charAt(0);
                if (!Character.isDigit(firstChar)) {
                    // Split String by colon to separate Album name and artist + release year
                    String[] string = data.split(":");

                    // extract year from the string containing artist and year
                    // https://www.w3schools.com/java/java_regex.asp

                    int Year = Integer.parseInt(string[1].replaceAll(".*\\((\\d{4})\\).*", "$1"));
                    String Artist = string[0].replaceAll(".*\\((\\d{4})\\).*", "");

                    // Remove the year in parentheses from the album name
                    String AlbumName = string[1].replaceAll("\\(\\d{4}\\)", "").trim();

                    //create new album  and add to collection
                    currentAlbum = new Album(AlbumName, Artist, Year);
                    collection.addAlbum(currentAlbum);

                    //Find album of shortest Album name
                    if (shortestAlbum == null || currentAlbum.getAlbumName().length()
                            < shortestAlbum.getAlbumName().length()) {
                        shortestAlbum = currentAlbum;
                    }

                } else if (Character.isDigit(firstChar)) {
                    //initialise duration for track
                    int Hour = Integer.parseInt(data.charAt(0) + "");
                    int Minutes = Integer.parseInt(data.substring(2, 4));
                    int Seconds = Integer.parseInt(data.substring(5, 7));
                    Duration duration = new Duration(Hour, Minutes, Seconds);

                    String trackTitle = data.substring(10);
                    Track track = new Track(trackTitle, duration);
                    currentTrack = track;
                    //Add time for duration for specified artist album Kraftwerk
                    currentAlbum.addTrack(track);
                    if (currentAlbum.getArtist().contains(artistName)) {
                        artistPlayTime = artistPlayTime.add(track.getDuration());
                    }

                    //Find track of longest name
                    if (longestTrack == null || (currentTrack.getDuration().compareTo(longestTrack.getDuration())) == 1) {
                        longestTrack = currentTrack;
                    }
                }
            }
            scanner.close();
            collection.sortAlbums();
            System.out.println(collection);
            System.out.println(collection.getTotalDuration());
            System.out.println("Total play time for " + artistName + " : " + artistPlayTime);
            System.out.println("Album with shortest Album name : " + shortestAlbum);
            System.out.println("Track with Longest duration : " + longestTrack);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }
}