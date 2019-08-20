import java.util.*;

public class Position
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private int x;
  private int y;
  private String type;

  //Position Associations

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Position(int aX, int aY, String aType)
  {
    x = aX;
    y = aY;
    type = aType;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setX(int aX)
  {
    boolean wasSet = false;
    x = aX;
    wasSet = true;
    return wasSet;
  }

  public boolean setY(int aY)
  {
    boolean wasSet = false;
    y = aY;
    wasSet = true;
    return wasSet;
  }

  public void setType(String aType)
  {
    type = aType;
  }

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }

  /**
   * This will define doors, walls, hallways, board edges etc.
   */
  public String getType()
  {
    return type;
  }

}