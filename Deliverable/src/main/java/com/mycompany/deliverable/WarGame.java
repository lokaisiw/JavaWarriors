/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deliverable;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
/**
 *
 * @author Liam Lokaisingh
 */
public class WarGame {

    private GroupOfCards deck;
    private Player player1;
    private Player player2;
    
    public WarGame(String name) {
        deck = new GroupOfCards();
        initializeDeck();
        initializePlayers();
    }
    
    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        int [] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; // Ace is 14.
           
        for (String suit: suits) {
            for (int value : values) {
                deck.addCard(new Card(suit, value));
            }
        }
        deck.shuffle();
    }
    
    private void initializePlayers() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");

        Queue<Card> deckQueue = new LinkedList<>(deck.getCards());
        while (!deckQueue.isEmpty()) {
            player1.addToHand(deckQueue.poll());
            if (!deckQueue.isEmpty()) {
                player2.addToHand(deckQueue.poll());
            }
        }
    }
    
    public void play() {
        Scanner scanner = new Scanner(System.in);
        int round = 1;
        
        while (player1.hasCards() && player2.hasCards()) {
            System.out.println("Round " + round);
            
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();
            
            System.out.println(player1.getName() + " plays: " + player1.playCard());
            System.out.println(player2.getName() + " plays: " + player2.playCard());
            
            int comparison = Integer.compare(card1.getValue(), card2.getValue());
            
            if (comparison > 0) {
                player1.addToHand(card1);
                player1.addToHand(card2);
                System.out.println(player1.getName() + " wins the round!");
            } else if (comparison < 0) {
                player2.addToHand(card1);
                player2.addToHand(card2);
                System.out.println(player2.getName() + " wins the round!");
            } else {
                System.out.println("War!");
                handleWarScenario(card1, card2);
            }
            
            round++;
        }
        
        scanner.close();
    }
    
    private void handleWarScenario(Card card1, Card card2) {
        GroupOfCards warPile = new GroupOfCards();
        warPile.addCard(card1);
        warPile.addCard(card2);

        for (int i = 0; i < 3; i++) {
            if (player1.hasCards() && player2.hasCards()) {
                warPile.addCard(player1.playCard());
                warPile.addCard(player2.playCard());
            }
        }

        if (player1.hasCards() && player2.hasCards()) {
            Card warCard1 = player1.playCard();
            Card warCard2 = player2.playCard();

            System.out.println(player1.getName() + " plays a war card: " + warCard1);
            System.out.println(player2.getName() + " plays a war card: " + warCard2);

            int comparison = Integer.compare(warCard1.getValue(), warCard2.getValue());

            if (comparison > 0) {
                for (Card card : warPile.getCards()) {
                    player1.addToHand(card);
                }
                System.out.println(player1.getName() + " wins the war!");
            } else if (comparison < 0) {
                for (Card card : warPile.getCards()) {
                    player2.addToHand(card);
                }
                System.out.println(player2.getName() + " wins the war!");
            } else {
                System.out.println("Another war!");
                handleWarScenario(warCard1, warCard2);
            }
        }
    }

    public void declareWinner() {
        if (!player1.hasCards()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println(player1.getName() + " wins the game!");
        }
    }

    public static void main(String[] args) {
        WarGame warGame = new WarGame("War");
        warGame.play();
        warGame.declareWinner();
    }
}
