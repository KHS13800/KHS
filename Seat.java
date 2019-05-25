package kr.inhatc.java.Project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

 
public class Seat extends JPanel implements MouseListener {
	
    private JPanel pan;

    private JLabel btn, Num;

	public Seat(int numSeat) {
        setLayout(null);
 

        pan = new JPanel();
        pan.setBounds(0,0,1600,900);
        pan.setLayout(null);
        pan.setOpaque(false);
        
        
        
        int Number = numSeat + 1;
        
        Num = new JLabel(Number+"번");
        Num.setBackground(Color.ORANGE);
        Num.setOpaque(true);
        Num.setBounds(0, 0, 79, 19);
        
        
        
        
        btn = new JLabel("빈자리");
		btn.setBackground(Color.WHITE);
    	btn.setOpaque(true);
        btn.setBounds(0, 19, 79, 59);
    	btn.addMouseListener(this);
        
    	
        
    	pan.add(Num);
        pan.add(btn);
        add(pan);
        
         
        setVisible(true);
        setOpaque(false);
        setFocusable(true);
		pan.requestFocus();
    }
 
    public static void main(String[] args) {
        JFrame frameTest = new JFrame();
//        frameTest.setTitle("시트패널");
//        frameTest.add(new SeatButton(1));
//        frameTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frameTest.setSize(99, 144);
//        frameTest.setVisible(true);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (Select.STATE == 1) {	//로그인상태 STATE==1
			if(btn.getText().equals("빈자리")) {	//빈자리라면
				int result = JOptionPane.showConfirmDialog(null, " 번 자리를 사용하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {}	//닫기 X
				else if(result == JOptionPane.YES_OPTION) {	//YES
					btn.setText("admin 사용중");
					SeatSet.lblLog2.setText("OOO");
					Select.STATE = 0;
				}
				else {}	//NO
			}
			else {	//빈자리가아니라면
				JOptionPane.showMessageDialog(null, "다른 자리를 선택해주십시오.", "caution", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else {	//비로그인상태 STATE==0
			if(btn.getText().equals("빈자리")) {	//빈자리라면
				JOptionPane.showMessageDialog(null, "로그인이 필요합니다.", "caution", JOptionPane.ERROR_MESSAGE);
			}
			else {	//빈자리가아니라면
				String Logout = JOptionPane.showInputDialog("로그아웃을 위해 비밀번호를 입력해주세요.");
				if(Logout!=null) {	//null오류해결
					if(Logout.equals("1234")) {	//맞으면
						btn.setText("빈자리");
					}
					else {	//틀리면
						JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.", "caution", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == btn)
			btn.setBackground(Color.YELLOW);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == btn)
			btn.setBackground(Color.WHITE);
	}
	
}










