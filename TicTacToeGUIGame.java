


import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Main class for the GUI version of the Tic Tac Toe Game.
 * Creates the board and conditions for play.
 */
public class TicTacToeGUIGame extends javax.swing.JFrame {
    //instance variables
    private PlayerVsPlayer player;
    private ComputerVsPlayer ai;
    private int turn = 0;
    private int player1count = 0;
    private int player2count = 0;
    private JButton[] buttons;

    GameConfiguration config = new GameConfiguration();

    /**
     * Creates new form TicTacToeGUIGame
     */
    public TicTacToeGUIGame() {
        initComponents();
        setSize(600, 600);
        setLocationRelativeTo(null);
        setUp();
        setStatusBar();
        setScore();
    }

    /**
     * Sets up the game and board.
     */
    private void setUp(){
        config.table = new String[3][3];
        config.setTable();
        if (config.mode == 1){
            setTitle("Tic Tac Toe - Player vs Player");
            player.play();
        }else if (config.mode == 2){
            setTitle("Tic Tac Toe - Player vs AI");
            ai.player = "X";
            ai.computer = "O";
        }
        //places game board buttons in an array
        buttons = new JButton[9];
        buttons[0] = jButton1;
        buttons[1] = jButton2;
        buttons[2] = jButton3;
        buttons[3] = jButton4;
        buttons[4] = jButton5;
        buttons[5] = jButton6;
        buttons[6] = jButton7;
        buttons[7] = jButton8;
        buttons[8] = jButton9;

    }

    /**
     * Sets the players' scores.
     */
    private void setScore(){
        if (config.mode == 1){
            jLabel_Score.setText("Player X's Score: " + String.valueOf(player1count)
                    + "\t                                                              "
                    + "Player O's Score: " + String.valueOf(player2count));
        }else if (config.mode ==2){
            jLabel_Score.setText("Player " + ai.player + "'s Score: " +
                    String.valueOf(player1count) + "\t                             "
                    + "                                 Computer's Score: " +
                    String.valueOf(player2count));
        }
    }

    /**
     * Updates the status bar for the players' turns.
     */
    private void setStatusBar(){
        if (config.mode == 1){
            jLabel_Status.setText("Player " + player.player + "'s turn.");
        }else{
            if (turn % 2 == 0){
                jLabel_Status.setText("Player " + ai.player + "'s turn.");
            }else{
                jLabel_Status.setText("Computer's turn.");
            }
        }
    }

    /**
     * Displays the winner.
     */
    private void winner(){
        if (config.mode == 1){
            JOptionPane.showMessageDialog(this, "Player " + player.player + " wins.",
                    "Game Over", JOptionPane.INFORMATION_MESSAGE);
            if (player.player == "X"){
                player1count += 1;
            }else if (player.player == "O"){
                player2count += 1;
            }
            setScore();
        }else if (config.mode == 2){
            if (turn % 2 == 0){
                JOptionPane.showMessageDialog(this, "You won!",
                        "Game Over", JOptionPane.INFORMATION_MESSAGE);
                player1count += 1;
            }else{
                JOptionPane.showMessageDialog(this, "Computer wins.",
                        "Game Over", JOptionPane.INFORMATION_MESSAGE);
                player2count += 1;
            }
            setScore();
        }
    }

