package BankManager;


public class DemoBank {

	public static void main(String[] argumentos) {

		Bank bank = new Bank ();
		
		bank.recive_client (1, 1, 100, 0, 100);
		bank.recive_client (1, 2, 100, 0, 100);
		bank.recive_client (1, 1, 100, 100, 0);
		bank.recive_client (1, 2, 100, 100, 0);
		bank.recive_client (0, 1,   0,   0, 0);
		bank.recive_client (0, 1,   0,   0, 0);
		bank.meet_clients ();
	}
}