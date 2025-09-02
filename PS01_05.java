// Title: Census Calculations
// Name: Sam Uong
// Date: 8/31/2025

public class PS01_05{
    public static void main(String[] args){
        double population = 312032486;
        double births = 31536000/7;
        double deaths = 31536000/13;
        double immigrants = 31536000/45;
        int yearcounter = 1;
        while (yearcounter < 6){
            population = population + births - deaths + immigrants;
            System.out.println("The population in the next " + yearcounter + " year(s) is " + population);
            yearcounter+=1;
        }
    }
}