package kr.inhatc.java.Project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import kr.inhatc.java.db.DB_Conn;

public class SeatSet extends JFrame implements ActionListener {
    
    public JPanel contentPane;
	private ImageIcon back;
    private JButton Login;
    private Seat[] seat;
	private JLabel lblLog1;
	public static JLabel lblLog2;
    
    public SeatSet() {
        
        setTitle("좌석배치");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1650, 950);
        //setResizeable(false);
        
        Back();	//배경

        Else();	//그외
        
        Seats();	//좌석

        
        
        setVisible(true);
    }

	public static void main(String[] args) {
		new SeatSet();
	}
	
	public void Back() {
		back = new ImageIcon("img\\back1.png");
        contentPane = new JPanel(){
            public void paintComponent(Graphics g) {
            	g.drawImage(back.getImage(), 0, 0, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        };
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("좌석배치도");	//제목
        label.setForeground(Color.BLACK);
        label.setFont(new Font("굴림", Font.PLAIN, 50));
        label.setBounds(100, 50, 500, 50);
        contentPane.add(label);
	}

	public void Else() {
		Login = new JButton("로그인");
		Login.setBounds(500, 100, 100, 50);
		Login.addActionListener(this);
		contentPane.add(Login);
		
		lblLog1 = new JLabel("사용자 : ");
		lblLog1.setBounds(700,100,100,50);
		contentPane.add(lblLog1);
		lblLog2 = new JLabel("OOO");
		lblLog2.setBounds(800,100,100,50);
		contentPane.add(lblLog2);
	}
	
	public void Seats() {
        seat = new Seat[40];
        int posX = 20, posY = 300;

        for (int Num = 0; Num < 20; Num++) {
        	seat[Num] = new Seat(Num);
            if (Num % 5 == 0 && Num != 0) {
                posX = 20;
                posY += 190;
            }
            if (Num % 10 == 0 && Num != 0) {
                posY -= 80;
            }
            seat[Num].setBounds(posX, posY, 79, 79);
            contentPane.add(seat[Num]);   
            posX += 135;
        }

        posX = 950;
        posY = 300;
        for (int Num = 0; Num < 20; Num++) {
        	seat[Num+20] = new Seat(Num+20);
            if (Num % 5 == 0 && Num != 0) {
                posX = 950;
                posY += 190;
            }
            if (Num % 10 == 0 && Num != 0) {
                posY -= 80;
            }
            seat[Num+20].setBounds(posX, posY, 79, 79);
            contentPane.add(seat[Num+20]);   
            posX += 135;
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		new Select();
	}
	
}