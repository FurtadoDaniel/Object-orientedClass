package BankManager;

public class Client {

	public int Operation;
	public int OpValue;
	private int Wallet;
	private int Account;

	Client(int Operation, int OpValue, int Wallet, int Account) {

		this.Operation = Operation;
		this.OpValue = OpValue;
		this.Wallet = Wallet;
		this.Account = Account;

	}

	public static void answer_account() {
		return this.Account;
	}

	public static void answer_wallet() {
		return this.Wallet;
	}

	public static void change_account(int NewValue) {
		this.Account = NewValue;
	}	

	public static void change_wallet(int NewValue) {
		this.Wallet = NewValue;
	}
}