package JavaFiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> compurerPositions = new ArrayList<>();
    public static void main(String[] args) {
        char [][] gameBoard = {{' ','|',' ','|',' '},
                               {'-','+','-','+','-'},
                               {' ','|',' ','|',' '},
                               {'-','+','-','+','-'},
                               {' ','|',' ','|',' '}};
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your placement(1-9):");
            int playerPos = sc.nextInt();
            while(playerPositions.contains(playerPos) || compurerPositions.contains(playerPos)){
                System.out.println("Position Taken! Enter a correct position.");
                playerPos = sc.nextInt();
            }
            placePiece(playerPos,gameBoard,"player");
            String winner = checkWinner();
            if(winner.length()>0){
                printGameBoard(gameBoard);
                System.out.println(winner);
                break;
            }
            
            Random rand = new Random();
            int computerPos = rand.nextInt(10);
            while(playerPositions.contains(computerPos) || compurerPositions.contains(computerPos)){
                System.out.println("Position Taken Computer! Generate another number.");
                computerPos = rand.nextInt(10);
            }
            placePiece(computerPos,gameBoard,"computer");
            printGameBoard(gameBoard);
            winner = checkWinner();
            if(winner.length()>0){
                System.out.println(winner);
                break;
            }
        }
        
    }
    public static void printGameBoard(char[][] gameBoard){
        for(char[] row: gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println("");
        }
    }
    public static void placePiece(int pos, char[][] gameBoard, String user){
        char symbol=' ';
        if(user.equals("player")){
            symbol='X';
            playerPositions.add(pos);
        }else if(user.equals("computer")){
            symbol='O';
            compurerPositions.add(pos);
        }
        switch(pos){
                case 1:
                    gameBoard[0][0] = symbol;
                    break;
                case 2:
                    gameBoard[0][2] = symbol;
                    break;
                case 3:
                    gameBoard[0][4] = symbol;
                    break;
                case 4:
                    gameBoard[2][0] = symbol;
                    break;
                case 5:
                    gameBoard[2][2] = symbol;
                    break;
                case 6:
                    gameBoard[2][4] = symbol;
                    break;
                case 7:
                    gameBoard[4][0] = symbol;
                    break;
                case 8:
                    gameBoard[4][2] = symbol;
                    break;
                case 9:
                    gameBoard[4][4] = symbol;
                    break;
                default:
                    break;
        }
    }
    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);
        
        List<List> winningConditions = new ArrayList<>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(botRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);
        for(List l: winningConditions){
            if(playerPositions.containsAll(l)){
                return "Congratulations you won!";
            }else if(compurerPositions.containsAll(l)){
                return "Computer Won! Sorry:(";
            }else if(playerPositions.size() + compurerPositions.size() == 9){
                return "It is a TIE!!";
            }
        }
        return "";
    }
}

    

