package java2.day21_예외처리;

public class Account {

	private long balance;
	
	public Account() {}

//메소드-------------------------------------	
	public long getBalance() {
		return balance;}
	
	public void deposit(int money) {
		balance+=money;
		}
	
	public void wirhdraw (int money) throws 잔고부족예외 {
		if(this.balance<money) {
			//예금액이 부족하면 출금 금지.. // 예외가 발생하지 않지만 고의적으로 예외를 발생시키는!!
			throw new 잔고부족예외("잔고부족: "+(money-this.balance)+"만큼 부족");
		}
		this.balance -= money;
	
	}//f()


	
}//c
