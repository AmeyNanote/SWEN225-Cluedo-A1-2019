/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/



// line 81 "model.ump"
public class Solution
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Solution Attributes
  private Character murderer;
  private Item weapon;
  private Room murderRoom;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Solution(Character aMurderer, Item aWeapon, Room aMurderRoom)
  {
    murderer = aMurderer;
    weapon = aWeapon;
    murderRoom = aMurderRoom;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMurderer(Character aMurderer)
  {
    boolean wasSet = false;
    murderer = aMurderer;
    wasSet = true;
    return wasSet;
  }

  public boolean setWeapon(Item aWeapon)
  {
    boolean wasSet = false;
    weapon = aWeapon;
    wasSet = true;
    return wasSet;
  }

  public boolean setMurderRoom(Room aMurderRoom)
  {
    boolean wasSet = false;
    murderRoom = aMurderRoom;
    wasSet = true;
    return wasSet;
  }

  /**
   * Who is the murderer
   */
  public Character getMurderer()
  {
    return murderer;
  }

  /**
   * What is the murder item
   */
  public Item getWeapon()
  {
    return weapon;
  }

  /**
   * What room did the murder take place
   */
  public Room getMurderRoom()
  {
    return murderRoom;
  }


  public String toString()
  {
    return this.getMurderer().getName() + " in the " + this.getMurderRoom().getName() + " with the " + this.getWeapon();
  }
}