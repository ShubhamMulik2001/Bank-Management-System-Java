
import java.util.Scanner;

/*Class Account contains the important functions of Deposit, Withdraw and Checkbalance
        which are accessed in the entire program*/

class Account {
    static double balance;

    public Account() {
        balance = 0;
    }

    public static void Withdraw(double amt) {
        balance = balance - amt;
    }

    public static void Deposit(double amt) {
        balance = balance + amt;
    }

    public static double CheckBalance() {
        return balance;
    }
}

/* SavingsAccount inherits parent class Account and performs the function of Withdraw and Deposit
by accessing the Withdraw and Deposit functions of Account Class. Offers maximum 5 transaction*/

class SavingsAccount extends Account {
    static int t = 0;
    static int limit = 5;
    static int e = 0;

    public static void Withdraw(double amt) {
        if (t > limit) {
            System.out.println("\t\tTransaction Exceeded");
            System.out.println("\n\t\tTransaction Failed......");
        } else if (Account.CheckBalance() - amt < e) {
            System.out.println("\t\tAmount Exceeds Balance");
            System.out.println("\n\t\tTransaction Failed......");
            t++;
        } else {
            Account.Withdraw(amt);
            t++;
            System.out.println("\t\tAmount Successfully Withdrawn.......");
        }
    }

    public static void Deposit(double amt) {
        if (t > limit) {
            System.out.println("\t\tTransaction Exceeded");
            System.out.println("\n\t\tTransaction Failed......");
        } else {
            Account.Deposit(amt);
            t++;
            System.out.println("\n\t\tAmount Successfully Deposited.......");
        }
    }
}

//(Multilevel Inheritance)
/*VIPSavingsAccount inherits parent class SavingsAccount and performs the function of Withdraw and Deposit
by accessing the Withdraw and Deposit functions of Account Class(Since SavingsAccount class inherits Account Class).
Minimum Balance of Rs 25000 mandatory for Transactions. Offers maximum 10 transaction*/

class VIPSavingsAccount extends SavingsAccount {
    static double minbalance = 25000;
    static int limit = 10;
    static int t = 0;

    public static void Deposit(double amt) {
        if (t > limit) {
            System.out.println("\t\tTransaction Exceeded");
            System.out.println("\n\t\tTransaction Failed......");
        } else {
            Account.Deposit(amt);
            t++;
            System.out.println("\n\t\tAmount Successfully Deposited.......");
        }
    }

    public static void Withdraw(double amt) {
        if (t > limit) {
            System.out.println("\t\tTransaction Exceeded");
            System.out.println("\n\t\tTransaction Failed......");
        } else if (Account.CheckBalance() - amt < minbalance) {
            System.out.println("\t\tCannot withdraw due to minimum balance");
            System.out.println("\n\t\tTransaction Failed......");
            t++;
        } else {
            Account.Withdraw(amt);
            t++;
            System.out.println("\n\t\tAmount Successfully Withdrawn.......");
        }

    }
}

//(Hierarchial Inheritance)
/* DematAccount inherits parent class Account and performs the function of Withdraw and Deposit
 by accessing the Withdraw and Deposit functions of Account Class. No Restrictions in Number of Transactions.
 tax of 1% of amount to be Withdrawn or Deposit cuts for every transaction*/

class DematAccount extends Account {
    double tax;
    double amt;
    static int e = 0;

    public DematAccount() {
        tax = amt * 0.01;
    }

    public static void Withdraw(double amt) {
        if (Account.CheckBalance() - amt < e) {
            System.out.println("\t\tAmount Exceeds Balance");
            System.out.println("\n\t\tTransaction Failed......");
        } else {
            amt = amt + (amt * 0.01);
            Account.Withdraw(amt);
            System.out.println("\n\t\tAmount Successfully Withdrawn.......");
        }
    }

    public static void Deposit(double amt) {
        amt = amt - (amt * 0.01);
        Account.Deposit(amt);
        System.out.println("\n\t\tAmount Successfully Deposited.......");
    }
}

/* Main Class holds the Data and Design of Program*/

public class Main {
    static int amt = 0;

