// Title: Grade Nested
// Name: Sam Uong
// Date: 10/28/25

import static java.lang.System.out;
import java.util.Scanner;

public class GradeNotNested{
    public static void main(String[] args){
        Scanner ericIsBad = new Scanner(System.in);
        out.print("Input your grade >> ");
        //double grade = ericIsBad.nextDouble();
        double grade = Math.random()*100;
        out.println(grade);
        //out.println("Your letter grade without nesting is " + letterGrader1(grade));
        //out.println("Your letter grade with nesting is " + letterGrader2(grade));
        out.println("Eric's letter grade without nesting is " + letterGrader1(grade));
        out.println("Eric's letter grade with nesting is " + letterGrader2(grade));
    }
    public static String letterGrader1(double score){
        if(score >= 90.0){
            return "A";
        }
        else if(score >= 80.0){
            return "B";
        }
        else if(score >= 70.0){
            return "C";
        }
        else if(score >= 60.0){
            return "D";
        }
        else{
            return "F";
        }
        }
    public static String letterGrader2(double score){ // Nested (not recommended)
        if(score >= 90.0){
            return "A";
        }
        else{
            if(score >= 80.0){
                return "B";
            }
            else{
                if(score >= 70.0){
                    return "C";
                }
                else{
                    if(score >= 60.0){
                        return "D";
                    }
                    else{
                        return "F";
                    }
                }
            }
        }
    }
}


