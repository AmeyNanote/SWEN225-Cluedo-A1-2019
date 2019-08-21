
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