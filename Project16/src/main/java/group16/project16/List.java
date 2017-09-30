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
public class List {
    private String listName;
    private Card headCard;
    private Card tailCard;
    private List nextList;
    private List prevList;
    
    public List(String name){
        this.listName = name;
        Card firstCard = new Card("Add something...");
        headCard = firstCard;
        tailCard = firstCard;
    }
    
    public String getName() {
        return this.listName;
    }
    
    public void editName(String newName) {
        this.listName = newName;
    }
    
    public void addCard(Card newCard) {
        // even though we added a first card when we made the list, the user may
        //      delete all the cards, this if-else accounts for that
        if (headCard == null) {
            headCard = newCard;
            tailCard = newCard;
        }
        else {
            tailCard.setNext(newCard);
            newCard.setPrev(tailCard);
            tailCard = newCard;
        }
    }
    
    public void removeCard(Card oldCard) {
        // check if headCard
        if (oldCard != headCard) {
            // set the card before oldCard's next card to the one after oldCard
            oldCard.getPrev().setNext(oldCard.getNext());
        }
        else {
            // oldCard == headCard 
            headCard = oldCard.getNext();
            headCard.setPrev(null);
        }
        // check if tailcard
        if (oldCard != tailCard) {
            // set the card after oldCard's previous card to the one before oldCard
            oldCard.getNext().setPrev(oldCard.getPrev());
        }
        else {
            // oldCard == tailCard
            tailCard = oldCard.getPrev();
            tailCard.setNext(null);
        }
        // now oldCard is no longer in the linked list
    }
    
    public void setNext(List nList) {
        this.nextList = nList;
    }
    
    public void setPrev(List pList) {
        this.prevList = pList;
    }
     
    public boolean hasNext() {
        if (this.nextList != null) {
            return true;
        }
        else 
            return false;
    }
    
    public List getNext() {
        return this.nextList;
    }
    
    public boolean hasPrev() {
        if (this.prevList != null) {
            return true;
        }
        else
            return false;
    }
    
    public List getPrev() {
        return this.prevList;
    }
}
