
package banking_application;

import java.util.ArrayList;
import java.util.Scanner;
class Customer {
    Scanner scan = new Scanner(System.in);
    private final int  accountNumber;
    String customerName,customerAddress;
    double balance;
    Customer(int input){
        accountNumber=input;
    }
    void addCustomer() {
        System.out.println("Your Generated Account Number is : "+ accountNumber);
        System.out.print("Enter Customer Name : ");
        customerName = scan.next();
        scan.nextLine();
        System.out.print("Enter customer Address : ");
        customerAddress = scan.nextLine();
        while(true) {
            System.out.print("Enter the Inital money Deposited(500 or more) : ");
            balance = scan.nextDouble();
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
            double deposit = scan.nextDouble();
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
            double withdraw = scan.nextDouble();
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

public class BankingApplication {

       static int index=0;
       static ArrayList<Customer> customerArray = new ArrayList<>(100);
       static Scanner scan = new Scanner(System.in);
        
    public static void main(String[] args) {
        while(true) {
            System.out.println("1.Add a customer\n"
                              +"2.Deposit Money\n"
                              +"3.Withdraw Money\n"
                              +"4.Transfer Money\n"
                              +"5.Total money in bank\n"
                              +"6.Person with highest deposit\n"
                              +"7.Exit");
            System.out.print("Please Enter your choice : ");
            int choice = scan.nextInt();
            switch(choice) {
                case 1 :   
                            addingCustomer();
                            break;
                case 2 : 
                           depositMoney();
                           break;
                
                case 3 :  withdrawMoney();
                           break;
                          
                case 4 : 
                            transferMoney();
                            break;
                
                case 5 : 
                            totalMoneyInBank();
                            break;
                
                case 6 : 
                            richestPerson();
                            break;
                
                default : 
                            System.exit(0);
                
                     }
        }
    }
    static void addingCustomer() {
        Customer newCustomerobject = new Customer(index);
        newCustomerobject.addCustomer();
        index++;
        customerArray.add(newCustomerobject);
    }
    static void depositMoney() {
        System.out.print("Please enter your Account number : ");
        int input = scan.nextInt();
         try {
             customerArray.get(input).deposit();
        }
        catch(ArrayIndexOutOfBoundsException b) {
            System.out.println("Invalid Account number.");
        }
    }
    static void withdrawMoney() {
        System.out.print("Please enter your Account number : ");
        int input = scan.nextInt();
        try {
             customerArray.get(input).withdraw();
        }
        catch(ArrayIndexOutOfBoundsException b) {
            System.out.println("Invalid Account number.");
        }
    }
    static void transferMoney() {
        System.out.print("Enter the your account number : ");
        int yourAccountNumber = scan.nextInt();
        System.out.print("Please enter the beneficiary Account number : ");
        int beneficiaryAccountNumber=scan.nextInt();
        try {
            double yourCurrentBalance = customerArray.get(yourAccountNumber).balance;
            double benificiaryBalance = customerArray.get(beneficiaryAccountNumber).balance;
            System.out.print("Please enter the amount to transfer : ");
            double transferAmount = scan.nextDouble();
            if((yourCurrentBalance-transferAmount)>= 500) {
                customerArray.get(yourAccountNumber).balance -= transferAmount;
                customerArray.get(beneficiaryAccountNumber).balance += transferAmount;
                System.out.println("Transfer Successful.");
            }
            else {
                System.out.println("Insufficent balance. Transfer Failed");
            }
        }
        catch (ArrayIndexOutOfBoundsException b){
            System.out.println("invaild Account Numbers.Try again");
        }
    }
    static void totalMoneyInBank() {
        double totalMoneyInBank=0;
        for(int j=0;j<index;j++)
        {
            totalMoneyInBank += customerArray.get(j).balance;
        }
        if(totalMoneyInBank==0.0){
            System.out.println("The bank is empty.");
        }
        else
            System.out.println("The Total Money in bank is : "+totalMoneyInBank);
    }
    static void richestPerson() {
        try {
                int accountWithHighestBalance=0;
                double highestBalance = customerArray.get(0).balance;
                for(int j=1;j<index;j++) {
                    double bal = customerArray.get(j).balance;
                    if(highestBalance<bal){
                        highestBalance = bal;
                        accountWithHighestBalance = j;
                    }
                }
                String name = customerArray.get(accountWithHighestBalance).customerName;
                System.out.println("The person with highest bank balance is : "+name+" With balance : "+highestBalance);
        }
        catch (IndexOutOfBoundsException b) {
            System.out.println("The Bank has No Accounts.");
        }
    }
}
