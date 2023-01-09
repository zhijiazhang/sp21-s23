package deque;

import java.util.Iterator;

/*
represents a generic linked list based deque
 */
public class LinkedListDeque <T>  {

    //caches the size of the linked list so we can access in constant time
    public int size;

    //creates an empty linked list deque
    public LinkedListDeque(){


    }


    public void addFirst(T item){

        //TODO
        //Adds an item of type T to the front of the deque
        //You can assume that item is never null.
        //MUST NOT INVOLVE ANY LOOPING OR RECURSION
    }

    public void addLast(T item){

        //TODO
        //Adds an item of type T to the back of the deque.
        //You can assume that item is never null
        //MUST NOT INVOLVE ANY LOOPING OR RECURSION
    }


    public boolean isEmpty(){

        //TODO
        //returns true if deque is empty, otherwise false

        return false;
    }



    public int size(){

        //TODO
        //returns the number of items in the deque

        return 1;
    }


    public void printDeque(){

        //TODO
        //Prints the items in the deque from first to last, separated by a space.
        //Once all the items have been printed, print out a new line

    }


    public T removeFirst(){

        //TODO
        //Removes and returns the item at the front of the deque.
        // If no such item exists, returns null.
        //MUST NOT INVOLVE ANY LOOPING OR RECURSION

    }


    public T removeLast(){

        //TODO
        //Removes and returns the item at the back of the deque.
        //If no such item exists, returns null.
        //MUST NOT INVOLVE ANY LOOPING OR RECURSION
    }


    public T get(int index){

        //TODO
        //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
        // If no such item exists, returns null. Must not alter the deque!
        //MUST USE ITERATION
    }


    public T getRecursive(int index){

        //TODO
        //Same as get, but uses recursion
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











}
