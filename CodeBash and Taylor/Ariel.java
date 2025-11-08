import java.io.*;
import java.util.Scanner;

public class Ariel {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(new File("Ariel.dat"));
        int count = scanner.nextInt();
        for (int i = 1; i <= count; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int sum = a + b;
            System.out.println(sum);
            if (i != count){
                scanner.nextLine();
            }
        }
    }    
}
