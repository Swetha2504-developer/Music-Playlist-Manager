package src;
import java.util.Scanner;

public class MusicPlayerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist playlist = new Playlist();
        int choice;

        do {
            System.out.println("\n===== MUSIC PLAYLIST MANAGER =====");
            System.out.println("1. Add new song (end)");
            System.out.println("2. Add song at position");
            System.out.println("3. Remove song by title");
            System.out.println("4. Display playlist");
            System.out.println("5. Play current song");
            System.out.println("6. Next song");
            System.out.println("7. Previous song");
            System.out.println("8. Search song by title");
            System.out.println("9. Clear playlist");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = safeIntInput(sc);

            switch (choice) {
                case 1:
                    Song s1 = readSongFromUser(sc);
                    playlist.addSong(s1);
                    break;
                case 2:
                    Song s2 = readSongFromUser(sc);
                    System.out.print("Enter position (1-based): ");
                    int pos = safeIntInput(sc);
                    playlist.addSongAtPosition(s2, pos);
                    break;
                case 3:
                    System.out.print("Enter song title to remove: ");
                    String titleRemove = sc.nextLine();
                    playlist.removeSongByTitle(titleRemove);
                    break;
                case 4:
                    playlist.displayPlaylist();
                    break;
                case 5:
                    playlist.playCurrent();
                    break;
                case 6:
                    playlist.nextSong();
                    break;
                case 7:
                    playlist.previousSong();
                    break;
                case 8:
                    System.out.print("Enter song title to search: ");
                    String titleSearch = sc.nextLine();
                    playlist.searchSong(titleSearch);
                    break;
                case 9:
                    playlist.clear();
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }

    private static Song readSongFromUser(Scanner sc) {
        System.out.print("Enter song title: ");
        String title = sc.nextLine();
        System.out.print("Enter artist name: ");
        String artist = sc.nextLine();
        System.out.print("Enter album name: ");
        String album = sc.nextLine();
        System.out.print("Enter duration in seconds: ");
        int duration = safeIntInput(sc);
        return new Song(title, artist, album, duration);
    }

    private static int safeIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine(); // clear newline
        return val;
    }
}
