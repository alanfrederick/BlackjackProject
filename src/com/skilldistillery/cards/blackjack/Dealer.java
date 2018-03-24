package com.skilldistillery.cards.blackjack;

import com.skilldisitillery.cards.common.Deck;

public class Dealer {
  private Deck deck = new Deck();
  private Hand hand = new Hand();

  public boolean dealerBust() {
    if (hand.getValueOfHand() > 21) {
      return true;
    } else {
      return false;
    }
  }

  public boolean dealerShouldHit() {
    if (hand.getValueOfHand() < 17) {
      return true;
    } else {
      return false;
    }
  }

  public Deck getDeck() {
    return deck;
  }

  public Hand getHand() {
    return hand;
  }

  public void resetDeck() {
    deck = new Deck();
  }
}
