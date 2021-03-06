
package banking_application;

import java.util.ArrayList;
import java.util.Scanner;
/** 
 * Customer class provides with methods that add a new customer to the system.
 *  It also have methods that help with withdraws and deposits.
 */
class Customer {
    Scanner scan = new Scanner(System.in);
    private final int  accountNumber;
    String customerName,customerAddress;
    double balance;
    /**
     * The constructor takes in the input at creation of the object and sets
     * the account Number given as input at creation.
     * accountNumber stores the account number of the customer and is of the type integer.
     * 
     * @param input the input given from main class to setup account number.
     * @param name it the name of the customer
     * @param address it is the address of the customer
     * @param deposit it the initial deposit of the customer at the creation of the account.
     * 
     */
    Customer(int input,String name,String address,double deposit){
        accountNumber=input;
        customerName=name;
        customerAddress=address;
        balance=deposit;
    }
    /**
     * The job of this method is to update the balance when the customer wants to deposit/add money to his/her
     * bank account.
     * It also has while loop and a if statement to make sure No Invalid Amount is being deposited. 
     */
    int deposit(double deposit) {
        balance+=deposit;
        return 0;
    }
    /**
     *The job of this method is to update the balance when the customer wants to Withdraw/Subtract money from his/her
     *bank account.
     * the method a while loop with if conditions to make sure the minimum balance is maintained at all times.
     * And also makes sure that no Invalid amount is being withdrawn.
     */
    int withdraw(double withdraw) {
        balance-=withdraw;
        return 0;
    }
    
}
/**
 * This is the main class of the program. The main method exists here.
 * This class has main method , Transfer money method,Total money in bank method etc,to
 * carry out all the normal functions of the bank as per the Customer requirements .
 * 
 * @author kishore
 * @version 1
 */
public class BankingApplication {

    static int index=0;
    static ArrayList<Customer> customerArray = new ArrayList<>(100);
    static Scanner scan = new Scanner(System.in);
    
/**
 * This is the first method to run.
 * it Displays a menu to the user to select an option from and 
 * performs the needed action accordingly.
 * it has while loop so that the program runs a long as user doesn't want to quit it.
 * The switch case go the appropriate actions that needs to be performed as per user
 * choice.
 * 
 * @param args the command line input to the method from the user. 
 */    
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
                            userDataInput();
                            break;
                case 2 : 
                           depositMoney();
                           break;
                
                case 3 :  withdrawMoney();
                           break;
                          
