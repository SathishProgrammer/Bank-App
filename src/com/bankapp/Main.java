package com.bankapp;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Bank bank = new Bank();
    Account account = null;
    Scanner scan = new Scanner(System.in);
    while(true){
      System.out.println("Welcome to Indian Bank");
      System.out.println(" ");
      System.out.println("Select the option to perform: ");
      System.out.println(" ");
      System.out.println("1: Open Account" + "\n" +"2: View Account" + "\n" +"3: Close Account" + "\n" +
              "4: Deposit Amount" + "\n" + "5: Withdraw Amount" + "\n" + "6: Check Balance" + "\n" + "7: Exit"+ "\n");

      int choice = scan.nextInt();
      scan.nextLine();
      switch (choice) {
        case 1:
          account = new Account();
          account.openAccount();
          bank.addCustomer(account);
          break;

        case 2:
          bank.findCustomer();
          break;
          
        case 3:
          bank.removeCustomer();
          break;

        case 4:
              bank.cashDeposit();;
              break;

        case 5:
              bank.cashWithdraw();
              break;
          
        case 6:
          bank.getBalance();
          break;

        default:
          if(choice != 7){
            System.out.println("Enter a valid input: ");
      }
          break;
    }
    if (choice==7){
      System.out.println("Thank you for banking with us!!");
      break;
    }
  }
    scan.close();
    }
}
