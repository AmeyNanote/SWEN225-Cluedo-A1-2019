/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/



// line 68 "model.ump"
// line 133 "model.ump"
public class Refute
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Refute Attributes
  private Hand characterDefend;
  private Character accuser;
  private Solution solution;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Refute(Hand aCharacterDefend, Character aAccuser, Solution aSolution)
  {
    characterDefend = aCharacterDefend;
    accuser = aAccuser;
    solution = aSolution;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCharacterDefend(Hand aCharacterDefend)
  {
    boolean wasSet = false;
    characterDefend = aCharacterDefend;
    wasSet = true;
    return wasSet;
  }

  public boolean setAccuser(Character aAccuser)
  {
    boolean wasSet = false;
    accuser = aAccuser;
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

  /**
   * Character refuting by displayer card from their hand
   */
  public Hand getCharacterDefend()
  {
    return characterDefend;
  }

  /**
   * Who is making the accusation
   */
  public Character getAccuser()
  {
    return accuser;
  }

  public Solution getSolution()
  {
    return solution;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "accuser" + ":" + getAccuser()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "characterDefend" + "=" + (getCharacterDefend() != null ? !getCharacterDefend().equals(this)  ? getCharacterDefend().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "solution" + "=" + (getSolution() != null ? !getSolution().equals(this)  ? getSolution().toString().replaceAll("  ","    ") : "this" : "null");
  }
}