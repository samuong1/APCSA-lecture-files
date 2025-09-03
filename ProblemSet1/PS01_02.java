// Title: Pi Approximation
// Name: Sam Uong
// Date: 9/2/2025

public class PS01_02{
    public static void main(String[] args){
        /* 
        Version A uses integers for the numerators. This means that when calculating the fractions, Java will drop the decimals.
        For example, (1/3) is usually 0.333 (repeating), but since they are both integers, Java will drop all decimals, leaving us with 0.
        This is the reason that Pi Version A has the answer 4; since each fraction only has integers, Java will drop all the decimal spaces,
        leaving us with 0 for each fraction. 4 * (1 - 0 + 0 - 0 + 0 - 0) = 4 * 1 = 4 
        */
        double PiVersionA = 4 * (1 - (1/3) + (1/5) - (1/7) + (1/9) - (1/11));
        System.out.println("This is Pi with 1 as the numerator: " + PiVersionA);
        /* 
        Version B uses double (or decimal) values for the numerators. This means that when calculating the fractions, Java will NOT drop
        the decimals, and instead, return the fractional values with decimals. For example, (1/3) is usually 0.333 (repeating), but since
        now one of the fractional elements is a double (or decimal) value, it will calculate it as a double (or decimal) value, leaving us
        with 0.33333333...
        This is the reason that Pi version B has a double value instead of an integer value; since each fraction has one double, Java will
        keep the decimals in the calculations, leaving us with a more precise approximation of Pi.
        */
        double PiVersionB = 4 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11));
        System.out.println("This is Pi with 1.0 as the numerator: " + PiVersionB);
    }
}