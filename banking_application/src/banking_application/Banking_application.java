
package banking_application;

import java.util.ArrayList;
import java.util.Scanner;
class Customer {
    Scanner s = new Scanner(System.in);
    private int accno;
    String name,address;
    double balance;
    Customer(int i){
        accno=i;
    }
    void addcustomer() {
        System.out.println("Your Generated Account Number is : "+ accno);
        System.out.print("Enter Customer Name : ");
        name = s.next();
        s.nextLine();
        System.out.print("Enter customer Address : ");
        address = s.nextLine();
        while(true) {
            System.out.print("Enter the Inital money Deposited(500 or more) : ");
            balance = s.nextDouble();
            if(balance >= 500.00) {
                System.out.println("Account Successfully Created.");
                break;
            }
            else
                System.out.println("The input inital deposited is less than 500.please try again.");
        }
        
    }
    void deposit() {
        while(true){
            System.out.print("Enter the amount to be deposited : ");
            double deposit = s.nextDouble();
            if(deposit > 0.0) {
                balance +=deposit;
                System.out.println("The updated balance is : "+balance);
                break;
            }
            else
                System.out.println("invalid Deposit amount. Please try again");
        }
    }
    void withdraw() {
        while(true){
            System.out.print("Enter the amount to be Withdrawn : ");
            double withdraw = s.nextDouble();
            if((withdraw > 0.0 )&& ((balance-withdraw)>=500)) {
                balance -=withdraw;
                System.out.println("The updated balance is : "+balance);
                break;
            }
            else if(balance == 500) {
                System.out.println("minimum Balance present.No withdrawal can me made.");
                break;
            }
            else
                System.out.println("invalid withdrawl amount. Please try again");
        }
    }
    
}

public class Banking_application {

   
    public static void main(String[] args) {
        int i=0;
        ArrayList<Customer> cust = new ArrayList<>(100);
        Scanner sl = new Scanner(System.in);
        while(true) {
            System.out.println("1.Add a customer\n"
                              +"2.Deposit Money\n"
                              +"3.Withdraw Money\n"
                              +"4.Transfer Money\n"
                              +"5.Total money in bank\n"
                              +"6.Person with highest deposit\n"
                              +"7.Exit");
            System.out.print("Please Enter your choice : ");
            int choice = sl.nextInt();
            switch(choice) {
                case 1 : { 
                            Customer newcust = new Customer(i);
                            newcust.addcustomer();
                            i++;
                            cust.add(newcust);
                            break;
                }
                case 2 : {
                           System.out.print("Please enter your Account number : ");
                           int input = sl.nextInt();
                            try {
                                cust.get(input).deposit();
                           }
                           catch(ArrayIndexOutOfBoundsException b) {
                               System.out.println("Invalid Account number.");
                           }
                           finally {
                           break;
                            }
                }
                case 3 : {
                           System.out.print("Please enter your Account number : ");
                           int input = sl.nextInt();
                           try {
                                cust.get(input).withdraw();
                           }
                           catch(ArrayIndexOutOfBoundsException b) {
                               System.out.println("Invalid Account number.");
                           }
                           finally {
                           break;
                            }
                }
                case 4 : {
                            System.out.print("Enter the your account number : ");
                            int youracc = sl.nextInt();
                            System.out.print("Please enter the beneficiary Account number : ");
                            int benacc=sl.nextInt();
                            try {
                                double yourcurbal = cust.get(youracc).balance;
                                System.out.print("Please enter the amount to transfer : ");
                                double traamt = sl.nextDouble();
                                if((yourcurbal-traamt)>= 500) {
                                    cust.get(youracc).balance -= traamt;
                                    cust.get(benacc).balance += traamt;
                                    System.out.println("Transfer Successful.");
                                }
                                else {
                                    System.out.println("Insufficent balance. Transfer Failed");
                                }
                            }
                            catch (ArrayIndexOutOfBoundsException b){
                                System.out.println("invaild Account Numbers.Try again");
                            }
                            break;
                }
                case 5 : {
                            double sum=0;
                            for(int j=0;j<i;j++)
                            {
                                sum += cust.get(j).balance;
                                System.out.println("The Total Money in bank is : "+sum);
                            }
                            if(sum==0.0){
                                System.out.println("The bank is empty.");
                            }
                            break;
                }
                case 6 : { 
                          try {
                            int highacc=0;
                            double highbal = cust.get(0).balance;
                            for(int j=1;j<i;j++) {
                                double bal = cust.get(j).balance;
                                if(highbal<bal){
                                    highbal = bal;
                                    highacc = j;
                                }
                            }
                            String name = cust.get(highacc).name;
                            System.out.println("The person with highest bank balance is : "+name+" With balance : "+highbal);
                          }
                          catch (IndexOutOfBoundsException b) {
                              System.out.println("The Bank has No Accounts.");
                          }
                          finally {
                            break;
                            }
                }
                default : {
                            System.exit(0);
                }
                     }
        }
    }
    
}
