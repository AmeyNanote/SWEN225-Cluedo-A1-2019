/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// line 123 "model.ump"
public class Clue {
  public int playerCount;
  public ArrayList<String> playables = new ArrayList<>();
  //Hashmaps Key = Player actual name and Value = Player Assigned Name!
  public HashMap<String, String> playerAssigns = new HashMap<>();
  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Clue(){

  }

  public static void main(String[] args){
    Clue cInstance = new Clue();
    cInstance.startClue();
    cInstance.playMaker().toString();
  }

  //------------------------
  // INTERFACE
  //------------------------

  private void startClue(){
    Scanner userIn = new Scanner(System.in);
    System.out.printf("Welcome to the Cluedo game! How many players will be playing? : \n");
    playerCount =  userIn.nextInt();
    if(playerCount >= 3 && playerCount <= 6){
      System.out.println("So " + playerCount + " will play the game...");
      for(int i=1; i<playerCount+1; i++){
        System.out.println("Who's player " + i);
        String name = userIn.next();
        //If the name of the player is blank or less then put the name in the hashmap which assigns the player.
        if(!name.isBlank() && name.length() > 1){
          playerAssigns.put(name, null);
          System.out.println(name + " added!");
        } else {
          System.out.println("To be a valid name it shouldn't be blank and have more than 1 letter!");
          System.out.println("Game over. Miss me with that troll plz!");
          break;
        }
      }
    } else {
      System.out.printf("There can only be 3 to 6 players in a game. Try Again!\n");
      startClue();
    }
  }

  // Makes a new Player and adds it to an arraylist. Here we can return the arrayList.
  public ArrayList<Player> playMaker(){
    ArrayList<Player> playerInstances = new ArrayList<>();
    //ArrayLists are easiest to work with. Filler name added so that it increments every time properly!
    playables.add("Filler"); playables.add("Miss Scarlet"); playables.add("Professor Plum");  playables.add("Mr. Green");  playables.add("Mrs. White");  playables.add("Colonel Mustard"); playables.add("Mrs. Peacock");
    for(String player: playerAssigns.keySet()) {
        for (int x = 0; x < playables.size(); x++) {
            playerAssigns.put(player, playables.get(x));
            playables.remove(x);
            System.out.println(player + " just got assigned " + playables.get(x));
            break;
        }
    }
    for(int i=0; i<playerCount+1; i++){
      Player newPlayer = new Player(playerAssigns.keySet().toString(), playerAssigns.values().toString(), false, false, false, null);
      playerInstances.add(newPlayer);
    }
    return playerInstances;
  }

  public void delete(){

  }

}