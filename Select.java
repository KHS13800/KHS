package kr.inhatc.java.Project;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Select extends JFrame implements ActionListener{
	
	public static int STATE = 0;
	private JPanel Pan;
	private JLabel lblS1, lblS2, lblId, lblPw, lblConn;
	private JTextField tfId;
	private JPasswordField tfPw;
	private JButton btnLo;


	public Select() {
        setTitle("좌석선택");
    	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//이창만 끄기
    	setSize(300, 200);
    	setLocationRelativeTo(null);
    	 	
    	Pan = new JPanel();
    	Pan.setLayout(new GridLayout(3,2,3,3));
    	Pan.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));   
    	
    	lblId = new JLabel("ID:			", JLabel.LEFT);
    	Pan.add(lblId);
    	
    	tfId = new JTextField();
		Pan.add(tfId);
		
    	lblPw = new JLabel("Password:	", JLabel.LEFT);
    	Pan.add(lblPw);
    	
    	tfPw = new JPasswordField();
		Pan.add(tfPw);
		
    	lblConn = new JLabel("", JLabel.LEFT);
    	Pan.add(lblConn);
    	
		btnLo = new JButton("로그인");
		btnLo.addActionListener(this);
		Pan.add(btnLo);	
		
		add(Pan);
		
        setVisible(true);
    }
	

	public static void main(String[] args) {
		new Select();
	}


	@Override
	public void actionPerformed(ActionEvent e){
		if(tfId.getText().equals("admin") && tfPw.getText().equals("1234")) {
			SeatSet.lblLog2.setText("admin");
			STATE = 1;
			dispose();
		} else {
			lblConn.setForeground(Color.RED);
			lblConn.setText("Invalid user.. ");
		}
		
	}

}
