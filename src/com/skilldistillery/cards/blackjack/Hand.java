package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;
import com.skilldisitillery.cards.common.Card;

public class Hand {

  private List<Card> hand = new ArrayList<>();

  public void addCard(Card card) {
    hand.add(card);
  }

  public int getValueOfHand() {
    int value = 0;
    for (Card card : hand) {
      value = value + card.getValue();
    }
    return value;
  }

  public void clearHand() {
    hand.clear();
  }

  public List<Card> getCards() {
    return hand;
  }

  public Card getFirstCard() {
    return hand.get(0);
  }

  @Override
  public String toString() {
    return hand.toString();
  }
  

}
