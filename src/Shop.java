import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Shop extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); //화면의 너비, 높이 정보를 screenSize에 대입 
	
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
		
		setLocation(screenSize.width/2-(w/2), screenSize.height/2-(h/2));	// 프레임 시작 위치
		setSize(w, h);
		setLayout(null);
		setIconImage(new ImageIcon("images/Shop_icon.png").getImage());	// 아이콘 이미지 설정
		
		// Store name
		name = new Label("TN_Store");
		name.setBounds(205, 50, 100, 50);
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//현재 소지금 입력 panel
		p1= new Panel();
		p1.setBounds(30, 100, 440, 50);
		p1.setBackground(Color.yellow);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		l1 = new Label("MONEY :");
		tf = new TextField("현재 소지하고 있는 금액",17);
		tf.selectAll();
		
		gt = new Button("입력");
		gt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = tf.getText();
				try {
                    int integerValue = Integer.parseInt(text);
                    // 정수 값을 콘솔에 출력 (또는 필요에 따라 다른 동작 수행)
                    by1.money = by1.money + integerValue;
                    System.out.println("MONEY: " + by1.money +"원");
                } catch (NumberFormatException ex) {
                    // 정수로 변환할 수 없는 경우 예외 처리
                    System.err.println("돈을 입력하세요.!!!");
                }
			}
		});
		p1.add(l1); p1.add(tf); p1.add(gt);
		
		
		//현재 남은 금액 and 현재 포인트 버튼 만들기
		pif = new Panel();
		pif.setBounds(30, 150, 440, 70);
		pif.setBackground(Color.GRAY);
		pif.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//현재 남은 금액(ca)
		lca = new Label("현재 금액:");
		tca = new TextField("현재 남은 금액",9);
		tca.setEditable(false);
		
		bm = new Button("갱신");
		bm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//by1.money = Shopping_Basket.by1.money;
					String tempString = "";
					tca.setText(tempString.valueOf(by1.money) + "원");	
	            } catch (NullPointerException ex) {
	                System.err.println("돈을 입력하세요.");
	            }
			}
		});
		
		//현재 포인트 버튼(bp) 만들기
		lbp = new Label("현재 포인트:");
		tbp = new TextField("현재 포인트",7);
		tbp.setEditable(false);
		
		bbp = new Button("입력");
		bbp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tempString = "";
					tbp.setText(tempString.valueOf(by1.bp));
                } catch (NullPointerException ex) {
                    System.err.println("포인트 없음");
                }
			}
		});
		
		// 제품 표시란
		lp = new Label("제품:");
		tp = new TextField("어떤 것을 구매하시겠습니까?",35);
		tp.setEditable(false);
		
//////////////////////////////////////////////////////////////////////////////////////
		
		// 제품 보여주는 panel 
		
		p2 = new Panel();
		p2.setBounds(30, 220, 440, 500);
		p2.setBackground(new Color(9,119,247));
		p2.setLayout(Card);
		
		// 제품 구매 버튼
		b1 = new Button("Computer");
		b1.setBackground(new Color(0,255,255));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tp.setText(b1.getLabel() + "를(을) 구매하시겠습니까?" + "(" + c.price + "원)");
				pkind = 1;
			}
		});
		b2 = new Button("Switch");
		b2.setBackground(new Color(0,255,255));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tp.setText(b2.getLabel() + "를(을) 구매하시겠습니까?" + "(" + s.price + "원)");
				pkind = 2;
			}
		});
		b3 = new Button("Nintendo");
		b3.setBackground(new Color(0,255,255));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tp.setText(b3.getLabel() + "를(을) 구매하시겠습니까?" + "(" + n.price + "원)");
				pkind = 3;
			}
		});
		
		bb = new Button("구매");
		bb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 구매를 눌렀을 때 비교 by1머니와 제품 가격이랑 비교하고 구매할 수 
				// 있으면 구매성공 없으면 구매실패 현재 잔액 :
				switch (pkind) {
					case 1:
						try {by1.buy(c);} 
						catch (NullPointerException e2) {System.out.println("돈을 입력하세요.");}
						break;
					case 2:
						try {by1.buy(s);} 
						catch (NullPointerException e2) {System.out.println("돈을 입력하세요.");}
						break;
					case 3:
						try {by1.buy(n);} 
						catch (NullPointerException e2) {System.out.println("돈을 입력하세요.");}
						break;
					default:
						tp.setText("제품을 선택하세요.");
						break;
				}
			}
		});
		
		bc = new Button("장바구니");
		bc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (pkind) {
					// 장바구니를 누르면 Shopping_Basket에 추가됨
					case 1:
						sb.basket(c,pkind, by1.money);
						tp.setText("제품을 추가했습니다.");
						break;
					case 2:
						sb.basket(s,pkind, by1.money);
						tp.setText("제품을 추가했습니다.");
						break;
					case 3:
						sb.basket(n,pkind, by1.money);
						tp.setText("제품을 추가했습니다.");
						break;
					default:
						tp.setText("제품을 선택하세요.");
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
		
		left = new Button("왼쪽");
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.previous(p2);
			}
		});
		right = new Button("오른쪽");
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.next(p2);
			}
		});
		
		p3.add(left); p3.add(right);
		
		add(name); add(p1); add(pif); add(p2); add(p3);
		
		// 프레임 닫기(x버튼) 이벤트 처리
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	}
}
