import java.awt.*;
import java.awt.event.*;


public class Help extends Frame{
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); //화면의 너비, 높이 정보를 screenSize에 대입 
	Image img;
	int w = 520,h = 700;
	TextArea t;
	String text = " 이 프로그램은 쇼핑몰 입니다. 쇼핑몰에서 물건을 구입할 수 있습니다. 장바구니에서 담은 물건을 구입할 수 있습니다.구매내역은 지금까지 구매한 내역을 볼 수 있습니다.감사합니디.";
	Help(String title) {
		super(title);
		
		setLocation(screenSize.width/2-(w/2), screenSize.height/2-(h/2));
		setSize(w, h);
		setLayout(null);
		img = tk.getImage("images/Shop_icon.png");
		
		t = new TextArea(text,0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		t.setBounds(10, 560, w, 100);
		t.setEditable(false);
		t.setFont(new Font("Serif", Font.PLAIN, 20));
		addWindowListener(new WindowAdapter() { // 프레임 닫기(x버튼) 이벤트 처리
			public void windowClosing(WindowEvent e) {
				dispose(); // 메모리에서 삭제0
			}
		});
		
		add(t);
		
		setVisible(true);
	}
	
	// paint() 호출 시점 3가지
	// 1. 화면이 처음 보여주는 순간 
	// 2. 화면이 다른 화면에 가려졌다 다시 보여주는 순간
	// 3. 최소화에서 다시 화면에 보여지는 순간
	
	public void paint(Graphics g) {
		g.drawImage(img, 0, 30, this);
		
	}
	
	public static void main(String[] args) {
		new Help("Help");
	
	}
}
