package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class GameApp {
  static Dealer dealer = new Dealer();
  static Player player = new Player();
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    // Beginning of game, ask for name and if user wants to play
    System.out.println("Enter name");
    player.setName(input.nextLine());
    System.out.println("Would you like to play blackjack, " + player.getName() + "?  1 Yes, 2 No");
    int choice = input.nextInt();
    if (choice == 1) {
      playRound();
    } else if (choice == 2) {
      System.out.println("Another time, then!");
      System.exit(0);
    } else {
      System.out.println("Please choose a valid option!");
      invalidChoice();
    }
  }
  
// handle invalid input from user
  public static void invalidChoice() {
    System.out.println("Would you like to play blackjack, " + player.getName() + "?  1 Yes, 2 No");
    int choice = input.nextInt();
    if (choice == 1) {
      playRound();
    } else if (choice == 2) {
      System.out.println("Another time, then!");
      System.exit(0);
    }
    else {
      System.out.println("Please choose a valid option!");
      invalidChoice();
    }
  }

  public static void playRound() {
    // check if deck is under 10 cards, reset deck if necessary
    if (dealer.getDeck().checkDeckSize() < 10) {
      dealer.resetDeck();
      System.out.println("***The current deck has less than 10 cards***\n.  Shuffling new deck...");
    }
    // dealer shuffles deck and deals initial two cards to player and dealer
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

  // method checking who wins based on blackjack game conditions
  private static void displayWhoWon() {
    if (player.getHand().getValueOfHand() > dealer.getHand().getValueOfHand()) {
      System.out
          .println("The dealer had: " + dealer.getHand() + " with a value of " + dealer.getHand().getValueOfHand());
      System.out.println("You had : " + player.getHand() + " with a value of " + player.getHand().getValueOfHand());
      System.out.println("You won!");
      resetRound();
    } else if (dealer.getHand().getValueOfHand() > player.getHand().getValueOfHand()) {
      System.out
          .println("The dealer had: " + dealer.getHand() + " with a value of " + dealer.getHand().getValueOfHand());
      System.out.println("You had : " + player.getHand() + " with a value of " + player.getHand().getValueOfHand());
      System.out.println("The dealer won!");
      resetRound();
    } else if (dealer.getHand().getValueOfHand() == player.getHand().getValueOfHand()) {
      System.out.println("~~Push!~~");
      resetRound();
    }
  }

  private static void playerTurn() {
    // give user option to hit or stay and return value of current hand
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

  // deal new card to player
  private static void playerHit() {
    player.getHand().addCard(dealer.getDeck().dealCard());

  }

  // dealer logic, hard coded in dealer class to hit on < 17 and bust > 21
  private static void dealerTurn() {
    while (dealer.dealerShouldHit()) {
      dealerHit();
      if (dealer.dealerBust()) {
        System.out
            .println("The dealer had: " + dealer.getHand() + " with a value of " + dealer.getHand().getValueOfHand());
        System.out.println("You had : " + player.getHand() + " with a value of " + player.getHand().getValueOfHand());
        System.out.println("Dealer busts, you win!");
        resetRound();
      }
    }
  }

  // deal new card to dealer
  private static void dealerHit() {
    dealer.getHand().addCard(dealer.getDeck().dealCard());
  }

  // method to reset round asking if player wants to play again, card list is
  // cleared with .clear() method in hand class
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