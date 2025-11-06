import java.io.*;
import java.util.Scanner;

public class DryRun {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("dryrun.in"));
        int number = scanner.nextInt();
        scanner.nextLine();
        for(int x = 0; x < number; x++){
            String name = scanner.nextLine();
            System.out.println("Movie: " + name);
        }
    }
}
