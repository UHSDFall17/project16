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
public class Card extends Node{
    private String cardText;
    
    Card() {
        super();
        this.cardText = "";
    }
    
    Card(String text) {
        this.cardText = text;
    }
    
    String getText() {
        return this.cardText;
    }
    
    void changeText(String newText) {
        this.cardText = newText;
    }
}
