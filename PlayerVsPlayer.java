public class PlayerVsPlayer extends TicTacToe{

    protected static String player = "";

    public static void main(String[] args){
        play();
        while (!(game.won)){
            Move();
            gameOver();
        }
    }

    public static void play(){
        player = "X";
    }

    public static void Move(){
        int userInput = uInput.nextInt();
        if (!(userInput > 0 && userInput <= 9)){
            System.out.println("Invalid input. Enter a number:");
        }else{
            switch (userInput){
                case 1:
                    swap(0,0);
                    break;
                case 2:
                    swap(0,1);
                    break;
                case 3:
                    swap(0,2);
                    break;
                case 4:
                    swap(1,0);
                    break;
                case 5:
                    swap(1,1);
                    break;
                case 6:
                    swap(1,2);
                    break;
                case 7:
                    swap(2,0);
                    break;
                case 8:
                    swap(2,1);
                    break;
                case 9:
                    swap(2,2);
                    break;
            }
        }
    }

    public static void gameOver(){
        game.checkIfWon();
        if (game.won){
            System.out.println("Game over.");
            printWinner();
        }
        game.isBoardFull();
        if (game.isBoardFull()){
            System.out.println("Game over.");
            printWinner();
        }else{
            nextPlayer();
            System.out.println("Player " + player + "'s turn. Enter a number:");
        }
    }

    public static void nextPlayer(){
        if (player == "X"){
            player = "O";
        }else{
            player = "X";
        }
    }

    public static void printWinner(){
        if (game.won){
            System.out.println("Player " + player + " wins.");
        }else
            System.out.println("It's a draw.");
        System.exit(0);
    }

    static void swap(int i, int j){
        if (game.mode == 1){
            if ((game.table[i][j] != "X") && (game.table[i][j] !="O")){
                game.table[i][j] = player;
            }else{
                System.out.println("This spot is taken. Try again.");
                nextPlayer();
            }
        }else if (game.mode == 2){
            if ((game.table[i][j] != "X") && (game.table[i][j] !="O")){
                game.table[i][j] = ComputerVsPlayer.player;
            }else{
                System.out.println("This spot is taken. Try again.");
                game.printTable();
                System.out.println("Player " + ComputerVsPlayer.player + "'s turn. Enter a number:");
                Move();
            }
        }
    }

}
