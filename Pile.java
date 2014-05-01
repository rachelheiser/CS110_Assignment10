import java.util.ArrayList;
import java.util.Random;

// Rachel Heiser
// CS110 Assignment10
// Piles class

public class Pile extends Deck implements PileInterface
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
      The isEmpty methoddetermines if the pile has any cards remaining.
      @return The boolean value true if there are no cards remaining.
      Otherwise, the boolean value false is returned.
   */
   
   public boolean isEmpty()
   {
      if (pile.size() == 0)
         return true;
      else
         return false;   
   }
   
   /**
      The dealCard method removes a Card from the pile and
      returns the Card.
      @return A Card from the top of the pile.
   */
   
   public Card dealCard()
   {
      Card tempCard = pile.remove(0);
      return tempCard;
   }
   
   /**
      The addCard method adds a Card to the end of the pile.
      @param newCard The card to add to the pile.
   */
   
   public void addCard(Card newCard)
   {
      pile.add(newCard);
   }
   
   /**
      The shuffle method shuffles cards in the pile.
   */
   
   public void shuffle()
   {
      int rNum;
      Card tempCard;
      Random r = new Random();
      for (int i = 0; i < pile.size(); i++)
      {
         rNum = r.nextInt(pile.size());
         tempCard = pile.get(i);
         pile.set(i,pile.get(rNum));
         pile.set(rNum,tempCard);
      }
   }
}