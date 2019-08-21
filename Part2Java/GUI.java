import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GUI extends JFrame{

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	static JFrame f;
	static JButton StartGame, ExitGame, showCards, hand, emptyButton, north, south, east, west, suggest, accuse, end;
	static JPanel p, p1, p2;
	public Action gameSetup;
	static JLabel l, playerTurn, playerMoves;

	//GUI Attributes

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public GUI() {
		l = new JLabel("Welcome to our Cluedo game!");
		f = new JFrame("Cluedo (SWEN225) - Ethan & Amey");
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
		f.setSize(300,300);
		gameSetup = new Action("gameSetup", null, null, null, null);
		StartGame = new JButton("Start Game");
		StartGame.addActionListener(gameSetup);

		ExitGame = new JButton("Exit Game");
		ExitGame.addActionListener(new Action("exit", null, null, null, null));
		p.add(StartGame);
		p.add(ExitGame);
		p1.add(l, BorderLayout.LINE_START);

	}

	public void playGUI(JButton[] buttons, int turn, Player player, Board board) {
		f.setSize(800,800);
		p1.setLayout(new GridLayout(2, 5));


		p1.remove(l);

		//If the players moves are not 0. Draw all of this.

		if (playerTurn != null) {
			p1.remove(playerTurn);
			p1.remove(hand);
			p1.remove(north);
			p1.remove(east);
			p1.remove(suggest);
			p1.remove(playerMoves);
			p1.remove(end);
			p1.remove(south);
			p1.remove(west);
			p1.remove(accuse);
		}
		playerTurn = new JLabel("Turn: " + turn + " - Player: " + player.getPos().getType());
		p1.add(playerTurn);

		hand = new JButton("Player Hand");
		hand.addActionListener(new Action("hand", player, null, null, null));
		p1.add(hand);

		north = new JButton("North");
		north.addActionListener(new Action("north", player, board, null, null));
		p1.add(north);

		east = new JButton("East");
		east.addActionListener(new Action("east", player, board, null, null));
		p1.add(east);

		suggest = new JButton("Suggest");
		suggest.addActionListener(new Action("suggest", player, board, null, null));
		p1.add(suggest);

		playerMoves = new JLabel("Moves: " + Integer.toString(player.getMoves()) + "/" + Integer.toString(player.getDiceRoll()));
		p1.add(playerMoves);

		end = new JButton("End");
		end.addActionListener(new Action("end", player, board, null, null));
		p1.add(end);

		south = new JButton("South");
		south.addActionListener(new Action("south", player, board, null, null));
		p1.add(south);

		west = new JButton("West");
		west.addActionListener(new Action("west", player, board, null, null));
		p1.add(west);

		accuse = new JButton("Accuse");
		accuse.addActionListener(new Action("accuse", player, board, null, null));
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
		JMenuItem escape = new JMenuItem("Quit Game");
		instances.add(escape);
		escape.addActionListener(new Action("exit", null, null, null, null));
	}

	public void updatePlayGUI(JButton[] buttons, int turn, Player player, Board board) {

	}

}