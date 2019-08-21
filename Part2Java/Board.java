import java.awt.Color;
import java.awt.Insets;
import java.util.*;

import javax.swing.JButton;

public class Board
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Board Associations
  public String[] wholeASCIIboard = new String[600];
  public String[][] boardASCII = new String[24][25];
  public JButton[] boardButtons = new JButton[600];
  public ArrayList<Position> boardPositions = new ArrayList<Position>();
  public Solution solution;
  public List<Player> players;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  // Initialize the board to the standard no player state with a 2D array
  public Board(Solution s){
	  wholeASCIIboard = new String[]{
			  "XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX", "03", "XX", "XX", "XX", "XX", "S4", "XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX",
			  "ki", "ki", "ki", "ki", "ki", "XX", "XX", "__", "__", "__", "XX", "ba", "ba", "XX", "__", "__", "__", "XX", "co" ,"co" ,"co" ,"co" ,"co" ,"co",
			  "ki", "ki", "ki", "ki", "ki", "XX", "__", "__", "XX", "XX", "ba", "ba", "ba", "XX", "XX", "XX", "__", "__", "XX" ,"co" ,"co" ,"co" ,"co" ,"co",
			  "ki", "ki", "ki", "ki", "ki", "XX", "__", "__", "XX", "ba", "ba", "ba", "ba", "ba", "ba", "XX", "__", "__", "XX" ,"co" ,"co" ,"co" ,"co" ,"co",
			  "ki", "ki", "ki", "ki", "ki", "XX", "__", "__", "XX", "ba", "ba", "ba", "ba", "ba", "ba", "XX", "__", "__", "co" ,"co" ,"co" ,"co" ,"co" ,"co",
			  "ki", "ki", "ki", "ki", "ki", "XX", "__", "__", "ba", "ba", "ba", "ba", "ba", "ba", "ba", "ba", "__", "__", "__", "XX" ,"XX" ,"XX" ,"XX", "XX",
			  "XX", "XX", "XX", "XX", "ki", "XX", "__", "__", "XX", "ba", "ba", "ba", "ba", "ba", "ba", "XX", "__", "__", "__", "__", "__", "__", "__", "05",
			  "__", "__", "__", "__", "__", "__", "__", "__", "XX", "ba", "XX", "XX", "XX", "XX", "ba", "XX", "__", "__", "__", "__", "__", "__", "__", "XX",
			  "XX", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "XX" ,"XX" ,"XX" ,"XX" ,"XX" ,"bi",
			  "XX" ,"XX" ,"XX" ,"XX" ,"XX" ,"__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "bi", "bi" ,"bi" ,"bi" ,"bi" ,"bi",
			  "di" ,"di" ,"di" ,"di" ,"di" ,"XX" ,"XX" ,"XX" ,"__", "__", "XX" ,"XX" ,"XX" ,"XX" ,"XX" ,"__", "__", "__", "XX" ,"bi" ,"bi" ,"bi" ,"bi" ,"bi",
			  "di" ,"di" ,"di" ,"di" ,"di" ,"di" ,"di" ,"XX" ,"__", "__", "XX" ,"ce" ,"ce" ,"ce" ,"XX" ,"__", "__", "__", "XX" ,"bi" ,"bi" ,"bi" ,"bi" ,"bi",
			  "di" ,"di" ,"di" ,"di" ,"di" ,"di" ,"di" ,"di" ,"__", "__", "XX" ,"ce" ,"ce" ,"ce" ,"XX" ,"__", "__", "__", "XX" ,"XX" ,"XX" ,"XX" ,"bi", "bi",
			  "di" ,"di" ,"di" ,"di" ,"di" ,"di" ,"di" ,"XX" ,"__", "__", "XX" ,"ce" ,"ce" ,"ce" ,"XX" ,"__", "__", "__", "__", "__", "__", "__", "__", "XX",
			  "di" ,"di" ,"di" ,"di" ,"di" ,"di" ,"di" ,"XX" ,"__", "__", "XX" ,"ce" ,"ce" ,"ce" ,"XX" ,"__", "__", "__", "XX" ,"XX" ,"li" ,"XX" ,"XX" ,"XX",
			  "XX" ,"XX" ,"XX" ,"XX" ,"XX" ,"XX" ,"di" ,"XX" ,"__", "__", "XX" ,"ce" ,"ce" ,"ce" ,"XX" ,"__", "__", "XX" ,"li" ,"li" ,"li" ,"li" ,"li" ,"li",
			  "XX", "__", "__", "__", "__", "__", "__", "__", "__", "__", "XX" ,"XX" ,"XX" ,"XX" ,"XX" ,"__", "__", "li", "li" ,"li" ,"li" ,"li" ,"li" ,"li",
			  "02", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "XX" ,"li" ,"li" ,"li" ,"li" ,"li" ,"li",
			  "XX", "__", "__", "__", "__", "__", "__", "__", "__", "XX", "XX", "ha", "XX", "XX", "XX", "__", "__", "__", "XX" ,"XX" ,"XX" ,"XX" ,"XX" ,"XX",
			  "XX", "XX", "XX", "XX" ,"XX", "lo" ,"XX", "__", "__", "XX", "ha", "ha", "ha", "ha", "XX", "__", "__", "__", "__", "__", "__", "__", "__", "06",
			  "lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"XX" ,"__", "__", "XX", "ha", "ha", "ha", "ha", "ha", "__", "__", "__", "__", "__", "__", "__", "__", "XX",
			  "lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"XX" ,"__", "__", "XX", "ha", "ha", "ha", "ha", "XX", "__", "__", "XX" ,"st" ,"XX" ,"XX" ,"XX" ,"XX" ,"XX",
			  "lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"XX" ,"__", "__", "XX", "ha", "ha", "ha", "ha", "XX", "__", "__", "XX" ,"st" ,"st" ,"st" ,"st" ,"st" ,"st",
			  "lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"XX" ,"__", "__", "XX", "ha", "ha", "ha", "ha", "XX", "__", "__", "XX" ,"st" ,"st" ,"st" ,"st" ,"st" ,"st",
			  "lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"XX" ,"01", "XX", "XX", "ha", "ha", "ha", "ha", "XX", "XX", "__", "XX", "st" ,"st" ,"st" ,"st" ,"st" ,"st"};

	  // Filling the 2D array of positions row by row
	  int wholeASCIIboardIndex = 0;
	  for (int i = 0; i <= 24; i++) { // The x coordinate
		  for (int j = 0; j <= 23; j++) { // The y coordinate
			  Position p = new Position(j, i, wholeASCIIboard[wholeASCIIboardIndex++]);
			  boardPositions.add(p);

		  }
	  }

	  wholeASCIIboardIndex = 0;
	  for (int t = 0; t < 600; t++) {
		  JButton b;

		  String sym = wholeASCIIboard[wholeASCIIboardIndex];
		  if (sym.equals("__") || sym.equals("XX")) {
			  b = new JButton("");
			  b.setMargin(new Insets(0, 0, 0, 0));
		  }
		  else {
			  b = new JButton(sym);
			  b.setMargin(new Insets(0, 0, 0, 0));
		  }

		  boardButtons[t] = b;

		  if (sym.equals("XX")) {
			  b.setBackground(Color.BLACK);
		  }
		  else if (sym.equals("__")) {
			  b.setBackground(Color.LIGHT_GRAY);
		  }
		  else {
			  b.setBackground(Color.WHITE);
		  }
		  b.setSize(20,20);
		  wholeASCIIboardIndex++;
	  }

	  solution = s;
  }

  public JButton[] getButtons() {
	  return boardButtons;
  }

  public void drawBoard() {
//	  for (int i = 0; i < 25; i++) { // The x coordinate
//		  System.out.println("");
		  //System.out.print(i); // Row number
//		  for (int j = 0; j < 24; j++) { // The y coordinate
//			  System.out.print(boardASCII[j][i] + " ");
//		  }
//
//	  }
//	  System.out.println();
  }

  public void updateBoard() {
	  for (Position o: boardPositions) {
		  boardASCII[o.getX()][o.getY()] = o.getType();
		  int arrayPosition = (o.getY() * 24) + o.getX();
		  if (!o.getType().equals("__") && !o.getType().equals("XX")) {
			  boardButtons[arrayPosition].setText(o.getType());
			  if (o.getType().equals("ki")) {
				  boardButtons[arrayPosition].setBackground(Color.MAGENTA.darker());
			  }
			  else if (o.getType().equals("li")) {
				  boardButtons[arrayPosition].setBackground(new Color(205, 133, 63));
			  }
			  else if (o.getType().equals("lo")) {
				  boardButtons[arrayPosition].setBackground(Color.PINK.darker());
			  }
			  else if (o.getType().equals("ba")) {
				  boardButtons[arrayPosition].setBackground(Color.PINK);
			  }
			  else if (o.getType().equals("bi")) {
				  boardButtons[arrayPosition].setBackground(Color.GREEN.darker());
			  }
			  else if (o.getType().equals("ce")) {
				  boardButtons[arrayPosition].setBackground(Color.GRAY.darker());
			  }
			  else if (o.getType().equals("st")) {
				  boardButtons[arrayPosition].setBackground(Color.YELLOW.darker());
			  }
			  else if (o.getType().equals("di")) {
				  boardButtons[arrayPosition].setBackground(Color.ORANGE.darker());
			  }
			  else if (o.getType().equals("ha")) {
				  boardButtons[arrayPosition].setBackground(Color.CYAN.darker());
			  }
			  else if (o.getType().equals("co")) {
				  boardButtons[arrayPosition].setBackground(Color.RED.darker());
			  }
			  else {
				  boardButtons[arrayPosition].setBackground(Color.gray);
			  }
		  }
		  else if (o.getType().equals("XX")){
			  boardButtons[arrayPosition].setBackground(Color.BLACK);
		  }
		  else {
			  boardButtons[arrayPosition].setText("");
			  boardButtons[arrayPosition].setBackground(Color.LIGHT_GRAY);
		  }

	  }

	  for (Player p: players) {
		  boardASCII[p.getPos().getX()][ p.getPos().getY()] =  p.getPos().getType();
		  int arrayPosition = (p.getPos().getY() * 24) + p.getPos().getX();

		  if (p.getIsOut()) {
			  // Removes player from the board so they dont interfear with play
			  for (Position pos: this.boardPositions) {
				  if (p.getPos().getX() == pos.getX() && p.getPos().getY() == pos.getY()) {
					  p.getPos().setType(p.getRoom());
					  boardButtons[arrayPosition].setText(p.getRoom());
				  }
			  }
		  }
		  else {
			  boardButtons[arrayPosition].setText(p.getPos().getType());
			  boardButtons[arrayPosition].setBackground(p.getColor());
		  }
	  }

  }


}
