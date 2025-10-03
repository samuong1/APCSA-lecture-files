// Title: Car Class Inheritance
// Name: Sam Uong
// Date: 10/1/25

import static java.lang.System.out;

public class Car{
    public static void main(String[] args){
        System.out.print("success");
    }
    String make;
    String model;
    int year;
    double fuelLevel;
    double miles;
    boolean isFloodDamaged;

    public Car(){
        make = "Honda";
        model = "Civic";
        year = 1998;
    }
    
    public Car(String newMake, String newModel, int newYear){
        make = newMake;
        model = newModel;
        year = newYear;
    }

    public void displayInfo(){
        out.println("Miles: " + miles + " miles");
        out.println("Fuel Percentage %: " + fuelLevel * 100);
    }

    public void carInfo(){
        out.println("Make: " + make);
        out.println("Model: " + model);
        out.println("Year: " + year);
    }
}