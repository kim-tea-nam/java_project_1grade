import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Shopping_Basket extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); //화면의 너비, 높이 정보를 screenSize에 대입 
	int w = 600,h = 400;
	static Panel p1 = new Panel();;
	Panel p2;
	Button b1;
	Label l1, l2, l3;
	
	//static Buyer by1 = new Buyer();
	Computer c = new Computer();
	Switch s = new Switch();
	Nintendo n = new Nintendo();
	
	static String pArray[] = new String[10];
	static int pCount;
	
	Shopping_Basket() {
		
	}
	
	Shopping_Basket(String title) {
		super(title);
		
		setLocation(screenSize.width/2-(w/2), screenSize.height/2-(h/2));	// 프레임 시작 위치
		setSize(w, h);	
		setIconImage(new ImageIcon("images/Shop_icon.png").getImage());	// 아이콘 이미지 설정
		setLayout(null);
		
		
		p1.setBounds(0, 30, 600, 300);
		p1.setBackground(Color.gray);
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		p2 = new Panel();
		p2.setBounds(290, 340, 25, 30);
		p2.setBackground(new Color(0,0,0));
		p2.setLayout(new FlowLayout());
		
		b1 = new Button("구매");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i<pCount;++i) {
					if (pArray[i] == "c") {
						Shop.by1.buy(c);
					} else if (pArray[i] == "s") {
						Shop.by1.buy(s);
					} else if (pArray[i] == "n") {
						Shop.by1.buy(n);
					} else {
						System.out.println("없음");
					}
				}
				
				for(int i = 0; i<pCount;++i) {
					pArray[i]= ""; 
				}
				pCount = 0;
				p1.removeAll();
			}
		});
		
		p2.add(b1);
		
		
		
		add(p1); add(p2);
		
		
		addWindowListener(new WindowAdapter() { // 프레임 닫기(x버튼) 이벤트 처리
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	}
	
	void basket(Product p, int pkind, int money) {
		switch (pkind) {
			// 장바구니를 누르면 Shopping_Basket에 추가됨
			case 1:
				l1 = new Label(p.toString());
				l1.setFont(new Font("dialog", Font.BOLD, 20));
				p1.add(l1);
				try {
					pArray[pCount] = "c";
					System.out.println(p +" 추가했습니다.");
					pCount++;
				} catch (Exception e) {
					System.out.println("최대 10개까지 담을 수 있습니다.");
				}
				break;
			case 2:
				l2 = new Label(p.toString());
				l2.setFont(new Font("dialog", Font.BOLD, 20));
				p1.add(l2);
				try {
					pArray[pCount] = "s";
					System.out.println(p +" 추가했습니다.");
					pCount++;
				} catch (Exception e) {
					System.out.println("최대 10개까지 담을 수 있습니다.");
				}
				break;
			case 3:
				l3 = new Label(p.toString());
				l3.setFont(new Font("dialog", Font.BOLD, 20));
				p1.add(l3);
				try {
					pArray[pCount] = "n";
					System.out.println(p +" 추가했습니다.");
					pCount++;
				} catch (Exception e) {
					System.out.println("최대 10개까지 담을 수 있습니다.");
				}
				break;
		}
	}
}
