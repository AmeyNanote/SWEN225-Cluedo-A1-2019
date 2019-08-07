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

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Character(String aName) {
    name = aName;
  }

  //------------------------
  // INTERFACE
  //------------------------


  /**
   * Char name
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