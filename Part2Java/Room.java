/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.util.*;

// line 50 "model.ump"
public class Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Room Attributes
  private String roomType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Room(String type)
  {
    roomType = type;
  }

  //------------------------
  // INTERFACEString
  //------------------------
  /* Code from template attribute_SetMany */
  public String getName() {
	  return roomType;
  }

  public String toString()
  {
    return getName();
  }
}