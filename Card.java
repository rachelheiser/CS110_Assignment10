import javax.swing.*;

// Rachel Heiser
// CS110 Assignment10
// Card class

public class Card implements CardInterface
{
   // ranks jack through ace
   public static int JACK = 11;
   public static int QUEEN = 12;
   public static int KING = 13;
   public static int ACE = 14;
   
   // suits
   public static int CLUBS = 1;
   public static int DIAMONDS = 2;
   public static int HEARTS = 3;
   public static int SPADES = 4;
   
   int rank;      // to hold card rank
   int suit;      // to hold card suit
   ImageIcon pic; // to hold card image
   
   /**
      The constructor will set the rank, suit, and image of the Card.
      @param r The rank of card.
      @param s The suit of the card.
      @param im The card image.
   */
   
   public Card(int r, int s, ImageIcon im)
   {
      rank = r;
      suit = s;
      pic = im;
   }
   
   /**
      The getRank method returns the rank of the card as an int.
      @return The rank of the card.
   */
   
   public int getRank()
   {
      return rank;
   }
   
   /**
      The getSuit method returns the suit of the card as an int.
      @return The value of the suit.
   */
   
   public int getSuit()
   {
      return suit;
   }  
   
   /**
      The getPicture method returns the image associated with the card.
      @return The card image.
   */
   
   public ImageIcon getPicture()
   {
      return pic;
   }
   
   /**
      The equals method compares the ranks of two cards and determines
      if they are equal.
      @return True ff the two cards have the same rank. Otherwise, false is returned.
   */
   
   public boolean equals(Card object2)
   {
      if (rank == object2.rank)
         return true;
      else
         return false;   
   }
   
   /**
      The toString method returns a description of the card.
      @return A string indicating the card's rank and suit.
   */
   
   public String toString()
   {
      // create a string
      String str = "";
      
      // determine rank and add to string
      if (rank < 11)
      {
         str = rank + " of ";
      }   
      else
      {   
         switch (rank)
         {
            case 11:
               str = "Jack of ";
               break;
            case 12:
               str = "Queen of ";
               break;
            case 13:
               str = "King of "; 
               break;  
            case 14:
               str = "Ace of "; 
               break;     
         }
      }
      // determine suit and add to string
      switch (suit)
      {
         case 1:
            str += "Clubs";
            break;
         case 2:
            str += "Diamonds";
            break;
         case 3:
            str += "Hearts";
            break;
         case 4:
            str += "Spades"; 
            break;        
      } 
      // return the string
      return str;  
   }
   
}