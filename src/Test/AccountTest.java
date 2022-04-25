package Test;

import Model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountTest {

    //List of Accounts
    private static List<Account> AccountsData = new ArrayList<>();

    public static void main(String[] args) {

        Generate_InitialAccountsData();

        Show_UserMenu();
    }

    static void Generate_InitialAccountsData(){
        AccountsData.add(new Account("100","jalvarezm","12345678","05/11/1999",20000.00 ));
        AccountsData.add(new Account("101","calvarezm","12345678","05/11/2015",30000.00 ));
        AccountsData.add(new Account("102","galvarezm","12345678", "05/11/2010",40000.00 ));
        AccountsData.add(new Account("103","kalvarezm","12345678","05/11/2021",50000.00 ));
        AccountsData.add(new Account("104","ftorres","12345678", "05/11/2002",15000.00 ));
        AccountsData.add(new Account("105","eegusquiza","12345678","05/11/2004",20000.00 ));
    }

    static void Show_UserMenu(){
        System.out.println();
        System.out.println("USER MENU");
        System.out.println("1. List Accounts");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Transfer to another Account");
        System.out.println("4. Deposit Money");
        System.out.println("5. Create new Saving Account");
        System.out.println("6. Exit");
        System.out.print ("Please choose an option by enter a number:");

        Scanner myScanner = new Scanner (System.in);
        String Input_keyboard = myScanner.nextLine ();
        System.out.println ();

        switch (Input_keyboard){
            case "1":
                listAccount();
                break;
            case "2":
                WithdrawMoney();
                break;
            case "3":
                TransferMoney();
                break;
            case "4":
                DepositMoney();
                break;
            case "5":
                createAccount();
                break;
            case "6":
                ExitSystem();
                break;

            default:
                System.out.println("Incorrect option, please try again.");
                Show_UserMenu();
        }
    }

    static void listAccount(){

        System.out.println("***** ACCOUNTS LIST *****");

        for(Account i: AccountsData){
            System.out.println( "Account: "+ i.getAccount_number() +", User:"+i.getUser() +", Password:"+i.getPassword()
                    +", Opening Date: "+i.getOpening_date() +", Balance: $"+i.getBalance() );
        }

        Show_UserMenu();
    }

    static void WithdrawMoney(){
        System.out.print ("Please enter saving account number: ");
        Scanner myScanner = new Scanner (System.in);
        String input_keyboard = myScanner.nextLine ();
        boolean exists=false;

        for (Account e: AccountsData) {
            if(e.getAccount_number().equals(input_keyboard)) {
                System.out.println("***** Account found ***** ");
                System.out.println("Account: "+ e.getAccount_number() +", User:"+e.getUser()
                        +", Password:" +e.getPassword() +", Opening Date "+e.getOpening_date()
                        +", Balance "+e.getBalance());
                System.out.print("Enter amount to withdraw: ");
                double amount_withdrawal = Double.parseDouble( myScanner.nextLine() );

                if(amount_withdrawal<1000){
                    e.setBalance( e.getBalance() - amount_withdrawal-200 );
                }else{
                    e.setBalance( e.getBalance() - amount_withdrawal-200- (amount_withdrawal*0.15) );
                }

                System.out.println("***** Successful Transaction ***** ");
                System.out.println("Account: "+ e.getAccount_number() +", User:"+e.getUser()
                        +", Password:"+e.getPassword()+", Opening Date "+e.getOpening_date()+", Balance "+e.getBalance());
                exists=true;
                break;
            }
        }

        if (exists==false){
            System.out.println("ACCOUNT DOESN'T EXIST. Please verify account number.");
        }
        Show_UserMenu();
    }

    static void TransferMoney(){

        System.out.print ("Introduce ORIGIN saving account: ");
        Scanner myScanner = new Scanner (System.in);
        String origin_account = myScanner.nextLine ();

        boolean exists=false;

        for (Account e: AccountsData) {
            if(e.getAccount_number().equals(origin_account)) {
                System.out.println("***** Account found ***** ");
                System.out.println("Account: "+ e.getAccount_number() +", User:"+e.getUser()
                        +", Password:"+e.getPassword()+", Opening Date "+e.getOpening_date()
                        +", Balance "+e.getBalance());

                System.out.print ("Introduce TARGET saving account: ");
                String target_account = myScanner.nextLine ();

                System.out.print("Enter amount to be transferred: ");
                double amount_transferred = Double.parseDouble( myScanner.nextLine () );

                e.setBalance(e.getBalance() - amount_transferred - 100);

                System.out.println("****** Successful Transaction *****"
                        +"\n Origin Account : "+ origin_account +", Target Account: "+target_account
                        +", Origin Account new balance: "+e.getBalance());
                exists=true;
                break;
            }
        }

        if (exists==false){
            System.out.println("ACCOUNT DOESN'T EXIST. Please verify account number.");
        }
        Show_UserMenu();
    }

    static void DepositMoney(){
        System.out.print ("Introduce saving account number: ");
        Scanner myScanner = new Scanner (System.in);
        String input_keyboard = myScanner.nextLine ();
        boolean exists=false;

        for (Account e: AccountsData) {
            if(e.getAccount_number().equals(input_keyboard)) {
                System.out.println("***** Account found ***** ");
                System.out.println("Account: "+ e.getAccount_number() +", Usuario:"+e.getUser()
                        +", Password:"+e.getPassword()+", Opening Date "+e.getOpening_date()
                        +", Balance "+e.getBalance());

                System.out.print("Enter amount to deposit: ");
                double deposit_amount = Double.parseDouble( myScanner.nextLine () );
                e.setBalance( e.getBalance() + deposit_amount );

                System.out.println("***** Successful Transaction ***** "
                +"\nAccount: "+ e.getAccount_number() +", User:"+e.getUser()+", Password:"+e.getPassword()
                        +", Opening Date "+e.getOpening_date() + ", Balance "+e.getBalance());
                exists=true;
                break;
            }
        }

        if (exists==false){
            System.out.println("ACCOUNT DOESN'T EXIST. Please verify account number.");
        }
        Show_UserMenu();
    }

    static void createAccount(){
        Scanner myScanner = new Scanner (System.in);

        System.out.print ("Please introduce an account number for your new saving account: ");
        String account_number = myScanner.nextLine ();
        System.out.print ("Introduce a User name: ");
        String user = myScanner.nextLine ();
        System.out.print ("Introduce password: ");
        String password = myScanner.nextLine ();
        System.out.print ("Introduce Opening Date: ");
        String opening_date = myScanner.nextLine ();
        System.out.print ("Introduce an Initial Balance: ");
        double balance = Double.parseDouble( myScanner.nextLine() );

        AccountsData.add( new Account(account_number, user, password, opening_date,balance) );

        Account i= AccountsData.get( AccountsData.size()-1 );
        System.out.println("***** Successful Transaction ***** "
                            +"\nCuenta: "+ i.getAccount_number() +", User:"+i.getUser()+", Password:"+i.getPassword()
                            +", Opening Date: "+i.getOpening_date() +", Balance: "+ i.getBalance() );

        Show_UserMenu();

    }

    static void ExitSystem(){
        System.out.println("****** SEE YOU SOON ******");
    }

}
