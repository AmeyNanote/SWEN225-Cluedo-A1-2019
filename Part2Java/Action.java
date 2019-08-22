
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class Action implements ActionListener{

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	private String a; // Type of action to take place (ie. move north, accuse, refute);
	private Player p; // The current player's actions
	private Board b; // the current board state
	private int playerCount;
	private ArrayList<String> playerNames = new ArrayList<String>();
	public ButtonGroup b1;
	public ButtonGroup b2;

	// Action Attributes

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Action(String action, Player player, Board board, ButtonGroup but1, ButtonGroup but2) {
		a = action;
		p = player;
		b = board;
		b1 = but1;
		b2 = but2;

	}

	//------------------------
	// INTERFACE
	//------------------------

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (a.equals("exit")) { // Exit action if the user presses exit game
			int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
			if(a == JOptionPane.YES_OPTION){
			}
		}

		else if (a.equals("close")) { // Closes a single window
			Window win = SwingUtilities.getWindowAncestor((Component) e.getSource());
			win.dispose();
		}

		else if (a.equals("end")) { // ends the players turn
			int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to end your turn?");
			if(a == JOptionPane.YES_OPTION){
				Window win = SwingUtilities.getWindowAncestor((Component) e.getSource());
				win.dispose();
				p.setMoves(0);
				p.actionMade = true;
			}
		}

		else if (a.equals("gameSetup")) {
			ArrayList<String> noPlayers = new ArrayList<String>(Arrays.asList("3", "4", "5", "6"));
			String num = JOptionPane.showInputDialog(new JFrame(), "How manny players are there?");
			while (!noPlayers.contains(num)) {
				num = JOptionPane.showInputDialog(null, "Must be between 3-6!", "Invalid input", JOptionPane.ERROR_MESSAGE);
			}

			for (int c = 0; c < (noPlayers.indexOf(num) + 3); c++) {
				String playerName = JOptionPane.showInputDialog(new JFrame(), "Enter name initials for player " + (c + 1));
				while (playerName == null || playerName.length() < 1 || playerName.contains(" ")) {
					playerName = JOptionPane.showInputDialog(null, "Please put a name with no spaces", "Invalid input", JOptionPane.ERROR_MESSAGE);
				}
				playerNames.add(playerName);
			}

			playerCount = noPlayers.indexOf(num) + 3;


		}

		else if (a.equals("hand")) {
			JOptionPane.showMessageDialog(null, p.getHand().toString());
		}

		else if (a.equals("north")) {
			if (p.getActions(b).contains("North") && p.getMoves() > 0) {
				p.getPos().setY(p.getPos().getY() - 1);
				b.updateBoard();
			    p.setMoves(p.getMoves() - 1);
				p.setRoom(b);
				p.actionMade = true;
			}
//			else {
//				JOptionPane.showMessageDialog(null , "Can't move north", "Invalid action", JOptionPane.ERROR_MESSAGE);
//			}
		}

		else if(a.equals("south")) {
			if (p.getActions(b).contains("South") && p.getMoves() > 0) {
				p.getPos().setY(p.getPos().getY() + 1);
				b.updateBoard();
			    p.setMoves(p.getMoves() - 1);
				p.setRoom(b);
				p.actionMade = true;


			}
//			else {
//				JOptionPane.showMessageDialog(null , "Can't move south", "Invalid action!", JOptionPane.ERROR_MESSAGE);
//			}
		}

		else if(a.equals("east")) {
			if (p.getActions(b).contains("East") && p.getMoves() > 0) {
				p.getPos().setX(p.getPos().getX() + 1);
				b.updateBoard();
				p.setMoves(p.getMoves() - 1);
				p.setRoom(b);
				p.actionMade = true;


			}
//			else {
//				JOptionPane.showMessageDialog(null, "Can't move east", "Invalid action!", JOptionPane.ERROR_MESSAGE);
//			}
		}

		else if(a.equals("west")) {
			if (p.getActions(b).contains("West") && p.getMoves() > 0 ) {
				p.getPos().setX(p.getPos().getX() - 1);
				b.updateBoard();
			    p.setMoves(p.getMoves() - 1);
				p.setRoom(b);
				p.actionMade = true;


			}
//			else {
//				JOptionPane.showMessageDialog(null, "Can't move west", "Invalid action!", JOptionPane.ERROR_MESSAGE);
//			}
		}

		else if(a.equals("accuse")) {
			if (p.getActions(b).contains("Accuse")) {
				JFrame radioFrame = new JFrame("Accusation Options");
				radioFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				JPanel charRadioPanel = new JPanel();
				JPanel itemRadioPanel = new JPanel();
				JPanel optionsPanel = new JPanel();

				radioFrame.setLayout(new GridLayout(3, 1));
				JRadioButton rb;

				ButtonGroup charRadioButtons = new ButtonGroup();
				charRadioPanel.add(new JLabel("Please pick a character to accuse: "));
				for (String chars: p.getGuessableChars()) {
					rb = new JRadioButton(chars);
					charRadioButtons.add(rb);
					charRadioPanel.add(rb);
				}

				ButtonGroup itemRadioButtons = new ButtonGroup();
				itemRadioPanel.add(new JLabel("Please pick a character to accuse: "));
				for (String items: p.getGuessableItems()) {
					rb = new JRadioButton(items);
					itemRadioButtons.add(rb);
					itemRadioPanel.add(rb);
				}


					JButton cancel = new JButton("Cancel");
					cancel.addActionListener(new Action("close", null, null, null, null));

					JButton acceptAccuse = new JButton("Accuse!");
					acceptAccuse.addActionListener(new Action("acceptAccuse", p, b, charRadioButtons, itemRadioButtons));

					optionsPanel.add(cancel);
					optionsPanel.add(acceptAccuse);
					radioFrame.add(charRadioPanel);
					radioFrame.add(itemRadioPanel);
					radioFrame.add(optionsPanel);
					radioFrame.setSize(1000, 150);
					radioFrame.show();
			}
			else {
				JOptionPane.showMessageDialog(null, "Must be in a room to accuse", "Invalid action!", JOptionPane.ERROR_MESSAGE);
			}
		}

		else if(a.equals("suggest")) {
			if (p.getActions(b).contains("Suggest")) {
				JFrame radioFrame = new JFrame("Suggestion Options");
				radioFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				JPanel charRadioPanel = new JPanel();
				JPanel itemRadioPanel = new JPanel();
				JPanel optionsPanel = new JPanel();

				radioFrame.setLayout(new GridLayout(3, 1));
				JRadioButton rb;

				ButtonGroup charRadioButtons = new ButtonGroup();
				charRadioPanel.add(new JLabel("Please pick a character to suggest: "));
				for (String chars: p.getGuessableChars()) {
					rb = new JRadioButton(chars);
					charRadioButtons.add(rb);
					charRadioPanel.add(rb);
				}

				ButtonGroup itemRadioButtons = new ButtonGroup();
				itemRadioPanel.add(new JLabel("Please pick a character to suggest: "));
				for (String items: p.getGuessableItems()) {
					rb = new JRadioButton(items);
					itemRadioButtons.add(rb);
					itemRadioPanel.add(rb);
				}

				JButton cancel = new JButton("Cancel");
				cancel.addActionListener(new Action("close", null, null, null, null));

				JButton acceptAccuse = new JButton("Suggest!");
				acceptAccuse.addActionListener(new Action("acceptSuggest", p, b, charRadioButtons, itemRadioButtons));

				optionsPanel.add(cancel);
				optionsPanel.add(acceptAccuse);
				radioFrame.add(charRadioPanel);
				radioFrame.add(itemRadioPanel);
				radioFrame.add(optionsPanel);
				radioFrame.setSize(1000, 150);
				radioFrame.show();
			}
			else {
				JOptionPane.showMessageDialog(null, "Must be in a room to suggest", "Invalid action!", JOptionPane.ERROR_MESSAGE);
			}
		}

		else if (a.contentEquals("acceptAccuse")) {

			// Check if the accusation was right
			if (b.solution.getMurderer().getName().equals(getSelectedButton(b2))
			  && b.solution.getMurderRoom().getName().equals(p.getFullRoom())
			  && b.solution.getWeapon().getName().equals(getSelectedButton(b1))) {
				JOptionPane.showMessageDialog(null, "Congratulations, you won!");
				System.exit(0);
			}

			// Otherwise the player is wrong and is out of the game
			else {
				JOptionPane.showMessageDialog(null, "Wrong, better luck next time");
				p.setIsOut(true);
				p.setMoves(0);
				p.actionMade = true;
				Window win1 = SwingUtilities.getWindowAncestor((Component) e.getSource());
				win1.dispose();
			}

			// Checks if there is at least one player left
			Boolean allout = true;
			for (Player player: b.players) {
				if (!player.getIsOut()) {
					allout = false;
				}
			}

			// If all the players are out then game exits
			if (allout) {
				JOptionPane.showMessageDialog(null, "All players are out, the solution was: " + b.solution.toString());
				System.exit(0);
			}


		}

		else if (a.contentEquals("acceptSuggest")) {

			// For each player refute, the refutes list is a specific list that holds the cards they can refute
			int refutingPlayer = p.getPlayerNum() + 1;
			for (int j = 0; j < b.players.size() - 1; j++) {
				Player np;

				ArrayList<String> refutes = new ArrayList<String>();

				// This makes sure that the player is within the bounds of players array and loops to 0
				if (refutingPlayer > b.players.size() - 1) {
					refutingPlayer = 0;
				}
				np = b.players.get(refutingPlayer);

				if (!p.equals(np)) {
					refutes.clear();

					// these 3 for loops interate through and assign the items rooms chars that can be refuted by this player
					for (Character ch: np.getHand().getChars()) {
						if (ch.getName().equals(getSelectedButton(b2))){
							refutes.add(getSelectedButton(b2));
						}
					}
					for (Item itm: np.getHand().getItems()) {
						if (itm.getName().equals(getSelectedButton(b1))) {
							refutes.add(getSelectedButton(b1));
						}
					}

					for (Room rm: np.getHand().getRooms()) {
						if (rm.getName().equals(p.getFullRoom())){
							refutes.add(p.getFullRoom());
						}
					}

					// Only players with cards matching the assumption can refute
					if (!refutes.isEmpty()) {

						JFrame radioFrame = new JFrame("Refute Options");
						radioFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
						JPanel refuteRadioPanel = new JPanel();
						JPanel optionPanel = new JPanel();
						radioFrame.setLayout(new GridLayout(2, 1));
						JRadioButton rb;

						ButtonGroup refuteRadioButtons = new ButtonGroup();
						refuteRadioPanel.add(new JLabel("Player " + (np.getPlayerNum() + 1) + " please pick a card to refute: "));
						for (String refuteOption: refutes) {
							rb = new JRadioButton(refuteOption);
							refuteRadioButtons.add(rb);
							refuteRadioPanel.add(rb);
						}

						JButton acceptRefute = new JButton("Refute!");
						acceptRefute.addActionListener(new Action("acceptRefute", np, b, refuteRadioButtons, null));

						optionPanel.add(acceptRefute);
						radioFrame.add(refuteRadioPanel);
						radioFrame.add(optionPanel);
						radioFrame.setSize(700, 125);
						radioFrame.show();

					}
					refutingPlayer++;

				}

				p.setMoves(0);
				p.actionMade = true;
				Window win1 = SwingUtilities.getWindowAncestor((Component) e.getSource());
				win1.dispose();
			}

		}
		else if (a.contentEquals("acceptRefute")) {
			JOptionPane.showMessageDialog(null, "Player " + (p.getPlayerNum() + 1) + " has refuted with " + getSelectedButton(b1));
			Window win1 = SwingUtilities.getWindowAncestor((Component) e.getSource());
			win1.dispose();
		}

		else if (a.contentEquals("newGame")) {
			int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?");
			if(a == JOptionPane.YES_OPTION){
				b.setRestart(true);
			}
		}
	}

	public String getSelectedButton(ButtonGroup butgroup) {
        for (Enumeration<AbstractButton> buttons = butgroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

	public Integer getPlayerCount() {
		return playerCount;
	}
	public List<String> getPlayerNames() {
		return playerNames;
	}

}