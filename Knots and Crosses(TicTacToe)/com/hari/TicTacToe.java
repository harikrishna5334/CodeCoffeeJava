package com.hari;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) throws InterruptedException{
//        Welcoming the user with a note of welcome:
        String welcomeNote="Welcome to the Gaming World ! Let's have some fun".toUpperCase();

        //Rendering character by character on screen to welcome the user with a small note:
        for(int letter=0;letter<welcomeNote.length();letter++){

            System.out.print(welcomeNote.charAt(letter)+" ");
            Thread.sleep(100);
            //displaying on new line when sentence hits '!'
            if(welcomeNote.charAt(letter)=='!'){
                System.out.println();
                int count=0;
                while(count<5){
                    System.out.print(" ");
                    count++;
                }
            }

        }
        System.out.println();

//      Providing help to a user?
        Scanner in=new Scanner(System.in);
        System.out.print("Want to know how to Play?(Y/N): ");
        char help=in.next().toLowerCase().trim().charAt(0);

//      Player positions in the game:
        String[] arr={
                "00 <--> TOP-LEFT",
                "01 <--> TOP",
                "02 <--> TOP-RIGHT",
                "10 <--> LEFT",
                "11 <--> CENTER",
                "12 <--> RIGHT",
                "20 <--> BOTTOM-LEFT",
                "21 <--> BOTTOM",
                "22 <--> BOTTOM-RIGHT",
        };
        //If user need any help:
        if(help=='Y' || help=='y'){
            for(int valueIndex=0; valueIndex < arr.length;valueIndex++) {
                System.out.println(arr[valueIndex]);
            }

        }
        else{
            System.out.println("Choose 'Y' in case you need any help ");
        }

        /*
            Actual implementation of the game
            initially let's take the board and at starting we set all the positions are to be empty
            since the board is 2-Dimensional let's take 2-D Array

         */

        char[][] gameBoard=new char[3][3];
        //Assigning the value at all positions in the gameBoard as just space(empty):
        for(int row=0; row< gameBoard.length; row++){
            for(int col=0; col<gameBoard[row].length;col++){
                gameBoard[row][col]=' ';
            }
        }

        //starting the game with player:X
        char player='X';
        boolean gameOver=false;

        //Few instructions of the game
        System.out.println("Please provide space between row and column positions");
        System.out.println("Allowed combinational values are only 0 1 2");
        System.out.println();
        System.out.println("***** Your game goes here *****");


        while(!gameOver){
            displayBoard(gameBoard);
            System.out.print("Player "+player+" enter: ");
            int row=in.nextInt();
            int col=in.nextInt();
            System.out.println();

            if(gameBoard[row][col]==' '){
                gameBoard[row][col]=player; //placing the element
                gameOver=hasGameWon(gameBoard,player);
                if(gameOver){
                    System.out.println("Player "+player+" has Won");

                }
                else{
                    player=(player=='X')?'Y':'X';
                }

            }
            else{
                System.out.println("invalid move.Try again!");
            }
        }


    }

    /*
    Let's construct A function to check whether any of the player has won the game or not'
    there are three cases to check whether the gameIsOver or not
    case-1:::::( Horizontal Check)
        all the elements present in the same ROW are equal
    case-2::::( Vertical Check)
        all the elements present in the same COLUMN are equal
    case-3::::( Diagonal Check)
        all the elements present along the DIAGONAL are equal
     */


    //Algorithm to check whether the game is over not?
    public static boolean hasGameWon(char[][] gameBoard,char player){
        //CASE-1 Rows
        for(int row=0;row< gameBoard.length;row++){
            if(gameBoard[row][0]==player && gameBoard[row][1]==player && gameBoard[row][2]==player){
                return true;
            }
        }

        //CASE-2 Columns
        for(int col=0;col<gameBoard[0].length;col++){
            if(gameBoard[0][col] == player && gameBoard[1][col] == player && gameBoard[2][col] == player ){
                return true;
            }
        }

        //CASE-3 Diagonal

        if(gameBoard[0][0]==player && gameBoard[1][1]==player && gameBoard[2][2]==player){
            return true;

        }
        if(gameBoard[0][2]==player && gameBoard[1][1] == player && gameBoard[2][0]==player){
            return true;
        }

        return false;
    }

    //other function is to print the GameBoard after a player enters his choice of position

    public static void displayBoard(char[][] gameBoard){
        for(int row=0;row< gameBoard.length;row++){
            for(int col=0;col<gameBoard[row].length;col++){
                System.out.print(gameBoard[row][col]+ " | ");
            }
            System.out.println();
        }
    }
}
