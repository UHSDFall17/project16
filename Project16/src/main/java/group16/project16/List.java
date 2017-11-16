/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group16.project16;

/**
 * @author ryan
 * 
 * Lists are double-linked lists of Card. 
 *  Lists also act like nodes for the double-linked lists of Boards.
 */
public class List extends Node{
    private String listName;
    private Card headCard;
    private Card tailCard;
    
    List(){
        super();        // call to superClass constructor for Node
        listName = "";
        Card firstCard = new Card();
        headCard = firstCard;
        tailCard = firstCard;
    }
    
    List(String name){
        super();
        listName = name;
        Card firstCard = new Card();
        headCard = firstCard;
        tailCard = firstCard;
    }
    
    String getName() {
        return this.listName;
    }
    
    void editName(String newName) {
        this.listName = newName;
    }
    
    void addCard(Card newCard) {
        // even though we added a first card when we made the list, the user may
        //      delete all the cards, this if-else accounts for that
        //Card newCard = new Card(nCard.getText());
        
        if (this.headCard == null) {
            this.headCard = newCard;
            this.tailCard = newCard;
        }
        else {
            this.tailCard.setNext(newCard);
            newCard.setPrev(this.tailCard);
            this.tailCard = newCard;
        }
    }
    
    void removeCard(Card oldCard) {
        // check if headCard
        if (oldCard != headCard) {
            // set the card before oldCard's next card to the one after oldCard
            oldCard.getPrev().setNext(oldCard.getNext());
        }
        else {
            // oldCard == headCard 
            if (headCard == tailCard) {
                headCard = null;
                tailCard = null;
                return;
            }
            headCard = (Card)oldCard.getNext();
            headCard.setPrev(null);
        }
        // check if tailcard
        if (oldCard != tailCard) {
            // set the card after oldCard's previous card to the one before oldCard
            oldCard.getNext().setPrev(oldCard.getPrev());
        }
        else {
            // oldCard == tailCard
            tailCard = (Card)oldCard.getPrev();
            tailCard.setNext(null);
        }
        // now oldCard is no longer in the linked list
    }
    
    Card getHead() {
        return this.headCard;
    }
    
    Card getTail() {
        return this.tailCard;
    }
}
