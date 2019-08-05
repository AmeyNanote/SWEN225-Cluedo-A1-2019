/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


// line 75 "model.ump"
public class Accusation {
  Room accusedRoom;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Accusation Attributes
  private Character accusedChar;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Accusation(Character aAccusedChar)
  {
    accusedChar = aAccusedChar;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAccusedChar(Character aAccusedChar)
  {
    boolean wasSet = false;
    accusedChar = aAccusedChar;
    wasSet = true;
    return wasSet;
  }

  /**
   * Which player is being accused
   */
  public Character getAccusedChar()
  {
    return accusedChar;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "accusedChar" + ":" + getAccusedChar()+ "]";
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 77 model.ump
  
}