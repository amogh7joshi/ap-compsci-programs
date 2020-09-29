import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

// 9-29-2020

public class arraySpiral{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a value: ");
        System.out.println();
        int userval = console.nextInt();
        int arraysize = arraySize(userval);
        
        System.out.println(arraysize);
        console.close();

        int[][] spiralarray = new int[arraysize][arraysize];

        int minCol = 0;
        int minRow = 0;
        int maxRow = arraysize - 1;
        int maxCol = arraysize - 1;
        int value = 1; // The value that is being filled into each index.

        while (value <= userval)
        {
            for (int i = minCol; i <= maxCol; i++)
            {
                spiralarray[minRow][i] = value; 
                value++;
            }
             
            for (int i = minRow+1; i <= maxRow; i++) 
            { 
                spiralarray[i][maxCol] = value;   
                value++; 
            } 
             
            for (int i = maxCol-1; i >= minCol; i--)
            {
                spiralarray[maxRow][i] = value;          
                value++;
            }
             
            for (int i = maxRow-1; i >= minRow+1; i--) 
            {
                spiralarray[i][minCol] = value;
                value++;
            }
             
            minCol++;
            minRow++;
            maxCol--;
            maxRow--;
        }

        System.out.println(Arrays.deepToString(spiralarray) + "\n");
        for(int i = 0; i < (arraysize ); i++){
            for(int j = 0; j < (arraysize); j++){
                System.out.print(spiralarray[i][j] + "\t");
            }
            System.out.println();
        }

    }

    private static int arraySize(int x){
        return (int)(Math.ceil(Math.sqrt(x)));
    }
}
