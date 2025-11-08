import java.io.*;
import java.util.Scanner;

public class Clair {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(new File("Clair.dat"));
        int count = scanner.nextInt();
        for (int i = 1; i <= count; i++){
            if (i != count){
                scanner.nextLine();
            }
        }
    }
        
}