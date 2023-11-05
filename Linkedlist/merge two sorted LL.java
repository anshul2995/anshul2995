package Linkedlist;

class abc190623 {
    
    public static void main(String[] args) {

        Node ll1 = head1();
        Node ll2 = head2();
        //print(sortByCreateNewLL(ll1, ll2));

        //print(sortByInplace(ll1, ll2));
        print(sortByInPlaceLeetCodeSoln(ll1, ll2));
    }

    /*static Node sortByCreateNewLL(Node ll1, Node ll2){
        Node dummy = new Node();

        if (ll1!=null & ll2!=null){
            if (ll2.data <= ll1.data){
                Node node = new Node(ll2.data);
                dummy.next = node;
                ll2 = ll2.next;
            }
        }
        while(ll1!=null && ll2!=null){
            if (ll2.data <= ll1.data){
                Node dummyDuplicate = new Node(ll2.data);
                dummy.next = dummyDuplicate;
                ll2 = ll2.next;
            } else {
                Node dummyDuplicate = new Node(ll1.data);
                dummy.next = dummyDuplicate;
                ll1 = ll1.next;
            }
        }
        return null;
    }*/
    //You were not able to think how to manage dummy and dummyDuplicate.
    //Dummy and DummyDuplicate should be assigned to the same [empty] node and move dummyDuplicate forward.


    //https://leetcode.com/problems/merge-two-sorted-lists/solutions/3627101/video-step-by-step-visualization-and-explanation/
    static Node sortByInPlaceLeetCodeSoln(Node ll1, Node ll2){

        Node head = new Node();
        Node current = head;

        while (ll1!=null && ll2!=null) {
            if (ll1.data < ll2.data) {
                current.next = ll1;
                ll1=ll1.next;
            } else {
                current.next = ll2;
                ll2=ll2.next;
            }
            current = current.next;
        }

        if (ll1==null && ll2!=null) {
            current.next = ll2;
        }

        if(ll2==null && ll1!=null){
            current.next = ll1;
        }


        return head.next;
    }

    static Node sortByInplace(Node ll1, Node ll2){

        if (ll1.data > ll2.data) {
            Node temp = ll1;
            ll1 = ll2;
            ll2 = temp;
        }

        Node result = ll1;

        while (ll1!= null && ll2!= null){
            Node temp = null;
            while(ll1.data <= ll2.data) {
                temp = ll1;
                ll1 = ll1.next;
                if (ll1 == null) break;
            }
            temp.next = ll2;

            temp = ll1;
            ll1 = ll2;
            ll2 = temp;
        }

        return result;
    }

    static Node sortByCreateNewLL(Node ll1, Node ll2){ 

        Node dummy = new Node();
        Node dummyDuplicate = dummy;

        while(ll1!=null && ll2!=null){
            if (ll1.data <= ll2.data){
                Node node = new Node(ll1.data);
                dummyDuplicate.next = node;
                ll1 = ll1.next;
                dummyDuplicate = node;
            } else {
                Node node = new Node(ll2.data);
                dummyDuplicate.next = node;
                ll2=ll2.next;
                dummyDuplicate = node;
            }
        }

        if (ll1==null && ll2!=null) {
            dummyDuplicate.next = ll2;
        }

        if(ll2==null && ll1!=null){
            dummyDuplicate.next = ll1;
        }
        
        return dummy.next;
    }

    static Node head1(){

        Node nine = new Node(9);
        Node seven = new Node(7);
        Node five = new Node(5);

        five.next = seven;
        seven.next = nine;
        return five;
    }

    static Node head2(){

        Node three = new Node(3);
        Node four = new Node(4);
        Node eight = new Node(8);
        Node ten = new Node(10);

        three.next = four;
        four.next = eight;
        eight.next = ten;

        return three;
    }

    static void print(Node LL){

        Node temp = LL;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
