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

	public int answer_account() {
		return this.Account;
	}

	public int answer_wallet() {
		return this.Wallet;
	}

	public void change_account(int NewValue) {
		this.Account = NewValue;
	}	

	public void change_wallet(int NewValue) {
		this.Wallet = NewValue;
	}
}