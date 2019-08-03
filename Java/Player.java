/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/

// line 118 "model.ump"
public class Player {

  //------------------------
  // MEMBER VARIABLES
  //------------------------
  //Their allocated character
  private String player;
  private String assignedChar;
  private boolean isMurderer;
  private boolean isTurn;
  private boolean isWinner;
  private String weaponName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(String playerChar, String assignedChar, boolean isMurderer, boolean isTurn, boolean isWinner, String weaponName){
     player = playerChar;
     this.assignedChar = assignedChar;
     this.isMurderer = isMurderer;
     this.isTurn = isTurn;
     this.isWinner = isWinner;
     this.weaponName = weaponName;
  }

  //------------------------
  // INTERFACE
  //------------------------
  public void delete(){}

  public String getWeaponName() {
        return weaponName;
  }
  public String getPlayer() {
      return player;
  }
  public String getAssignedChar() {
        return assignedChar;
  }
  public void setAssignedChar(String assignedChar) {
        this.assignedChar = assignedChar;
  }
  public void setPlayerChar(String playerChar){
      this.player = playerChar;
  }
  public void setMurderer(boolean isMurderer){
      this.isMurderer = isMurderer;
  }
  public void setTurn(boolean isTurn){
      this.isTurn = isTurn;
  }
  public void setWinner(boolean isWinner){
      this.isWinner = isWinner;
  }
  public void setWeapon(String weaponName){
      this.weaponName = weaponName;
  }


}