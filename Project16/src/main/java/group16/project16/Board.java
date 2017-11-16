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
public class Board extends Node {
    private String boardName;
    private List headList;
    private List tailList;
    
    Board(String name) {
        super();
        boardName = name;
        //List firstList = new List();
        headList = null;
        tailList = null;
    }
    
    String getName() {
        return this.boardName;
    }
    
    void setName(String newName) {
        this.boardName = newName;
    }
    
    void addList(List newList) {
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
    
    void removeList(List oldList) {
        // check if headList
        if (oldList != headList) {
            // set the card before oldCard's next card to the one after oldCard
            oldList.getPrev().setNext(oldList.getNext());
        }
        else {
            // oldList == headList 
            if (headList == tailList) {
                // only one List on this Board and we are removing it
                headList = null;
                tailList = null;
                return;
            }
            headList = (List)oldList.getNext();
            headList.setPrev(null);
        }
        // check if tailList
        if (oldList != tailList) {
            // set the card after oldCard's previous card to the one before oldCard
            oldList.getNext().setPrev(oldList.getPrev());
        }
        else {
            // oldList == tailList
            tailList = (List)oldList.getPrev();
            tailList.setNext(null);
        }
        // now oldList is no longer in the linked list
    }
    
    List getHead() {
        return this.headList;
    }
    
    List getTail() {
        return this.tailList;
    }
    
}
