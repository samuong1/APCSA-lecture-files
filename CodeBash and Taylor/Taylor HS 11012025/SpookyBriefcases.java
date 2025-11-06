import java.io.*;
import java.util.Scanner;

public class SpookyBriefcases {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("SpookyBriefcases.in"));
        int number = scanner.nextInt();
        scanner.nextLine();
        int currentMass = 0;
        int xCoordinate = 0;
        int yCoordinate = 0;
        int rightXBound = 0;
        int leftXBound = 0;
        int topYBound = 0;
        int bottomYBound = 0;
        int numberOfSpooky = 0;
        double centerX = 0.0;
        double centerY = 0.0;
        double totalX = 0.0;
        double totalY = 0.0;
        double totalMass = 0.0;
        boolean alcantar = false;
        for (int x = 0; x < number; x++){
            currentMass = scanner.nextInt();
            xCoordinate = scanner.nextInt();
            yCoordinate = scanner.nextInt();
            if ("SPOOKY".equals(scanner.next())){
                currentMass = ((int) Math.pow(currentMass, 2)) * numberOfSpooky;
                numberOfSpooky++;
            }
            if (xCoordinate < leftXBound){
                leftXBound = xCoordinate;
            }
            else if(xCoordinate > rightXBound){
                rightXBound = xCoordinate;
            }
            if (yCoordinate < bottomYBound){
                bottomYBound = yCoordinate;
            }
            else if(yCoordinate > topYBound){
                topYBound = yCoordinate;
            }
            centerX = currentMass * xCoordinate;
            centerY = currentMass * yCoordinate;
            totalX = totalX + centerX;
            totalY = totalY + centerY;
            totalMass = totalMass + currentMass;
        }
        double xTotalCoordinate = totalX / totalMass;
        double yTotalCoordinate = totalY / totalMass;
        if (xTotalCoordinate > rightXBound || xTotalCoordinate < leftXBound || yTotalCoordinate > topYBound || yTotalCoordinate < bottomYBound){
            alcantar = true;
        }
        else{
            alcantar = false;
        }
        
        System.out.println("(" + xTotalCoordinate + ", " + yTotalCoordinate + ")");
        if (alcantar) {
            System.out.println("SPOOKY!");
        }
        else{
            System.out.println("NORMAL!");
        }
    }
}