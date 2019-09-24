import java.util.Scanner;

/**
 *
 *
 */
public class ComputerVsPlayer extends TicTacToe{

    protected static String player;
    protected static String computer;

    public static void play(){
        Scanner num = new Scanner(System.in);
        //int NUM=num.nextInt();
        System.out.println("Choose your marker.");
        System.out.println("Type 1 for 'X' or 2 for 'O': ");
        int choice=num.nextInt();
        if (choice== 1){
            player = "X";
            computer = "O";
        }else if (choice==2){
            player = "O";
            computer = "X";
        }
        else{
            System.out.println("illegal entry,Type 1 for 'X' or 2 for 'O':");
            play();
        }

        game.setTable();
        System.out.println("Player " + player + ". Enter a number:");
    }

    public static int Move(){

        boolean moved = false;

        int move = 0;
        int count = 0;

        if (game.table[1][1] == "5" && (game.table[0][0] == player || game.table[0][1] == player || game.table[0][2] == player || game.table[1][0] == player
                || game.table[1][2] == player || game.table[2][0] == player || game.table[2][1] == player || game.table[2][2] == player)) {
            count = 1;
        }
        else if (game.table[1][1] == player && game.table[0][0] == "1") {
            count = 100;
        }
        if (game.table[1][1] == computer && game.table[0][0] == "1" && game.table[2][2] == "9") {
            count = 99;
        }
        if (game.table[1][1] == computer && game.table[0][2] == "3" && game.table[2][0] == "7"){
            count = 98;
        }

        if (game.table[0][0] == player && game.table[0][1] == player && game.table[0][2] == "3") {
            count = 2;
        }
        else if (game.table[0][0] == computer && game.table[0][1] == computer && game.table[0][2] == "3") {
            count = 2;
        }
        else if (game.table[2][0] == computer && game.table[1][1] == computer && game.table[0][2] == "3"){
            count = 2;
        }

        if (game.table[0][0] == player && game.table[0][2] == player && game.table[0][1] == "2") {
            count = 3;
        }
        else if (game.table[0][0] == computer && game.table[0][2] == computer && game.table[0][1] == "2") {
            count = 3;
        }

        if (game.table[0][1] == player && game.table[0][2] == player && game.table[0][0] == "1") {
            count = 4;
        }
        else if (game.table[0][1] == computer && game.table[0][2] == computer && game.table[0][0] == "1") {
            count = 4;
        }

        if (game.table[1][0] == player && game.table[1][1] == player && game.table[1][2] == "6") {
            count = 5;
        }
        else if (game.table[1][0] == computer && game.table[1][1] == computer && game.table[1][2] == "6") {
            count = 5;
        }

        if (game.table[1][0] == player && game.table[1][2] == player && game.table[1][1] == "5") {
            count = 6;
        }
        else if (game.table[1][0] == computer && game.table[1][2] == computer && game.table[1][1] == "5") {
            count = 6;
        }

        if (game.table[1][1] == player && game.table[1][2] == player && game.table[1][0] == "4") {
            count = 7;
        }
        else if (game.table[1][1] == computer && game.table[1][2] == computer && game.table[1][0] == "4") {
            count = 7;
        }

        if (game.table[2][0] == player && game.table[2][1] == player && game.table[2][2] == "9") {
            count = 8;
        }
        else if (game.table[2][0] == computer && game.table[2][1] == computer && game.table[2][2] == "9") {
            count = 8;
        }
        else if (game.table[0][0] == computer && game.table[1][1] == computer && game.table[2][2] == "9"){
            count = 8;
        }

        if (game.table[2][0] == player && game.table[2][2] == player && game.table[2][1] == "8") {
            count = 9;
        }
        else if (game.table[2][0] == computer && game.table[2][2] == computer && game.table[2][1] == "8") {
            count = 9;
        }

        if (game.table[2][1] == player && game.table[2][2] == player && game.table[2][0] == "7") {
            count = 10;
        }
        else if (game.table[2][1] == computer && game.table[2][2] == computer && game.table[2][0] == "7") {
            count = 10;
        }
        if (game.table[0][2] == player && game.table[1][1] == player && game.table[2][0] == "7"){
            count = 10;
        }
        else if (game.table[0][2] == computer && game.table[1][1] == computer && game.table[2][0] == "7"){
            count = 10;
        }


        if (game.table[0][0] == player && game.table[1][0] == player && game.table[2][0] == "7") {
            count = 11;
        }
        else if (game.table[0][0] == computer && game.table[1][0] == computer && game.table[2][0] == "7") {
            count = 11;
        }

        if (game.table[0][0] == player && game.table[2][0] == player && game.table[1][0] == "4") {
            count = 12;
        }
        else if (game.table[0][0] == computer && game.table[2][0] == computer && game.table[1][0] == "4") {
            count = 12;
        }

        if (game.table[1][0] == player && game.table[2][0] == player && game.table[0][0] == "1") {
            count = 13;
        }
        else if (game.table[1][0] == computer && game.table[2][0] == computer && game.table[0][0] == "1") {
            count = 13;
        }

        if (game.table[0][1] == player && game.table[1][1] == player && game.table[2][1] == "8") {
            count = 14;
        }
        else if (game.table[0][1] == computer && game.table[1][1] == computer && game.table[2][1] == "8") {
            count = 14;
        }

        if (game.table[0][1] == player && game.table[2][1] == player && game.table[1][1] == "5") {
            count = 15;
        }
        else if (game.table[0][1] == computer && game.table[2][1] == computer && game.table[1][1] == "5") {
            count = 15;
        }

        if (game.table[1][1] == player && game.table[2][1] == player && game.table[0][1] == "2") {
            count = 16;
        }
        else if (game.table[1][1] == computer && game.table[2][1] == computer && game.table[0][1] == "2") {
            count = 16;
        }

        if (game.table[0][2] == player && game.table[1][2] == player && game.table[2][2] == "9") {
            count = 17;
        }
        else if (game.table[0][2] == computer && game.table[1][2] == computer && game.table[2][2] == "9") {
            count = 17;
        }

        if (game.table[0][2] == player && game.table[2][2] == player && game.table[1][2] == "6") {
            count = 18;
        }
        else if (game.table[0][2] == computer && game.table[2][2] == computer && game.table[1][2] == "6") {
            count = 18;
        }

        if (game.table[1][2] == player && game.table[2][2] == player && game.table[0][2] == "3") {
            count = 19;
        }
        else if (game.table[1][2] == computer && game.table[2][2] == computer && game.table[0][2] == "3") {
            count = 19;
        }
        if (game.table[2][0] == player && game.table[1][1] == player && game.table[0][2] == "3") {
            count = 19;
        }
        else if (game.table[2][0] == computer && game.table[1][1] == computer && game.table[0][2] == "3") {
            count = 19;
        }

        if (game.table[0][0] == player && game.table[2][2] == player && game.table[0][2] == "3") {
            count = 19;
        }
        else if (game.table[0][0] == computer && game.table[2][2] == computer && game.table[0][2] == "3") {
            count = 19;
        }

        if (game.table[0][2] == player && game.table[2][0] == player && game.table[0][0] == "1") {
            count = 4;
        }
        else if (game.table[0][2] == computer && game.table[2][0] == computer && game.table[0][0] == "1") {
            count = 4;
        }

        if (game.table[1][0] == computer && game.table[1][1] == computer && game.table[1][2] == player) {
            count = 26;
        }

        if (game.table[0][1] == computer && game.table[1][1] == computer && game.table[2][1] == player && game.table[1][0]=="4") {
            count = 7;}
        else if (game.table[0][1] == computer && game.table[1][1] == computer && game.table[2][1] == player &&game.table[2][0] == "7"){
            count=10;}
        else if (game.table[0][1] == computer && game.table[1][1] == computer && game.table[2][1] == player && game.table[2][2]=="9"){
            count=8;}
        else if (game.table[0][1] == computer && game.table[1][1] == computer && game.table[2][1] == player){
            count=4;
        }
        if (game.table[1][0] == computer && game.table[1][1] == computer && game.table[1][2] == player && game.table[0][1]=="2") {
            count = 3;}
        else if (game.table[1][0] == computer && game.table[1][1] == computer && game.table[1][2] == player && game.table[0][2]=="3") {
            count = 2;}
        else if (game.table[1][0] == computer && game.table[1][1] == computer && game.table[1][2] == player){
            count=9;
        }
        if (game.table[0][1] == computer && game.table[1][1] == computer && game.table[2][1] == player && game.table[1][2]=="6") {
            count = 5;}
        else if (game.table[0][1] == computer && game.table[1][1] == computer && game.table[2][1] == player && game.table[2][2]=="9") {
            count = 8;}
        else if(game.table[0][1] == computer && game.table[1][1] == computer && game.table[2][1] == player){
            count=11;
        }

        if (game.table[1][2] == computer && game.table[1][1] == computer && game.table[1][0] == player && game.table[0][1]=="2") {
            count = 3;}
        else if (game.table[1][2] == computer && game.table[1][1] == computer && game.table[1][0] == player &&game.table[2][2] == "9"){
            count = 8; //change
        }
        else if (game.table[1][2] == computer && game.table[1][1] == computer && game.table[1][0] == player){
            count=10;
        }

        if (game.table[2][1] == computer && game.table[1][1] == computer && game.table[0][1] == player  ) {
            count = 2;
        }
        if (game.table[2][1] == computer && game.table[1][1] == computer && game.table[0][1] == player &&game.table[0][2]==computer  && game.table[0][0]=="1" ){
            count = 4;}
        else if (game.table[2][1] == computer && game.table[1][1] == computer && game.table[0][1] == player &&game.table[0][2]==computer){
            count =7;
        }
        if (game.table[0][1] == player && game.table[0][2] == player && game.table[1][1] == player && game.table[2][0] == "7") {
            count = 27;
        }



        if (count == 1) {
            game.table[1][1] = computer;
            moved = true;
            move = 5;
        }
        if (count == 2) {
            game.table[0][2] = computer;
            moved = true;
            move = 3;
        }
        if (count == 3) {
            game.table[0][1] = computer;
            moved = true;
            move = 2;
        }
        if (count == 4) {
            game.table[0][0] = computer;
            moved = true;
            move = 1;
        }
        if (count == 5) {
            game.table[1][2] = computer;
            moved = true;
            move = 6;
        }
        if (count == 6) {
            game.table[1][1] = computer;
            moved = true;
            move = 5;
        }
        if (count == 7) {
            game.table[1][0] = computer;
            moved = true;
            move = 4;
        }
        if (count == 8) {
            game.table[2][2] = computer;
            moved = true;
            move = 9;
        }
        if (count == 9) {
            game.table[2][1] = computer;
            moved = true;
            move = 8;
        }
        if (count == 10) {
            game.table[2][0] = computer;
            moved = true;
            move = 7;
        }
        if (count == 11) {
            game.table[2][0] = computer;
            moved = true;
            move = 7;
        }
        if (count == 12) {
            game.table[1][0] = computer;
            moved = true;
            move = 4;
        }
        if (count == 13) {
            game.table[0][0] = computer;
            moved = true;
            move = 1;
        }
        if (count == 14) {
            game.table[2][1] = computer;
            moved = true;
            move = 8;
        }
        if (count == 15) {
            game.table[1][1] = computer;
            moved = true;
            move = 5;
        }
        if (count == 16) {
            game.table[0][1] = computer;
            moved = true;
            move = 2;
        }
        if (count == 17) {
            game.table[2][2] = computer;
            moved = true;
            move = 9;
        }
        if (count == 18) {
            game.table[1][2] = computer;
            moved = true;
            move = 6;
        }
        if (count == 19) {
            game.table[0][2] = computer;
            moved = true;
            move = 3;
        }
        if (count == 25) {
            game.table[0][2] = computer;
            moved = true;
            move=2;
        }
        if (count == 24) {
            game.table[0][2] = computer;
            moved = true;
            move=3;
        }
        if (count == 26) {
            game.table[2][1] = computer;
            moved = true;
            move=8;
        }
        if (count == 27) {
            game.table[2][0] = computer;
            moved = true;
            move=7;
        }
        if (count == 98) {
            game.table[2][0] = computer;
            moved = true;
            move=7;
        }
        if (count == 99) {
            game.table[2][2] = computer;
            moved = true;
            move=9;
        }
        if (count == 100) {
            game.table[0][0] = computer;
            moved = true;
            move=1;
        }

        int empty_count = 0;
        for (int i =0; i<3;i++) {
            for (int j=0; j<3; j++) {
                if (game.table[i][j] != player && game.table[i][j] != computer) {
                    empty_count ++;
                }
            }
        }

        if (empty_count == 2) {
            if(game.table [0][0] == "1" && game.table [0][1] == "2") {
                count = 20;
            }

            if(game.table [0][1] == "2" && game.table [0][2] == "3" ) {
                count = 21;
            }
            if(game.table [2][0] == "7" && game.table [2][1] == "8") {
                count = 22;
            }
            if(game.table [2][1] == "8" && game.table [2][2] == "9") {
                count = 23;
            }

            if(count == 20 || count == 21) {
                game.table[0][1] = computer;
                moved = true;
                move = 2;

            }

            if(count == 22 || count == 23) {
                game.table[2][1] = computer;
                moved = true;
                move = 7;

            }
        }

        while (!moved){
            int iRandom = (int)(Math.random() * 3);
            int jRandom = (int)(Math.random() * 3);

            if(game.table[iRandom][jRandom] != player && game.table[iRandom][jRandom] != computer){
                game.table[iRandom][jRandom] = computer;
                if (iRandom == 0 && jRandom == 0){
                    move = 1;
                }if (iRandom == 0 && jRandom == 1){
                    move = 2;
                }if (iRandom == 0 && jRandom == 2){
                    move = 3;
                }if (iRandom == 1 && jRandom == 0){
                    move = 4;
                }if (iRandom == 1 && jRandom == 1){
                    move = 5;
                }if (iRandom == 1 && jRandom == 2){
                    move = 6;
                }if (iRandom == 2 && jRandom == 0){
                    move = 7;
                }if (iRandom == 2 && jRandom == 1){
                    move = 8;
                }if (iRandom == 2 && jRandom == 2){
                    move = 9;
                }
                moved = true;
            }
        }
        return move;

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
        }
    }

    public static void printWinner(){
        if (game.won){
            if (turn % 2 == 0){
                System.out.println("You won!");
            }else{
                System.out.println("Computer wins.");
            }
        }else
            System.out.println("It's a draw.");
        System.exit(0);
    }

}
