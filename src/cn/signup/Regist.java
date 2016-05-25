package cn.signup;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Regist extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textPassword;
	private JTextField textemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regist frame = new Regist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Regist() {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel userName = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		JLabel userPassword = new JLabel("\u5BC6\u7801\uFF1A");
		
		JLabel email = new JLabel("\u90AE\u7BB1:");
		
		textName = new JTextField();
		textName.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		
		textemail = new JTextField();
		textemail.setColumns(10);
		
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users user = new Users(textName.getText(),textPassword.getText(),textemail.getText());
				boolean tp = true;
				for(Users users2 : MainFrame.users){
					if (users2.name.equals(textName.getText())) {
						JOptionPane.showMessageDialog(submit, "该用户已存在！");
						tp = false;
					}
				}
//				if (it.hasNext()) {
//					if (it.next().name.equals(textName.getText())) {
//						tp = false;
//						JOptionPane.showMessageDialog(submit, "该用户已存在！");
//					}
//				}
				if (tp) {
					MainFrame.users.add(user);
					JOptionPane.showMessageDialog(submit, "注册成功！");
					dispose();
				}
//				if (MainFrame.users.contains(user)) {
//					JOptionPane.showMessageDialog(submit, "该用户已存在！");
//				}else {
//				}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(userName)
						.addComponent(userPassword)
						.addComponent(email))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(submit)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textemail)
							.addComponent(textPassword)
							.addComponent(textName, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
					.addContainerGap(152, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userName)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userPassword)
						.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(email)
						.addComponent(textemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(submit)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
