package com.bankapp;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Bank {

  private List<Account>customers;
  Scanner scan = new Scanner(System.in);

  public Bank() {
    this.customers = new ArrayList<>();
  }

  public void addCustomer(Account customer){
    customers.add(customer);
  }

  public void removeCustomer(){
	  Account account = getAccount();
	  try {
		  if(account == null) {
			  throw new CustomerNotFoundException("Account not found");
		  }
		  customers.remove(account);
		  System.out.println("Account closed successfully");
	  }
	  catch(CustomerNotFoundException e) {
		  System.out.println(e.getMessage());
		  removeCustomer();
	  }
  }
  
  public Account getAccount() {
	  
	  System.out.print("Enter Account Number: ");
      String accNo = scan.nextLine();
	  for (Account account : customers) {
	        if (account.getAccountNumber().equals(accNo)){
	          return account;
	        }
	  }
	  return null;
  }
  
  public void cashDeposit() {
	  Account account = getAccount();
	  try {
		  if(account == null) {
			  throw new CustomerNotFoundException("Incorrect Account Number");
		  }
		  
		  System.out.print("Enter the amount: ");
		  int amount = scan.nextInt();
		  scan.nextLine(); // to consume leftover new line
		  
		  if(amount > 100) {
			  System.out.println(account.deposit(amount)+"\n");
		  }
		  else {
			  System.out.println("Amount should be atleast 100");			  
		  }
	  }
	  catch (CustomerNotFoundException e) {
		  System.out.println(e.getMessage());
		  cashDeposit();
	  }
  }
  
  public void cashWithdraw(){
	  Account account = getAccount();
	  try {
    	if(account == null) {
    		throw new CustomerNotFoundException("Incorrect Account Number");
    	}
    	System.out.print("Enter the amount: ");
    	int amount = scan.nextInt();
    	scan.nextLine(); // to consume leftover new line
    	
	    if (amount > account.getInitialBalance()){
	      System.out.println("Insuffiecient Balance"+"\n");
	    }
	    else{
	      System.out.println("Balance: " + account.withdraw(amount)+"\n");
	    }
    }
    catch(CustomerNotFoundException e){
    	System.out.println(e.getMessage());
    	cashWithdraw();
    }  
  }

  public void getBalance(){
	  Account account = getAccount();
	  try {
		  if(account == null) {
			  throw new CustomerNotFoundException("Incorrect account number");
		  }
		  System.out.println(account.getInitialBalance()+"\n");
	  }
	  catch(CustomerNotFoundException e) {
		  System.out.println(e.getMessage());
		  getBalance();
	  }
  }

  public void findCustomer(){
	  Account account = getAccount();
    try {
    	if(account == null) {
    		throw new CustomerNotFoundException("Customer not found.");    		
    	}
    	System.out.println(account);
    }
    catch (CustomerNotFoundException e) {
		System.out.println(e.getMessage());
		findCustomer();
	}
  
  }

  public void displayAllCustomers(){
    for (Account customer : customers) {
      System.out.println(customer);
    }
  }
}