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

	int i; // Type of action to take place (ie. move north, accuse, refute);
	private int playerCount;
	// Action Attributes

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Action(int action) {
		i = action;
	}

	//------------------------
	// INTERFACE
	//------------------------

	@Override
	public void actionPerformed(ActionEvent e) {
		if (i == 0) { // Exit action if the user presses exit game
			int a = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure?");
			if(a == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
		else if (i == 1) {
			ArrayList<String> noPlayers = new ArrayList<String>(Arrays.asList("3", "4", "5", "6"));
			String a = JOptionPane.showInputDialog(new JFrame(), "How manny players are there?");
			while (!noPlayers.contains(a)) {
				a = JOptionPane.showInputDialog(new JFrame(), "Invalid input, must be between 3-6!");
			}
			playerCount = noPlayers.indexOf(a) + 3;
		}
	}

	public Integer getPlayerCount() {
		return playerCount;
	}

}