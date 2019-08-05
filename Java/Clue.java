/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4597.b7ac3a910 modeling language!*/


import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

// line 123 "model.ump"
public class Clue {
  public int playerCount;
//  public ArrayList<String> playables = new ArrayList<>();
  //Hashmaps Key = Player actual name and Value = Player Assigned Name!
//  public HashMap<String, String> playerAssigns = new HashMap<>();

  public Solution solution;
  public ArrayList<Player> players = new ArrayList<Player>();
  public ArrayList<String> abrRooms = new ArrayList<String>(Arrays.asList("ki", "ba", "co", "bi", "li", "st", "ha", "lo", "di"));
  public ArrayList<String> items = new ArrayList<String>(Arrays.asList("Candlestick", "Dagger", "Lead Pipe", "Revolver", "Rope", "Spanner"));
  public ArrayList<String> rooms = new ArrayList<String>(Arrays.asList("Kitchen", "Ball Room", "Conseratory", "Billard Room", "Library", "Study", "Hall", "Lounge", "Dining Room"));
  public ArrayList<String> characters = new ArrayList<String>(Arrays.asList("Miss Scarlett", "Colonel Mustard", "Mrs. White", "Mr. Green", "Mrs. Peacock", "Professor Plum"));
  public Board board = new Board();

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
    cInstance.assignSolution();
    cInstance.startClue();
    cInstance.assignPlayerHands();
    //cInstance.playMaker().toString();
    cInstance.playerTurns();
  }

  //------------------------
  // INTERFACE
  //------------------------


  /**
   * Player count and player assignment is not randomized this is an assumed choice since,
   * there are no such rules which say that the players have to be randmly assigned
   * Players are being assigned.
   */
  private void startClue(){
    System.out.println("Welcome to the Cluedo game!");
    System.out.println("How many players?");

    ArrayList<String> noPlayers = new ArrayList<String>(Arrays.asList("3", "4", "5", "6"));

    Scanner userIn = new Scanner(System.in);
	String playerCountInput = userIn.next();

	// This loop does not let the setup end until they input acceptable number of players
    while (!noPlayers.contains(playerCountInput)) {
        System.out.print("There can only be 3 to 6 players in a game. Try Again!\n");
    	playerCountInput =  userIn.next();
    }
    playerCount = noPlayers.indexOf(playerCountInput) + 3;
    System.out.println("So " + playerCount + " players in the game...");

    // This loop creates each player instance and assigns it a character so player 1 is always Scarlette and 2 Colonel Mustard etc.
    // Players no longer get to pick there names, not important basic game function
    Position initialPosition[] = {new Position(7, 24, "MS"), new Position(0, 17, "CM"), new Position(9, 0, "MW"), new Position(14, 0, "MG"), new Position(23, 5, "MP"), new Position(23, 19, "PP")};
    for(int i = 1; i < playerCount + 1; i++){
		Player newPlayer = new Player((String) characters.get(i - 1), false, false, initialPosition[i - 1]);
		players.add(newPlayer);
		System.out.println("Player " + i + " is " + characters.get(i - 1));
    }
	System.out.println();



  }

  public void assignPlayerHands() {
	  /** Create each hand for each player **/

	    ArrayList<String> shuffledCards = new ArrayList<String>();
	    shuffledCards.addAll(characters);
	    shuffledCards.addAll(items);
	    shuffledCards.addAll(rooms);

	    shuffledCards.remove(shuffledCards.indexOf(solution.getMurderer().getName()));
	    shuffledCards.remove(shuffledCards.indexOf(solution.getMurderRoom().getName()));
	    shuffledCards.remove(shuffledCards.indexOf(solution.getWeapon().getName()));

	    Collections.shuffle(shuffledCards);
	    //System.out.println(shuffledCards);

	    int cardCount = 0;
	    while (cardCount < 18) {
	    	for (int j = 0; j < playerCount; j++) {
	    		if (cardCount < 18) {
		    		players.get(j).addCard(shuffledCards.get(cardCount));
		    		cardCount++;
	    		}
	    		else {
	    			break;
	    		}
	    	}
	    }

	    for (Player p: players) {
	    	System.out.println(p.getAssignedChar() + " has the following cards: ");
	    	System.out.println("Characters: " + p.getHand().getChars());
	    	System.out.println("Items: " + p.getHand().getItems());
	    	System.out.println("Rooms: " + p.getHand().getRooms());
	    	System.out.println();
	    }
  }

  /**
   * Before the game is set up the solution is assigned and a new Solution instacne is made.
   * @return
   */

  public Solution assignSolution() {
	  System.out.println("Creating Cluedo Solution... ");
	  int randomChar = (int) (Math.random() * 6);
	  Character character = new Character(characters.get(randomChar), null, null);

	  int randomItem = (int) (Math.random() * 6);
	  Item item = new Item(items.get(randomItem), new Position(0, 0, "IT"));

	  int randomRoom = (int) (Math.random() * 9);
	  Room room = new Room(rooms.get(randomRoom));

	  solution = new Solution(character, item, room);
	  System.out.println("The murderer is: " + solution.getMurderer().getName());
	  System.out.println("The murder weapon is: " + solution.getWeapon().getName());
	  System.out.println("The murder room is: " + solution.getMurderRoom().getName());

	  System.out.println("Solution done... ");
	  return solution;
  }

  public void playerTurns() {
	  Scanner userIn = new Scanner(System.in);
	  boolean endGame = false;
	  
	  int currentTurn = 1;
	  
	  outerloop:
	  while (!endGame) {
		
		  board.updateBoard(players);
		  System.out.println("Turn: " + currentTurn);
	
		  innerloop:
		  for (int s = 0; s < players.size(); s++) {
			  Player p = players.get(s);
			  int moves = p.getDiceRoll();
			  System.out.println("Player " + (players.indexOf(p) + 1) + " " + p.getPos().getType() + " has rolled a " + moves);
	
			  for (int m = 0; m < moves; m++) {
				  ArrayList<String> availableMoves = (ArrayList) p.getActions(board);
				  System.out.println("You have " + (moves - m) + " left");
				  System.out.println("Which action do you want to take? " + availableMoves);
				  String action = userIn.next();
	
	
				  // Player ends turn this was an assumption if the player does not want to do anything else
				  if (action.equals("End")) {
					  break;
				  }
	
				  else if (!availableMoves.contains(action)) {
					  System.out.println("Invalid move type");
					  m--;
				  }
				  else if (action.equals("North")){
					  p.getPos().setY(p.getPos().getY() - 1);
					  board.updateBoard(players);
					  p.setRoom(board);
	
				  }
				  else if (action.equals("South")){
					  p.getPos().setY(p.getPos().getY() + 1);
					  board.updateBoard(players);
					  p.setRoom(board);
	
				  }
				  else if (action.equals("East")){
					  p.getPos().setX(p.getPos().getX() + 1);
					  board.updateBoard(players);
					  p.setRoom(board);
	
				  }
				  else if (action.equals("West")){
					  p.getPos().setX(p.getPos().getX() - 1);
					  board.updateBoard(players);
					  p.setRoom(board);
				  }
	
				  else if (action.equals("Accuse")) {
					  System.out.println();
					  System.out.println("Currently in room " + rooms.get(abrRooms.indexOf(p.getRoom())));
					  ArrayList<String> tempChars = characters;
					  ArrayList<String> tempItems = items;
					  
					// Potential Weapons to accuse
					  for (Item i: p.getHand().getItems()) {
						  if (items.contains(i.getName())){
							  tempItems.remove(i.getName());
						  }
					  }
	
					  // Potential People to accuse, including your own character
					  // This method removes the cards in your hand
					  for (Character c: p.getHand().getChars()) {
						  if (characters.contains(c.getName())){
							  tempChars.remove(c.getName());
						  }
					  }
					  
					  System.out.println("Who would you like to accuse?");
					  System.out.println(tempChars);
					  String accused = readString();
	
					  while (!characters.contains(accused)) {
						  System.out.println("Please pick a valid name. Try again");
						  accused = readString();
					  }
					  System.out.println();
					  
					  System.out.println("What weapon did the murderer use?");
					  System.out.println(tempItems);
					  String weapon = readString();
	
					  while (!items.contains(weapon)) {
						  System.out.println("Please pick a valid weapon. Try again");
						  weapon = readString();
					  }
					  System.out.println();
					  
					  
					  if (solution.getMurderer().getName().equals(accused) 
						  && solution.getMurderRoom().getName().equals(p.getRoom())
						  && solution.getWeapon().getName().equals(weapon)){
						  System.out.println("You are correct, the solution is: " + solution.toString());	
						  System.out.println("The game is now over");
						  endGame = true;
						  break outerloop;
					  }
					  else {
						  System.out.println("You were wrong, the solution is: " + solution.toString());
						  System.out.println("You have now been removed form the game, thank you for playing");
						  p.setIsOut(true);
						  break innerloop;
					  }
				  }
			  }
			  
		  }

		  
	  }
	  
	  

  }

  public String readString()
  {
      Scanner sc = new Scanner(System.in);
      return sc.nextLine();
  } 

  // Makes a new Player and adds it to an arraylist. Here we can return the arrayList.
//  public ArrayList<Player> playMaker(){
//    ArrayList<Player> playerInstances = new ArrayList<>();
//    //ArrayLists are easiest to work with. Filler name added so that it increments every time properly!
//    playables.add("Filler"); playables.add("Miss Scarlet"); playables.add("Colonel Mustard");  playables.add("Mrs. White");  playables.add("Mr. Green");  playables.add("Mrs. Peacock"); playables.add("Professor Plum");
//
//    for(String player: playerAssigns.keySet()) {
//        for (int x = 0; x < playables.size(); x++) {
//            playerAssigns.put(player, playables.get(x));
//            playables.remove(x);
//
//            System.out.println(player + " just got assigned " + playables.get(x));
//
//            break;
//        }
//    }

//    for(int i=0; i<playerCount+1; i++){
//
//      System.out.println(playerAssigns.keySet().toString());
//
//      playerInstances.add(newPlayer);
//    }
//
//    return playerInstances;
//  }
}
