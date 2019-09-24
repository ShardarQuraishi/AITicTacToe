

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Main menu for the GUI version of the Tic Tac Toe game.
 */
public class mainMenu {

    //instance variable
    protected JFrame frame;

    /**
     * Main method, launches the application.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainMenu window = new mainMenu();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public mainMenu() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
//first window of the game
//editing the window, adding background, setting font style and the location and size of the window
//initializing the contents of the frame
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
//initializing the tic tac toe label
        Label titleLabel = new Label("Welcome to Tic Tac Toe");
        titleLabel.setBounds(96, 10, 233, 44);
        titleLabel.setBackground(Color.RED);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Bodoni MT Black", Font.BOLD, 16));
        titleLabel.setAlignment(Label.CENTER);
        frame.getContentPane().add(titleLabel);
//initializing the "Start Game" button and the action taken when clicked
        JButton btnStartGame = new JButton("Start Game");
        btnStartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                gameOption gm = new gameOption(); //making new gamefile object to access game option class
                gm.game();
                frame.dispose(); //java frame terminated
            }
        });
        //editing the window, adding background, setting font style and the location and size of the window
        btnStartGame.setForeground(Color.WHITE);
        btnStartGame.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
        btnStartGame.setBackground(Color.DARK_GRAY);
        btnStartGame.setBounds(117, 95, 194, 65);
        frame.getContentPane().add(btnStartGame);
    }
}
