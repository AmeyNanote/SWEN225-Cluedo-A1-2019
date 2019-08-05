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
  private boolean isTurn;
  private boolean isWinner;
  private Position position;
  
  private ArrayList<String> items = new ArrayList<String>(Arrays.asList("Candlestick", "Dagger", "Lead Pipe", "Revolver", "Rope", "Spanner"));
  private ArrayList<String> rooms = new ArrayList<String>(Arrays.asList("Kitchen", "Ball Room", "Conseratory", "Billard Room", "Library", "Study", "Hall", "Lounge", "Dining Room"));
  private ArrayList<String> characters = new ArrayList<String>(Arrays.asList("Miss Scarlett", "Colonel Mustard", "Mrs. White", "Mr. Green", "Mrs. Peacock", "Professor Plum"));

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(String assignedChar, boolean isTurn, boolean isWinner, Position pos){
	 this.position = pos;
     this.assignedChar = assignedChar;
     this.isTurn = isTurn;
     this.isWinner = isWinner;

  }

  //------------------------
  // INTERFACE
  //------------------------
  public void delete(){}
  
  public Hand getHand() {
	  	return hand;
  }
  
  public int getDiceRoll() {
	  diceRoll =  ((int)(Math.random() * 6 + 1) + (int)(Math.random() * 6 + 1));
	  return diceRoll;
  }
  public String getAssignedChar() {
        return assignedChar;
  }
  public void setAssignedChar(String assignedChar) {
        this.assignedChar = assignedChar;
  }
  public void setTurn(boolean isTurn){
      this.isTurn = isTurn;
  }
  public void setWinner(boolean isWinner){
      this.isWinner = isWinner;
  }
  public Position getPos() {
	  return position;
  }
  
  public void setPos(Position newPos) {
	  position = newPos;
  }
  
  public boolean addCard(String card)
  {
    boolean wasAdded = false;
    if (characters.contains(card)) {
    	Character character = new Character(card, null, null);
        wasAdded = hand.addChar(character);
    }
    else if (items.contains(card)) {
    	Item item = new Item(card, null);
    	wasAdded = hand.addItem(item);
    }
    else if (rooms.contains(card)) {
    	Room room = new Room(card);
    	wasAdded = hand.addRoom(room);
    }
    return wasAdded;
  }

}