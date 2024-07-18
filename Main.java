// Program for ATM interface
import java.util.*;

class Account{
    int account_no;
    String name;
    double balance;
    public void account(){
        System.out.println("********************WELCOME TO BANKING APLLICATION********************");
        Scanner in=new Scanner(System.in);
        Scanner st=new Scanner(System.in);
        System.out.println("Enter the 10 digit Account Number: ");
        account_no=in.nextInt();
        System.out.println("Enter the acccount Holder name: ");
        name=st.nextLine();
        System.out.println("Enter the Available balance in your account: ");
        balance=in.nextDouble();
        if(balance<2000){
            System.out.println("The amount is less than the minimum balance, Hence to deposit as soon as possible");
        }
    }
}

class Deposit extends Account{
    public void deposit(int amount){
        balance+=amount;
        System.out.println("###################ACCOUNT DETAILS####################");
        System.out.println("ACCOUNT NUMBER: "+account_no);
        System.out.println("ACCOUNT HOLDER: "+name);
        System.out.println("The amount of INR: "+amount+ "has been deposited in the account");
        System.out.println("The Available balance is : "+balance);
        System.out.println("________________________________________________________________");
    }
}


class Withdraw extends Deposit{
    public void withdraw(int amount){
        int min_bal=2000;
        if(balance<amount){
            System.out.println("Sorry,The requested amount is not available in the account as the balance is only: "+balance);
            System.out.println("________________________________________________________________");
        }
        else if(amount<balance){
            balance-=amount;
            System.out.println("###################ACCOUNT DETAILS####################");
            System.out.println("ACCOUNT NUMBER: "+account_no);
            System.out.println("ACCOUNT HOLDER: "+name);
            System.out.println("The amount of INR: "+amount+ "has been withdrawed from the account");
            System.out.println("The Available balance is : "+balance);
            System.out.println("________________________________________________________________");
        }
        if(balance<min_bal){
            System.out.println("Your balance has gone below the minimum balance, Hence try to deposit amount as soon as possible");
            System.out.println("________________________________________________________________");

        }
    }
}


class Balance extends Withdraw{
    public void checkBalance(){
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("The available balance in the account number: "+account_no+" is = "+balance);
        System.out.println("---------------------------THANK YOU-----------------------------------------");
    }
}


public class Main extends Balance{
    public static void main(String[] args){
        Main b=new Main();
        Scanner ins=new Scanner(System.in);
        Scanner sc=new Scanner(System.in);
        int ch,x;
        String c;
        b.account();
        do{
            System.out.println("\n\nThe available options are \n1.Deposit\n2.Withdraw\n3.Check Balance");
            System.out.println("Enter you choice: ");
            ch=ins.nextInt();
            switch(ch){
                case 1:
                {
                    System.out.println("Enter the amount to deposit: ");
                    x=ins.nextInt();
                    b.deposit(x);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter the amount to withdraw: ");
                    x=ins.nextInt();
                    b.withdraw(x);
                    break;
                }
                case 3:
                {
                    b.checkBalance();
                    break;
                }
            }
            System.out.println("Do you want to perform another transaction (y for yes and n for no): ");
            c=sc.nextLine();
        }while(c.equals("y"));
    }
}


