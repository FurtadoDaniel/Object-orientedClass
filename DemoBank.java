//Alunos:Barbara Drummond e Daniel Furtado


import java.util.ArrayList;

class Client {

	public int Operation;// 1-withdrawal, 2-depost
	public int OpValue;
	private double Wallet;
	private int Account;

	Client(int Operation, int OpValue, double Wallet, int Account) {

		this.Operation = Operation;
		this.OpValue = OpValue;
		this.Wallet = Wallet;
		this.Account = Account;


	}

	public int answer_account() {
		return this.Account;
	}

	public double answer_wallet() {
		return this.Wallet;
	}

	public void change_account(int NewValue) {
		this.Account = NewValue;
	}	

	public void change_wallet(int NewValue) {
		this.Wallet = NewValue;
	}
}

class Cashier {

	//return true if tansection succeed ou false if not
	public boolean meet_client ( Client client ) {

		switch (client.Operation )  {

			case 1: // 1-withdrawal
				int value_changed = client.answer_account() - client.OpValue;
				if (value_changed >= 0) {
					client.change_account(value_changed);
					client.change_wallet( (int) client.answer_wallet() + client.OpValue);
				}
				else return false;
				break;

			case 2: // 1-deposit
				value_changed = (int) client.answer_wallet() - client.OpValue;
				if (value_changed >= 0) {
					client.change_wallet(value_changed);
					client.change_account(client.answer_account() + client.OpValue);
				}
				else return false;
				break;

			default: return false;
		}
		return true;
	}
}

class Bank {


	//clients lists
	private ArrayList<Client> priority_list;
	private ArrayList<Client> normal_list;

	private Cashier cashier1;//priotiry cashier
	private Cashier cashier2;//normal cashier

	Bank () {

		this.priority_list = new ArrayList<Client>();
		this.normal_list = new ArrayList<Client>();

		this.cashier1 = new Cashier();
		this.cashier2 = new Cashier();
	}

	//fill the clients list
	public void recive_client (boolean priority, int Operation, int OpValue, double Wallet, int Account) {
		if (priority) this.priority_list.add( new Client (Operation, OpValue, Wallet, Account) );
		else this.normal_list.add( new Client (Operation, OpValue, Wallet, Account) );		
	}

	public void meet_clients () {
		while ( ! (priority_list.isEmpty() && normal_list.isEmpty() ) ) {

			boolean success;
			Client NextClient;

			//check what list should take
			if ( ! priority_list.isEmpty() ) NextClient = priority_list.get(0);
			else NextClient = normal_list.get(0);


			success = cashier1.meet_client(NextClient);
			if (success) System.out.print ("Account: " + NextClient.answer_account() + "	Wallet:"+ NextClient.answer_wallet() +"\n");
			else System.out.print ("Failed\n");

			if ( ! priority_list.isEmpty() ) priority_list.remove(0);
			else normal_list.remove(0);

			//check if the list has a odd client number
			if ( ! (priority_list.isEmpty() && normal_list.isEmpty() ) ) {


				//check what list should take
				if ( normal_list.isEmpty() || priority_list.size() > 3) NextClient = priority_list.get(0);
				else NextClient = normal_list.get(0);

				success = cashier1.meet_client(NextClient);
				if (success) System.out.print ("Account: " + NextClient.answer_account() + "	Wallet:"+ NextClient.answer_wallet() +"\n");
				else System.out.print ("Failed\n");



				if ( normal_list.isEmpty() || priority_list.size() > 3) priority_list.remove(0);
				else normal_list.remove(0);
			}	
		}
	}
}

public class DemoBank {
	public static void main(String[] argumentos) {

		Bank bank = new Bank ();
		
		bank.recive_client (true, 1, 100, 0, 100);//primeiro resultado 0 100
		bank.recive_client (true, 1, 100, 0, 100);//segundo resultado 0 100
		bank.recive_client (true, 1, 100, 0, 100);//terceiro resultado 0 100
		bank.recive_client (true, 1, 100, 100, 0);//quinto resultado falha
		bank.recive_client (true, 2, 100, 100, 0);//setimo resultado 100 0
		bank.recive_client (false,2,   0,   0, 0);//quarto resultado 0 0
		bank.recive_client (false,1,   0,   0, 0);//sexto resultado 0 0
		bank.meet_clients ();
	}
}