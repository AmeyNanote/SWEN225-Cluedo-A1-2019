import java.util.*;

public class Position
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private int x;
  private int y;
  private String characterString;
  private String type;

  //Position Associations
  private List<Board> boards;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Position(int aX, int aY, String aType)
  {
    x = aX;
    y = aY;
    type = aType;
    boards = new ArrayList<Board>();
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

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
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
  /* Code from template association_GetMany */
  public Board getBoard(int index)
  {
    Board aBoard = boards.get(index);
    return aBoard;
  }

  public List<Board> getBoards()
  {
    List<Board> newBoards = Collections.unmodifiableList(boards);
    return newBoards;
  }

  public int numberOfBoards()
  {
    int number = boards.size();
    return number;
  }

  public boolean hasBoards()
  {
    boolean has = boards.size() > 0;
    return has;
  }

  public int indexOfBoard(Board aBoard)
  {
    int index = boards.indexOf(aBoard);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBoards()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Board addBoard(int aTurn, Solution aSolution)
  {
    return new Board();
  }

  public boolean addBoard(Board aBoard)
  {
    boolean wasAdded = false;
    if (boards.contains(aBoard)) { return false; }
    Position existingPosition = aBoard.getPosition();
    boolean isNewPosition = existingPosition != null && !this.equals(existingPosition);
    if (isNewPosition)
    {
      aBoard.setPosition(this);
    }
    else
    {
      boards.add(aBoard);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBoard(Board aBoard)
  {
    boolean wasRemoved = false;
    //Unable to remove aBoard, as it must always have a position
    if (!this.equals(aBoard.getPosition()))
    {
      boards.remove(aBoard);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBoardAt(Board aBoard, int index)
  {
    boolean wasAdded = false;
    if(addBoard(aBoard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBoards()) { index = numberOfBoards() - 1; }
      boards.remove(aBoard);
      boards.add(index, aBoard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBoardAt(Board aBoard, int index)
  {
    boolean wasAdded = false;
    if(boards.contains(aBoard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBoards()) { index = numberOfBoards() - 1; }
      boards.remove(aBoard);
      boards.add(index, aBoard);
      wasAdded = true;
    }
    else
    {
      wasAdded = addBoardAt(aBoard, index);
    }
    return wasAdded;
  }



  public String toString()
  {
    return super.toString() + "["+
            "x" + ":" + getX()+ "," +
            "y" + ":" + getY()+ "," +
            "type" + ":" + getType()+ "]";
  }
}