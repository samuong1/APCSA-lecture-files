import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hamilton {
    long accountNumber = 0;
    String paddedNumber = null;
    double money = 0.0;
    public static List<Hamilton> accountList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("Hamilton.dat"));
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++){
            String operations = scanner.next();
            switch (operations) {
                case "OPEN" -> {
                    long desiredNumber = scanner.nextLong();
                    double desiredMoney = scanner.nextDouble();
                    boolean desiredSavings = false;
                    if (scanner.next().equals("SAVING")) {
                        desiredSavings = true;
                    }
                    accountOpen(desiredNumber, desiredMoney, desiredSavings);
                }
                case "DEPOSIT" -> {
                    String customerNumber = scanner.next();
                    double desiredDeposit = scanner.nextDouble();
                    accountDeposit(customerNumber, desiredDeposit);
                }
                case "WITHDRAW" -> {
                    String customerNumber2 = scanner.next();
                    double desiredWithdrawl = scanner.nextDouble();
                    accountWithdraw(customerNumber2, desiredWithdrawl);
                }
            }
            if(i != count - 1){
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    private Hamilton(long accountNumber, double money){
        this.accountNumber = accountNumber;
        this.paddedNumber = padding(accountNumber);
        this.money = money;
    }
    private static String padding(long num){
        return String.format("%06d", num);
    }
    public static void accountOpen(long accountN, double monies, boolean isItSavings){
        if((accountN <= 0) || (accountN > 999999)){
            System.out.println("HISTORY HAS ITS EYES ON YOU");
            return;
        }
        if(monies < 0){
            System.out.println("I AM NOT THROWING AWAY MY SHOT"); // Check this? Wording was weird
            return;
        }
        if((isItSavings == true && monies < 1500.00) || (isItSavings == false && monies < 100.00)){
            System.out.println("INSUFFICIENT STARTING FUND FOR ACCOUNT CREATION");
            return;
        }
        Hamilton newAccount = new Hamilton(accountN, monies);
        for (int z = 0; z < accountList.size(); z++){
            if(accountList.get(z).accountNumber == newAccount.accountNumber){
                for (int i = 0; i < 31; i++) {
                    long mask = 1L << i; 
                    long candidate = newAccount.accountNumber ^ mask;
                    boolean isUnique = true;
                    for (int j = 0; j < accountList.size(); j++) {
                        if (accountList.get(j).accountNumber == candidate) {
                            isUnique = false;
                            break;
                        }
                    }
                if (isUnique) {
                    newAccount.accountNumber = candidate;
                    newAccount.paddedNumber = padding(newAccount.accountNumber);
                    accountList.add(newAccount);
                    System.out.println(newAccount.paddedNumber);
                    return; 
                    }
                }
            }
        }
        accountList.add(newAccount);
        System.out.println(newAccount.paddedNumber);   
    }

    public static void accountWithdraw(String accountN, double monies2){
        Hamilton temporary = null;
        for (Hamilton h : accountList){
            if (h.paddedNumber.equals(accountN)){
                temporary = h;
                break;
            }
        }
        if (temporary == null){
            System.out.println("HISTORY HAS ITS EYES ON YOU");
            return;
        }
        if (temporary.money < monies2){
            System.out.println("INSUFFICIENT FUNDS FOR REQUESTED WITHDRAWAL");
            return;
        }
        if (monies2 < 0){
            System.out.println("I AM NOT THROWING AWAY MY SHOT");
            return;
        }
        temporary.money -= monies2;
        System.out.println(String.format("%.2f", temporary.money));
    }

    public static void accountDeposit(String accountN, double monies3){
        Hamilton temporary = null;
        for (Hamilton h : accountList){
            if (h.paddedNumber.equals(accountN)){
                temporary = h;
                break;
            }
        }
        if (temporary == null){
            System.out.println("HISTORY HAS ITS EYES ON YOU");
            return;
        }
        if (monies3 < 0){
            System.out.println("I AM NOT THROWING AWAY MY SHOT");
            return;
        }
        temporary.money += monies3;
        System.out.println(String.format("%.2f", temporary.money));
    }
}