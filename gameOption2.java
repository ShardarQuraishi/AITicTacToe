
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class gameOption2 {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gameOption2 window = new gameOption2();
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
    public gameOption2() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
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
        btnPlayerVsPlayer.setBounds(60, 85, 159, 51);
        frame.getContentPane().add(btnPlayerVsPlayer);

        JButton btnPlayerVsCpu = new JButton("Player vs CPU");
        btnPlayerVsCpu.setBounds(245, 85, 159, 51);
        frame.getContentPane().add(btnPlayerVsCpu);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(156, 160, 159, 51);
        frame.getContentPane().add(btnClose);
    }
}
