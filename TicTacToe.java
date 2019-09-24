import java.util.Scanner;

public class TicTacToe extends GameConfiguration{

    protected static Scanner uInput;
    private static PlayerVsPlayer player;
    private static ComputerVsPlayer computer;
    protected static int turn = 0;

    static TicTacToe game = new TicTacToe();

    public static void main(String[] args) {
        game.Menu();
        game.table = new String[3][3];
        uInput = new Scanner(System.in);
        if (game.mode == 1){
            game.setTable();
            game.printTable();
            player.play();
            System.out.println("Player " + player.player + ". Enter a number:");
            while (!(game.won)){
                player.Move();
                game.printTable();
                player.gameOver();
            }
        }
        if (game.mode == 2){
            computer.play();
            game.printTable();
            while (!(game.won)){
                player.Move();
                turn++;
                game.printTable();
                computer.gameOver();
                computer.Move();
                //turn++;
                System.out.println("Computer's turn:");
                game.printTable();
                computer.gameOver();
                System.out.println("Player " + computer.player + "'s turn. Enter a number:");
            }
        }
    }

}
