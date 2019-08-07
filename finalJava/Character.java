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
  private Position playerPos;

  Clue clueUser = new Clue();

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Character(String aName, Room aCurrentRoom, Position aPlayerPos) {
    name = aName;
    cards = new ArrayList<Hand>();
    currentRoom = aCurrentRoom;
    playerPos = aPlayerPos;
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
  public boolean setPlayerPos(Position aPlayerPos)
  {
    boolean wasSet = false;
    playerPos = aPlayerPos;
    wasSet = true;
    return wasSet;
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

  /**
   * Where the player. For example [2. 4] or [24, 11]
   */
  public Position getPlayerPos()
  {
    return playerPos;
  }



  public String toString()
  {
    return getName();
  }
}