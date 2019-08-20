import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Action implements ActionListener{

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	String a; // Type of action to take place (ie. move north, accuse, refute);
	Player p;
	Board b;
	private int playerCount;
	// Action Attributes

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Action(String action, Player player, Board board) {
		a = action;
		p = player;
		b = board;
	}

	//------------------------
	// INTERFACE
	//------------------------

	@Override
	public void actionPerformed(ActionEvent e) {
		if (a.equals("exit")) { // Exit action if the user presses exit game
			int a = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure?");
			if(a == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
		else if (a.equals("gameSetup")) {
			ArrayList<String> noPlayers = new ArrayList<String>(Arrays.asList("3", "4", "5", "6"));
			String num = JOptionPane.showInputDialog(new JFrame(), "How manny players are there?");
			while (!noPlayers.contains(num)) {
				num = JOptionPane.showInputDialog(new JFrame(), "Invalid input, must be between 3-6!");
			}
			playerCount = noPlayers.indexOf(num) + 3;
		}
		else if (a.equals("hand")) {
			JOptionPane.showMessageDialog(null , p.getHand().toString());
		}
		else if (a.equals("north")) {
			p.getPos().setY(p.getPos().getY() - 1);
			  b.updateBoard(p);
			  p.setRoom(b);
			System.out.println("postions changed");
		}
		else if(a.equals("south")) {
			p.getPos().setY(p.getPos().getY() + 1);
			  b.updateBoard(p);
			  p.setRoom(b);
		}
		else if(a.equals("east")) {
			 p.getPos().setX(p.getPos().getX() + 1);
			  b.updateBoard(p);
			  p.setRoom(b);
		}
		else if(a.equals("west")) {
			p.getPos().setX(p.getPos().getX() - 1);
			  b.updateBoard(p);
			  p.setRoom(b);
		}
	}

//	//Gets Action that has been made
//	public String getCallOut() {
//		return callOut;
//	}

	public Integer getPlayerCount() {
		return playerCount;
	}

}