public class Song {
    private String title;
    private String artist;
    private String album;
    private int durationSeconds; // store duration in seconds

    public Song(String title, String artist, String album, int durationSeconds) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.durationSeconds = durationSeconds;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    @Override
    public String toString() {
        int minutes = durationSeconds / 60;
        int seconds = durationSeconds % 60;
        return title + " - " + artist + " (" + album + ") [" +
                String.format("%02d:%02d", minutes, seconds) + "]";
    }
}
