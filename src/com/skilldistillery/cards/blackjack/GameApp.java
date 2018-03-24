package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class GameApp {
  static Dealer dealer = new Dealer();
  static Player player = new Player();
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Enter name");
    player.setName(input.nextLine());
    System.out.println("Would you like to play blackjack, " + player.getName() + "?  1 Yes, 2 No");
    int choice = input.nextInt();
    if (choice == 1) {
      playRound();
    } else {
      System.out.println("Another time, then!");
      System.exit(0);
    }
    input.close();
  }

  public static void playRound() {
    dealer.getDeck().shuffleDeck();
    playerHit();
    dealerHit();
    playerHit();
    dealerHit();
    System.out.println("Your hand is: " + player.getHand());
    System.out.println("The current value of your hand is " + player.getHand().getValueOfHand());
    System.out.println("The dealer is showing " + dealer.getHand().getFirstCard());
    playerTurn();
    dealerTurn();
    displayWhoWon();
  }
  
  private static void displayWhoWon() {
    if (player.getHand().getValueOfHand() > dealer.getHand().getValueOfHand()) {
      System.out.println("The dealer had: " + dealer.getHand() + " with a value of " + dealer.getHand().getValueOfHand());
      System.out.println("You had : " + player.getHand() + " with a value of " + player.getHand().getValueOfHand());
      System.out.println("You won!");
      resetRound();
    } else if (dealer.getHand().getValueOfHand() > player.getHand().getValueOfHand()) {
      System.out.println("The dealer had: " + dealer.getHand() + " with a value of " + dealer.getHand().getValueOfHand());
      System.out.println("You had : " + player.getHand() + " with a value of " + player.getHand().getValueOfHand());
      System.out.println("The dealer won!");
      resetRound();
    } else if (dealer.getHand().getValueOfHand() == player.getHand().getValueOfHand()) {
      System.out.println("Push!");
      resetRound();
    }
  }

  private static void playerTurn() {

    System.out.println("To hit, press 1.  To stay, press 2.");
    int choice = input.nextInt();
    while (choice == 1) {
      playerHit();
      System.out.println("Your hand is: " + player.getHand());
      System.out.println("The current value of your hand is " + player.getHand().getValueOfHand());
      if (player.playerBust()) {
        System.out.println("You busted!  :(");
        resetRound();
      }
      System.out.println("To hit, press 1.  To stay, press 2.");
      choice = input.nextInt();
    }

  }

  private static void playerHit() {
    player.getHand().addCard(dealer.getDeck().dealCard());

  }

  private static void dealerTurn() {
    while (dealer.dealerShouldHit()) {
      dealerHit();
      if (dealer.dealerBust()) {
        System.out.println("The dealer had: " + dealer.getHand() + " with a value of " + dealer.getHand().getValueOfHand());
        System.out.println("You had : " + player.getHand() + " with a value of " + player.getHand().getValueOfHand());
        System.out.println("Dealer busts, you win!");
      }
    }
  }

  private static void dealerHit() {
    dealer.getHand().addCard(dealer.getDeck().dealCard());
  }

  private static void resetRound() {
    player.getHand().clearHand();
    dealer.getHand().clearHand();
    System.out.println("Would you like to play again? 1 for Yes, 2 for No");
    int choice = input.nextInt();
    if (choice == 1) {
      playRound();
    } else {
      System.out.println("Thanks for playing.");
      System.exit(0);
    }

  }
}