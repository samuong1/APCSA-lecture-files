// Title: Census Calculations
// Name: Sam Uong
// Date: 9/2/2025

public class PS01_05{
    public static void main(String[] args){
        double population = 312032486;
        int time = 60 * 60 * 24 * 365;
        double births = time/7;
        double deaths = time/13;
        double immigrants = time/45;
        int yearcounter = 1;
        while (yearcounter < 6){
            population = population + births - deaths + immigrants;
            System.out.println("The population in the next " + yearcounter + " year(s) is " + population);
            yearcounter+=1;
        }
    }
}