import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
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
	static JButton StartGame, ExitGame, showCards, hand, emptyButton, north, south, east, west, suggest, accuse, end;
	static JPanel p, p1, p2;
	public Action gameSetup, displayHand;
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
		p1 = new JPanel();

	}

	//------------------------
	// INTERFACE
	//------------------------

	public void displayGUI() {
		f.add(p);
		f.add(p1, BorderLayout.PAGE_END);
		f.show();
	}

	public void setupGUI(){
		gameSetup = new Action("gameSetup", null, null);
		StartGame = new JButton("Start Game");
		StartGame.addActionListener(gameSetup);

		ExitGame = new JButton("Exit Game");
		ExitGame.addActionListener(new Action("exit", null, null));
		p.add(StartGame);
		p.add(ExitGame);
		p1.add(l, BorderLayout.LINE_START);


	}

	public void playGUI(JButton[] buttons, int turn, Player player, Board board) {
		p1.setLayout(new GridLayout(3, 5));


		p1.remove(l);
		p1.add(new JLabel("Turn: " + turn + " --- "));
		p1.add(new JButton(""));
		north = new JButton("North");
		north.addActionListener(new Action("north", player, board));
		p1.add(north);
		p1.add(new JButton(""));
		suggest = new JButton("Suggest");
		p1.add(suggest);
		p1.add(new JLabel("Die Rolls: " + Integer.toString(player.getDiceRoll()) + " --- "));
		west = new JButton("West");
		west.addActionListener(new Action("west", player, board));
		p1.add(west);
		end = new JButton("End");
		p1.add(end);
		east = new JButton("East");
		east.addActionListener(new Action("east", player, board));
		p1.add(east);
		p1.add(new JButton(""));
		hand = new JButton("Hand");
		hand.addActionListener(new Action("hand", player, null));
		p1.add(hand);
		p1.add(new JButton(""));
		south = new JButton("South");
		south.addActionListener(new Action("south", player, board));
		p1.add(south);
		p1.add(new JButton(""));
		accuse = new JButton("Accuse");
		p1.add(accuse);


		p.remove(StartGame);
		p.remove(ExitGame);
		for (JButton button: buttons) {
			p.add(button);
		}
		p.setLayout(new GridLayout(25, 24));



		//Drop down Menu!
		JMenuBar jmb = new JMenuBar();
		f.setJMenuBar(jmb);

		JMenu instances = new JMenu("Menu");
		jmb.add(instances);

		JMenuItem newGame = new JMenuItem("New Game");
		instances.add(newGame);
		instances.addSeparator();
		JMenuItem escape = new JMenuItem("Escape!");
		instances.add(escape);
		escape.addActionListener(new Action("exit", null, null));
	}

}