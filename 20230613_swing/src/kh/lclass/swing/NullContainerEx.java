package kh.lclass.swing;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NullContainerEx extends JFrame {
	public NullContainerEx() {
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(130, 50);
		la.setSize(200, 20);
		c.add(la);
		
		for(int i=1; i<=9; i++) {
			JButton b= new JButton(Integer.toString(i)); //버튼 생성 (버튼 이름)
			b.setLocation(i*15,i*15); //부착위치(시작위치 기준)
			b.setSize(50,20);
			c.add(b); //버튼을 컨텐트팬에 부착
		}
		setSize(300,200);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new NullContainerEx();
	}

}
