package com.skilldisitillery.cards.common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameApp {
  private static Deck deck = new Deck();

  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    deck.shuffleDeck();
    System.out.println("How may cards do would you like? ");
    int howMany = 0;
    try {
      howMany = input.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("That's not a number, Einstein.");
      
    }
    if (howMany > 52) {
      System.out.println("Not enough cards for that.");
      return;
    }
    for (int i = 0; i < howMany; i++) {
      Card card = deck.dealCard();
      System.out.println(card);
    }
    System.out.println("There are " + deck.checkDeckSize() + " cards left in the deck");

  }

}
