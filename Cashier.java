package BankManager;

public class Cashier {

	private Client client;

	Cashier(){
		this.client = null;
	}

	public static void recive_client(Client client){
		this.client = client;
	}

	public static boolean meet_client(){

		switch (this.client.Operation) {

			case 1: 
				int value_changed =  this.client.answer_account() - this.client.OpValue;
				if (value_changed >= 0) {
					this.client.change_account(value_changed);
					this.client.change_wallet(this.client.answer_account() + value_changed);
				}
				else return false;
				break;

			case 2:
				int value_changed =  this.client.answer_wallet() - this.client.OpValue;
				if (value_changed >= 0) {
					this.client.change_wallet((value_changed);
					this.client.change_account(this.client.answer_wallet() + value_changed);
				}
				else return false;
				break;

			default: return false;
			return true;
		}
	}
}