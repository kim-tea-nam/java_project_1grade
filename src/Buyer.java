public class Buyer {
	int money = 0;
	int bp = 0;
	Buyer() {
		
	}
	
	Buyer(int money) {
		this.money = this.money + money;
	}
	
	void buy(Product p) {	
		if (money < p.price) {
			System.out.println("잔액 부족!"); 
			return;
		}
		
		money = money - p.price;
		bp = bp + p.bp;		
		
		System.out.println(p+"를(을) 구입하셨습니다.");
		System.out.println("남은 잔액: "+ money + "원");
		Purchased.PurchasedKind(p);
		// 참조변수를 출력하는 것은 p.toString();와 같음
	}
}
