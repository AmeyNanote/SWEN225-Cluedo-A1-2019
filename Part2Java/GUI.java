import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI extends JFrame{

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	static JFrame f;
	static JButton b, b1;
	static JPanel p;
	static Action a, a1;
	static JLabel l;

	//GUI Attributes

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public GUI() {
		l = new JLabel("Welcome to our Cluedo game!");
		f = new JFrame("Cluedo (SWEN225) - Ethan & Amey");
		f.setSize(600,600);
		p = new JPanel();

	}

	//------------------------
	// INTERFACE
	//------------------------

	public void displayGUI() {
		f.add(p);
		f.show();
	}

	public void setupGUI(){
		a = new Action(1);
		b = new JButton("Start Game");
		b.addActionListener(a);

		a1 = new Action(0);
		b1 = new JButton("Exit Game");
		b1.addActionListener(a1);
		p.add(l);
		p.add(b);
		p.add(b1);


	}

	public void playGUI(JButton[] buttons) {
		p.remove(b);
		p.remove(b1);
		p.remove(l);
		for (JButton button: buttons) {
			p.add(button);
		}
		p.setLayout(new GridLayout(25, 24));

		//Drop down Menu!
		JMenuBar jmb = new JMenuBar();
		f.setJMenuBar(jmb);

		JMenu instances = new JMenu("Instances");
		jmb.add(instances);

		JMenuItem newGame = new JMenuItem("New Game");
		instances.add(newGame);
		instances.addSeparator();
		JMenuItem escape = new JMenuItem("Escape!");
		instances.add(escape);
		escape.addActionListener(new Action(0));
	}

}