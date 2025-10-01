// Title: Reference Type Variables
// Name: Sam Uong
// Date: 10/1/25

import static java.lang.System.out;

public class ObjectTester{
    public static void main(String[] args){
        out.println("success");
        Car myCar = new Car();
        Car yourCar = new Car();
        Car theirCar = myCar;
        out.println(myCar);
        out.println(yourCar);
        out.print(theirCar);
    }
}

class Car{
    String make;
    String model;
    int year;
    double fuelLevel;
    double miles;
    boolean isFloodDamaged;
}