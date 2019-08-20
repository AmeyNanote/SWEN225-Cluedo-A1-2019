
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
  public boolean addRoom(Room aRoom)
  {
    boolean wasAdded = false;
    wasAdded = rooms.add(aRoom);
    return wasAdded;
  }

  public List<Character> getChars()
  {
    return (ArrayList<Character>) chars;
  }

  public List<Item> getItems()
  {
    return items;
  }

  public List<Room> getRooms()
  {
    return rooms;
  }


  public String toString()
  {
    return super.toString() + "["+ "]";
  }
}