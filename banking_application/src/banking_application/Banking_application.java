
package banking_application;

import java.util.ArrayList;
import java.util.Scanner;
class customer {
    Scanner s = new Scanner(System.in);
    private int accno;
    String name,address;
    double balance;
    customer(int i){
        accno=i;
    }
    void addcustomer() {
        System.out.println("Your Generated Account Number is : "+ accno);
        System.out.print("Enter Customer Name : ");
        name = s.next();
        System.out.print("Enter customer Address : ");
        address = s.next();
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
            else
                System.out.println("invalid withdrawl amount. Please try again");
        }
    }
    
}

public class Banking_application {

   
    public static void main(String[] args) {
        int i=0;
        ArrayList<customer> cust = new ArrayList<>(100);
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("1.Add a customer\n"
                              +"2.Deposit Money\n"
                              +"3.Withdraw Money\n"
                              +"4.Transfer Money\n"
                              +"5.Total money in bank\n"
                              +"6.Person with highest deposit\n"
                              +"7.Exit");
            System.out.print("Please Enter your choice : ");
            int choice = s.nextInt();
            switch(choice) {
                case 1 : { 
                            customer newcust = new customer(i);
                            newcust.addcustomer();
                            i++;
                            cust.add(newcust);
                            break;
                }
                case 2 : {
                           System.out.print("Please enter your Account number : ");
                           int input = s.nextInt();
                           cust.get(input).deposit();
                           break;
                }
                case 3 : {
                           System.out.print("Please enter your Account number : ");
                           int input = s.nextInt();
                           cust.get(input).deposit();
                           break;
                }
                case 4 : {
                            System.out.print("Enter the your account number : ");
                            int youracc = s.nextInt();
                            System.out.print("Please enter the beneficiary Account number : ");
                            int benacc=s.nextInt();
                            if((i>youracc)&&(i>benacc)){
                                double yourcurbal = cust.get(youracc).balance;
                                System.out.print("Please enter the amount to transfer : ");
                                double traamt = s.nextDouble();
                                if((yourcurbal-traamt)>= 500) {
                                    cust.get(youracc).balance -= traamt;
                                    cust.get(benacc).balance += traamt;
                                    break;
                                }
                                else {
                                    System.out.println("Insufficent balance. Transfer Failed");
                                    break;
                                }
                            }
                            else {
                                System.out.print("invaild Account Numbers.Try again");
                                break;
                            }
                }
                case 5 : {
                            double sum=0;
                            for(int j=0;j<i;j++)
                            {
                                sum += cust.get(j).balance;
                                System.out.println("The Total Money in bank is : "+sum);
                                break;
                            }
                }
                case 6 : { 
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
                            System.out.println("The person with highest bank balance is : "+name+"With balance : "+highbal);
                            break;
                }
                default : {
                            System.exit(0);
                }
                     }
        }
    }
    
}
