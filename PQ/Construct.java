package PQ;

import java.util.ArrayList;

class Construct {

    ArrayList<Integer> list;

    Construct(ArrayList<Integer> list){
        this.list = list;
    }

    void add(int value){
        list.add(value);

        if (this.size() == -1) {
            return;    
        }
        upHeapify(this.size());
    }

    void upHeapify(int childIndex){
        // if (childIndex == 0) { //extra check, though not necessary
        //     return;  
        // }
       int parentIndex = (childIndex - 1) / 2;
       int childValue = list.get(childIndex);
       int parentValue = list.get(parentIndex);

       if (parentValue > childValue) {
            list.set(parentIndex, childValue);
            list.set(childIndex, parentValue);
       } else 
            return;

       upHeapify(parentIndex);
    }

    int size(){
        return list.size() - 1;
    }

    int peek(){
        if(this.size() == 0) {
            System.out.println("underflow");
            return -1;
        }
        return list.get(0); //not possible: this.get(0)
    }

    int remove(){
        if(this.size() == -1) { 
            System.out.println("underflow"); 
            return -1; 
        }

        int valueAt0thIndex = list.get(0);
        int valueAtLastIndex = list.get(this.size());
        
        //swapping the values at 1st and the value at the last index
        list.set(0, valueAtLastIndex); list.set(this.size(), valueAt0thIndex);

        //deleting the value at the last index.
        list.remove(this.size());

        downHeapify(0);

        return valueAt0thIndex;
    }

    void downHeapify(int parentIndex){

        int parentValue = list.get(parentIndex); 
        int leftChildIndex = (2 * parentIndex) + 1; 
        int rightChildIndex = (2 * parentIndex) + 2;

        if (leftChildIndex > this.size () && rightChildIndex > this.size())  //return when we are the leaf node.
            return;

        int leftChildValue = list.get(leftChildIndex);
        
        if(rightChildIndex <= this.size()) { //rightChild is present
            int rightChildValue = list.get(rightChildIndex);
            if (leftChildValue < rightChildValue && leftChildValue < parentValue){  //leftChild is smallest among all 3
                list.set(parentIndex, leftChildValue);
                list.set(leftChildIndex, parentValue);
                downHeapify(leftChildIndex);
                return;
            }
            if(rightChildValue < leftChildValue && rightChildValue < parentValue){ //rightChild is smallest among all 3
                list.set(parentIndex, rightChildValue);
                list.set(rightChildIndex, parentValue);
                downHeapify(rightChildIndex);
                return;
            }
            return;  //parent is the largest among the three.
        }
        else   {   //rightChild is not present
            if(leftChildValue < parentValue){        //leftChild is smaller than parent
                list.set(parentIndex, leftChildValue);
                list.set(leftChildIndex, parentValue);
                downHeapify(leftChildIndex);
                return;
            }
        }
    }

    public static void main(String args[]){

        Construct pq = new Construct(new ArrayList<>());

        pq.add(5);  //pq.printHeapArrayList();
        pq.add(10); //pq.printHeapArrayList();
        pq.add(17); //pq.printHeapArrayList();
        pq.add(40); //pq.printHeapArrayList();
        //pq.add(15); //pq.printHeapArrayList();
        //pq.add(30); //pq.printHeapArrayList();
        //pq.add(42); //pq.printHeapArrayList();

        pq.printHeapArrayList();
        pq.remove();
        pq.printHeapArrayList();
    }

    void printHeapArrayList(){
        list.forEach(i -> System.out.print(i+" "));
        System.out.println();
    }
}