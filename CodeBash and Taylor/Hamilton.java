import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hamilton {
    int accountNumber = 0;
    int accountPosition = 0;
    double money = 0.0;
    boolean isSavings = false;
    private static List<Hamilton> accountList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("Hamilton.dat"));
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++){
            if(scanner.next() == "OPEN"){
                //account open method
            }
            else{
                //withdraw method
            }
        }
    }
    public Hamilton(int accountNumber, double money, boolean isSavings){
        this.accountNumber = accountNumber;
        this.money = money;
        this.isSavings = isSavings;
    }
    public static void accountOpen(int accountN, double monies, boolean isItSavings){
        Hamilton newAccount = new Hamilton(accountN, monies, isItSavings);
        for (int z = 0; z < accountList.size(); z++){
            if(accountList.get(z).accountNumber == newAccount.accountNumber){
                for (int i = 0; i < 31; i++) {               
                    if (accountList.add(newAccount)) {               
                    break;
                    }   
                }
            }
        accountList.add(newAccount);
        System.out.println(accountN);
        }
    }
    public double accountWithdraw(int accountNo, double monies2){
        return money;
    }
}
