## Blackjack Project
SD14 Weekend Project

#### Project Info
A simple blackjack game where the dealer follows house rules.  This version does not
implement Aces being 1 or 11, nor includes betting.  This will be a good stretch goal in the future.


#### How to play
Upon running the application the user is given the option to either play Blackjack or not.  If the user
choses not to, a simple message displays and the program terminates.

The game consists of being dealt a hand against the dealer and trying to reach 21 without going over.  Each time the user
is dealt a card the option to continue (hit) or stop (stay) are presented.  If the user, or the dealer go over 21 (bust),
a message is displayed and the winner is presented.  In the even of a tie (push), this message is displayed and the game resets itself.

If the standard deck of 52 cards gets below 10, the deck is taken back, reshuffled, and then redealt.  This version of the game only uses
one deck of cards.