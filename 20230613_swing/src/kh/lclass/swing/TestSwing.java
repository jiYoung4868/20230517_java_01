package kh.lclass.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestSwing extends JFrame{
	
	public TestSwing() {
		setTitle("Hello Window 프레임");
		setDefaultCloseOperation(EXIT_ON_CLOSE); //X버튼 눌렀을 때 resource 정리하고 창 닫는 역할
		
		Container contentPane = getContentPane();
//		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); //물 흐르듯이 하나씩 나타남(flowlayout), center(중앙정렬), 간격
//		contentPane.setLayout(new BorderLayout(20,30)); //간격
//		contentPane.add(new JButton("OK"), BorderLayout.NORTH); //북쪽정렬
//		contentPane.add(new JButton("Cancel"), BorderLayout.WEST);
//		contentPane.add(new JButton("Ignore"), BorderLayout.EAST);
//		contentPane.add(new JButton("Center"), BorderLayout.CENTER);

		JTextField txtName = new JTextField();
		JTextField txtMajor = new JTextField();
		JTextField txtNo = new JTextField();
		JTextField txtSubject = new JTextField();
		JButton btnSave = new JButton("저장");
		
		//event 등록 = Action 리스너 달기
		btnSave.addActionListener(new MyActionListener());
		txtName.addActionListener(new MyActionListener());
		
		contentPane.setLayout(new GridLayout(5,2,10,10));
		contentPane.add(new JLabel("이름"));
		contentPane.add(txtName);
		contentPane.add(new JLabel("학과"));
		contentPane.add(txtMajor);
		contentPane.add(new JLabel("학번"));
		contentPane.add(txtNo);
		contentPane.add(new JLabel("과목"));
		contentPane.add(txtSubject);
		contentPane.add(btnSave);

		setSize(300, 300);
		setVisible(true); //true넣으면 보여지게 하는 것, false 넣으면 안보이게 함. 보였다 안보였다 하게 해줌
	}
	public static void main(String[] args) {
		TestSwing frame = new TestSwing();
	}

}

class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		System.out.println("이건 언제 호출되는가");
		System.out.println(e);
		Object source = e.getSource();
		if(source instanceof JButton) {
			System.out.println("button 눌렀음");
			if(((JButton)source).getText().equals("저장")) {
			((JButton)source).setText("Save"); //버튼 누르면 save로 바뀜
			}else {
				((JButton)source).setText("저장");
			}
		}else if (source instanceof JTextField) {
			System.out.println("text 필드에서 enter-key 눌렀음");
		}
	}
}