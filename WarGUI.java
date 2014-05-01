import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Rachel Heiser
// CS110 Assignment10
// War GUI class

public class WarGUI extends JFrame
{
   private War game;
   private JLabel title,         // for title of game
                  warSecTitle,   // for war section title
                  winnerIs;      // for displaying the winner at end of game
   private JPanel firstPanel, secondPanel,
                  thirdPanel, fourthPanel, fifthPanel;
   private JButton flipButton;
   private JLabel player1, player2,          // for player titles
                  p1CardsLabel, p2CardsLabel,  // for score labels
                  p1Score, p2Score,          // for player scores
                  p1FaceDown1, p2FaceDown1,    // display back of pile
                  p1FaceUp1, // display front of player1's 1st flipped card
                  p2FaceUp1, // display front of player2's 1st flipped card
                  p1FaceDown2, p2FaceDown2,  // display back of cards in event of war
                  p1FaceUp2,   // display front of player1's 2nd flipped card in war
                  p2FaceUp2;   // display front of player2's 2nd flipped card in war
                  
                  
   private ArrayList<Card> roundCards;  
   private Card card1, card2, card3, card4, card5, card6; 
   private int p1NumCards = 26;
   private int p2NumCards =26;          
                  
   /**
      The constructor
   */ 
   
   public WarGUI()
   {
      setTitle("War");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
      setLayout(new GridLayout(5,1));
      game = new War();
      
      // create panel for the title
      firstPanel = new JPanel();
      // create title label
      title = new JLabel("War");
      title.setFont(new Font("ARIAL", Font.BOLD, 36));
      // add title to first panel
      firstPanel.add(title);
      
      // create panel for the player titles and scores
      secondPanel = new JPanel(new GridLayout(3,2));
      // create labels
      player1 = new JLabel("Player 1");
      player1.setFont(new Font("ARIAL", Font.PLAIN, 24));
      player2 = new JLabel("Player 2");
      player2.setFont(new Font("ARIAL", Font.PLAIN, 24));
      p1CardsLabel = new JLabel("Cards:");
      p1CardsLabel.setFont(new Font("ARIAL", Font.PLAIN, 18));
      p2CardsLabel = new JLabel("Cards:");
      p2CardsLabel.setFont(new Font("ARIAL", Font.PLAIN, 18));
      p1Score = new JLabel("" + p1NumCards);
      p1Score.setFont(new Font("ARIAL", Font.PLAIN, 18));
      p2Score = new JLabel("" + p2NumCards);
      p2Score.setFont(new Font("ARIAL", Font.PLAIN, 18));
      
      //add labels to second panel
      secondPanel.add(player1);
      secondPanel.add(player2);
      secondPanel.add(p1CardsLabel);
      secondPanel.add(p2CardsLabel);
      secondPanel.add(p1Score);
      secondPanel.add(p2Score);
      
      /* create panel for main part of game where
         first cards flipped will be displayed and a flip button */
      thirdPanel = new JPanel(new GridLayout(1, 5));
      // create labels for the piles
      p1FaceDown1 = new JLabel();
      p2FaceDown1 = new JLabel();

      // labels for the cards flipped when not in a war
      p1FaceUp1 = new JLabel();
      p2FaceUp1 = new JLabel();
      // create flip button
      flipButton = new JButton("Flip");
       flipButton.addActionListener(new ButtonListener());
      // add labels and button to third panel
      thirdPanel.add(p1FaceDown1);
      thirdPanel.add(p1FaceUp1);
      thirdPanel.add(flipButton);
      thirdPanel.add(p2FaceUp1);
      thirdPanel.add(p2FaceDown1);
      
      
      // create fourth panel where cards will be displayed in event of a war
      fourthPanel = new JPanel(new GridLayout(1,5));
      // create labels for the cards
      p1FaceUp2 = new JLabel();
      p2FaceUp2 = new JLabel();
      p1FaceDown2 = new JLabel();
      p2FaceDown2 = new JLabel();
      // create war label
      warSecTitle = new JLabel();
      warSecTitle.setFont(new Font("ARIAL", Font.BOLD, 18));
      // add labels to the fourth panel
      fourthPanel.add(p1FaceDown2);
      fourthPanel.add(p1FaceUp2);
      fourthPanel.add(warSecTitle);
      fourthPanel.add(p2FaceUp2);
      fourthPanel.add(p2FaceDown2);
      
      // create fifth panel
      fifthPanel = new JPanel();
      // create label that will later display the winner of the game
      winnerIs = new JLabel();
      winnerIs.setFont(new Font("ARIAL", Font.BOLD, 30));
      fifthPanel.add(winnerIs);
      
      add(firstPanel);
      add(secondPanel);
      add(thirdPanel);
      add(fourthPanel);
      add(fifthPanel);
      
      pack();
      setVisible(true);  
   }
   
