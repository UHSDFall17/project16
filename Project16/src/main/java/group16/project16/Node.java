/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group16.project16;

/**
 *  Previous iterations had redundant methods between classes so I created Node to eliminate some redundancy.
 *  Node's are objects that point to other objects of type Node that are considered to be next (succeeding the node) 
 *  and previous (preceding the Node). 
 *  At the moment I intend for Card and List to extend this class.
 * 
 * @author ryan
 */
public class Node<T> {
    
    private Node<T> next;
    private Node<T> previous;
    
    Node() {
        this.next = null;
        this.previous = null;
    }
    
    void setNext(Node newNext) {
        this.next = newNext;
    }
    
    void setPrev(Node newPrev) {
        this.previous = newPrev;
    }
     
    boolean hasNext() {
        if (this.next != null) {
            return true;
        }
        else 
            return false;
    }
    
    Node getNext() {
        return this.next;
    }
    
    boolean hasPrev() {
        if (this.previous != null) {
            return true;
        }
        else
            return false;
    }
    
    Node getPrev() {
        return this.previous;
    }
}
