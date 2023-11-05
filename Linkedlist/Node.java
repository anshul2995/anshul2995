package Linkedlist;

public class Node {
    int data;
    Node next;

    public Node(){
        
    }

    public Node(int data){
        this.data = data;
    }

    public Node(int data, Node node){
        this.data = data;
        this.next = node;
    }

    public void print(Node node){
        Node temp = node;
        while(temp.next != null){
            System.out.print(node.data+"->");
        }
    }
}
