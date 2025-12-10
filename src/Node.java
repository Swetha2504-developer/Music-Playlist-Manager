package src;
public class Node {
    Song data;
    Node next;
    Node prev;

    public Node(Song data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
