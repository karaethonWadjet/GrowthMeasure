package timestamps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TimeCapture extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrintWriter nub;
	private JTextArea wyrd = new JTextArea(4,20);
	private JTextField cheetos = new JTextField(20);
	private JTextField pepper = new JTextField(20);
	private Scanner boo;
	private Date line = null, nbc = null;

	public TimeCapture() {
		File soop = new File("chibbers.txt");
		try {
			nub = new PrintWriter(soop);
			boo = new Scanner(soop);
		} catch (FileNotFoundException e) {
			System.out.println("crap");
		}
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel one = new JLabel("Time One");
		JLabel two = new JLabel("Time Two");
		JFrame cupola = new JFrame("Time Captcha");
		JButton go = new JButton("Capture One");
		JButton po = new JButton("Capture Two");
		JButton blah = new JButton("Don't press this");
		go.setActionCommand("go");
		blah.setActionCommand("blah");
		blah.addActionListener(this);
		go.addActionListener(this);
		po.setActionCommand("po");
		po.addActionListener(this);
		cheetos.setEditable(false);
		pepper.setEditable(false);
		wyrd.setEditable(false);
		add(one);
		add(cheetos);
		add(go);
		add(two);
		add(pepper);
		add(po);
		add(wyrd);
		add(blah);
		cupola.add(this);
		cupola.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cupola.setBounds(100, 100, 300, 500);
		cupola.setVisible(true);
	}

	public static void main(String args[]) {
		new TimeCapture();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Date jub = new Date();
		String hub = jub + "|" + jub.getTime();
		switch (e.getActionCommand()) {
		case "go":
			line = jub;
			cheetos.setText(hub);
			System.out.println(hub);
			//nub.println(hub);
			//nub.flush();
			break;
		case "po":
			nbc = jub;
			pepper.setText(hub);
			break;
		case "blah":
			JOptionPane.showMessageDialog(this, "You suck",
					"I told you not to press it",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		if (line != null && nbc != null){
			double heyo = nbc.getTime() - line.getTime(), meyo = heyo/1000;
			wyrd.setText("Diff is " + heyo + " milliseconds\n" + meyo + " seconds");
		}
	}
}
