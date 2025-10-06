// Title: Null Tester
// Name: Sam Uong
// Date: 10/6/25

public class NullTester{
    public static void main(String[] args){
        notGood please = new notGood();
        System.out.println(please.getLength());
    }
}
class notGood{
     String name;
     public notGood(){
        name = "Eric";
     }
     public int getLength(){
         return name.length(); // cannot get a null value: NullPointerException
    }
}