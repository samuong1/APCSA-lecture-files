

import java.util.Scanner;
import java.io.*;

public class PhysicsProblem {

    public static void main(String... args) throws IOException{
        Scanner kb = new Scanner(new File("03.in"));
        
        double x = 0;
        double y = 0;

        double totalMass = 0;

        int items = Integer.parseInt(kb.nextLine());

        int spookyCount = 0;
        boolean[] spookyTable = new boolean[items];
        double[][] candies = new double[items][3];

        double minX = Double.POSITIVE_INFINITY;
        double minY = Double.POSITIVE_INFINITY;
        double maxX = Double.NEGATIVE_INFINITY;
        double maxY = Double.NEGATIVE_INFINITY;

        for(int i = 0; i < items; i++){
            double mass = kb.nextDouble();
            double itemX = kb.nextDouble();
            double itemY = kb.nextDouble();

            minX = Math.min(itemX, minX);
            minY = Math.min(itemY, minY);
            maxX = Math.max(itemX, maxX);
            maxY = Math.max(itemY, maxY);

            candies[i][0] = mass;
            candies[i][1] = itemX;
            candies[i][2] = itemY;

            String remainder = kb.nextLine().trim();
            if(remainder.equals("SPOOKY")) {candies[i][0]*=candies[i][0]; spookyCount++; spookyTable[i] = true;}
        }

        for(int i = 0; i < candies.length; i++){
            double mass = candies[i][0];
            double itemX = candies[i][1];
            double itemY = candies[i][2];

            if(spookyTable[i]) mass*=(spookyCount-1);

            // System.out.println(mass + " " + itemX + " " + itemY);

            x += mass*itemX;
            y += mass*itemY;
            totalMass += mass;
        }

        x/=totalMass;
        y/=totalMass;

        System.out.printf("(%.4f, %.4f)\n", x,y);
        
        if( x < minX || x > maxX || y < minY || y > maxY)
            System.out.println("HAUNTED!");
        else
            System.out.println("NORMAL!");
        }
}
