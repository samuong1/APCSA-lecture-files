import java.awt.Toolkit;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HamiltonBankInteractive {
    long accountNumber = 0;
    String paddedNumber = null;
    double money = 0.0;
    public static List<HamiltonBankInteractive> accountList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("|----------------------------------------------------------------------------------|");
        Thread.sleep(100);
        System.out.println("|                                                                                  |");
        Thread.sleep(100);
        System.out.println("|                                  Welcome to the                                  |");
        Thread.sleep(100);
        System.out.println("|                                                                                  |");
        Thread.sleep(100);
        System.out.println("""
                           |                 _    _          __  __ _____ _   _______ ____  _   _             |\r
                           |                | |  | |   /\\   |  \\/  |_   _| | |__   __/ __ \\| \\ | |            |\r
                           |                | |__| |  /  \\  | \\  / | | | | |    | | | |  | |  \\| |            |\r
                           |                |  __  | / /\\ \\ | |\\/| | | | | |    | | | |  | | . ` |            |\r
                           |                | |  | |/ ____ \\| |  | |_| |_| |____| | | |__| | |\\  |            |\r
                           |                |_|__|_/_/    \\_\\_|_ |_|_____|______|_|__\\____/|_| \\_|            |\r
                           |                |  _ \\   /\\   | \\ | | |/ /_   _| \\ | |/ ____|                     |\r
                           |                | |_) | /  \\  |  \\| | ' /  | | |  \\| | |  __                      |\r
                           |                |  _ < / /\\ \\ | . ` |  <   | | | . ` | | |_ |                     |\r
                           |                | |_) / ____ \\| |\\  | . \\ _| |_| |\\  | |__| |                     |\r
                           |                |____/_/_   \\_\\_|_\\_|_|\\_\\_____|_|_\\_|\\_____|                     |\r
                           |                 / ____\\ \\   / / ____|__   __|  ____|  \\/  |                      |\r
                           |                | (___  \\ \\_/ / (___    | |  | |__  | \\  / |                      |\r
                           |                 \\___ \\  \\   / \\___ \\   | |  |  __| | |\\/| |                      |\r
                           |                 ____) |  | |  ____) |  | |  | |____| |  | |                      |\r
                           |                |_____/   |_| |_____/   |_|  |______|_|  |_|                      |\r
                           |                                                                                  |""");
        System.out.println("|                           Your trusted bank since 1791                           |");
        Thread.sleep(100);
        System.out.println("|                                                                                  |");
        Thread.sleep(100);
        System.out.println("|                        Please input your desired commands                        |");
        Thread.sleep(100);
        System.out.println("|                                                                                  |");
        Thread.sleep(100);
        System.out.println("|                   For assistance, type \"HELP\" into the terminal                  |");
        Thread.sleep(100);
        System.out.println("|                                                                                  |");
        Thread.sleep(100);
        System.out.println("|          If you wish to exit at any time, type \"EXIT\" into the terminal          |");
        Thread.sleep(100);
        System.out.println("|                                                                                  |");
        Thread.sleep(100);
        System.out.println("|----------------------------------------------------------------------------------|\n");
        Thread.sleep(100);
        while(true){
            Toolkit.getDefaultToolkit().beep();
            System.out.print("YOUR COMMAND: ");
            String operations = scanner.next();
            System.out.println("Querying...One Moment!");
            Thread.sleep(1500);
            switch (operations) {
                case "OPEN" -> {
                    long desiredNumber = scanner.nextLong();
                    double desiredMoney = scanner.nextDouble();
                    boolean desiredSavings = false;
                    if (scanner.next().equals("SAVING")) {
                        desiredSavings = true;
                    }
                    accountOpen(desiredNumber, desiredMoney, desiredSavings);
                    System.out.println();
                }
                case "DEPOSIT" -> {
                    String customerNumber = scanner.next();
                    double desiredDeposit = scanner.nextDouble();
                    accountDeposit(customerNumber, desiredDeposit);
                    System.out.println();
                }
                case "WITHDRAW" -> {
                    String customerNumber2 = scanner.next();
                    double desiredWithdrawal = scanner.nextDouble();
                    accountWithdraw(customerNumber2, desiredWithdrawal);
                    System.out.println();
                }
                case "ACCOUNT" -> {
                    String customerNumber3 = scanner.next();
                    accountCheck(customerNumber3);
                    System.out.println();
                }
                case "HELP" ->{
                    boolean running = true;
                    while (running){
                        System.out.println("\nWhat do you need help with today? Type in the number of the question you want answered.");
                        System.out.println("  1 - INTRODUCE ME TO THE MACHINE");
                        System.out.println("  2 - ACCOUNT BASICS");
                        System.out.println("  3 - OPENING AN ACCOUNT");
                        System.out.println("  4 - CHECKING AN ACCOUNT");
                        System.out.println("  5 - DEPOSITING INTO AN ACCOUNT");
                        System.out.println("  6 - WITHDRAWING FROM AN ACCOUNT");
                        System.out.println("  7 - COMMON ERRORS");
                        System.out.println("  8 - RANDOM ALCANTAR FACT");
                        System.out.println("  9 - ABOUT THIS MACHINE");
                        System.out.println("  0 - EXIT HELP MENU\n");
                        Toolkit.getDefaultToolkit().beep();
                        System.out.print("YOUR COMMAND: ");
                        String helpSelection = scanner.next();
                        System.out.println();
                        switch(helpSelection){
                            case "1" ->{
                                System.out.println("Welcome to the Official Hamilton Banking System!");
                                System.out.println("As long as this system is running, your data will be stored securely using our patented Alcantar Security Technology.");
                                System.out.println("This interactive is based on CodeBash2025's Problem 7. This interactive has additional features, but still retains the core concepts tested.");
                                System.out.println("To learn more about this machine, choose another option!");
                            }
                            case "2" ->{
                                System.out.println("At Hamilton Banking System, we offer free accounts with no monthly fees!");
                                System.out.println("We offer two basic account types: SAVING and CHECKING.");
                                System.out.println("Each account must have one of these types.");
                                System.out.println("SAVING accounts require a starting investment of $1500.00.");
                                System.out.println("CHECKING accounts require a starting investment of $100.00.");
                            }
                            case "3" ->{
                                System.out.println("To open an account, you need to type the OPEN command.");
                                System.out.println("The syntax goes as follows: ");
                                System.out.println();
                                System.out.println("OPEN [desired account number] [dollar amount] [SAVING or CHECKING]");
                                System.out.println();
                                System.out.println("[desired account number] - Input your desired account number, from 000001 to 999999.* Your desired account number may not be available; if it isn't, it will assign you a number close to your desired number.");
                                System.out.println("[dollar amount] - Input your initial investments (without the dollar sign). The machine accepts integers and decimal values (up to two places). For more information on inital investment requirements, see Option 2 in the Help Menu.");
                                System.out.println("[SAVING or CHECKING] - Type either \"SAVING\" or \"CHECKING\" into this field. This will determine your account type. For more information on account types, see Option 2 in the Help Menu.");
                                System.out.println();
                                System.out.println("EX: OPEN 123456 1500 SAVING");
                                System.out.println();
                                System.out.println("The system will print out your new account number.");
                                System.out.println("Our system uses bit flipping to determine new account numbers. If a number is requested too many times, it may use existing numbers. Contact HBS administrators if this happens.");
                                System.out.println();
                                System.out.println("* If your account has less than 6 digits, you will need to \"pad\" your number to access your account. EX: 3845 --> 003845");
                            }
                            case "4" ->{
                                System.out.println("To check your account, you need to type the ACCOUNT command.");
                                System.out.println("The syntax goes as follows: ");
                                System.out.println();
                                System.out.println("ACCOUNT [account number]");
                                System.out.println();
                                System.out.println("[account number] - Input your account number, from 000001 to 999999.*");
                                System.out.println();
                                System.out.println("EX: ACCOUNT 123456");
                                System.out.println();
                                System.out.println("The system will print out your account number and your current balance.");
                                System.out.println();
                                System.out.println("* If your account has less than 6 digits, you will need to \"pad\" your number to access your account. EX: 3845 --> 003845");
                            }
                            case "5" ->{
                                System.out.println("To deposit into an account, you need to type the DEPOSIT command.");
                                System.out.println("The syntax goes as follows: ");
                                System.out.println();
                                System.out.println("DEPOSIT [account number] [dollar amount]");
                                System.out.println();
                                System.out.println("[account number] - Input your account number.*");
                                System.out.println("[dollar amount] - Input your amount that you want to deposit (without the dollar sign). The machine accepts integers and decimal values (up to two places).");
                                System.out.println();
                                System.out.println("EX: DEPOSIT 123456 100");
                                System.out.println();
                                System.out.println("The system will print out your new balance.");
                                System.out.println();
                                System.out.println("* If your account has less than 6 digits, you will need to \"pad\" your number to access your account. EX: 3845 --> 003845");
                            }
                            case "6" ->{
                                System.out.println("To withdraw money from an account, you need to type the WITHDRAW command.");
                                System.out.println("The syntax goes as follows: ");
                                System.out.println();
                                System.out.println("WITHDRAW [account number] [dollar amount]");
                                System.out.println();
                                System.out.println("[account number] - Input your account number.*");
                                System.out.println("[dollar amount] - Input your amount that you want to withdraw (without the dollar sign). The machine accepts integers and decimal values (up to two places).");
                                System.out.println();
                                System.out.println("EX: WITHDRAW 123456 100");
                                System.out.println();
                                System.out.println("The system will print out your new balance.");
                                System.out.println();
                                System.out.println("* If your account has less than 6 digits, you will need to \"pad\" your number to access your account. EX: 3845 --> 003845");
                            }
                            case "7" ->{
                                System.out.println("Common Errors:");
                                System.out.println();
                                System.out.println(" - \"INSUFFICIENT STARTING FUNDS FOR ACCOUNT CREATION\" - Your starting investment is too low; you need more money to open this account.");
                                System.out.println(" - \"INSUFFICIENT FUNDS FOR REQUESTED WITHDRAWAL\" - Your account balance is lower than your requested withdrawal; try a lower value.");
                                System.out.println(" - \"HISTORY HAS ITS EYES ON YOU\" - You inputted an incorrect account number (negative, zero, greater than 999999); input your correct account number.");
                                System.out.println(" - \"I AM NOT THROWING AWAY MY SHOT\" - You attempted to withdraw or deposit a negative amount of money; input a positive amount of money.");
                                System.out.println(" - There is no output from the machine - You typed in a query wrong. Type the query in correctly.");
                                System.out.println(" - \"YOUR COMMAND: \" keeps repeating - You typed in a query wrong. Type the query in correctly.");
                                System.out.println(" - It throws an error related to code - An internal error has happened. Contact administrators.");                            
                            }
                            case "8" ->{
                                int randomNumber = (int) (Math.random() * 10) + 1;
                                String randomNumberString = Integer.toString(randomNumber);
                                System.out.println("One of ten fun facts about Mr. Alcantar: ");
                                switch(randomNumberString){
                                    case "1" ->{
                                        System.out.println("#1 - Mr. Alcantar's clicker never broke. He just put in the battery wrong.");
                                    }
                                    case "2" ->{
                                        System.out.println("#2 - Mr. Alcantar used to work at Houston Independent School District, at Margaret Long Wisdom High School.");
                                        System.out.println("     His HISD email is EALCANTA@houstonisd.org. He was paid $66,000.00 annually before moving to Memorial High School.");
                                    }
                                    case "3" ->{
                                        System.out.println("#3 - Mr. Alcantar has Discord! His profile picture is Goku. He also makes references to random shows that half of the UIL team doesn't understand.");
                                    }
                                    case "4" ->{
                                        System.out.println("#4 - Did you know about Computer Science UIL? Mr. Alcantar runs it and he desperately needs new members!");
                                        System.out.println("     Benefits include: Free food (sometimes), Free Absences from school (Present - Absent from Class), Improvement of Computer Science Skills, and more Alcantar Lore!");
                                        System.out.println("     Talk to your local Alcantar today!");
                                    }
                                    case "5" ->{
                                        System.out.println("#5 - Mr. Alcantar hates AI (specifically Copilot and Gemini).");
                                    }
                                    case "6" ->{
                                        System.out.println("#6 - Mr. Alcantar spent three days trying to learn how a Heap Sort works.");
                                    }
                                    case "7" ->{
                                        System.out.println("#7 - Mr. Alcantar loves PC^2. Please ask him for the GitHub repository to his PC^2 configuration.");
                                    }
                                    case "8" ->{
                                        System.out.println("#8 - Mr. Alcantar denies the existence of the Virtual Pumpkin Carving (VPC.java) incident at Taylor High School on November 1st, 2025.");
                                    }
                                    case "9" ->{
                                        System.out.println("#9 - No matter how terrible the code is, if the code works and functions as it should, it is accepted for a grade.");
                                        System.out.println("     That being said, please do not hard code everything.");
                                    }
                                    case "10" ->{
                                        System.out.println("#10 - In the historic APCSA class of 2024-2025, a student may or may not have been \"accidentally\" locked in the back office.");
                                    }
                                }                          
                            }
                            case "9" ->{
                                System.out.println("ABOUT THIS MACHINE:");
                                System.out.println("Owned by Hamilton Banking System Corporation");
                                System.out.println("FDIC Insured");
                                System.out.println("Uses bit flipping to determine new account numbers; if it breaks, contact HBS adminstrators.");
                                LocalDateTime dateObject = LocalDateTime.now();
                                DateTimeFormatter dateFormatted = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
                                String currentDate = dateObject.format(dateFormatted);
                                System.out.println("Local Date and Clock: " + currentDate);
                            }
                            case "0" ->{
                                System.out.println("Exiting help menu. You can always access the help menu by typing \"HELP\" into the terminal again.\n");
                                Thread.sleep(1500);
                                System.out.print("\033[H\033[2J");
                                running = false;
                            }
                            case "EXIT" ->{
                                scanner.close();
                                Toolkit.getDefaultToolkit().beep();
                                return;
                            }
                        }
                    }
                }
                case "EXIT" ->{
                    scanner.close();
                    Toolkit.getDefaultToolkit().beep();
                    return;
                }
            }
        }
    }
    private HamiltonBankInteractive(long accountNumber, double money){
        this.accountNumber = accountNumber;
        this.paddedNumber = padding(accountNumber);
        this.money = money;
    }
    private static String padding(long num){
        return String.format("%06d", num);
    }
    public static void accountCheck(String accountN){
        HamiltonBankInteractive temporary = null;
        for (HamiltonBankInteractive h : accountList){
            if (h.paddedNumber.equals(accountN)){
                temporary = h;
                break;
            }
        }
        if (temporary == null){
            System.out.println("\nHISTORY HAS ITS EYES ON YOU");
            return;
        }
        System.out.println("\nACCOUNT NUMBER: " + temporary.accountNumber);
        System.out.print("CURRENT BALANCE: ");
        System.out.println(String.format("%.2f", temporary.money));
    }
    public static void accountOpen(long accountN, double monies, boolean isItSavings){
        if((accountN <= 0) || (accountN > 999999)){
            System.out.println("\nHISTORY HAS ITS EYES ON YOU");
            return;
        }
        if(monies < 0){
            System.out.println("\nI AM NOT THROWING AWAY MY SHOT");
            return;
        }
        if((isItSavings == true && monies < 1500.00) || (isItSavings == false && monies < 100.00)){
            System.out.println("\nINSUFFICIENT STARTING FUND FOR ACCOUNT CREATION");
            return;
        }
        HamiltonBankInteractive newAccount = new HamiltonBankInteractive(accountN, monies);
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
                if (isUnique && candidate <= 999999 && candidate > 0) {
                    newAccount.accountNumber = candidate;
                    newAccount.paddedNumber = padding(newAccount.accountNumber);
                    accountList.add(newAccount);
                    System.out.println("\nCongratulations on creating a new account!"); 
                    System.out.println("Your new account number: " + newAccount.paddedNumber); 
                    System.out.print("Your current balance: $");
                    System.out.println(String.format("%.2f", newAccount.money));
                    return; 
                    }
                }
            }
        }
        accountList.add(newAccount);
        System.out.println("\nCongratulations on creating a new account!"); 
        System.out.println("Your new account number: " + newAccount.paddedNumber); 
        System.out.print("Your current balance: $");
        System.out.println(String.format("%.2f", newAccount.money));
    }

    public static void accountWithdraw(String accountN, double monies2){
        HamiltonBankInteractive temporary = null;
        for (HamiltonBankInteractive h : accountList){
            if (h.paddedNumber.equals(accountN)){
                temporary = h;
                break;
            }
        }
        if (temporary == null){
            System.out.println("\nHISTORY HAS ITS EYES ON YOU");
            return;
        }
        if (temporary.money < monies2){
            System.out.println("\nINSUFFICIENT FUNDS FOR REQUESTED WITHDRAWAL");
            return;
        }
        if (monies2 < 0){
            System.out.println("\nI AM NOT THROWING AWAY MY SHOT");
            return;
        }
        temporary.money -= monies2;
        System.out.print("\nYOUR NEW BALANCE: $");
        System.out.println(String.format("%.2f", temporary.money));
    }

    public static void accountDeposit(String accountN, double monies3){
        HamiltonBankInteractive temporary = null;
        for (HamiltonBankInteractive h : accountList){
            if (h.paddedNumber.equals(accountN)){
                temporary = h;
                break;
            }
        }
        if (temporary == null){
            System.out.println("\nHISTORY HAS ITS EYES ON YOU");
            return;
        }
        if (monies3 < 0){
            System.out.println("\nI AM NOT THROWING AWAY MY SHOT");
            return;
        }
        temporary.money += monies3;
        System.out.print("\nYOUR NEW BALANCE: $");
        System.out.println(String.format("%.2f", temporary.money));
    }
}