import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MenuStart extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); //ȭ���� �ʺ�, ���� ������ screenSize�� ���� 
	Image img;
	int w = 624,h = 480;
	
	MenuStart(String title) {
		super(title);
		
		setLocation(screenSize.width/2-(w/2), screenSize.height/2-(h/2));	// ������ ���� ��ġ
		setSize(w, h);		// ������ �ʺ�, ����
		setIconImage(new ImageIcon("images/Shop_icon.png").getImage());	// ������ �̹��� ����
		
		img = tk.getImage("images/bg.jpg");
		
		MenuBar mb = new MenuBar();
		
		Menu mFile = new Menu("File");
		MenuItem miJoin = new MenuItem("Join", new MenuShortcut('J',true));
		MenuItem miExit = new MenuItem("Exit", new MenuShortcut('E'));
		//Exit ������ ����
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// mFile�� miJoin, miExit ���̱�
		mFile.add(miJoin); mFile.addSeparator(); mFile.add(miExit);
		
		Menu mEvent1 = new Menu("Event");
		MenuItem miShop = new MenuItem("���θ�");
		miShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Shop("TN_Store");
			}
		});
		
		MenuItem miBasket = new MenuItem("��ٱ���");
		miBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Shopping_Basket("��ٱ���");
			}
		});
		MenuItem miPurchased = new MenuItem("���� ����");
		miPurchased.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Purchased("���� ����");
			}
		});
		
		mEvent1.add(miShop); mEvent1.add(miBasket); 
		mEvent1.addSeparator();mEvent1.add(miPurchased);
		
		
		Menu mHelp = new Menu("Help");
		MenuItem miHelp = new MenuItem("���α׷� ����");
		miHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help("���α׷� ����");
			}
		});
		MenuItem miDev = new MenuItem("������ �Ұ�");
		
		miDev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dev("������ �Ұ�");
			}
		});
		
		
		
		// mHelp�� miHelp, miDev ���̱�
		mHelp.add(miHelp); mHelp.add(miDev);
		
		// �޴��ٿ� �޴� ���̱�
		mb.add(mFile); mb.add(mEvent1); mb.add(mHelp);
		
			
		
		addWindowListener(new WindowAdapter() { // ������ �ݱ�(x��ư) �̺�Ʈ ó��
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
		new MenuStart("TN_���θ�");
		
	}

}
