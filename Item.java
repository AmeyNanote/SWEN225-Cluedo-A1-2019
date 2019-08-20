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

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Item(String aName )
  {
    name = aName;
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


  /**
   * Weapons
   * What the item is, wrench, pipe, etc.
   */
  public String getName()
  {
    return name;
  }

  public String toString()
  {
    return getName();
  }
}