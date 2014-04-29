import java.util.ArrayList;

// Rachel Heiser
// CS110 Assignment10
// War class

public class War
{
   String roundWinner;           // to hold the winner of a round
   String overallWinner;
   Pile player1;                 // to hold player1's cards
   Pile player2;                 // to hold player2's cards
   ArrayList<Card> roundCards;   // holds the cards laid out during the round
   
   /**
      The constructor creates a deck, creates a pile for 
      each player from the deck, and sets up an ArrayList that
      will hold cards used in a round.
   */
   
   public War()
   {
      // create a deck for game
      Deck gameDeck = new Deck();
      // shuffle the deck
      gameDeck.shuffle();
      // create a pile for player1
      player1 = new Pile(gameDeck, 26);
      // create a pile for player2
      player2 = new Pile(gameDeck, 26);
      
      // create an ArrayList
      roundCards = new ArrayList<Card>();
   }
   
   /**
      The flip method takes the top card from each player's
      pile and compare them.
   */
   
   public void flip()
   {
      Card p1Card = player1.dealCard();
      Card p2Card = player2.dealCard();
      
      // add cards to the roundCards ArrayList
      roundCards.add(p1Card);
      roundCards.add(p2Card);
      
      // compare the ranks of the cards
      compareCards(p1Card, p2Card);
   }
   
   /**
      The compareCards method will compare the ranks of two
      given cards and set the round winner
      @param card1 Player1's card
      @param card2 Player2's card
   */
   
   private void compareCards(Card card1, Card card2)
   {
      // if either player has an empty pile, the game is over, otherwise
      // draw cards
      if (!isGameOver())
         {
         if (card1.equals(card2))
         {
            roundWinner = null;
         }
         else if (card1.getRank() > card2.getRank())
         {
            roundWinner = "Player 1";
         }
         else
         {
            roundWinner = "Player 2";
         }
      }   
   }
   
   /**
      The assignPoints method will add the cards of the round
      to the winning player's pile.
   */
   
   public void assignPoints()
   {
      if (roundWinner.equals("Player 1"))
      {
         // add round cards to player1's pile
         for (Card card : roundCards)
            player1.addCard(card);
      }
      else if (roundWinner.equals("Player 2"))
      {
         // add round cards to player2's pile
         for (Card card : roundCards)
            player2.addCard(card);
      }
      else
      {
         while (!roundWinner.equals("Player 1") && 
                     !roundWinner.equals("Player 2"))
         {
            war();
         }        
              
      }
   }
   
   /**
      The war method takes the top two cards from both
      player's piles. One card from each of the pairs are
      flipped. If there is no winner, the second cards are
      flipped.
   */
   
   public void war()
   {
      // take top two cards from each pile
      Card p1Card1 = player1.dealCard();
      Card p1Card2 = player1.dealCard();
      Card p2Card1 = player2.dealCard();
      Card p2Card2 = player2.dealCard();
      
      // add cards to roundCards ArrayList
      roundCards.add(p1Card1);
      roundCards.add(p1Card2);
      roundCards.add(p2Card1);
      roundCards.add(p2Card2);
      
      // if  either player has run out of cards, game is over
      if (!isGameOver())
      { 
         compareCards(p1Card1, p2Card1);
         
         if (!roundWinner.equals("Player 1") && 
                  !roundWinner.equals("Player 2"))
         {
            compareCards(p1Card2, p2Card2);    
         }   
      }         
      
   }
   
   /**
      The isGameOver method determines if either player has run out of cards.
      If a player has an empty pile, they will automatically lose.
      @return True if a player has an empty pile. Otherwise, false is returned.
   */
   
   public boolean isGameOver()
   {
      // if player1's pile is empty, player2 wins
      if (player1.isEmpty())
      {
         overallWinner = "Player 2";
         return true;
      }
      // if player2's pile is empty, player1 wins
      else if (player2.isEmpty())
      {
         overallWinner = "Player 1";
         return true;
      }
      // otherwise the game can continue
      else
      {
         return false;
      }
      
   }
   
   /**
      The getRoundCards method
      @return An array list containing the cards used during a round.
   */
   
   public ArrayList<Card> getRoundCards()
   {
      return roundCards;
   }  
   
   /**
      The getRoundWinner method
      @return A string containing the winner of the round.
   */
   
   public String getRoundWinner()
   {
      return roundWinner;
   }
   
   /**
      The getOverallWinner method
      @return A string containing the winner of the game.
   */
}