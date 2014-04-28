import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Rachel Heiser
// CS110 Assignment10
// War GUI class

public class WarGUI extends JFrame
{
   private War game;
   private JLabel title;   // for title of game
   private JPanel firstPanel, secondPanel,
                  thirdPanel, fourthPanel, fifthPanel;
   private JButton flipButton;
   private JLabel p1Label, p2Label,          // for player titles
                  score1Label, score2Label,  // for score labels
                  p1ScoreL, p2ScoreL,        // for player scores
                  back1Label, back2Label,    // to display back of pile
                  firstFrontLabel1, // to display front of player1's 1st flipped card
                  firstFrontLabel2; // to display front of player2's 1st flipped card
                  
                  
   /**
      The constructor
   */ 
   
   public WarGUI()
   {
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
      p1Label = new JLabel("Player 1");
      p1Label.setFont(new Font("ARIAL", Font.PLAIN, 24));
      p2Label = new JLabel("Player 2");
      p2Label.setFont(new Font("ARIAL", Font.PLAIN, 24));
      score1Label = new JLabel("Score:");
      score1Label.setFont(new Font("ARIAL", Font.PLAIN, 18));
      score2Label = new JLabel("Score:");
      score2Label.setFont(new Font("ARIAL", Font.PLAIN, 24));
      //add labels to second panel
      secondPanel.add(p1Label);
      secondPanel.add(p2Label);
      secondPanel.add(score1Label);
      secondPanel.add(score2Label);
      
      // create panel for main part of game where
      // first cards flipped will be displayed and a flip button
      thirdPanel = new JPanel(new GridLayout(1, 5));
      // create labels for the piles
      back1Label = new JLabel();
      back2Label = new JLabel();
      while (!game.player1.isEmpty())
      {
         // display pile for first player in first cell
         back1Label.setIcon(new ImageIcon("back.jpg"));
      }
      while (!game.player2.isEmpty())
      {
         // display pile for second player in first cell
         back2Label.setIcon(new ImageIcon("back.jpg"));
      }
      // labels for the cards flipped when not in a war
      firstFrontLabel1 = new JLabel();
      firstFrontLabel2 = new JLabel();
      // create flip button
      flipButton = new JButton("Flip");
//       flipButton.addActionListener(new ButtonListener());
      // add labels and button to third panel
      thirdPanel.add(back1Label);
      thirdPanel.add(firstFrontLabel1);
      thirdPanel.add(flipButton);
      thirdPanel.add(firstFrontLabel2);
      thirdPanel.add(back2Label);
      
      
      
      
   }
//    // handle button event
//    private class ButtonListener implements ActionListener
//    {
//    
//    }
   
   
   public static void main(String[] args)
   {
      new WarGUI();
   }
                    
}