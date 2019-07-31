/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.util.*;

// line 9 "model.ump"
// line 107 "model.ump"
public class Board
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Board Attributes
  private List<Position> squares;
  private List<Character> chars;
  private int turn;
  private Solution solution;

  //Board Associations
  private Position position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Board(int aTurn, Solution aSolution, Position aPosition)
  {
    squares = new ArrayList<Position>();
    chars = new ArrayList<Character>();
    turn = aTurn;
    solution = aSolution;
    boolean didAddPosition = setPosition(aPosition);
    if (!didAddPosition)
    {
      throw new RuntimeException("Unable to create board due to position. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template attribute_SetMany */
  public boolean addSquare(Position aSquare)
  {
    boolean wasAdded = false;
    wasAdded = squares.add(aSquare);
    return wasAdded;
  }

  public boolean removeSquare(Position aSquare)
  {
    boolean wasRemoved = false;
    wasRemoved = squares.remove(aSquare);
    return wasRemoved;
  }
  /* Code from template attribute_SetMany */
  public boolean addChar(Character aChar)
  {
    boolean wasAdded = false;
    wasAdded = chars.add(aChar);
    return wasAdded;
  }

  public boolean removeChar(Character aChar)
  {
    boolean wasRemoved = false;
    wasRemoved = chars.remove(aChar);
    return wasRemoved;
  }

  public boolean setTurn(int aTurn)
  {
    boolean wasSet = false;
    turn = aTurn;
    wasSet = true;
    return wasSet;
  }

  public boolean setSolution(Solution aSolution)
  {
    boolean wasSet = false;
    solution = aSolution;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_GetMany */
  public Position getSquare(int index)
  {
    Position aSquare = squares.get(index);
    return aSquare;
  }

  public Position[] getSquares()
  {
    Position[] newSquares = squares.toArray(new Position[squares.size()]);
    return newSquares;
  }

  public int numberOfSquares()
  {
    int number = squares.size();
    return number;
  }

  public boolean hasSquares()
  {
    boolean has = squares.size() > 0;
    return has;
  }

  public int indexOfSquare(Position aSquare)
  {
    int index = squares.indexOf(aSquare);
    return index;
  }
  /* Code from template attribute_GetMany */
  public Character getChar(int index)
  {
    Character aChar = chars.get(index);
    return aChar;
  }

  public Character[] getChars()
  {
    Character[] newChars = chars.toArray(new Character[chars.size()]);
    return newChars;
  }

  public int numberOfChars()
  {
    int number = chars.size();
    return number;
  }

  public boolean hasChars()
  {
    boolean has = chars.size() > 0;
    return has;
  }

  public int indexOfChar(Character aChar)
  {
    int index = chars.indexOf(aChar);
    return index;
  }

  /**
   * Current turn
   */
  public int getTurn()
  {
    return turn;
  }

  /**
   * The pre-choosen solution to who is the murdere
   */
  public Solution getSolution()
  {
    return solution;
  }
  /* Code from template association_GetOne */
  public Position getPosition()
  {
    return position;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPosition(Position aPosition)
  {
    boolean wasSet = false;
    if (aPosition == null)
    {
      return wasSet;
    }

    Position existingPosition = position;
    position = aPosition;
    if (existingPosition != null && !existingPosition.equals(aPosition))
    {
      existingPosition.removeBoard(this);
    }
    position.addBoard(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Position placeholderPosition = position;
    this.position = null;
    if(placeholderPosition != null)
    {
      placeholderPosition.removeBoard(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "turn" + ":" + getTurn()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "solution" + "=" + (getSolution() != null ? !getSolution().equals(this)  ? getSolution().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "position = "+(getPosition()!=null?Integer.toHexString(System.identityHashCode(getPosition())):"null");
  }
}