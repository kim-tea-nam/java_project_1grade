import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Shopping_Basket extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); //ȭ���� �ʺ�, ���� ������ screenSize�� ���� 
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
		
		setLocation(screenSize.width/2-(w/2), screenSize.height/2-(h/2));	// ������ ���� ��ġ
		setSize(w, h);	
		setIconImage(new ImageIcon("images/Shop_icon.png").getImage());	// ������ �̹��� ����
		setLayout(null);
		
		
		p1.setBounds(0, 30, 600, 300);
		p1.setBackground(Color.gray);
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		p2 = new Panel();
		p2.setBounds(290, 340, 25, 30);
		p2.setBackground(new Color(0,0,0));
		p2.setLayout(new FlowLayout());
		
		b1 = new Button("����");
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
						System.out.println("����");
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
		
		
		addWindowListener(new WindowAdapter() { // ������ �ݱ�(x��ư) �̺�Ʈ ó��
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	}
	
	void basket(Product p, int pkind, int money) {
		switch (pkind) {
			// ��ٱ��ϸ� ������ Shopping_Basket�� �߰���
			case 1:
				l1 = new Label(p.toString());
				l1.setFont(new Font("dialog", Font.BOLD, 20));
				p1.add(l1);
				try {
					pArray[pCount] = "c";
					System.out.println(p +" �߰��߽��ϴ�.");
					pCount++;
				} catch (Exception e) {
					System.out.println("�ִ� 10������ ���� �� �ֽ��ϴ�.");
				}
				break;
			case 2:
				l2 = new Label(p.toString());
				l2.setFont(new Font("dialog", Font.BOLD, 20));
				p1.add(l2);
				try {
					pArray[pCount] = "s";
					System.out.println(p +" �߰��߽��ϴ�.");
					pCount++;
				} catch (Exception e) {
					System.out.println("�ִ� 10������ ���� �� �ֽ��ϴ�.");
				}
				break;
			case 3:
				l3 = new Label(p.toString());
				l3.setFont(new Font("dialog", Font.BOLD, 20));
				p1.add(l3);
				try {
					pArray[pCount] = "n";
					System.out.println(p +" �߰��߽��ϴ�.");
					pCount++;
				} catch (Exception e) {
					System.out.println("�ִ� 10������ ���� �� �ֽ��ϴ�.");
				}
				break;
		}
	}
}
