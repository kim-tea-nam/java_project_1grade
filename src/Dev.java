import java.awt.*;
import java.awt.event.*;


public class Dev extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); //ȭ���� �ʺ�, ���� ������ screenSize�� ���� 
	Image img;
	int w = 510,h = 700;
	TextArea t;
	String text = "202010054/���³��Դϴ�. �̹� ���θ��� ���� �������Դϴ�.";
	
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
		
		addWindowListener(new WindowAdapter() { // ������ �ݱ�(x��ư) �̺�Ʈ ó��
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		add(t);
		
		setVisible(true);
	}
	
	// paint() ȣ�� ���� 3����
	// 1. ȭ���� ó�� �����ִ� ���� 
	// 2. ȭ���� �ٸ� ȭ�鿡 �������� �ٽ� �����ִ� ����
	// 3. �ּ�ȭ���� �ٽ� ȭ�鿡 �������� ����
	
	public void paint(Graphics g) {
		g.drawImage(img, 0, 30, this);
	}
	
	public static void main(String[] args) {
		new Dev("������ �Ұ�");

	}

}
