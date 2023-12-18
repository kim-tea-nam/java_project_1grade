import java.awt.*;
import java.awt.event.*;


public class Dev extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); //화면의 너비, 높이 정보를 screenSize에 대입 
	Image img;
	int w = 510,h = 700;
	TextArea t;
	String text = "202010054/김태남입니다. 이번 쇼핑몰을 만든 개발자입니다.";
	
	Dev(String title) {
		super(title);
		
		setLocation(screenSize.width/2-(w/2), screenSize.height/2-(h/2));
		setSize(w, h);
		setLayout(null);
		
		img = tk.getImage("images/Dev.jpg");
		
		t = new TextArea(text,0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		t.setBounds(10, 560, w, 100);
		t.setEditable(false);
		t.setFont(new Font("Serif", Font.PLAIN, 20));
		
		addWindowListener(new WindowAdapter() { // 프레임 닫기(x버튼) 이벤트 처리
			public void windowClosing(WindowEvent e) {
				dispose();
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
		new Dev("개발자 소개");

	}

}
