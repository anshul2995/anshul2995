package Linkedlist;

class abc05062002 {
    public static void main(String[] args) {
        
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        five.next = null;
        four.next = five;
        three.next = four;
        two.next = three;
        one.next = two;
        
        Node head = one;

        reverse(head);
    }   
    
    static Node reverse(Node head){

        Node dummy = null;
        while(head!=null){
            Node next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy; //at the end, dummy will now point to 5. //head will be pointing to null
    }
}