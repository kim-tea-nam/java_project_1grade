import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MenuStart extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); //화면의 너비, 높이 정보를 screenSize에 대입 
	Image img;
	int w = 624,h = 480;
	
	MenuStart(String title) {
		super(title);
		
		setLocation(screenSize.width/2-(w/2), screenSize.height/2-(h/2));	// 프레임 시작 위치
		setSize(w, h);		// 프레임 너비, 높이
		setIconImage(new ImageIcon("images/Shop_icon.png").getImage());	// 아이콘 이미지 설정
		
		img = tk.getImage("images/bg.jpg");
		
		MenuBar mb = new MenuBar();
		
		Menu mFile = new Menu("File");
		MenuItem miJoin = new MenuItem("Join", new MenuShortcut('J',true));
		MenuItem miExit = new MenuItem("Exit", new MenuShortcut('E'));
		//Exit 누르면 꺼짐
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// mFile에 miJoin, miExit 붙이기
		mFile.add(miJoin); mFile.addSeparator(); mFile.add(miExit);
		
		Menu mEvent1 = new Menu("Event");
		MenuItem miShop = new MenuItem("쇼핑몰");
		miShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Shop("TN_Store");
			}
		});
		
		MenuItem miBasket = new MenuItem("장바구니");
		miBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Shopping_Basket("장바구니");
			}
		});
		MenuItem miPurchased = new MenuItem("구매 내역");
		miPurchased.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Purchased("구매 내역");
			}
		});
		
		mEvent1.add(miShop); mEvent1.add(miBasket); 
		mEvent1.addSeparator();mEvent1.add(miPurchased);
		
		
		Menu mHelp = new Menu("Help");
		MenuItem miHelp = new MenuItem("프로그램 설명");
		miHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help("프로그램 설명");
			}
		});
		MenuItem miDev = new MenuItem("개발자 소개");
		
		miDev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dev("개발자 소개");
			}
		});
		
		
		
		// mHelp에 miHelp, miDev 붙이기
		mHelp.add(miHelp); mHelp.add(miDev);
		
		// 메뉴바에 메뉴 붙이기
		mb.add(mFile); mb.add(mEvent1); mb.add(mHelp);
		
			
		
		addWindowListener(new WindowAdapter() { // 프레임 닫기(x버튼) 이벤트 처리
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setMenuBar(mb);
		
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, 0, 30, this);
	}
	
	public static void main(String[] args) {
		new MenuStart("TN_쇼핑몰");
		
	}

}
