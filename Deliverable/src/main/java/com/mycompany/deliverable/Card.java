/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deliverable;

/**
 *
 * @author Liam Lokaisingh
 */
public class Card {
    private String suit;
    private int value;
    
    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }
    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public String toString() {
        return value + " of " + suit;
    }
    
    public int getValue() {
        return value;
    }
}
