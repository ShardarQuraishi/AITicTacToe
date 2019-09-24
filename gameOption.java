


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gameOption extends  TicTacToeGUIGame {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public void game() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gameOption window = new gameOption();
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
    public gameOption() {
        initialize();
    }

    public int pvp(){
        return 1;
    }

    public int pvc(){
        return 2;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        Label label = new Label("Welcome to Tic Tac Toe");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Bodoni MT Black", Font.BOLD, 16));
        label.setBackground(Color.RED);
        label.setAlignment(Label.CENTER);
        label.setBounds(104, 10, 233, 44);
        frame.getContentPane().add(label);

        JButton btnPlayerVsPlayer = new JButton("Player vs Player");
        btnPlayerVsPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                config.mode=1;
                TicTacToeGUIGame n = new TicTacToeGUIGame();
                n.main(null);
//              mainMenu m=new mainMenu();
//              m.main(null);
//
                frame.dispose();
//                mainMenu m=new mainMenu();
//                m.main(null);
                // pvp();


            }
        });


        btnPlayerVsPlayer.setBounds(60, 85, 159, 51);
        frame.getContentPane().add(btnPlayerVsPlayer);

        JButton btnPlayerVsCpu = new JButton("Player vs CPU");
        btnPlayerVsCpu.addActionListener(new ActionListener() {
                                             public void actionPerformed(ActionEvent e) {
                                                 config.mode=2;
                                                 //pvc();
                                                 TicTacToeGUIGame n = new TicTacToeGUIGame();
                                                 n.main(null);
                                                 frame.dispose();


                                             }


                                         }

        );
        btnPlayerVsCpu.setBounds(245, 85, 159, 51);
        frame.getContentPane().add(btnPlayerVsCpu);

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnClose.setBounds(156, 160, 159, 51);
        frame.getContentPane().add(btnClose);
    }
}
