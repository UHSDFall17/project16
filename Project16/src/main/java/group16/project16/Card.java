/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group16.project16;

/**
 * @author ryan
 * 
 * Cards are like nodes. They hold text at the moment.
 *      Eventually they may be associated with an event, task, and/or attachment
 */
public class Card {
    private String cardText;
    private Card prevCard;
    private Card nextCard;
    
    Card() {
        this.cardText = "";
        this.nextCard = null;
        this.prevCard = null;
    }
    
    Card(String text) {
        this.cardText = text;
        this.nextCard = null;
        this.prevCard = null;
    }
    
    String getText() {
        return this.cardText;
    }
    
    void changeText(String newText) {
        this.cardText = newText;
    }
    
    void setNext(Card nCard) {
        this.nextCard = nCard;
    }
    
    void setPrev(Card pCard) {
        this.prevCard = pCard;
    }
     
    boolean hasNext() {
        if (this.nextCard != null) {
            return true;
        }
        else 
            return false;
    }
    
    Card getNext() {
        return this.nextCard;
    }
    
    boolean hasPrev() {
        if (this.prevCard != null) {
            return true;
        }
        else
            return false;
    }
    
    Card getPrev() {
        return this.prevCard;
    }
}
