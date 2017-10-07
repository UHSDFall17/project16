/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group16.project16;

/**
 * @author ryan
 * 
 */
public class Board {
    private String boardName;
    private List headList;
    private List tailList;
    
    public Board(String name) {
        this.boardName = name;
        //List firstList = new List();
        this.headList = null;
        this.tailList = null;
    }
    
    public Board(String bName, String lName) {
        this.boardName = bName;
        List firstList = new List(lName);
        this.headList = firstList;
        this.tailList = firstList;
    }
    
    public String getName() {
        return this.boardName;
    }
    
    public void setName(String newName) {
        this.boardName = newName;
    }
    
    public void addList(List newList) {
        // even though we added a first List when we made the Board, the user may
        //      delete all the List, this if-else accounts for that
        //List newList = new List(nList.getName());
        if (this.headList == null) {
            this.headList = newList;
            this.tailList = newList;
        }
        else {
            this.tailList.setNext(newList);
            newList.setPrev(this.tailList);
            this.tailList = newList;
        }
    }
    
    public void removeList(List oldList) {
        // check if headList
        if (oldList != headList) {
            // set the card before oldCard's next card to the one after oldCard
            oldList.getPrev().setNext(oldList.getNext());
        }
        else {
            // oldList == headList 
            headList = oldList.getNext();
            headList.setPrev(null);
        }
        // check if tailList
        if (oldList != tailList) {
            // set the card after oldCard's previous card to the one before oldCard
            oldList.getNext().setPrev(oldList.getPrev());
        }
        else {
            // oldList == tailList
            tailList = oldList.getPrev();
            tailList.setNext(null);
        }
        // now oldList is no longer in the linked list
    }
    
}
