package com.skilldistillery.cards.blackjack;

public class Player {

  private Hand hand = new Hand();
  private String name;


  public boolean playerBust() {
    if (hand.getValueOfHand() > 21) {
      return true;
    } else {
      return false;
    }
  }

  public Hand getHand() {
    return hand;
  }

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
 
}
