package codewars.linked_list;

public class Node {

    public Object data;
    public Node next;

    <T extends Object> Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    <T extends Object> Node(T data) {
        this(data, null);
    }

}
