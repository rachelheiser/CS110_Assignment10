import java.util.ArrayList;

// Rachel Heiser
// CS110 Assignment10
// Piles class

public class Pile extends Deck
{
   ArrayList<Card> pile;
   int numCards;        // to hold number of cards in pile
   
   /**
      The constructor takes a given number of cards from 
      a deck and puts them in an ArrayList.  The constructor
      will also set numCards.
      @param deck The deck to take cards from
      @param nCards The number of cards to draw from the deck.
   */
   
   public Pile(Deck deck, int nCards)
   {
      // set numCards
      numCards = nCards;
      
      // create pile
      pile = new ArrayList<Card>(nCards);
      
      // add Cards to pile
      for (int i = 0; i < nCards; i++)
      {
         // take top card from deck and add to pile
         pile.add(deck.dealCard());
      }
   }
   
   /**
      The getSize method
      @return The number of Cards in the pile.
   */
   
   public int getSize()
   {
      return pile.size();
   }
   
   /**
      The dealCard method removes a Card from the pile and
      returns the Card.
      @return A Card from the top of the pile.
   */
   
   
}