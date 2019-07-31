/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/



// line 44 "model.ump"
public class Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Item Attributes
  private String name;
  private Position itemPos;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Item(String aName, Position aItemPos)
  {
    name = aName;
    itemPos = aItemPos;
  }

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

  public boolean setItemPos(Position aItemPos)
  {
    boolean wasSet = false;
    itemPos = aItemPos;
    wasSet = true;
    return wasSet;
  }

  /**
   * Weapons
   * What the item is, wrench, pipe, etc.
   */
  public String getName()
  {
    return name;
  }

  /**
   * Where item is on the board
   */
  public Position getItemPos()
  {
    return itemPos;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "itemPos" + "=" + (getItemPos() != null ? !getItemPos().equals(this)  ? getItemPos().toString().replaceAll("  ","    ") : "this" : "null");
  }
}