                case 4 : 
                            collectAccountNUmbersForTransfer();
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
    static void userDataInput() {
         String customerName,customerAddress;
         double initialDeposit;
         int status;
        System.out.print("Enter Customer Name : ");
        customerName = scan.next();
        scan.nextLine();
        System.out.print("Enter customer Address : ");
        customerAddress = scan.nextLine();
        while(true) {
            System.out.print("Enter the Inital money Deposited(500 or more) : ");
            initialDeposit = scan.nextDouble();
            if(initialDeposit >= 500.00) {
                status = addingCustomer(index,customerName,customerAddress,initialDeposit);
                break;
            }
            else
                System.out.println("The input inital deposited is less than 500.please try again.");
        }
        if(status == 0) {
            System.out.println("Account Successfully created.");
        }
        else
            System.out.println("Error unable to Create Account");
    }
    /**
     * When called this method takes input from the user and creates a new bank account
     * for the user.
     * It also has a while loop and if statement to make sure that the account isn't created unless the 
     * minimum balance requirement are met. i.e the initial amount deposited needs to be 500 or more.
     * scan: this is used to take input from the user and it is of the type Scanner.
     * customerName: this stores the name of the customer and is of the type String
     * customerAddress: this stores the address of the customer and is of the type String.
     * balance: this stores the current balance of the customer at any give time and is of the type double.
     * This method when called creates a new object of type Customer, initialize
     * it with index value as account number, called the method addCustomer
     * to take the customer details and then it adds that object to the array list.
     */
    static int addingCustomer(int accno,String name,String address,double deposit) {
        Customer newCustomerobject = new Customer(accno,name,address,deposit);
        index++;
        customerArray.add(newCustomerobject);
        return 0;
    }
    /**
     * this method is called when the customer wants to add money to his/her Account.
     * When called it takes the account number from the user.
     * Next it tries to access deposit method of the array list element of that account number.
     * if the account number exist then the deposit method is run.
     * Else it throws a ArrayInderOutOfBoundsException.
     * The Exception is caught and an error message is shown to the user.
     */
    static void depositMoney() {
        System.out.print("Please enter your Account number : ");
        int input = scan.nextInt();
         try {
            while(true){
            System.out.print("Enter the amount to be deposited : ");
            double deposit = scan.nextDouble();
            if(deposit > 0.0) {
                customerArray.get(input).deposit(deposit);
                break;
            }
            else
                System.out.println("invalid Deposit amount. Please try again");
        }
        }
        catch(ArrayIndexOutOfBoundsException b) {
            System.out.println("Invalid Account number.");
        }
    }
    /**
     * this method is called when the customer wants to withdraw money from his/her Account.
     * When called it takes the account number from the user.
     * Next it tries to access withdraw method of the array list element of that account number.
     * if the account number exist then the withdraw method is run.
     * Else it throws a ArrayInderOutOfBoundsException.
     * The Exception is caught and an error message is shown to the user.
     */
    static void withdrawMoney() {
        System.out.print("Please enter your Account number : ");
        int input = scan.nextInt();
        try {
            while(true){
            System.out.print("Enter the amount to be Withdrawn : ");
            double withdraw = scan.nextDouble();
            double bal = customerArray.get(input).balance;
            if((withdraw > 0.0 )&& ((bal-withdraw)>=500)) {
                customerArray.get(input).withdraw(withdraw);
                break;
            }
            else if(bal == 500) {
                System.out.println("minimum Balance present.No withdrawal can me made.");
                break;
            }
            else
                System.out.println("invalid withdrawl amount. Please try again");
        }

        }
        catch(ArrayIndexOutOfBoundsException b) {
            System.out.println("Invalid Account number.");
        }
    }
    static void collectAccountNUmbersForTransfer() {
        System.out.print("Enter the your account number : ");
        int yourAccountNumber = scan.nextInt();
        System.out.print("Please enter the beneficiary Account number : ");
        int beneficiaryAccountNumber=scan.nextInt();
        transferMoney(yourAccountNumber,beneficiaryAccountNumber);
    }
    /**
     * this method is called when the customer wants to Transfer money from his/her Account.
     * When called it takes the account number from the Customer.
     * Then it asks for the Account number of the Beneficiary .
     * Next it tries to access balance variable of the array list element of that account number.
     * Next it takes the amount to be transfered from the customer.
     * if both the account numbers exist then it checks if the  Customer have enough money to send.
     * if this condition is also satisfied then the transfer happens.
     * if there is not enough balance then a error message is shown. and if anyone of the account numbers 
     * don't exit an exception is thrown.
     * it throws a ArrayInderOutOfBoundsException.
     * The Exception is caught and an error message is shown to the user.
     */
    static int transferMoney(int yourAccountNumber,int beneficiaryAccountNumber) {
        try {
            double yourCurrentBalance = customerArray.get(yourAccountNumber).balance;
            double benificiaryBalance = customerArray.get(beneficiaryAccountNumber).balance;
            System.out.print("Please enter the amount to transfer : ");
            double transferAmount = scan.nextDouble();
            if((yourCurrentBalance-transferAmount)>= 500) {
                customerArray.get(yourAccountNumber).balance -= transferAmount;
                customerArray.get(beneficiaryAccountNumber).balance += transferAmount;
                return 0;
            }
            else {
                return 1;
                //System.out.println("Insufficent balance. Transfer Failed");
            }
        }
        catch (ArrayIndexOutOfBoundsException b){
        return 1;    
        //System.out.println("invaild Account Numbers.Try again");
        }
    }
    /**
     * This method simply adds money of the Customers to calculate the total money 
     * present in the bank.
     * it also has a for when the bank is empty.
     */
    static int totalMoneyInBank() {
        double totalMoneyInBank=0;
        for(int j=0;j<index;j++)
        {
            totalMoneyInBank += customerArray.get(j).balance;
        }
        if(totalMoneyInBank==0.0){
            System.out.println("The bank is empty.");
            return 1;
        }
        else
            
            System.out.println("The Total Money in bank is : "+totalMoneyInBank);
            return 0;
    }
    /**
     * This method is used to find the Richest customer.
     * it compares the balance of all the customers and find outs who has 
     * the highest balance.
     * Then it displays their Name with their Balance.
     */
    static int richestPerson() {
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
                return 0;
        }
        catch (IndexOutOfBoundsException b) {
            System.out.println("The Bank has No Accounts.");
            return 1;
        }
    }
}
