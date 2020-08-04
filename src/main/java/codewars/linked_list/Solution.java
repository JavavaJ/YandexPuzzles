package codewars.linked_list;

public class Solution {
    static int length(Node head) {
        return head.next != null ? 1 + length(head.next) : 1;
    }

}