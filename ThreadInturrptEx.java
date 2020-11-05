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
			//1�� ���� �ڵ� �ۼ�
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				return; //run �޼ҵ� ����
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
		//JLabel ���� �� ����
		JLabel tl=new JLabel();
		tl.setFont(new Font("���",Font.ITALIC,80));
		c.add(tl);
		//������ ����
		Thread th=new Thread(new TimerRunnable0(tl));
		//��ư ����
		JButton btn=new JButton("kill timer");
		//��ư �̺�Ʈ ���
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
		
		th.start(); //������ ����
	}

	public static void main(String[] args) {
		new ThreadInturrptEx();

	}

}
