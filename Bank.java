package BankManager;

import java.util.Scanner;

public class Bank {

	private ArrayList<Client> priority_list;
	private ArrayList<Client> normal_list;

	private Cashier cashier1;
	private Cashier cashier2;

	BankManager(){

		this.priority_list = new ArrayList<Client>();
		this,normal_list = new ArrayList<Client>();

		this.cashier1 = new Cashier();
		this.cashier2 = new Cashier();
	}
}