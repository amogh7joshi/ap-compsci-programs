import java.util.Scanner;
import java.lang.Math;

// Prints out a multiplication table which has a size determined by the user.
// Prints out a checkerboard with the pieces filled in.

public class ArrayTwoDWork {
    private static int[][] multiplicationTable;
    private static String[][] checkerboard;

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        
        System.out.println("How large would you like the multiplication table to be? ");
        int arraysize = console.nextInt();
        System.out.println("\n");

        multiplicationTable = new int[arraysize][arraysize];
        multiplicationTableSolve(arraysize);

        for(int i = 0; i < arraysize; i++){
            for(int j = 0; j < arraysize; j++){
                System.out.print(multiplicationTable[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n");

        checkerboard = new String[8][8];
        fillCheckerboard();

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print("[" + checkerboard[i][j] + "]\t");
            }
            System.out.println();
        }
        System.out.println("\n");
        

        console.close();
    }

    private static int[][] multiplicationTableSolve(int arraysize){
        for(int i = 0; i < arraysize; i++){
            for(int j = 0; j < arraysize; j++){
                multiplicationTable[i][j] = Math.multiplyExact(i + 1, j + 1);
            }
        }

        return multiplicationTable;
    }

    private static String[][] fillCheckerboard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 8; j++){
                if((i + j) % 2 != 0){
                    checkerboard[i][j] = "BLACK";
                }
                else{
                    checkerboard[i][j] = "     ";
                }
            }
        }
        for(int i = 3; i < 5; i++){
            for(int j = 0; j < 8; j++){
                checkerboard[i][j] = "     ";
            }
        }
        for(int i = 5; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if((i + j) % 2 != 0){
                    checkerboard[i][j] = "WHITE";
                }
                else{
                    checkerboard[i][j] = "     ";
                }
            }
        }

        return checkerboard;
    }
    
}

