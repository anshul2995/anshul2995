package Linkedlist;

class abc03062022{
    public static void main(String[] args) {

       int k=3;
       Node one = new Node(1); Node two = new Node(2); Node three = new Node(3);Node four = new Node(4);
       Node five = new Node(5);

       five.next = null;four.next = five;three.next = four;two.next = three;one.next = two;     

       Node head = one;
       print(head);

       if (head == null || k==1) {
            System.out.println("head is empty or k=1");
       }
       
       Node dummy = new Node(0, head); //dummy is now pointing to the head node which is 1.

       Node pre = dummy, curr = dummy, next = dummy; int count = 0 ;
       //counting the lenght of the LL
       while(curr.next!=null){
            curr = curr.next;
            count++;
       }
       while(count>=k){
           curr = pre.next;
           next = curr.next;
           for(int i = 1 ; i < k; i++){
               curr.next = next.next;
               next.next = pre.next;
               pre.next = next;
               next = curr.next;
           }
           count -= k;
           pre = curr; 
       }
       head=dummy.next;

       print(head);
    }

    private static void print(Node node){
        Node temp = node;
        while(temp.next != null){
            System.out.print(node.data+"->");
        }
    }
}
