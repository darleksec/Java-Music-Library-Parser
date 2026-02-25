public class Duration implements Comparable<Duration> {
    //initialise instance variables
    private int hours;
    private int minutes;
    private int seconds;
    //constructor to initialise Duration obj
    public Duration(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    //getter methods to access private variables
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
    //Take duration obj return duration in seconds
    public int toSeconds() {
        return this.hours * 3600 + this.minutes * 60 + this.seconds;
    }
    //compareTo method for comparing 2 duration obj, return 1,0 or -1(>,=,<)
    public int compareTo(Duration duration2) {
        int DurationThis = Duration.this.toSeconds();
        int DurationOther = duration2.toSeconds();
        return Integer.compare(DurationThis, DurationOther);
    }
    //Override toString method to change string format to desired format
    public String toString() {
        return String.format("%2d:%02d:%02d", hours, minutes, seconds);
    }
    //addition for 2 duration obj
    public Duration add(Duration other) {
        int totalSeconds = this.toSeconds() + other.toSeconds();  // Add total seconds of both durations
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return new Duration(hours, minutes, seconds);
    }

    public static void main(String[] args) {
        //1st obj
        Duration duration = new Duration(1, 2, 3);
        System.out.println(duration);
        //2nd obj
        Duration duration2 = new Duration(2, 3, 4);
        System.out.println(duration2);
        //compareTo test
        System.out.println(duration.compareTo(duration2));
        //add duration obj test
        Duration duration3 = new Duration(0,0,0);
        System.out.println(duration3.add(duration2));
        System.out.println(duration3.add(duration).add(duration2));
        //to and get function tests
        System.out.println(duration.toSeconds());
        System.out.println(duration.getSeconds());
        System.out.println(duration.getHours());
        System.out.println(duration.getMinutes());
        //testing code
    }
}
