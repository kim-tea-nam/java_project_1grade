import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Shop extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); //ȭ���� �ʺ�, ���� ������ screenSize�� ���� 
	
	Label name, l1, lca, lp, lbp; 
	Panel p1, pif, p2, p3;
	TextField tf, tca, tbp, tp;
	Button gt, bm, bbp, b1, b2, b3, bb, bc, left, right;
	
	static Buyer by1 = new Buyer();
	Shopping_Basket sb = new Shopping_Basket();
	
	Computer c = new Computer();
	Switch s = new Switch();
	Nintendo n = new Nintendo();;
	final CardLayout Card = new CardLayout();
	
	int pkind;
	int w = 500,h = 800;
	
	Shop(String title) {
		super(title);
		
		setLocation(screenSize.width/2-(w/2), screenSize.height/2-(h/2));	// ������ ���� ��ġ
		setSize(w, h);
		setLayout(null);
		setIconImage(new ImageIcon("images/Shop_icon.png").getImage());	// ������ �̹��� ����
		
		// Store name
		name = new Label("TN_Store");
		name.setBounds(205, 50, 100, 50);
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//���� ������ �Է� panel
		p1= new Panel();
		p1.setBounds(30, 100, 440, 50);
		p1.setBackground(Color.yellow);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		l1 = new Label("MONEY :");
		tf = new TextField("���� �����ϰ� �ִ� �ݾ�",17);
		tf.selectAll();
		
		gt = new Button("�Է�");
		gt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = tf.getText();
				try {
                    int integerValue = Integer.parseInt(text);
                    // ���� ���� �ֿܼ� ��� (�Ǵ� �ʿ信 ���� �ٸ� ���� ����)
                    by1.money = by1.money + integerValue;
                    System.out.println("MONEY: " + by1.money +"��");
                } catch (NumberFormatException ex) {
                    // ������ ��ȯ�� �� ���� ��� ���� ó��
                    System.err.println("���� �Է��ϼ���.!!!");
                }
			}
		});
		p1.add(l1); p1.add(tf); p1.add(gt);
		
		
		//���� ���� �ݾ� and ���� ����Ʈ ��ư �����
		pif = new Panel();
		pif.setBounds(30, 150, 440, 70);
		pif.setBackground(Color.GRAY);
		pif.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//���� ���� �ݾ�(ca)
		lca = new Label("���� �ݾ�:");
		tca = new TextField("���� ���� �ݾ�",9);
		tca.setEditable(false);
		
		bm = new Button("����");
		bm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//by1.money = Shopping_Basket.by1.money;
					String tempString = "";
					tca.setText(tempString.valueOf(by1.money) + "��");	
	            } catch (NullPointerException ex) {
	                System.err.println("���� �Է��ϼ���.");
	            }
			}
		});
		
		//���� ����Ʈ ��ư(bp) �����
		lbp = new Label("���� ����Ʈ:");
		tbp = new TextField("���� ����Ʈ",7);
		tbp.setEditable(false);
		
		bbp = new Button("�Է�");
		bbp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tempString = "";
					tbp.setText(tempString.valueOf(by1.bp));
                } catch (NullPointerException ex) {
                    System.err.println("����Ʈ ����");
                }
			}
		});
		
		// ��ǰ ǥ�ö�
		lp = new Label("��ǰ:");
		tp = new TextField("� ���� �����Ͻðڽ��ϱ�?",35);
		tp.setEditable(false);
		
//////////////////////////////////////////////////////////////////////////////////////
		
		// ��ǰ �����ִ� panel 
		
		p2 = new Panel();
		p2.setBounds(30, 220, 440, 500);
		p2.setBackground(new Color(9,119,247));
		p2.setLayout(Card);
		
		// ��ǰ ���� ��ư
		b1 = new Button("Computer");
		b1.setBackground(new Color(0,255,255));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tp.setText(b1.getLabel() + "��(��) �����Ͻðڽ��ϱ�?" + "(" + c.price + "��)");
				pkind = 1;
			}
		});
		b2 = new Button("Switch");
		b2.setBackground(new Color(0,255,255));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tp.setText(b2.getLabel() + "��(��) �����Ͻðڽ��ϱ�?" + "(" + s.price + "��)");
				pkind = 2;
			}
		});
		b3 = new Button("Nintendo");
		b3.setBackground(new Color(0,255,255));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tp.setText(b3.getLabel() + "��(��) �����Ͻðڽ��ϱ�?" + "(" + n.price + "��)");
				pkind = 3;
			}
		});
		
		bb = new Button("����");
		bb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���Ÿ� ������ �� �� by1�ӴϿ� ��ǰ �����̶� ���ϰ� ������ �� 
				// ������ ���ż��� ������ ���Ž��� ���� �ܾ� :
				switch (pkind) {
					case 1:
						try {by1.buy(c);} 
						catch (NullPointerException e2) {System.out.println("���� �Է��ϼ���.");}
						break;
					case 2:
						try {by1.buy(s);} 
						catch (NullPointerException e2) {System.out.println("���� �Է��ϼ���.");}
						break;
					case 3:
						try {by1.buy(n);} 
						catch (NullPointerException e2) {System.out.println("���� �Է��ϼ���.");}
						break;
					default:
						tp.setText("��ǰ�� �����ϼ���.");
						break;
				}
			}
		});
		
		bc = new Button("��ٱ���");
		bc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (pkind) {
					// ��ٱ��ϸ� ������ Shopping_Basket�� �߰���
					case 1:
						sb.basket(c,pkind, by1.money);
						tp.setText("��ǰ�� �߰��߽��ϴ�.");
						break;
					case 2:
						sb.basket(s,pkind, by1.money);
						tp.setText("��ǰ�� �߰��߽��ϴ�.");
						break;
					case 3:
						sb.basket(n,pkind, by1.money);
						tp.setText("��ǰ�� �߰��߽��ϴ�.");
						break;
					default:
						tp.setText("��ǰ�� �����ϼ���.");
						break;
				}
			}
		});
		
		pif.add(lca); pif.add(tca); pif.add(bm);
		pif.add(lbp); pif.add(tbp); pif.add(bbp); 
		pif.add(lp); pif.add(tp); pif.add(bb); pif.add(bc);
		
		p2.add(b1); p2.add(b2); p2.add(b3);
		
		p3 =new Panel();
		p3.setBounds(200, 730, 100, 30);
		p3.setBackground(new Color(0,119,247));
		p3.setLayout(new FlowLayout());
		
		left = new Button("����");
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.previous(p2);
			}
		});
		right = new Button("������");
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.next(p2);
			}
		});
		
		p3.add(left); p3.add(right);
		
		add(name); add(p1); add(pif); add(p2); add(p3);
		
		// ������ �ݱ�(x��ư) �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	}
}
