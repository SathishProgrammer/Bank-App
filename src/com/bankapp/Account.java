package com.bankapp;


import java.util.Scanner;

public class Account {
  private String name;
  private String phoneNumber;
  private String address;
  private double initialBalance;
  private String customerId;
  private String accountNumber;

  public double getInitialBalance() {
    return initialBalance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }
  
  public String getCustomerId() {
    return customerId;
  }

  Scanner scan = new Scanner(System.in);

  // Method for opening a account
  public void openAccount(){
    System.out.println("Enter your details: ");

    System.out.print("Enter your name: ");
    this.name = scan.nextLine();
  
  //this loop validates the input mobile number.

    while(true){
      System.out.print("Enter your PhoneNumber: ");
      this.phoneNumber = scan.nextLine();
      if (phoneNumber.matches("\\d{10}")){
        break;
      }
      else{
        System.out.println("Enter a valid input");
      }
    }

    System.out.print("Enter your Address: ");
    this.address = scan.nextLine();

    System.out.print("Enter your InitialDepositAmount: ");
    this.initialBalance = scan.nextDouble();

    int acNo = (int)(Math.random()*(699999999 - 600000000)+600000000);
    this.accountNumber = String.valueOf(acNo);

    int id = (int)(Math.random()*(2999 - 2000)+2000);
    this.customerId = String.valueOf(id);

    System.out.println(" ");

    System.out.println("Your account has been created successfully."+"\n"); 

    show();
  }

  public double deposit(double amount){
    this.initialBalance = initialBalance+amount;
    return initialBalance;
  }

  public double withdraw(double amount){
      this.initialBalance = initialBalance-amount;
      return initialBalance;
  }

  public void show(){
    System.out.println("Name: "+name);
    System.out.println("AccountNumber: "+accountNumber);
    System.out.println("CustomerId: "+customerId);
    System.out.println("PhoneNumber: "+phoneNumber);
    System.out.println("Address: "+address+"\n");
  }

  @Override
  public String toString(){
    return "Name: "+name +"\n"+
          "AccountNumber: "+ accountNumber+"\n"+
          "CustomerId: "+customerId+"\n"+
          "PhoneNumber: "+phoneNumber+"\n"+
          "Address: "+address +"\n";
  }

}
