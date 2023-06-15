package kh.lclass.chat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 347748170880267162L;
	private JTextArea jta = new JTextArea(40, 25);
	private JTextField jtf = new JTextField(25);

	private String nickName;

	private ClientBackground cb = new ClientBackground(); // 채팅 socket기능을 담당할 객체

	public ClientGUI(String nickName) {
		this.nickName = nickName;

		// 생성자에서는 초기화(즉 화면 초기화)
		setBounds(200, 100, 400, 600);
		setTitle(nickName + "님 창");

		jta.setEditable(false);
		jta.setFont(new Font("맑은고딕", Font.PLAIN, 18));
		jta.setBackground(new Color(200, 150, 230));

		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		cb.setNickname(nickName);
		cb.setGui(this);
		cb.connection();
	}

	// TODO 새 메시지를 받았을때 메소드 호출됨
	public void appendMsg(String msg) {
		jta.append(msg);
		jta.append("\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = jtf.getText();
		System.out.println(msg + "\n");
		jtf.setText("");
		cb.sendMessage(msg);
	}
}
