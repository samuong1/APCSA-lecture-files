import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hamilton {
    long accountNumber = 0;
    int accountPosition = 0;
    double money = 0.0;
    boolean isSavings = false;
    public static List<Hamilton> accountList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("Hamilton.dat"));
        //int count = scanner.nextInt();
        accountOpen(123456, 1500, true);
        accountOpen(123456, 1500, true);
        for (int i = 0; i < 4; i++){
            if(scanner.next() == "OPEN"){
                //account open method
            }
            else{
                //withdraw method
            }
        }
    }
    private Hamilton(long accountNumber, double money, boolean isSavings){
        this.accountNumber = accountNumber;
        this.money = money;
        this.isSavings = isSavings;
    }
    public static void accountOpen(long accountN, double monies, boolean isItSavings){
        Hamilton newAccount = new Hamilton(accountN, monies, isItSavings);
        for (int z = 0; z < accountList.size(); z++){
            if(accountList.get(z).accountNumber == newAccount.accountNumber){
                for (int i = 0; i < 31; i++) {     
                    String binaryAccountNumber = Long.toBinaryString(newAccount.accountNumber).trim();
                    int length = binaryAccountNumber.length();
                    if (i > 0){
                        if (binaryAccountNumber.charAt(length - i) == 1){
                            binaryAccountNumber = binaryAccountNumber.substring(0, length - i) + "0";
                        }   
                        else{
                            binaryAccountNumber = binaryAccountNumber.substring(0, length - i) + "1";
                        }     
                    }
                    newAccount.accountNumber = Long.parseLong(binaryAccountNumber, 2);
                    if (accountList.add(newAccount)) {            
                        break;
                    }   
                }
            }
        }
        accountList.add(newAccount);
        System.out.println(newAccount.accountNumber);
    }
    public double accountWithdraw(int accountNo, double monies2){
        return money;
    }
}
