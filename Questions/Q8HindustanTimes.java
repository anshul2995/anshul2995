package Questions;

public class Q8HindustanTimes {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    //Input: head = [1,2,3,4,5,6]. Output: [2,1,4,3]
    public static void main(String[] args) {

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        Node head = one;

        head = swapNodes(head);

        while (head != null) {
            System.out.print(head.data + ",");
            head = head.next;
        }
    }

    //Input: head = [1,2,3,4,5,6]. Output: [2,1,4,3]
        //[2,1,3,4,5,6]

    public static Node swapNodes(Node head) {

        int length = 6;

        Node dummyHead = new Node(0);
        dummyHead.next = head;

        Node pre = dummyHead;
        Node curr;
        Node next;

        while (length >= 2) {
            curr = pre.next;
            next = curr.next;

            for (int i = 1; i < 2; i++) {
                curr.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = curr.next;
            }

            pre = curr;
            length -= 2;
        }

        return dummyHead.next;
    }
}
