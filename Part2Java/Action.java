import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (a.equals("exit")) { // Exit action if the user presses exit game
			int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
			if(a == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
		
		else if (a.equals("close")) { // Closes a single window
			Window win = SwingUtilities.getWindowAncestor((Component) e.getSource());
			win.dispose();
		}
		
		else if (a.equals("end")) { // ends the players turn
			
		}
		
		else if (a.equals("gameSetup")) {
			ArrayList<String> noPlayers = new ArrayList<String>(Arrays.asList("3", "4", "5", "6"));
			String num = JOptionPane.showInputDialog(new JFrame(), "How manny players are there?");
			while (!noPlayers.contains(num)) {
				num = JOptionPane.showInputDialog(null, "Invalid input, must be between 3-6!", JOptionPane.ERROR_MESSAGE);
			}
			playerCount = noPlayers.indexOf(num) + 3;
		}
		
		else if (a.equals("hand")) {
			JOptionPane.showMessageDialog(null, p.getHand().toString());
		}
		
		else if (a.equals("north")) {
			if (p.getActions(b).contains("North")) {
				p.getPos().setY(p.getPos().getY() - 1);
				b.updateBoard(p);
				p.setRoom(b);
				p.setMoves(p.getMoves() - 1);
				System.out.println(p.getMoves());
			}
			else {
				JOptionPane.showMessageDialog(null , "Invalid action", "Can't move north", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if(a.equals("south")) {
			if (p.getActions(b).contains("South")) {
				p.getPos().setY(p.getPos().getY() + 1);
				b.updateBoard(p);
				p.setRoom(b);
				p.setMoves(p.getMoves() - 1);

			}
			else {
				JOptionPane.showMessageDialog(null , "Invalid action!", "Can't move south", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if(a.equals("east")) {
			if (p.getActions(b).contains("East")) {
				p.getPos().setX(p.getPos().getX() + 1);
				b.updateBoard(p);
				p.setRoom(b);
				p.setMoves(p.getMoves() - 1);

			}
			else {
				JOptionPane.showMessageDialog(null , "Invalid action", "Can't move east", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if(a.equals("west")) {
			if (p.getActions(b).contains("West")) {
				p.getPos().setX(p.getPos().getX() - 1);
				b.updateBoard(p);
				p.setRoom(b);
				p.setMoves(p.getMoves() - 1);

			}
			else {
				JOptionPane.showMessageDialog(null , "Invalid action", "Can't move west", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if(a.equals("accuse")) {
			if (p.getActions(b).contains("Accuse")) {
				JFrame radioFrame = new JFrame();
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
				JOptionPane.showMessageDialog(null , "Invalid action", "Must be in a room to accuse", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if(a.equals("suggest")) {
			if (p.getActions(b).contains("Suggest")) {
			
			}
			else {
				JOptionPane.showMessageDialog(null , "Invalid action" , "Must be in a room to suggest", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if (a.contentEquals("acceptAccuse")) {		
			Window win = SwingUtilities.getWindowAncestor((Component) e.getSource());
			win.dispose();
			
			if (b.solution.getMurderer().getName().equals(getSelectedButton(b2))
			  && b.solution.getMurderRoom().getName().equals(p.getFullRoom())
			  && b.solution.getWeapon().getName().equals(getSelectedButton(b1))) {
				JOptionPane.showMessageDialog(null, "Congratulations, you won!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Wrong, better luck next time");
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

}