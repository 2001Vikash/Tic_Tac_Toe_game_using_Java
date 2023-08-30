import java.util.Scanner;

public  class Main {
        public static void main(String[] args) {
            System.out.println("Welcome to this game Enjoy!");

            // make a board of character with 3*3 size

            char[][] board = new char[3][3];
            for(int row = 0; row < board.length; row++){
                for(int col = 0; col < board[0].length; col++){
                    board[row][col] = ' '; // make the board empty.
                }
            }


            Scanner sc = new Scanner(System.in);

            char player = 'X';
            boolean gameOver = false;

            while(!gameOver){
                printBoard(board);
                System.out.println("Player " + player + " Now it's your turn :");
                int row = sc.nextInt();
                int col = sc.nextInt();

                if(board[row][col] != player){
                    board[row][col] = player;
                }else{
                    System.out.println("Invalid move. Try again!");
                }

                gameOver = haveWon(board, player);
                if(gameOver){
                    printBoard(board);
                    System.out.println("Player " + player + " won the game. Congrats!");
                }

                if(player == 'X'){
                    player = '0';
                }else{
                    player = 'X';
                }
            }
        }

        public static boolean haveWon(char[][] board, char player){

            // check rows
            for(int row = 0; row < board.length; row++){
                if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                    return true;
                }
            }

            // check columns
            for(int col = 0; col < board[0].length; col++){
                if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                    return true;
                }
            }

            // check diagonals

            if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
                return true;
            }
            if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
                return true;
            }

            return false;
        }

        public static void printBoard(char[][] board){
            for(int row = 0; row < board.length; row++){
                for(int col = 0; col < board[0].length; col++){
                    System.out.print(board[row][col] + " | ");
                }
                System.out.println();
            }
        }
    }

