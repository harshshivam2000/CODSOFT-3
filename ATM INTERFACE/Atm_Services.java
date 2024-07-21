//import java.io.Closeable;
//import java.nio.file.SecureDirectoryStream;
import java.io.PrintStream;
import java.util.*;
 class Atm
{
    private Bank_Amount acc;
    private int pin;

    public Atm(Bank_Amount ac,int pin)
    {
        this.acc=ac;
        this.pin=pin;
    }

    public void options()
    {
        System.out.println("Welcome to our Atm");
        System.out.println("press 1 to check Balance " );
        System.out.println("press 2 to Deposit" );
        System.out.println("press 3 to Withdrwal" );
        System.out.println("press 4 to Exit " );
    }

    public boolean verfiy_pin(int entred_pin)
    {
        return this.pin== entred_pin;
    }

    public void atm_process()
{
    Scanner sc =new Scanner(System.in);

    int entered_pin;

    System.out.println("Enter your pin");
    entered_pin =sc.nextInt();


if(verfiy_pin(entered_pin))
{
    int option=0;
    
    while(option!=4)
    {
        System.out.println("Enter your opinion press 1 for A/C balance 2 for deposit 3 for Withdrwal and 4 for exit ");

        option =sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("The Account balance is="+acc.getbalance());
                break;
            case 2:
                System.out.println("Enter the amount to deposit=");
                double Amount_deposit =sc.nextDouble();
                acc.deposit_balance(Amount_deposit);
                break;

            case 3:
                System.out.println("Enter the amount to Withdrwal=");
                double Amount_withdrawal  =sc.nextDouble();
                acc.Withdrwal_balance (Amount_withdrawal );
                break;
             
            case 4:
                System.out.println("Thanks for using Atm");
                break;
                
            default:
            System.out.println("You entered wrong choice");
                
        }
    }
}
else{
       System.out.println("Incorrect pin "); 
    }
    PrintStream st;
   // Closeable sc;
    sc.close();
}
}

class Bank_Amount 
{
    private double balance;

    public Bank_Amount(double d) {
        //TODO Auto-generated constructor stub
    }
    public  void Bank_Acc(double initial_Balance)
    {
        this.balance=initial_Balance;
    }
    public double getbalance()
    {
        return balance;
    }

    public void deposit_balance(double amount)
    {
        if(amount>0)
        {
            balance=balance+amount;
            System.out.println("The amount"+amount+"is deposite Successfully");
        }
        else
        {
            System.out.println("The can't deposit anount less than 0");

        }
    }

    public void Withdrwal_balance(double amount)
    {
        if(amount>0 && amount<=balance)
        {
            balance=balance-amount;
            System.out.println("The amount"+amount+"is withdrawal Successfully ");
        }
        else
        {
            System.out.println("You don't have sufficient balance to withdrawal ");
        }
    }

}


public class Atm_Services{
    public static void main(String[] args)
    {
        Bank_Amount user_account=new Bank_Amount(1000.0);
        int actual_pin=1234;
        Bank_Amount a;
        Atm atm=new Atm(user_account,actual_pin);
        atm.atm_process();
    }
}
