import java.util.ArrayList;

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
      The boolean value true is returned if there are no cards remaining.
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
   
   
//    // testing
//    public static void main(String[] args)
//    {
//       Deck myDeck = new Deck();
//       myDeck.shuffle();
// //       Card firstCard = myDeck.dealCard();
// //       System.out.println(firstCard);
// //       Card secondCard = myDeck.dealCard();
// //       System.out.println(secondCard);
// //       System.out.println(firstCard.equals(secondCard));
// //       System.out.println(myDeck.getSize());
// //       System.out.println(myDeck.isEmpty());
//       Pile myPile = new Pile(myDeck, 26);
//       System.out.println(myPile.getSize());
//       Card firstCard = myPile.dealCard();
//       System.out.println(firstCard);
//       System.out.println(myPile.getSize());
//       myPile.addCard(firstCard);
//       System.out.println(myPile.getSize());
//       System.out.println(myPile.isEmpty());
//       Pile myPileTwo = new Pile(myDeck, 26);
//       System.out.println(myPileTwo.isEmpty());
//       
//    }
   
}