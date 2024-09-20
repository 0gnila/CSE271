// Import component classes from swing package
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

// Import layout classes and event-handling interfaces from awt package
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe extends JFrame implements ActionListener 
{
    private String player1;                             // Name of player 1
    private String player2;                             // Name of player 2
    private String currentPlayer;                       // Name of the current player
    private boolean gameOver = false;                   // Flag indicating if the game is over
    private JButton[][] buttons = new JButton[3][3];    // Buttons for the game board
    private JLabel turnLabel;                           // Label to display current player's turn

    // Constructor
    public TicTacToe() 
    {
        // Set the title of the game window
        
        // Set the closing operation of the game window

        // Set the size of the game window

        // Set the layout of the game window

        // Create panel for player turn label and add it to the frame

        // Create panel for game board (3 * 3) and add it to the frame

        // Set the visibility of the frame to 'true'

        // Get player names through Dialog container
        
        // Set the currentPlayer to player1
        
        // Set the text of the turnLabel to hold the name of player1 at the beginning of the game  
    }

    // ActionListener method
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (!gameOver) 
        {
            // Get the button that triggered the action event
            JButton clickedButton = (JButton) e.getSource();

            // Determine the location of which button was clicked (i.e., grid cell)
            

            // Check if the chosen cell is empty or not. If empty:
                // 1. Set the text of the grid cell
                // 2. Check for win
                // 3. Check for draw
                // 4. Switch player and set the text of the 'turnLabel' no win or draw yet!
            
            // If not empty, a pop-up window (Dialog) stating the cell is already taken!
            
        }
    }

    // Method to check for win


    // Method to check for draw
    

    // Main method
    public static void main(String[] args) 
    {
        // Instantiate the TicTacToeTemplate class
        new TicTacToe();
    }
}