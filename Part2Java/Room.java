
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