    public static void main(String[] args) {
        String name = null;
        double minbalance = 25000;
        int i = 10, j = 5;
        int ch, acno = 0, choice = 0;

        do {
            System.out.println("\n-------------------------------------------------------------------------------------");
            System.out.println("\n\t\t=======================");
            System.out.println("\t\tBANK MANAGEMENT PROJECT");
            System.out.println("\t\t=======================");
            System.out.println("\t\t     ::MAIN MENU::");
            System.out.println("\n\t\t1)NEW ACCOUNT");
            System.out.println("\t\t2)DEPOSIT AMOUNT");
            System.out.println("\t\t3)WITHDRAW AMOUNT");
            System.out.println("\t\t4)DISPLAY EXISTING ACCOUNT DETAILS");
            System.out.println("\t\t5)EXIT");
            System.out.println("\n\t\tEnter your choice: ");
            Scanner b = new Scanner(System.in);
            ch = b.nextInt();
            Scanner p = new Scanner(System.in);
            switch (ch) {
                case 1:
                    System.out.println("\t\tEnter Account Holders Name: ");
                    Scanner n = new Scanner(System.in);
                    name = n.nextLine();
                    System.out.println("\t\tEnter Account Number: ");
                    Scanner acn = new Scanner(System.in);
                    acno = acn.nextInt();
                    System.out.println("\t\tEnter Account Type: ");
                    System.out.println("\n\t\t\t\t1)SAVINGS ACCOUNT");
                    System.out.println("\n\t\t\t\t2)DEMAT ACCOUNT");
                    System.out.println("\n\t\t\t\t3)VIP SAVINGS ACCOUNT");
                    System.out.println("\n\t\tEnter your choice: ");
                    Scanner choice1 = new Scanner(System.in);
                    choice = choice1.nextInt();
                    if (choice == 1) {
                        System.out.println("\n\t\tSavings Account Created..........\n");
                        System.out.println("\n\t\tEnter Opening Balance: ");
                        amt = p.nextInt();
                        SavingsAccount.Deposit(amt);
                    } else if (choice == 2) {
                        System.out.println("\n\t\tDemat Account Created..........\n");
                        System.out.println("\n\t\tEnter Opening Balance: ");
                        amt = p.nextInt();
                        DematAccount.Deposit(amt);
                    } else if (choice == 3) {
                        System.out.println("\n\t\tVIP Savings Account Created..........");
                        System.out.println("\n\t\tAmount should be more than " + minbalance + " for Transactions");
                        System.out.println("\n\t\tEnter Opening Balance: ");
                        amt = p.nextInt();
                        VIPSavingsAccount.Deposit(amt);
                    } else {
                        System.out.println("\n\t\tINVALID Choice");
                    }
                    break;
                case 2:
                    if (choice == 1) {
                        System.out.println("\n\t\tTotal " + j + " Transactions Left");
                        System.out.println("\t\tEnter Amount to be Deposited: ");
                        amt = p.nextInt();
                        SavingsAccount.Deposit(amt);
                        j--;
                    } else if (choice == 2) {
                        System.out.println("\t\tEnter Amount to be Deposited: ");
                        amt = p.nextInt();
                        DematAccount.Deposit(amt);
                    } else if (choice == 3) {
                        System.out.println("\n\t\tTotal " + i + " Transactions Left");
                        System.out.println("\n\t\tEnter Amount to be Deposited: ");
                        amt = p.nextInt();
                        VIPSavingsAccount.Deposit(amt);
                        i--;
                    } else {
                        System.out.println("\n\t\tCreate Account to Deposit.............");
                    }
                    break;
                case 3:
                    if (choice == 1) {
                        System.out.println("\n\t\tTotal " + j + " Transactions Left");
                        System.out.println("\n\t\tEnter Amount to be Withdrawn: ");
                        amt = p.nextInt();
                        SavingsAccount.Withdraw(amt);
                        j--;
                    } else if (choice == 2) {
                        System.out.println("\t\tEnter Amount to be Withdrawn: ");
                        amt = p.nextInt();
                        DematAccount.Withdraw(amt);
                    } else if (choice == 3) {
                        System.out.println("\n\t\tTotal " + i + " Transactions Left");
                        System.out.println("\n\t\tMinimum Balance of " + minbalance + " is Mandatory");
                        System.out.println("\n\t\tEnter Amount to be Withdrawn: ");
                        amt = p.nextInt();
                        VIPSavingsAccount.Withdraw(amt);
                        i--;
                    } else {
                        System.out.println("\n\t\tCreate Account to Withdraw.............");
                    }
                    break;
                case 4:
                    if (choice == 1) {
                        System.out.println("\t\t\t\t\tDETAILS");
                        System.out.println("\t\t\t\t\tAccount Holders Name: " + name);
                        System.out.println("\t\t\t\t\tAccount Number: " + acno);
                        System.out.println("\t\t\t\t\tAccount Type: SAVINGS ACCOUNT ");
                        System.out.println("\t\t\t\t\tBalance: " + SavingsAccount.CheckBalance());
                    } else if (choice == 2) {
                        System.out.println("\t\t\t\t\tDETAILS");
                        System.out.println("\t\t\t\t\tAccount Holders Name: " + name);
                        System.out.println("\t\t\t\t\tAccount Number: " + acno);
                        System.out.println("\t\t\t\t\tAccount Type: DEMAT ACCOUNT ");
                        System.out.println("\t\t\t\t\tBalance: " + DematAccount.CheckBalance());
                    } else if (choice == 3) {
                        System.out.println("\t\t\t\t\tDETAILS");
                        System.out.println("\t\t\t\t\tAccount Holders Name: " + name);
                        System.out.println("\t\t\t\t\tAccount Number: " + acno);
                        System.out.println("\t\t\t\t\tAccount Type: VIP SAVINGS ACCOUNT ");
                        System.out.println("\t\t\t\t\tBalance: " + VIPSavingsAccount.CheckBalance());
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\t\tInvalid Choice......");
                    System.out.println("\n\t\tEnter Valid Choice.......");
                    break;
            }
        }
        while (ch != 5);
    }
}

