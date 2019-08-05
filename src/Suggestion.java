/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/



// line 62 "model.ump"
// line 128 "model.ump"
public class Suggestion
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Suggestion Attributes
  private Character suggested;
  private Item suggestedItem;
  private Room currentCharacterRoom;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Suggestion(Character aSuggested, Item aSuggestedItem, Room aCurrentCharacterRoom)
  {
    suggested = aSuggested;
    suggestedItem = aSuggestedItem;
    currentCharacterRoom = aCurrentCharacterRoom;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSuggested(Character aSuggested)
  {
    boolean wasSet = false;
    suggested = aSuggested;
    wasSet = true;
    return wasSet;
  }

  public boolean setSuggestedItem(Item aSuggestedItem)
  {
    boolean wasSet = false;
    suggestedItem = aSuggestedItem;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentCharacterRoom(Room aCurrentCharacterRoom)
  {
    boolean wasSet = false;
    currentCharacterRoom = aCurrentCharacterRoom;
    wasSet = true;
    return wasSet;
  }

  /**
   * Char being suggested as murderer
   */
  public Character getSuggested()
  {
    return suggested;
  }

  /**
   * Item being suggested as murder weapon
   */
  public Item getSuggestedItem()
  {
    return suggestedItem;
  }

  /**
   * Knows what room the current player making suggestion is in
   */
  public Room getCurrentCharacterRoom()
  {
    return currentCharacterRoom;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "suggested" + ":" + getSuggested()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "suggestedItem" + "=" + (getSuggestedItem() != null ? !getSuggestedItem().equals(this)  ? getSuggestedItem().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "currentCharacterRoom" + "=" + (getCurrentCharacterRoom() != null ? !getCurrentCharacterRoom().equals(this)  ? getCurrentCharacterRoom().toString().replaceAll("  ","    ") : "this" : "null");
  }
}