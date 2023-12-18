import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Purchased extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); //ȭ���� �ʺ�, ���� ������ screenSize�� ����
	int w = 300,h = 600;
	static int pcCound = 0;
	Panel p;
	Label lc;
	static Panel p1 = new Panel();
	static Label lp;
	
	Purchased(String title) {
		super(title);
		
		setLocation(screenSize.width/2-(w/2), screenSize.height/2-(h/2));
		setSize(w, h);
		setIconImage(new ImageIcon("images/Shop_icon.png").getImage());	// ������ �̹��� ����
		setLayout(null);
		
		p = new Panel();
		p.setLayout(new GridLayout(pcCound,1));
		p.setBounds(8, 30, 70, h-30);
		p.setBackground(new Color(99,234,237));
		for(int i = 0; i< pcCound; ++i) {
			lc = new Label(String.valueOf(i+1) + "��");
			lc.setFont(new Font("serif", Font.BOLD, 20));
			p.add(lc);
		}
		
		p1.setLayout(new GridLayout(pcCound,1));
		p1.setBounds(78, 30, w-78, h-30);
		p1.setBackground(new Color(192,192,192));
		
		
		
		addWindowListener(new WindowAdapter() { // ������ �ݱ�(x��ư) �̺�Ʈ ó��
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		add(p); add(p1);
		
		setVisible(true);
	}
	
	static void PurchasedKind(Product p) {
		pcCound++;
		
		lp = new Label(p.toString());
		lp.setFont(new Font("serif", Font.BOLD, 20));
		p1.add(lp);
		
		p1.revalidate();
		p1.repaint();
		
	}
}
