/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.util.*;

// line 25 "model.ump"
// line 97 "model.ump"
public class Character {

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Character Attributes
  private String name;
  private boolean isMurderer;
  private List<Hand> cards;
  private Room currentRoom;
  private List<Action> actions;
  private Position playerPos;
  private List<Position> prevPositions;

  Clue clueUser = new Clue();

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Character(String aName, Room aCurrentRoom, Position aPlayerPos) {
    name = aName;
    cards = new ArrayList<Hand>();
    currentRoom = aCurrentRoom;
    actions = new ArrayList<Action>();
    playerPos = aPlayerPos;
    prevPositions = new ArrayList<Position>();
  }

//  private String isMurderer(){
//    String murderer;
//    Random generator = new Random();
//    Object[] values = clueUser.playerAssigns.values().toArray();
//    murderer = (String) values[generator.nextInt(values.length)];
//    return murderer;
//  }
//  public boolean aIsMurderer(){
//
//  }



  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  /* Code from template attribute_SetMany */
  public boolean addCard(Hand aCard)
  {
    boolean wasAdded = false;
    wasAdded = cards.add(aCard);
    return wasAdded;
  }

  public boolean removeCard(Hand aCard)
  {
    boolean wasRemoved = false;
    wasRemoved = cards.remove(aCard);
    return wasRemoved;
  }

  public boolean setCurrentRoom(Room aCurrentRoom)
  {
    boolean wasSet = false;
    currentRoom = aCurrentRoom;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetMany */
  public boolean addAction(Action aAction)
  {
    boolean wasAdded = false;
    wasAdded = actions.add(aAction);
    return wasAdded;
  }

  public boolean removeAction(Action aAction)
  {
    boolean wasRemoved = false;
    wasRemoved = actions.remove(aAction);
    return wasRemoved;
  }

  public boolean setPlayerPos(Position aPlayerPos)
  {
    boolean wasSet = false;
    playerPos = aPlayerPos;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetMany */
  public boolean addPrevPosition(Position aPrevPosition)
  {
    boolean wasAdded = false;
    wasAdded = prevPositions.add(aPrevPosition);
    return wasAdded;
  }

  public boolean removePrevPosition(Position aPrevPosition)
  {
    boolean wasRemoved = false;
    wasRemoved = prevPositions.remove(aPrevPosition);
    return wasRemoved;
  }

  /**
   * Char name
   */
  public String getName()
  {
    return name;
  }

  /**
   * true or false
   */
  public boolean getIsMurderer()
  {
    return isMurderer;
  }
  /* Code from template attribute_GetMany */
  public Hand getCard(int index)
  {
    Hand aCard = cards.get(index);
    return aCard;
  }

  public Hand[] getCards()
  {
    Hand[] newCards = cards.toArray(new Hand[cards.size()]);
    return newCards;
  }

  public int numberOfCards()
  {
    int number = cards.size();
    return number;
  }

  public boolean hasCards()
  {
    boolean has = cards.size() > 0;
    return has;
  }

  public int indexOfCard(Hand aCard)
  {
    int index = cards.indexOf(aCard);
    return index;
  }

  /**
   * The room the player is in based on their position
   */
  public Room getCurrentRoom()
  {
    return currentRoom;
  }
  /* Code from template attribute_GetMany */
  public Action getAction(int index)
  {
    Action aAction = actions.get(index);
    return aAction;
  }

  public Action[] getActions()
  {
    Action[] newActions = actions.toArray(new Action[actions.size()]);
    return newActions;
  }

  public int numberOfActions()
  {
    int number = actions.size();
    return number;
  }

  public boolean hasActions()
  {
    boolean has = actions.size() > 0;
    return has;
  }

  public int indexOfAction(Action aAction)
  {
    int index = actions.indexOf(aAction);
    return index;
  }

  /**
   * Where the player. For example [2. 4] or [24, 11]
   */
  public Position getPlayerPos()
  {
    return playerPos;
  }
  /* Code from template attribute_GetMany */
  public Position getPrevPosition(int index)
  {
    Position aPrevPosition = prevPositions.get(index);
    return aPrevPosition;
  }

  public Position[] getPrevPositions()
  {
    Position[] newPrevPositions = prevPositions.toArray(new Position[prevPositions.size()]);
    return newPrevPositions;
  }

  public int numberOfPrevPositions()
  {
    int number = prevPositions.size();
    return number;
  }

  public boolean hasPrevPositions()
  {
    boolean has = prevPositions.size() > 0;
    return has;
  }

  public int indexOfPrevPosition(Position aPrevPosition)
  {
    int index = prevPositions.indexOf(aPrevPosition);
    return index;
  }

  public void delete()
  {}


  public String toString()
  {
    return getName();
  }
}