    /**
     * Changes the colour of the tiles if there is a win.
     */
    private void changeColour(){
        String[] bText = new String[9];
        for (int i = 0; i < 9; i++){
            bText[i] = buttons[i].getText();
        }

        if (bText[0] != "" && bText[0] == bText[1] && bText[1] == bText[2]){
            buttons[0].setBackground(Color.GREEN);
            buttons[1].setBackground(Color.GREEN);
            buttons[2].setBackground(Color.GREEN);
        }else if(bText[3] != "" && bText[3] == bText[4] && bText[4] == bText[5]){
            buttons[3].setBackground(Color.GREEN);
            buttons[4].setBackground(Color.GREEN);
            buttons[5].setBackground(Color.GREEN);
        }else if(bText[6] != "" && bText[6] == bText[7] && bText[7] == bText[8]){
            buttons[6].setBackground(Color.GREEN);
            buttons[7].setBackground(Color.GREEN);
            buttons[8].setBackground(Color.GREEN);
        }else if(bText[0] != "" && bText[0] == bText[4] && bText[4] == bText[8]){
            buttons[0].setBackground(Color.GREEN);
            buttons[4].setBackground(Color.GREEN);
            buttons[8].setBackground(Color.GREEN);
        }else if(bText[6] != "" && bText[6] == bText[4] && bText[4] == bText[2]){
            buttons[6].setBackground(Color.GREEN);
            buttons[4].setBackground(Color.GREEN);
            buttons[2].setBackground(Color.GREEN);
        }else if(bText[0] != "" && bText[0] == bText[3] && bText[3] == bText[6]){
            buttons[0].setBackground(Color.GREEN);
            buttons[3].setBackground(Color.GREEN);
            buttons[6].setBackground(Color.GREEN);
        }else if(bText[1] != "" && bText[1] == bText[4] && bText[4] == bText[7]){
            buttons[1].setBackground(Color.GREEN);
            buttons[4].setBackground(Color.GREEN);
            buttons[7].setBackground(Color.GREEN);
        }else if(bText[2] != "" && bText[2] == bText[5] && bText[5] == bText[8]){
            buttons[2].setBackground(Color.GREEN);
            buttons[5].setBackground(Color.GREEN);
            buttons[8].setBackground(Color.GREEN);
        }
    }

    /**
     * Checks for a winner.
     */
    private void checkIfWon(){
        config.checkIfWon();
        if (config.won){
            changeColour();
            winner();
            resetBoard();
        }else{
            config.isBoardFull();
            if (config.isBoardFull()){
                JOptionPane.showMessageDialog(this, "It's a draw.",
                        "Game Over", JOptionPane.INFORMATION_MESSAGE);
                resetBoard();
            }
        }
    }

    /**
     * Resets the board for a new game.
     */
    private void resetBoard(){
        for (int i = 0; i < 9; i++){
            buttons[i].setText("");
        }
        config.setTable();
        config.won = false;
        turn = 1;
        for (int i = 0; i < 9; i++){
            buttons[i].setBackground(Color.WHITE);
        }
    }

    /**
     * Plays the computer's move.
     */
    private void AIMove(){
        if (turn % 2 == 1){
            int move = ai.Move();
            buttons[move - 1].setForeground(Color.GRAY);
            buttons[move - 1].setText(ai.computer);
            checkIfWon();
            turn++;
            setStatusBar();
        }
    }

