import java.util.ArrayList;


public class Bank {

	private ArrayList<Client> priority_list;
	private ArrayList<Client> normal_list;

	private Cashier cashier1;
	private Cashier cashier2;

	Bank () {

		this.priority_list = new ArrayList<Client>();
		this.normal_list = new ArrayList<Client>();

		this.cashier1 = new Cashier();
		this.cashier2 = new Cashier();
	}

	public void recive_client (boolean priority, int Operation, int OpValue, int Wallet, int Account) {
		if (priority) this.priority_list.add( new Client (Operation, OpValue, Wallet, Account) );
		else this.normal_list.add( new Client (Operation, OpValue, Wallet, Account) );
	}

	public void meet_clients () {
		while ( ! (priority_list.isEmpty() && normal_list.isEmpty() ) ) {

			boolean success;
			Client NextClient;

			if ( ! priority_list.isEmpty() ) NextClient (priority_list.get(0));
			else NextClient = normal_list.get(0);

			success = cashier1.meet_client(NextClient);
			if (success) System.out.print ("Account: " + NextClient.answer_account() + "	Wallet:"+ NextClient.answer_wallet() +"\n");
			else System.out.print ("Failed");

			NextClient.remove();

			if ( normal_list.isEmpty() || priority_list.size() > 3) NextClient (priority_list.get(0));
			else NextClient = normal_list.get(0);

			success = cashier1.meet_client(NextClient);
			if (success) System.out.print ("Account: " + NextClient.answer_account() + "	Wallet:"+ NextClient.answer_wallet() +"\n");
			else System.out.print ("Failed");

			NextClient.remove();

		}
	}
}