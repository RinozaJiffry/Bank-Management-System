import java.util.Scanner;

public class Account
{
    static int accounBalanace;
    private static String accountHolderId;
    private static int previousTransaction;
    private static String accountHolderName;


    //Deposit
    static void deposit(int amount) {
        if (amount != 0) {
            accounBalanace = accounBalanace + amount;
            previousTransaction = amount;
        }
    }

    //Money widthdrawel
    static void withdrawal(int amount) {
        if (amount != 0) {
            accounBalanace = accounBalanace - amount;
            previousTransaction = -amount;
        }
    }


    //previous transaction
    static void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("            Deposited Amount: " + previousTransaction);
            System.out.println("            Keep connecting ...Happy Banking!!!");
        } else if (previousTransaction < 0) {
            System.out.println("            Withdrawal Amount : " + Math.abs(previousTransaction));
            System.out.println("            Keep connecting ...Happy Banking!!!");
        } else {
            System.out.println("            No transaction done");
            System.out.println("            Keep connecting ...Happy Banking!!!");
        }
    }

    // calculating interest of current funds after several years
    static void interstCalculating(int years) {
        double interestRate = .0245;
        double newBalance = (accounBalanace * interestRate * years) + accounBalanace;
        System.out.println("            The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("            After " + years + " years, you balance will be: " + newBalance);
    }

    // main menu
    static void showSystem() {
        char option = '\0';
        System.out.println("        =======================================================================================");
        System.out.println("        =======================================================================================");
        System.out.println("                ***************                WELCOME TO OUR BANK           ******************");
        System.out.println("        =======================================================================================");
        System.out.println("        =======================================================================================");
        System.out.println("   ");
        System.out.println("   ");

        Scanner scanner = new Scanner(System.in);
        System.out.print("          Please Enter your Name : ");
        accountHolderName = scanner.nextLine();
        System.out.print("          Please Enter your Account Number : ");
        accountHolderId= scanner.nextLine();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("                Welcome, " + accountHolderName + "!");
        System.out.println("                Your ID is: " + accountHolderId);
        System.out.println(" ");

        System.out.println("===========================================================================");
        System.out.println("===========================================================================");
        System.out.println("        What Kind of Service do you need from us ?");
        System.out.println();
        System.out.println("       A. Account Balance");
        System.out.println("       B. Deposit Money");
        System.out.println("       C. Withdraw Money");
        System.out.println("       D. View previous transaction");
        System.out.println("       E. Calculate interest");
        System.out.println("       F. Exit from the system");
        System.out.println("===========================================================================");
        System.out.println("===========================================================================");

        do {
            System.out.println();
            System.out.print("            Enter your option here : ");
            char selector = scanner.next().charAt(0);
            option = Character.toUpperCase(selector);


            switch(option) {
                //Case 'A' - Account Balance
                case 'A':
                    System.out.println("            ====================================");
                    System.out.println("            Balance Amount= $" + accounBalanace);
                    System.out.println("            ====================================");

                    break;
                //Case 'B' - Deposit Money
                case 'B':
                    System.out.print("            Enter depositing amount: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("            *************************************");
                    break;
                //Case 'C' - Widrawel Money
                case 'C':
                    System.out.print("            Enter withdrawing amount: ");
                    int amount2 = scanner.nextInt();
                    withdrawal(amount2);
                    System.out.println("            *************************************");

                    break;
                //Case 'D' - Previous function
                case 'D':
                    System.out.println("            ====================================");
                    getPreviousTransaction();
                    System.out.println("            ====================================");
                    break;
                //Case 'E' - Calculate interest according to the year
                case 'E':
                    System.out.print("            Enter the years of interest : ");
                    int years = scanner.nextInt();
                    interstCalculating(years);
                    break;
                //Case 'F' - Exit from the system
                case 'F':
                    System.out.println("            ====================================");
                    break;

                default:
                    System.out.println("        Invalid syntax...Please shoe the operation properly and try again....");
                    break;
            }
        } while(option != 'F');

        System.out.println("            ***************************************************");
        System.out.println("           Thank you for banking with us!!....Come Again!!....");
        System.out.println("            ***************************************************");
    }

}
