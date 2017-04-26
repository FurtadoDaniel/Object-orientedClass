public class Cashier {

	public static boolean meet_client ( Client client ) {

		switch (client.Operation )  {

			case 1: 
				int value_changed =  client.answer_account() - client.OpValue;
				if (value_changed >= 0) {
					client.change_account(value_changed);
					client.change_wallet(client.answer_account() + value_changed);
				}
				else return false;
				break;

			case 2:
				value_changed =  client.answer_wallet() - client.OpValue;
				if (value_changed >= 0) {
					client.change_wallet(value_changed);
					client.change_account(client.answer_wallet() + value_changed);
				}
				else return false;
				break;

			default: return false;
		}
		return true;
	}
}