package ch13;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TimerRunnable0 implements Runnable{
	private JLabel timerLabel;
	public TimerRunnable0(JLabel l) {
		timerLabel=l;
	}
	public void run() {
		int n=0;
		while(true) {
			timerLabel.setText(n+"");  //Integer.toString
			n++;
			//1초 쉬는 코드 작성
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				return; //run 메소드 종료
			}
		}
	}
}
public class ThreadInturrptEx extends JFrame{
	public ThreadInturrptEx() {
		setTitle("Thread Interrpt Ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		//JLabel 생성 및 설정
		JLabel tl=new JLabel();
		tl.setFont(new Font("고딕",Font.ITALIC,80));
		c.add(tl);
		//스레드 생성
		Thread th=new Thread(new TimerRunnable0(tl));
		//버튼 생성
		JButton btn=new JButton("kill timer");
		//버튼 이벤트 등록
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				th.interrupt();
				btn.setEnabled(false); //JButton b=(JButton)e.getSource(); b.setEnabled(false);
			}
		});
		c.add(tl); c.add(btn);
		setSize(300,200);
		setVisible(true);
		
		th.start(); //스레드 시작
	}

	public static void main(String[] args) {
		new ThreadInturrptEx();

	}

}
