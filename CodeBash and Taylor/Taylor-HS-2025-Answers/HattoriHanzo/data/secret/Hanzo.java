//package taylor_comp_solutions;

import java.util.Scanner;
import java.io.*;
//please refactor this to make it easier to understand (I wrote this really late so keep that in mind when you see this horrendous code)
public class Hanzo {


    static final int COLUMNS = 87; //they don't know this!!!
   
    public static void printEnd(char space){
        System.out.print("|");
        for (int i = 0; i < COLUMNS; i++) System.out.print(space);
        System.out.println("|");
    }
    public static void main(String[] args) throws IOException {
       
       
        //fdsffsdf

        Scanner kb = new Scanner(new File("Hanzo.in"));
       
        double SALES_TAX = kb.nextDouble(); kb.nextLine();
        int AMOUNT = kb.nextInt(); kb.nextLine();


        double SUBTOTAL = 0;


        printEnd('-');
        printEnd(' ');
        System.out.println("|  NAME          UNIT COST          INDIVIDUAL TAX          AMOUNT          TOTAL COST  |");
        printEnd(' ');
       
        for(int i = 0; i < AMOUNT; i++){
            String itemName = kb.next();
            double itemUnitCost = kb.nextDouble();
            double itemIndividualTax = kb.nextDouble();
            int itemAmount = kb.nextInt();
            if(kb.hasNextLine()) kb.nextLine();
           
            System.out.print("|  ");
            System.out.printf("%-14s",itemName.toUpperCase());
            // System.out.print("      ");
            System.out.printf("$%-18.2f", itemUnitCost);
            System.out.printf("%-24s", String.format("%.2f", itemIndividualTax*100)+"%");
            System.out.printf("%-16s", String.format("%d UNITS", itemAmount));


            double itemTotal = (itemUnitCost+itemUnitCost*itemIndividualTax)*itemAmount;


            SUBTOTAL+=itemTotal;


            System.out.printf("$%-11.2f", itemTotal);
            System.out.println("|");
        }
        printEnd(' ');
        System.out.printf("|  SUBTOTAL: $%-74.2f|", SUBTOTAL);
        System.out.println();
        System.out.printf("|  SALES TAX: %-74s|", String.format("%.2f%%", SALES_TAX*100));
        System.out.println();
        printEnd(' ');
        System.out.printf("|  TOTAL: $%-77.2f|", SUBTOTAL+SUBTOTAL*SALES_TAX);
        System.out.println();
        printEnd(' ');
        System.out.printf("|  %-85s|", "HATORI HANZO CANDIES");
        System.out.println();
        printEnd('-');
    }
}
