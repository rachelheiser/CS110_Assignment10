import javax.swing.*;

// Rachel Heiser
// CS110 Assignment10
// Card interface

public interface CardInterface
{
   int getRank();
   int getSuit();
   ImageIcon getPicture();
   boolean equals(Card object2);
   String toString();
}