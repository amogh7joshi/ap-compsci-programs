import java.util.Arrays;

public class OddNums{
    public static void main(String[]args)
    {
        int[] ascendingOdds = ascOdds();
        int[] descendingOdds = desOdds();
        System.out.println(Arrays.toString(ascendingOdds));
        System.out.println(Arrays.toString(descendingOdds));
    }

    private static int[] ascOdds(){
        int[] odds = new int [50];
        int z = 0;
        for(int i = 0; i < 99; i+=2)
        {
          odds[z] = i + 1;
          z += 1;
        }
        return odds;
    }

    private static int[] desOdds(){
        int[] odds = new int [50];
        int z = 0;
        for(int i = 98; i >= 0; i-=2)
        {
          odds[z] = i + 1;
          z += 1;
        }
        return odds;
    }
}

