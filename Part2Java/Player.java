import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/

// line 118 "model.ump"
public class Player {

  //------------------------
  // MEMBER VARIABLES
  //------------------------
  //Their allocated character
  private String assignedChar;
  public Hand hand = new Hand();
  private int diceRoll;
  private String currentRoom;
  private Position position;
  private boolean isOut;
  private Color playerColor;
  private String targetItem;
  private String targetCharacter;
  private String playerName;
  private int moves;
  public boolean actionMade;

  private ArrayList<String> actions = new ArrayList<String>();
  public ArrayList<String> invalidSquares = new ArrayList<String>(Arrays.asList("MS", "CM", "MW", "PP", "XX", "MP", "MG"));
  public ArrayList<String> abrRooms = new ArrayList<String>(Arrays.asList("ki", "ba", "co", "bi", "li", "st", "ha", "lo", "di"));
  private ArrayList<String> items = new ArrayList<String>(Arrays.asList("Candlestick", "Dagger", "Lead Pipe", "Revolver", "Rope", "Spanner"));
  private ArrayList<String> rooms = new ArrayList<String>(Arrays.asList("Kitchen", "Ball Room", "Conseratory", "Billard Room", "Library", "Study", "Hall", "Lounge", "Dining Room"));
  private ArrayList<String> characters = new ArrayList<String>(Arrays.asList("Miss Scarlett", "Colonel Mustard", "Mrs. White", "Mr. Green", "Mrs. Peacock", "Professor Plum"));

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(String assignedChar, Position pos, Color col){
	 this.position = pos;
     this.assignedChar = assignedChar;
     this.isOut = false;
     this.playerColor = col;

  }

  //------------------------
  // INTERFACE
  //------------------------
  public void delete(){}

  public Hand getHand() {
	  	return hand;
  }
  public List<String> getActions(Board b) {
	  actions.clear();

	  if (this.getPos().getX() - 1 > 0 && !invalidSquares.contains(b.boardASCII[this.getPos().getX() - 1][this.getPos().getY()])) {
		  actions.add("West");
	  }

	  if (this.getPos().getX() + 1 < 24 && !invalidSquares.contains(b.boardASCII[this.getPos().getX() + 1][this.getPos().getY()])) {
		  actions.add("East");
	  }

	  if (this.getPos().getY() - 1 > 0 && !invalidSquares.contains(b.boardASCII[this.getPos().getX()][this.getPos().getY() - 1])) {
		  actions.add("North");
	  }

	  if (this.getPos().getY() + 1 < 25 && !invalidSquares.contains(b.boardASCII[this.getPos().getX()][this.getPos().getY() + 1])) {
		  actions.add("South");
	  }
	  if (abrRooms.contains(this.getRoom())) {
		  actions.add("Accuse");
		  actions.add("Suggest");
	  }
	  actions.add("End");

	  return actions;
  }

  public void setRoom(Board b) {
	// Finds the room the player is in and stores it
	  for (Position s: b.boardPositions) {
		  if (this.getPos().getX() == (s.getX()) && this.getPos().getY() == (s.getY())) {
			 currentRoom = s.getType();
		  }
	  }
  }

  public void setIsOut(boolean b) {
	  isOut = b;
  }

  public boolean getIsOut() {
	  return isOut;
  }

  public void setPlayerName(String s) {
	  playerName = s;
  }

  public String getPlayerName() {
	  return playerName.toUpperCase();
  }

  public String getRoom() {
	  return currentRoom;
  }

  public String getFullRoom() {
	  return rooms.get(abrRooms.indexOf((currentRoom)));
  }

  public int getDiceRoll() {
	  return diceRoll;
  }

  public void setDiceRoll() {
	  diceRoll =  ((int)(Math.random() * 6 + 1) + (int)(Math.random() * 6 + 1));
  }

  public void setMoves(int m) {
	  moves = m;
  }

  public int getMoves() {
	  return moves;
  }

  public String getAssignedChar() {
        return assignedChar;
  }
  public void setAssignedChar(String assignedChar) {
        this.assignedChar = assignedChar;
  }

  public Position getPos() {
	  return position;
  }

  public void setPos(Position newPos) {
	  position = newPos;
  }

  public Color getColor() {
	  return playerColor;
  }
  public int getPlayerNum() {
	  return characters.indexOf(this.getAssignedChar());
  }

  public ArrayList<String> getGuessableChars(){
	  ArrayList<String> tempAccuseItems = new ArrayList<String>(items);

		// Potential Weapons to accuse
		for (Item i: this.getHand().getItems()) {
			if (items.contains(i.getName())){
				tempAccuseItems.remove(i.getName());
			}
		}
		return tempAccuseItems;
  }

  public ArrayList<String> getGuessableItems(){
	ArrayList<String> tempAccuseChars = new ArrayList<String>(characters);

	// Potential People to accuse, including your own character
	for (Character c: this.getHand().getChars()) {
		if (characters.contains(c.getName())){
			tempAccuseChars.remove(c.getName());
		}
	}
	return tempAccuseChars;

  }

  public void setTargetItem(String i) {
	  targetItem = i;
  }

  public String getTargetItem() {
	  return targetItem;
  }

  public void setTargetChar(String ch) {
	  targetCharacter = ch;
  }

  public String getTargetChar() {
	  return targetCharacter;
  }

  public boolean addCard(String card)
  {
    boolean wasAdded = false;
    if (characters.contains(card)) {
    	Character character = new Character(card);
        wasAdded = hand.addChar(character);
    }
    else if (items.contains(card)) {
    	Item item = new Item(card);
    	wasAdded = hand.addItem(item);
    }
    else if (rooms.contains(card)) {
    	Room room = new Room(card);
    	wasAdded = hand.addRoom(room);
    }
    return wasAdded;
  }


}