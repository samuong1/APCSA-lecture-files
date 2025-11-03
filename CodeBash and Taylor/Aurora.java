import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Aurora{
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("Aurora.dat"));
        int count = scanner.nextInt();
        for (int x = 0; x < count; x++){
            long seed = scanner.nextLong();
            Random rng = new Random(seed);
            int numberOfCars = scanner.nextInt();
            for (int y = 0; y < numberOfCars; y++){
                if (rng.nextInt(50) + 1 == 13){
                    System.out.print(y + " ");
                    numberOfCars -= y;
                    y = 0;
                }
            }
            System.out.println();
        }
    }
}
