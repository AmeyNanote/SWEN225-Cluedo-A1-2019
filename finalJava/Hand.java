
import java.util.*;

public class Hand
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Hand Attributes
  private List<Character> chars;
  private List<Item> items;
  private List<Room> rooms;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Hand()
  {
    chars = new ArrayList<Character>();
    items = new ArrayList<Item>();
    rooms = new ArrayList<Room>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template attribute_SetMany */
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
  /* Code from template attribute_SetMany */
  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    wasAdded = items.add(aItem);
    return wasAdded;
  }

  public boolean removeItem(Item aItem)
  {
    boolean wasRemoved = false;
    wasRemoved = items.remove(aItem);
    return wasRemoved;
  }
  /* Code from template attribute_SetMany */
  public boolean addRoom(Room aRoom)
  {
    boolean wasAdded = false;
    wasAdded = rooms.add(aRoom);
    return wasAdded;
  }

  public boolean removeRoom(Room aRoom)
  {
    boolean wasRemoved = false;
    wasRemoved = rooms.remove(aRoom);
    return wasRemoved;
  }
  /* Code from template attribute_GetMany */
  public Character getChar(int index)
  {
    Character aChar = chars.get(index);
    return aChar;
  }

  public List<Character> getChars()
  {
    return (ArrayList<Character>) chars;
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
  /* Code from template attribute_GetMany */
  public Item getItem(int index)
  {
    Item aItem = items.get(index);
    return aItem;
  }

  public List<Item> getItems()
  {
    return items;
  }

  public int numberOfItems()
  {
    int number = items.size();
    return number;
  }

  public boolean hasItems()
  {
    boolean has = items.size() > 0;
    return has;
  }

  public int indexOfItem(Item aItem)
  {
    int index = items.indexOf(aItem);
    return index;
  }
  /* Code from template attribute_GetMany */
  public Room getRoom(int index)
  {
    Room aRoom = rooms.get(index);
    return aRoom;
  }

  public List<Room> getRooms()
  {
    return rooms;
  }

  public int numberOfRooms()
  {
    int number = rooms.size();
    return number;
  }

  public boolean hasRooms()
  {
    boolean has = rooms.size() > 0;
    return has;
  }

  public int indexOfRoom(Room aRoom)
  {
    int index = rooms.indexOf(aRoom);
    return index;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+ "]";
  }
}