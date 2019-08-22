import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

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
	public boolean displayWindow = true;
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
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		p = new JPanel();
		p1 = new JPanel();

	}

	//------------------------
	// INTERFACE
	//------------------------

	@SuppressWarnings("deprecation")
	public void displayGUI() {
		if (displayWindow) {
			f.add(p);
			f.add(p1, BorderLayout.PAGE_END);
			f.show();
		}
	}

	public void setupGUI(){
		f.setSize(300,300);
		gameSetup = new Action("gameSetup", null, null, null, null);
		StartGame = new JButton("Start Game");
		StartGame.addActionListener(gameSetup);

		ExitGame = new JButton("Exit Game");
		ExitGame.addActionListener(new Action("close", null, null, null, null));
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
		playerTurn = new JLabel("Turn: " + turn + " - Player: " + player.getPlayerName());
		playerTurn.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	playerTurn.setBackground(Color.LIGHT_GRAY);
		    	playerTurn.setToolTipText("It is currently turn: " + turn + ", and the action is on Player: " + player.getPlayerName());
		    }
		});
		p1.add(playerTurn);

		hand = new JButton("Player Hand");
		hand.addActionListener(new Action("hand", player, null, null, null));
		hand.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        hand.setBackground(Color.LIGHT_GRAY);
		        hand.setToolTipText("Displays the cards in the players hand");
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        hand.setBackground(null);
		    }
		});
		p1.add(hand);

		north = new JButton("North");
		north.addActionListener(new Action("north", player, board, null, null));
		north.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        north.setBackground(Color.LIGHT_GRAY);
		        north.setToolTipText("Moves the player north");
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	north.setBackground(null);
		    }
		});
		p1.add(north);

		east = new JButton("East");
		east.addActionListener(new Action("east", player, board, null, null));
		east.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	east.setBackground(Color.LIGHT_GRAY);
		    	east.setToolTipText("Moves the player north");
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	east.setBackground(null);
		    }
		});
		p1.add(east);

		suggest = new JButton("Suggest");
		suggest.addActionListener(new Action("suggest", player, board, null, null));
		suggest.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	suggest.setBackground(Color.LIGHT_GRAY);
		    	suggest.setToolTipText("Suggests a solution");
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	suggest.setBackground(null);
		    }
		});
		p1.add(suggest);

		playerMoves = new JLabel("Moves: " + Integer.toString(player.getMoves()) + "/" + Integer.toString(player.getDiceRoll()));
		playerMoves.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	playerMoves.setToolTipText("The player has " + Integer.toString(player.getMoves()) + "/" + Integer.toString(player.getDiceRoll()) + " moves left");
		    }
		});
		p1.add(playerMoves);

		end = new JButton("End");
		end.addActionListener(new Action("end", player, board, null, null));
		end.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	end.setBackground(Color.LIGHT_GRAY);
		    	end.setToolTipText("Ends the player's turn");
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	end.setBackground(null);
		    }
		});
		p1.add(end);

		south = new JButton("South");
		south.addActionListener(new Action("south", player, board, null, null));
		south.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	south.setBackground(Color.LIGHT_GRAY);
		    	south.setToolTipText("Moves the player south");
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	south.setBackground(null);
		    }
		});
		p1.add(south);

		west = new JButton("West");
		west.addActionListener(new Action("west", player, board, null, null));
		west.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	west.setBackground(Color.LIGHT_GRAY);
		    	west.setToolTipText("Moves the player west");
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	west.setBackground(null);
		    }
		});
		p1.add(west);

		accuse = new JButton("Accuse");
		accuse.addActionListener(new Action("accuse", player, board, null, null));
		accuse.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	accuse.setBackground(Color.LIGHT_GRAY);
		    	accuse.setToolTipText("Make a final accusation");
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	accuse.setBackground(null);
		    }
		});
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

		JMenu menu = new JMenu("Menu");
		jmb.add(menu);

		JMenuItem newGame = new JMenuItem("New Game");
		menu.add(newGame);
		newGame.addActionListener(new Action("newGame", null, board, null, null));

		menu.addSeparator();
		JMenuItem escape = new JMenuItem("Quit Game");
		menu.add(escape);
		escape.addActionListener(new Action("exit", null, null, null, null) {
			public void actionPerformed(ActionEvent e) {
					int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
					if(a == JOptionPane.YES_OPTION){
						f.setVisible(false);
					}
			}

		});
	}

//	public void updatePlayGUI(JButton[] buttons, int turn, Player player, Board board) {
//
//	}

}