import java.util.ArrayList;
import javax.swing.*;
import java.util.Random;

// Rachel Heiser
// CS110 Assignment10
// Deck class

public class Deck
{
   // declare a deck ArrayList
   ArrayList<Card> deck;
   
   // create an array of image names
   String[] pics = {"2c.jpg","2d.jpg","2h.jpg","2s.jpg",
                    "3c.jpg","3d.jpg","3h.jpg","3s.jpg",
                    "4c.jpg","4d.jpg","4h.jpg","4s.jpg",
                    "5c.jpg","5d.jpg","5h.jpg","5s.jpg",
                    "6c.jpg","6d.jpg","6h.jpg","6s.jpg",
                    "7c.jpg","7d.jpg","7h.jpg","7s.jpg",
                    "8c.jpg","8d.jpg","8h.jpg","8s.jpg",
                    "9c.jpg","9d.jpg","9h.jpg","9s.jpg",
                    "10c.jpg","10d.jpg","10h.jpg","10s.jpg",
                    "jackc.jpg","jackd.jpg","jackh.jpg","jacks.jpg",
                    "queenc.jpg","queend.jpg","queenh.jpg","queens.jpg",
                    "kingc.jpg","kingd.jpg","kingh.jpg","kings.jpg",
                    "acec.jpg","aced.jpg","aceh.jpg","aces.jpg"};
                       
   /**
      The constructor creates a deck.
   */ 
   
   public Deck()
   {
      newDeck();
   }  
   
   /**
      The newDeck method creates a fresh deck.
   */ 
   
   public void newDeck()
   {
      ImageIcon im;  // will hold image for a card
      deck = new ArrayList<Card>();
      int position = 0; // starting position in image name array
      // go through all the card ranks
      for (int r = 2; r <= Card.ACE; r++)
      {
         // go through all the card suits
         for (int s = Card.CLUBS; s<= Card.SPADES; s++)
         {
            // get image for card
            im = new ImageIcon(pics[position]);
            // create Card object and add it to the deck
            deck.add(new Card(r, s, im));
            position++;
         }
      }
   } 
   
   /**
      The shuffle method shuffles the cards in the deck.
   */
   
   public void shuffle()
   {
      int rNum;
      Card tempCard;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         rNum = r.nextInt(deck.size());
         tempCard = deck.get(i);
         deck.set(i,deck.get(rNum));
         deck.set(rNum,tempCard);
      }
   }
   
   /**
      The dealCard method removes a card from the deck and
      returns the card.
      @return A card from the top of the deck.
   */
   
   public Card dealCard()
   {
      Card topCard = deck.remove(0);
      return topCard;
   }
   
   /**
      The getSize method
      @return The number of cards in the deck.
   */
   
   public int getSize()
   {
      return deck.size();
   }
   
   /**
      The isEmpty method determines if the deck has any cards remaining.
      The boolean value true is returned if there are no cards remaining.
      Otherwise, the boolean value false is returned.
   */
   
   public boolean isEmpty()
   {
      if (deck.size() == 0)
         return true;
      else
         return false;   
   }
                
}