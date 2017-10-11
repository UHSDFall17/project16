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
    
    public void printBoard() {
        if (this.boardName == null) {
            System.out.println("There was a problem retrieving your Board...");
            return; // trying to catch bad calls to printList()
        }
        // when printList() is called it prints the List name and all of its Cards to console
        System.out.println("********************************");
        System.out.println("********************************");
        System.out.println("Board: " + this.boardName);
        System.out.println("********************************");
        List printList = null;        // printList is a List used to walk through the Board
        printList = this.headList;          // printList starts at headList, might be null
        int index = 0;
        while (printList != null) {
            System.out.println(index + ": " + printList);
            if (printList.hasNext()) {
                printList = printList.getNext();
                index++;
            }
            else {
                break;  // there is not a next List to print, move forward
            }
        }
        System.out.println("********* End of Board *********");
    }
}
