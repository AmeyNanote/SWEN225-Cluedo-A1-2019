/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/



// line 56 "model.ump"
public class Action
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Action Attributes
  private String type;
  private Character character;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Action(String aType, Character aCharacter)
  {
    type = aType;
    character = aCharacter;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setCharacter(Character aCharacter)
  {
    boolean wasSet = false;
    character = aCharacter;
    wasSet = true;
    return wasSet;
  }

  /**
   * Action to be made, move, accuse, etc.
   */
  public String getType()
  {
    return type;
  }

  /**
   * Who is making the action
   */
  public Character getCharacter()
  {
    return character;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "type" + ":" + getType()+ "," +
            "character" + ":" + getCharacter()+ "]";
  }
}