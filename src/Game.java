/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/



// line 2 "model.ump"
// line 92 "model.ump"
public class Game
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Game Attributes
  private Board board;
  private int gameStatus;
  private int players;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game(Board aBoard, int aGameStatus, int aPlayers)
  {
    board = aBoard;
    gameStatus = aGameStatus;
    players = aPlayers;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBoard(Board aBoard)
  {
    boolean wasSet = false;
    board = aBoard;
    wasSet = true;
    return wasSet;
  }

  public boolean setGameStatus(int aGameStatus)
  {
    boolean wasSet = false;
    gameStatus = aGameStatus;
    wasSet = true;
    return wasSet;
  }

  public boolean setPlayers(int aPlayers)
  {
    boolean wasSet = false;
    players = aPlayers;
    wasSet = true;
    return wasSet;
  }

  /**
   * The board that will be played on
   */
  public Board getBoard()
  {
    return board;
  }

  /**
   * 0 = no game, 1 = setup, 2 = playing
   */
  public int getGameStatus()
  {
    return gameStatus;
  }

  /**
   * Number of players maybe should be stored here
   */
  public int getPlayers()
  {
    return players;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "gameStatus" + ":" + getGameStatus()+ "," +
            "players" + ":" + getPlayers()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "board" + "=" + (getBoard() != null ? !getBoard().equals(this)  ? getBoard().toString().replaceAll("  ","    ") : "this" : "null");
  }
}