package com.skilldisitillery.cards.common;

public enum Suit {

  HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

  final private String name;

  Suit(String d) {
    name = d;
  }

  @Override
  public String toString() {
    return name;
  }

//  public String getName() {
//    return name;
//  }

}
