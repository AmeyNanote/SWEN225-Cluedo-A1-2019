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
  private List<Position> positions;
  private String roomType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Room(String type)
  {
    positions = new ArrayList<Position>();
    roomType = type;
  }

  //------------------------
  // INTERFACEString
  //------------------------
  /* Code from template attribute_SetMany */
  public String getName() {
	  return roomType;
  }

  public boolean addPosition(Position aPosition)
  {
    boolean wasAdded = false;
    wasAdded = positions.add(aPosition);
    return wasAdded;
  }

  public boolean removePosition(Position aPosition)
  {
    boolean wasRemoved = false;
    wasRemoved = positions.remove(aPosition);
    return wasRemoved;
  }
  /* Code from template attribute_GetMany */
  public Position getPosition(int index)
  {
    Position aPosition = positions.get(index);
    return aPosition;
  }

  public Position[] getPositions()
  {
    Position[] newPositions = positions.toArray(new Position[positions.size()]);
    return newPositions;
  }

  public int numberOfPositions()
  {
    int number = positions.size();
    return number;
  }

  public boolean hasPositions()
  {
    boolean has = positions.size() > 0;
    return has;
  }

  public int indexOfPosition(Position aPosition)
  {
    int index = positions.indexOf(aPosition);
    return index;
  }

  public void delete()
  {}


  public String toString()
  {
    return getName();
  }
}