public class Playlist {
    private Node head;
    private Node tail;
    private Node current;
    private int size;

    public Playlist() {
        head = null;
        tail = null;
        current = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    // add song at end
    public void addSong(Song song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = tail = newNode;
            current = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        System.out.println("Song added to playlist.");
    }

    // add song at specific position (1-based index)
    public void addSongAtPosition(Song song, int position) {
        if (position <= 1) {
            addFirst(song);
        } else if (position > size) {
            addSong(song);
        } else {
            Node newNode = new Node(song);
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            size++;
            System.out.println("Song added at position " + position + ".");
        }
    }

    private void addFirst(Song song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = tail = current = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        System.out.println("Song added at beginning.");
    }

    // remove song by title (first occurrence)
    public void removeSongByTitle(String title) {
        if (isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        Node temp = head;
        while (temp != null && !temp.data.getTitle().equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Song not found.");
            return;
        }

        // update current pointer if needed
        if (temp == current) {
            if (current.next != null) {
                current = current.next;
            } else {
                current = current.prev;
            }
        }

        if (temp == head && temp == tail) {
            head = tail = current = null;
        } else if (temp == head) {
            head = head.next;
            head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        size--;
        System.out.println("Song removed: " + title);
    }

    // display all songs
    public void displayPlaylist() {
        if (isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("---- PLAYLIST ----");
        Node temp = head;
        int index = 1;
        while (temp != null) {
            System.out.println(index + ". " + temp.data.toString());
            temp = temp.next;
            index++;
        }
        System.out.println("------------------");
    }

    // play current song
    public void playCurrent() {
        if (current == null) {
            System.out.println("No song selected.");
        } else {
            System.out.println("Now playing: " + current.data.toString());
        }
    }

    // next song
    public void nextSong() {
        if (current == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (current.next != null) {
            current = current.next;
            playCurrent();
        } else {
            System.out.println("Already at last song.");
        }
    }

    // previous song
    public void previousSong() {
        if (current == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (current.prev != null) {
            current = current.prev;
            playCurrent();
        } else {
            System.out.println("Already at first song.");
        }
    }

    // simple linear search
    public void searchSong(String title) {
        if (isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        Node temp = head;
        int position = 1;
        while (temp != null) {
            if (temp.data.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Song found at position " + position + ":");
                System.out.println(temp.data.toString());
                return;
            }
            temp = temp.next;
            position++;
        }
        System.out.println("Song not found.");
    }

    // optional: clear playlist
    public void clear() {
        head = tail = current = null;
        size = 0;
        System.out.println("Playlist cleared.");
    }
}
