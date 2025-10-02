// Title: Reference Type Variables
// Name: Sam Uong
// Date: 10/1/25

import static java.lang.System.out;

public class ObjectTester{
    public static void main(String[] args){
        out.println("success");
        Car myCar = new Car();
        Car yourCar = new Car("Pizza", "Hello", 5);
        Car theirCar = myCar;
        out.println(myCar.make);
        out.println(yourCar.year);
        out.println(theirCar.model);
        myCar.carInfo();
        boolean eric_is_bad = true;
        out.print("Eric is bad = " + eric_is_bad);
    }
}
