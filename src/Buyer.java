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
			System.out.println("�ܾ� ����!"); 
			return;
		}
		
		money = money - p.price;
		bp = bp + p.bp;		
		
		System.out.println(p+"��(��) �����ϼ̽��ϴ�.");
		System.out.println("���� �ܾ�: "+ money + "��");
		Purchased.PurchasedKind(p);
		// ���������� ����ϴ� ���� p.toString();�� ����
	}
}
