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
    
    public List(){
        this.listName = "";
        Card firstCard = new Card();
        headCard = firstCard;
        tailCard = firstCard;
    }
    
    public List(String name){
        this.listName = name;
        Card firstCard = new Card();
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
    
    public void printList() {
        if (this.listName == null) {
            System.out.println("There was a problem retrieving your List...");
            return; // trying to catch bad calls to printList()
        }
        // when printList() is called it prints the List name and all of its Cards to console
        System.out.println("********************************");
        System.out.println("********************************");
        System.out.println("List: " + this.listName);
        System.out.println("********************************");
        Card printCard = new Card();        // printCard is a Card used to walk through the list
        printCard = this.headCard;          // printCard starts at headCard, might be null
        int index = 0;
        while (printCard != null) {
            System.out.println(index + ": " + printCard);
            if (printCard.hasNext()) {
                printCard = printCard.getNext();
                index++;
            }
            else {
                break;  // there is not a next Card to print, move forward
            }
        }
        System.out.println("********* End of List *********");
    }
}
