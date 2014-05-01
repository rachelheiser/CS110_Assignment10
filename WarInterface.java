import java.util.ArrayList;

// Rachel Heiser
// CS110 Assignment10
// War interface

public interface WarInterface
{
   void flip();
   void assignPoints();
   void war();
   boolean secondCardsFlipped();
   boolean isGameOver();
   ArrayList<Card> getRoundCards();
   String getRoundWinner();
   String getOverallWinner();
}