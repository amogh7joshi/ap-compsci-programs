// 9/18/2020

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class HW916{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Would you like to (1) Find a hypotenuse, or (2) Find quadratic roots?");
        int userInput = console.nextInt();

        if(userInput == 1){
            double a;
            double b;

            System.out.println("Enter the length of one leg.");
            a = console.nextDouble();
            System.out.println("Enter the length of another leg.");
            b = console.nextDouble();
            System.out.println("The length of the hypotenuse of your triangle is " + pythagHyp(a, b) + ".");
        }
        else if(userInput == 2){
            double a;
            double b;
            double c;

            System.out.println("Enter the value of a.");
            a = console.nextDouble();
            System.out.println("Enter the value of b.");
            b = console.nextDouble();
            System.out.println("Enter the value of c.");
            c = console.nextDouble();
            System.out.println("The roots of your quadratic equation are: " + Arrays.toString(quadForm(a, b, c)) + ".");
            
        }
        else{
            System.out.println("Please try again. That is not a valid option.");
        }

        console.close();

    }

    private static double pythagHyp(double a, double b){
        return (double)Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        
    }

    private static double[] quadForm(double a, double b, double c){
        double roots[] = new double[2];

        double formula1 = -1 * b + Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        formula1 = formula1/(2 * a);

        roots[0] = formula1;

        double formula2 = -1 * b - Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        formula2 = formula2/(2 * a);

        roots[1] = formula2;

        return roots;


    }
}
