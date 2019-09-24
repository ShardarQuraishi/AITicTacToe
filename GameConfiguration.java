


import java.util.Scanner;

public class GameConfiguration {

    protected static boolean won;
    protected static String[][] table;
    protected static int mode;

    public static int Menu(){
        System.out.println("Welcome to Tic Tac Toe");
        mode = gameMode();
        if(mode == 1)
            System.out.println("PlayervsPlayer");
        else if(mode == 2)
            System.out.println("PlayervsCPU");
        else
            System.out.println("Illegal entry");
        return mode;
    }

    public static int gameMode(){
        Scanner input = new Scanner(System.in);

        System.out.println("Game modes: ");
        System.out.println("Play against a friend (1)");
        System.out.println("Play against the computer (2)");
        System.out.println("Which option do you take (1-2): ");
        int gameOption;
        gameOption = input.nextInt();
        while(gameOption < 1 || gameOption > 2) {
            System.out.println("Which option do you take (1-2): ");
            gameOption = input.nextInt();
        }
        return gameOption;
    }

    public static void setTable(){
        table[0][0] = "1";
        table[0][1] = "2";
        table[0][2] = "3";
        table[1][0] = "4";
        table[1][1] = "5";
        table[1][2] = "6";
        table[2][0] = "7";
        table[2][1] = "8";
        table[2][2] = "9";
    }

    public static void printTable(){
        System.out.println(" " + table[0][0] + "  " + table[0][1] + "  " + table[0][2]);
        System.out.println(" " + table[1][0] + "  " + table[1][1] + "  " + table[1][2]);
        System.out.println(" " + table[2][0] + "  " + table[2][1] + "  " + table[2][2]);
    }

    public static boolean checkIfWon(){
        for (int i = 0; i < 3; i++){
            if (table[0][i] != "" && (table[0][i] == table[1][i]) && (table[1][i] == table[2][i])){
                won = true;
            }
            if (table[i][0] != "" && (table[i][0] == table[i][1]) && (table[i][1] == table[i][2])){
                won = true;
            }
            if ((table[0][0] != "" && (table[0][0] == table[1][1] && table[1][1] == table[2][2])) ||
                    ((table[0][2] != "" && (table[0][2] == table[1][1] && table[1][1] == table[2][0])))){
                won = true;
            }
        }
        return false;
    }

    public static boolean isBoardFull(){
        boolean full = true;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (table[i][j] == "1" || table[i][j] == "2" || table[i][j] == "3"
                        || table[i][j] == "4" || table[i][j] == "5" || table[i][j] == "6"
                        || table[i][j] == "7" || table[i][j] == "8" || table[i][j] == "9"){
                    full = false;
                }
            }
        }
        return full;
    }
}
