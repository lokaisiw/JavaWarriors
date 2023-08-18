/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deliverable;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Liam Lokaisingh
 */
public class GroupOfCards {
    private ArrayList<Card> cards;
    
    public GroupOfCards() {
        cards = new ArrayList<>();
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }
    
    public void resetDeck() {
        cards.addAll(cards);
        shuffle();
    }
}
