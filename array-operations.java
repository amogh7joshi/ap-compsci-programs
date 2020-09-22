import java.util.Arrays;
import java.util.Random;

public class ArrayProblems{
    public static void main(String args[])
    {
        int randomArray[] = new int[20];
        Random random = new Random();

        for(int i = 0; i < 20; i++)
        {
            randomArray[i] = random.nextInt(50);
        }

        System.out.println("Normal Array: " + Arrays.toString(randomArray));
        randomArray = arrayReverse(randomArray);
        System.out.println("Reversed Array: " + Arrays.toString(randomArray));
        randomArray = evenIndexReplace(randomArray);
        System.out.println("Even Indexes Replaced with 5: " + Arrays.toString(randomArray));
        randomArray = valueShift(randomArray);
        System.out.println("Values of the array shifted: " + Arrays.toString(randomArray));
    }

    private static int[] arrayReverse(int array[]){
        for(int i = 0; i < (array.length / 2); i++)
        {
            int hold = array[array.length - i - 1];
            array[array.length - i - 1] = array[i];
            array[i] = hold;
        }

        return array;
    }

    private static int[] evenIndexReplace(int array[]){
        for(int i = 0; i < array.length; i+=2)
        {
            array[i] = 5;
        }

        return array;
    }

    private static int[] valueShift(int array[]){        
        int hold = array[0];
        for(int i = 0; i < array.length - 1; i++)
        {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = hold;
        
        return array;
    }

}
