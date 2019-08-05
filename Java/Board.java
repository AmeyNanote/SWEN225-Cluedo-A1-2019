/*PLEASE DO NOT EDIT THIS CODE*/
/*This co"DE",was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.util.*;

// line 9 "model.ump"
// line 107 "model.ump"
public class Board
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Board Attributes
  private List<Character> chars;
  private int turn;
  private Solution solution;

  //Board Associations
  private Position position;
  public String[] wholeASCIIboard = new String[600];
  public String[][] boardASCII = new String[24][25];
  public ArrayList<Position> boardPositions = new ArrayList<Position>();

  //------------------------
  // CONSTRUCTOR
  //------------------------

  // Initialize the board to the standard no player state with a 2D array
  private List<Position> squares = new ArrayList<Position>();

  public Board()
  {
    squares = new ArrayList<Position>();
    chars = new ArrayList<Character>();
//    boolean didAddPosition = setPosition(aPosition);
//    if (!didAddPosition)
//    {
//      throw new RuntimeException("Unable to create board due to position. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
//    }

    wholeASCIIboard = new String[]{
    		 "XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX", "S3", "XX", "XX", "XX", "XX", "S4", "XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX", "XX",
    		 "ki", "ki", "ki", "ki", "ki", "XX", "XX", "__", "__", "__", "XX", "ba", "ba", "XX", "__", "__", "__", "XX", "co" ,"co" ,"co" ,"co" ,"co" ,"co",
    		 "ki", "ki", "ki", "ki", "ki", "XX", "__", "__", "XX", "XX", "ba", "ba", "ba", "XX", "XX", "XX", "__", "__", "XX" ,"co" ,"co" ,"co" ,"co" ,"co",
    		 "ki", "ki", "ki", "ki", "ki", "XX", "__", "__", "XX", "ba", "ba", "ba", "ba", "ba", "ba", "XX", "__", "__", "XX" ,"co" ,"co" ,"co" ,"co" ,"co",
    		 "ki", "ki", "ki", "ki", "ki", "XX", "__", "__", "XX", "ba", "ba", "ba", "ba", "ba", "ba", "XX", "__", "__", "co" ,"co" ,"co" ,"co" ,"co" ,"co",
    		 "ki", "ki", "ki", "ki", "ki", "XX", "__", "__", "ba", "ba", "ba", "ba", "ba", "ba", "ba", "ba", "__", "__", "__", "XX" ,"XX" ,"XX" ,"XX", "XX",
    		 "XX", "XX", "XX", "XX", "ki", "XX", "__", "__", "XX", "ba", "ba", "ba", "ba", "ba", "ba", "XX", "__", "__", "__", "__", "__", "__", "__", "S5",
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
    		 "S2", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "__", "XX" ,"li" ,"li" ,"li" ,"li" ,"li" ,"li",
    		 "XX", "__", "__", "__", "__", "__", "__", "__", "__", "XX", "XX", "ha", "XX", "XX", "XX", "__", "__", "__", "XX" ,"XX" ,"XX" ,"XX" ,"XX" ,"XX",
    		 "XX", "XX", "XX", "XX" ,"XX", "lo" ,"XX", "__", "__", "XX", "ha", "ha", "ha", "ha", "XX", "__", "__", "__", "__", "__", "__", "__", "__", "S6",
    		 "lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"XX" ,"__", "__", "XX", "ha", "ha", "ha", "ha", "ha", "__", "__", "__", "__", "__", "__", "__", "__", "XX",
    		 "lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"XX" ,"__", "__", "XX", "ha", "ha", "ha", "ha", "XX", "__", "__", "XX" ,"st" ,"XX" ,"XX" ,"XX" ,"XX" ,"XX",
    		 "lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"XX" ,"__", "__", "XX", "ha", "ha", "ha", "ha", "XX", "__", "__", "XX" ,"st" ,"st" ,"st" ,"st" ,"st" ,"st",
    		 "lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"__", "__", "XX", "ha", "ha", "ha", "ha", "XX", "__", "__", "XX" ,"st" ,"st" ,"st" ,"st" ,"st" ,"st",
    		 "lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"lo" ,"XX" ,"S1", "XX", "XX", "ha", "ha", "ha", "ha", "XX", "XX", "__", "XX", "st" ,"st" ,"st" ,"st" ,"st" ,"st"};

	  // Filling the 2D array of positions row by row
	  int wholeASCIIboardIndex = 0;
	  for (int i = 0; i <= 24; i++) { // The x coordinate
		  for (int j = 0; j <= 23; j++) { // The y coordinate
			  Position p = new Position(j, i, wholeASCIIboard[wholeASCIIboardIndex]);
			  boardPositions.add(p);
			  boardASCII[j][i] = wholeASCIIboard[wholeASCIIboardIndex++];
		  }
	  }
  }

  public void drawBoard() {
	  for (int i = 0; i < 25; i++) { // The x coordinate
		  System.out.println("");
		  //System.out.print(i); // Row number
		  for (int j = 0; j < 24; j++) { // The y coordinate
			  System.out.print(boardASCII[j][i] + " ");
		  }

	  }
	  System.out.println();
  }

  public void updateBoard(List<Player> players) {
	  for (Position o: boardPositions) {
		  boardASCII[o.getX()][o.getY()] = o.getType();
	  }

	  for (Player p: players) {
		  boardASCII[p.getPos().getX()][ p.getPos().getY()] =  p.getPos().getType();
	  }

	  drawBoard();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Co"DE",from template attribute_SetMany */
  public boolean addSquare(Position aSquare)
  {
    boolean wasAdded = false;
    wasAdded = squares.add(aSquare);
    return wasAdded;
  }

  public boolean removeSquare(Position aSquare)
  {
    boolean wasRemoved = false;
    wasRemoved = squares.remove(aSquare);
    return wasRemoved;
  }
  /* Co"DE",from template attribute_SetMany */
  public boolean addChar(Character aChar)
  {
    boolean wasAdded = false;
    wasAdded = chars.add(aChar);
    return wasAdded;
  }

  public boolean removeChar(Character aChar)
  {
    boolean wasRemoved = false;
    wasRemoved = chars.remove(aChar);
    return wasRemoved;
  }

  public boolean setTurn(int aTurn)
  {
    boolean wasSet = false;
    turn = aTurn;
    wasSet = true;
    return wasSet;
  }

  public boolean setSolution(Solution aSolution)
  {
    boolean wasSet = false;
    solution = aSolution;
    wasSet = true;
    return wasSet;
  }
  /* Co"DE",from template attribute_GetMany */
  public Position getSquare(int index)
  {
    Position aSquare = squares.get(index);
    return aSquare;
  }

  public Position[] getSquares()
  {
    Position[] newSquares = squares.toArray(new Position[squares.size()]);
    return newSquares;
  }

  public int numberOfSquares()
  {
    int number = squares.size();
    return number;
  }

  public boolean hasSquares()
  {
    boolean has = squares.size() > 0;
    return has;
  }

  public int indexOfSquare(Position aSquare)
  {
    int index = squares.indexOf(aSquare);
    return index;
  }
  /* Co"DE",from template attribute_GetMany */
  public Character getChar(int index)
  {
    Character aChar = chars.get(index);
    return aChar;
  }

  public Character[] getChars()
  {
    Character[] newChars = chars.toArray(new Character[chars.size()]);
    return newChars;
  }

  public int numberOfChars()
  {
    int number = chars.size();
    return number;
  }

  public boolean hasChars()
  {
    boolean has = chars.size() > 0;
    return has;
  }

  public int indexOfChar(Character aChar)
  {
    int index = chars.indexOf(aChar);
    return index;
  }

  /**
   * Current turn
   */
  public int getTurn()
  {
    return turn;
  }

  /**
   * The pre-choosen solution to who is the murdere
   */
  public Solution getSolution()
  {
    return solution;
  }
  /* Co"DE",from template association_GetOne */
  public Position getPosition()
  {
    return position;
  }
  /* Code ,from template association_SetOneToMany */
  public boolean setPosition(Position aPosition)
  {
    boolean wasSet = false;
    if (aPosition == null)
    {
      return wasSet;
    }

    Position existingPosition = position;
    position = aPosition;
    if (existingPosition != null && !existingPosition.equals(aPosition))
    {
      existingPosition.removeBoard(this);
    }
    position.addBoard(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Position placeholderPosition = position;
    this.position = null;
    if(placeholderPosition != null)
    {
      placeholderPosition.removeBoard(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "turn" + ":" + getTurn()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "solution" + "=" + (getSolution() != null ? !getSolution().equals(this)  ? getSolution().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "position = "+(getPosition()!=null?Integer.toHexString(System.identityHashCode(getPosition())):"null");
  }
}
