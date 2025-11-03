import java.io.*;
import java.util.Scanner;

public class Georgio{
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("Georgio.dat"));
        int count = scanner.nextInt();
        for (int x = 0; x < count; x++){
            int number = scanner.nextInt();
            boolean isPrime = true;
            for (int i = 2; i < number; i++){
                if (number % i == 0){
                    isPrime = false;
                }
            }
            if (isPrime){
                System.out.println("Optimal Prime");
            }
            else{
                System.out.println("Mega Dumb");
            }
        }
    }
}
