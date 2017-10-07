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
    
    public Card() {
        this.cardText = "";
        this.nextCard = null;
        this.prevCard = null;
    }
    
    public Card(String text) {
        this.cardText = text;
        this.nextCard = null;
        this.prevCard = null;
    }
    
    public String getText() {
        return this.cardText;
    }
    
    public void changeText(String newText) {
        this.cardText = newText;
    }
    
    public void setNext(Card nCard) {
        this.nextCard = nCard;
    }
    
    public void setPrev(Card pCard) {
        this.prevCard = pCard;
    }
     
    public boolean hasNext() {
        if (this.nextCard != null) {
            return true;
        }
        else 
            return false;
    }
    
    public Card getNext() {
        return this.nextCard;
    }
    
    public boolean hasPrev() {
        if (this.prevCard != null) {
            return true;
        }
        else
            return false;
    }
    
    public Card getPrev() {
        return this.prevCard;
    }
}
