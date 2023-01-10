package deque;

import afu.org.checkerframework.checker.oigj.qual.World;

import java.util.Iterator;

/*
represents a generic linked list based deque
 */
public class LinkedListDeque <T>  {


    /**
     * represents a node of the linked list
     */
    public class Node{

        //item of generic type
        public T item;

        //represents pointer to the next node
        public Node next;

        //represents pointer to previous node
        public Node prev;

        public Node(T item, Node next, Node prev){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }



    //caches the size of the linked list so we can access in constant time
    public int size;


    //represent a sentinel node
    //sentinel.next points to the first node in the LL
    //sentinel.prev points to the last node in the LL

    public Node sentinel;


    @SuppressWarnings("unchecked")
    //creates an empty linked list deque
    public LinkedListDeque(){

        this.sentinel = new Node((T) "sentinel", null, null);
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
        this.size = 0;

    }
    public void addFirst(T item){

        //TODO done
        //Adds an item of type T to the front of the deque
        //You can assume that item is never null.
        //MUST NOT INVOLVE ANY LOOPING OR RECURSION

        //creates new node to add
        Node newNode = new Node(item,null,null);

        //holds the front node which is the next node after sentinel
        Node temp = this.sentinel.next;

        //case where list is empty
        if (this.sentinel.next == this.sentinel && this.sentinel.prev == this.sentinel){

            //sentinel prev and next both point to new node
            this.sentinel.prev = newNode;
            this.sentinel.next = newNode;
            //new node prev and next both point to sentinel
            newNode.next = this.sentinel;
            newNode.prev =this.sentinel;
        }
        else{
            //sentinel.next points to new node
            this.sentinel.next = newNode;
            //newNode.prev points to this.sentinel
            newNode.prev = this.sentinel;
            //newNode.next points to the previous first node
            newNode.next = temp;
            //previous first node prev now points ot the new nod
            temp.prev = newNode;
        }
        this.size ++;

    }
    public void addLast(T item){

        //TODO done
        //Adds an item of type T to the back of the deque.
        //You can assume that item is never null
        //MUST NOT INVOLVE ANY LOOPING OR RECURSION

        //creates new node to add
        Node newNode = new Node(item,null,null);

        //holds the last node which is the "previous" node of sentinel
        Node temp = this.sentinel.prev;

        //case where list is empty
        if (this.sentinel.next == this.sentinel && this.sentinel.prev == this.sentinel){

            //sentinel prev and next both point to new node
            this.sentinel.prev = newNode;
            this.sentinel.next = newNode;
            //new node prev and next both point to sentinel
            newNode.next = this.sentinel;
            newNode.prev =this.sentinel;
        }
        else{
            //sentinel node prev now points at the new node, making it the last node
            this.sentinel.prev = newNode;
            //new node next points at the sentinel node
            newNode.next = this.sentinel;
            //temp next (which was the old last node) points at the new node
            temp.next = newNode;
            //new node prev points at temp
            newNode.prev = temp;
        }
        this.size++;
    }


    public boolean isEmpty(){

        //TODO done
        //returns true if deque is empty, otherwise false
        return this.sentinel.next == this.sentinel;
    }

    public int size(){

        //TODO done
        //returns the number of items in the deque
        return this.size;
    }


    public void printDeque(){

        //TODO done
        //Prints the items in the deque from first to last, separated by a space.
        //Once all the items have been printed, print out a new line

        //start at front and print -->
        Node temp = this.sentinel.next;

        while (temp != this.sentinel){
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public T removeFirst(){

        //TODO done
        //Removes and returns the item at the front of the deque.
        // If no such item exists, returns null.
        //MUST NOT INVOLVE ANY LOOPING OR RECURSION

        Node temp = this.sentinel.next;

        //if sentinel next is pointing to itself, that means it is empty
        if (temp == this.sentinel){
            return null;
        }
        else {
            //this breaks the connection of the first node
            this.sentinel.next = temp.next;
            temp.next.prev = this.sentinel;

            //first node set prev and next to null
            temp.next = null;
            temp.prev = null;
        }
        this.size--;
        return temp.item;
    }


    public T removeLast(){

        //TODO done
        //Removes and returns the item at the back of the deque.
        //If no such item exists, returns null.
        //MUST NOT INVOLVE ANY LOOPING OR RECURSION

        //holds the last node
        Node temp = this.sentinel.prev;

        //if sentinel next is pointing to itself, that means it is empty
        if (temp == this.sentinel){
            return null;
        }

        else{
            //sentinel node prev now points to node before the last node
            this.sentinel.prev = temp.prev;
            //previous node next points to the sentinel node
            temp.prev.next = this.sentinel;

            //last node prev and next points to null
            temp.prev = null;
            temp.next = null;
        }
        this.size --;
        return temp.item;
    }


    public T get(int index){

        //TODO
        //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
        // If no such item exists, returns null. Must not alter the deque!
        //MUST USE ITERATION

        int counter  = 0;
        Node temp = this.sentinel.next;
        while (temp != this.sentinel){
            if (counter == index) {
                return temp.item;
            }
            counter ++;
            temp = temp.next;
        }
        return null;
    }





    //TODO note to self : bulk of method is done and unit tests pass, just need to implement recursive get() [DONE]

    public T getRecursive(int index){
        //TODO
        //Same as get, but uses recursion

        if (index < 0 || index >= this.size){

            return null;
        }
        return this.getRecursiveHelper(0, index, this.sentinel.next);
    }
    
    public T getRecursiveHelper(int counter, int index, Node n){
        if (index == counter){
            return n.item;
        }
        return getRecursiveHelper(counter + 1, index, n.next);
    }




    //ALSO need to implement these 2 special methods

    /*
    public Iterator<T> iterator(){

        //TODO

    }

    public boolean equals(Object o){

        //TODO
        //Returns whether or not the parameter o is equal to the Deque.
        // o is considered equal if it is a Deque and if it contains the same contents
        // (as goverened by the generic T’s equals method) in the same order.

        return false;
    }

     */


    public static void main(String[] args) {

        LinkedListDeque <String> myLLD = new LinkedListDeque<>();

        myLLD.addLast("My");

        myLLD.addLast("Name");

        myLLD.addLast("is ZJ");

        myLLD.addFirst("World");

        myLLD.addFirst("Hello");

        System.out.println(myLLD.size());

        System.out.println(myLLD.get(0));

        System.out.println(myLLD.getRecursive(0));


        myLLD.printDeque();



    }






}
