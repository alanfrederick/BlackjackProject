package com.skilldisitillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

  // create new deck list
  List<Card> deck = new ArrayList<>();

  // check remaining deck size
  public int checkDeckSize() {
    return deck.size();
  }

  // deck array for suits and ranks, iterate over arrays to create a
  // new card object and add to the deck
  
  public Deck() {
    Suit[] suits = Suit.values();
    Rank[] ranks = Rank.values();
    for (Rank rank : ranks) {
      for (Suit suit : suits) {
        Card c = new Card(rank, suit);
        deck.add(c);
      }
    }
  }

  // Remove top card from array and return result
  public Card dealCard() {
    return deck.remove(0);
  }

  // Shuffle the deck
  public void shuffleDeck() {
    Collections.shuffle(deck);
  }
}
