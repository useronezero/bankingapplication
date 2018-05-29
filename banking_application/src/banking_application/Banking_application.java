
package banking_application;

import java.util.Scanner;

public class Banking_application {

   
    public static void main(String[] args) {
        int n=0;
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
            
        }
    }
    
}
