package codewars.linked_list;

public class NodeTest {

    public static void main(String[] args) {
        Node lastNode = new Node("last");
        Node secondNode = new Node("second", lastNode);
        Node firstNode = new Node("first", secondNode);

        int length = Solution.length(firstNode);
        System.out.println("Len: " + length);

    }

}