    /**
     * Action event for the gameboard buttons.
     */
    private void playMove(int button, int i, int j){
        String b = buttons[button].getText();
        if (b == ""){
            if (config.mode == 1){
                if (player.player == "X"){
                    buttons[button].setForeground(Color.DARK_GRAY);
                    buttons[button].setText("X");
                    player.swap(i,j);
                }else{
                    buttons[button].setForeground(Color.GRAY);
                    buttons[button].setText("O");
                    player.swap(i,j);
                }
                checkIfWon();
                player.nextPlayer();
                setStatusBar();
            }else if (config.mode == 2){
                if (turn % 2 == 0){
                    if ((config.table[i][j] != "X") && (config.table[i][j] !="O")){
                        buttons[button].setForeground(Color.DARK_GRAY);
                        buttons[button].setText(ai.player);
                        config.table[i][j] = ai.player;
                    }
                    checkIfWon();
                    turn++;
                    setStatusBar();
                    AIMove();
                }
            }
        }else{
            jLabel_Status.setText("This spot is taken. Try again.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButton_Back = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel_Status = new javax.swing.JLabel();
        jPanel2_Grid = new javax.swing.JPanel();
        jPanel_1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel_2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel_3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel_4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel_5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel_6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel_7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel_8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel_9 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel_Score = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");

        jButton_Back.setBackground(new java.awt.Color(0, 0, 0));
        jButton_Back.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jButton_Back.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Back.setText("Click here to go back to menu");
        jButton_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BackActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Back, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel_Status.setBackground(new java.awt.Color(204, 204, 204));
        jLabel_Status.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel_Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Status.setText("Status Bar");
        jPanel1.add(jLabel_Status, java.awt.BorderLayout.PAGE_END);

        jPanel2_Grid.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2_Grid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2_Grid.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        jPanel_1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel_1.setLayout(new java.awt.BorderLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 100)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel_1.add(jButton1, java.awt.BorderLayout.CENTER);

        jPanel2_Grid.add(jPanel_1);

        jPanel_2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel_2.setLayout(new java.awt.BorderLayout());

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 100)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel_2.add(jButton2, java.awt.BorderLayout.CENTER);

        jPanel2_Grid.add(jPanel_2);

        jPanel_3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel_3.setLayout(new java.awt.BorderLayout());

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Comic Sans MS", 1, 100)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel_3.add(jButton3, java.awt.BorderLayout.CENTER);

        jPanel2_Grid.add(jPanel_3);

        jPanel_4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel_4.setLayout(new java.awt.BorderLayout());

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 1, 100)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel_4.add(jButton4, java.awt.BorderLayout.CENTER);

        jPanel2_Grid.add(jPanel_4);

        jPanel_5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel_5.setLayout(new java.awt.BorderLayout());

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Comic Sans MS", 1, 100)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel_5.add(jButton5, java.awt.BorderLayout.CENTER);

        jPanel2_Grid.add(jPanel_5);

        jPanel_6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel_6.setLayout(new java.awt.BorderLayout());

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Comic Sans MS", 1, 100)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel_6.add(jButton6, java.awt.BorderLayout.CENTER);

        jPanel2_Grid.add(jPanel_6);

        jPanel_7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel_7.setLayout(new java.awt.BorderLayout());

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Comic Sans MS", 1, 100)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel_7.add(jButton7, java.awt.BorderLayout.CENTER);

        jPanel2_Grid.add(jPanel_7);

        jPanel_8.setBackground(new java.awt.Color(102, 102, 102));
        jPanel_8.setLayout(new java.awt.BorderLayout());

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Comic Sans MS", 1, 100)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel_8.add(jButton8, java.awt.BorderLayout.CENTER);

        jPanel2_Grid.add(jPanel_8);

        jPanel_9.setBackground(new java.awt.Color(102, 102, 102));
        jPanel_9.setLayout(new java.awt.BorderLayout());

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Comic Sans MS", 1, 100)); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel_9.add(jButton9, java.awt.BorderLayout.CENTER);

        jPanel2_Grid.add(jPanel_9);

        jPanel1.add(jPanel2_Grid, java.awt.BorderLayout.CENTER);

        jLabel_Score.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel_Score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Score.setText("Score");
        jPanel1.add(jLabel_Score, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        playMove(0,0,0);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        playMove(1,0,1);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        playMove(2,0,2);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        playMove(3,1,0);
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        playMove(4,1,1);
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        playMove(5,1,2);
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        playMove(6,2,0);
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        playMove(7,2,1);
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        playMove(8,2,2);
    }

    private void jButton_BackActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        gameOption gm = new gameOption();
        gm.game();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToeGUIGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToeGUIGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToeGUIGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeGUIGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeGUIGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton_Back;
    private javax.swing.JLabel jLabel_Score;
    private javax.swing.JLabel jLabel_Status;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2_Grid;
    private javax.swing.JPanel jPanel_1;
    private javax.swing.JPanel jPanel_2;
    private javax.swing.JPanel jPanel_3;
    private javax.swing.JPanel jPanel_4;
    private javax.swing.JPanel jPanel_5;
    private javax.swing.JPanel jPanel_6;
    private javax.swing.JPanel jPanel_7;
    private javax.swing.JPanel jPanel_8;
    private javax.swing.JPanel jPanel_9;
    // End of variables declaration
}