   // handle button event
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // clear the war area
         warSecTitle.setText(null);
         p1FaceDown2.setIcon(null);
         p2FaceDown2.setIcon(null);
         p1FaceUp2.setIcon(null);
         p2FaceUp2.setIcon(null);
         
         if (!game.player1.isEmpty())
         {
            // display pile for first player in first cell
            p1FaceDown1.setIcon(new ImageIcon("back.jpg"));
         }
         else
         {
            // if player1 has no cards, set icon to null
            p1FaceDown1.setIcon(null);
         }
         
         if (!game.player2.isEmpty())
         {
            // display pile for second player in first cell
            p2FaceDown1.setIcon(new ImageIcon("back.jpg"));
         }
         else
         {
            // if player2 has no cards, set icon to null
            p2FaceDown1.setIcon(null);
         }
         
         
         // if there is not an overall winnner
         if (game.getOverallWinner() == null)
         {
            // take top card from each file and compare
            game.flip();
            // get roundCards ArrayList
            roundCards = game.getRoundCards();
            // get top card from each file, player1's card is first
            card1 = roundCards.get(0);
            card2 = roundCards.get(1);
            // display top cards
            p1FaceUp1.setIcon(card1.getPicture());
            p2FaceUp1.setIcon(card2.getPicture());
            
            // if cards don't match assign points to the round winner
            String roundWinner = game.getRoundWinner();
            if (roundWinner != null)
            {
               // display number of cards for each player
               int numCards = roundCards.size();
               if (roundWinner.equals("Player 1"))
               {
                  p1NumCards += numCards/2;
                  p2NumCards -= numCards/2;
                  p1Score.setText("" + p1NumCards);
                  p2Score.setText("" + p2NumCards);
               }
               else
               {
                  p1NumCards -= numCards/2;
                  p2NumCards += numCards/2;
                  p1Score.setText("" + p1NumCards);
                  p2Score.setText("" + p2NumCards);
               }

               // assign points to the winner
               game.assignPoints();
               
            }
            else
            {
               while (roundWinner == null)
               {
                  game.war();
                  warSecTitle.setText("War");
                  // display cards for war
                  p1FaceDown2.setIcon(new ImageIcon("back.jpg"));
                  p2FaceDown2.setIcon(new ImageIcon("back.jpg"));
                  // get roundCards ArrayList
                  roundCards = game.getRoundCards();
                  // get first set of cards to display (the 3rd and 5th indexes in roundCards)
                  card3 = roundCards.get(3); // player1's flipped card in war
                  card4 = roundCards.get(5); // player2's flipped card in war
                  p1FaceUp2.setIcon(card3.getPicture());
                  p2FaceUp2.setIcon(card4.getPicture());
                  // if second pair of cards need to be flipped, display them.
                  if (game.secondCardsFlipped())
                  {
                     // get second set of cards to display (2nd and 4th indexes in roundCards).
                     card5 = roundCards.get(2); // player1's second flipped card in war
                     card6 = roundCards.get(4); // player2's second flipped card in war
                     p1FaceDown2.setIcon(card5.getPicture());
                     p2FaceDown2.setIcon(card6.getPicture());
                  }
                  
                  // get updated roundWinner
                  roundWinner = game.getRoundWinner();
               }   
               // display number of cards for each player
               roundCards = game.getRoundCards();
               int numCards = roundCards.size();
               if (roundWinner.equals("Player 1"))
               {
                  p1NumCards += numCards/2;
                  p2NumCards -= numCards/2;
                  p1Score.setText("" + p1NumCards);
                  p2Score.setText("" + p2NumCards);
               }
               else
               {
                  p1NumCards -= numCards/2;
                  p2NumCards += numCards/2;
                  p1Score.setText("" + p1NumCards);
                  p2Score.setText("" + p2NumCards);
               } 
               // assign points to the winner
               game.assignPoints();  
            } 
         }
         // if there is an overall winner
         else
         {
            // announce winner
            winnerIs.setText("Winner is " + game.getOverallWinner()); 
            // disable the flip button
            flipButton.setEnabled(false);
         }
      }      
   }
   
   
   
   public static void main(String[] args)
   {
      new WarGUI();
   }
                    
}