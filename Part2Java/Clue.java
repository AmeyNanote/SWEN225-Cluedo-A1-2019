
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Clue {
	public int playerCount;

	public static Solution solution;
	public ArrayList<Player> players = new ArrayList<Player>();
	public ArrayList<Color> playerColors = new ArrayList<Color>(Arrays.asList(Color.red.brighter(), Color.yellow, Color.white, Color.green, Color.cyan, Color.magenta));
	public ArrayList<String> abrRooms = new ArrayList<String>(Arrays.asList("ki", "ba", "co", "bi", "li", "st", "ha", "lo", "di"));
	public ArrayList<String> items = new ArrayList<String>(Arrays.asList("Candlestick", "Dagger", "Lead Pipe", "Revolver", "Rope", "Spanner"));
	public ArrayList<String> rooms = new ArrayList<String>(Arrays.asList("Kitchen", "Ball Room", "Conseratory", "Billard Room", "Library", "Study", "Hall", "Lounge", "Dining Room"));
	public ArrayList<String> characters = new ArrayList<String>(Arrays.asList("Miss Scarlett", "Colonel Mustard", "Mrs. White", "Mr. Green", "Mrs. Peacock", "Professor Plum"));
	public static Board board;
	public GUI gui = new GUI();

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Clue(){

	}

	public static void main(String[] args){
		while (true) {
			Clue cInstance = new Clue();
			cInstance.assignSolution();
			board = new Board(solution);
			cInstance.startClue();
			cInstance.assignPlayerHands();
			//cInstance.playMaker().toString();
			cInstance.playerTurns();
			board.setRestart(false);
		}

	}

	//------------------------
	// INTERFACE
	//------------------------


	/**
	 * Player count and player assignment is not randomized this is an assumed choice since,
	 * there are no such rules which say that the players have to be randmly assigned
	 * Players are being assigned.
	 */
	private void startClue() {
		gui.setupGUI();
		gui.displayGUI();

		// This loop creates each player instance and assigns it a character so player 1 is always Scarlette and 2 Colonel Mustard etc.
		// Players no longer get to pick there names, not important basic game function
		while (playerCount < 3 || playerCount > 6) {
			playerCount = gui.gameSetup.getPlayerCount();
		}

		Position initialPosition[] = {new Position(7, 24, "MS"), new Position(0, 17, "CM"), new Position(9, 0, "MW"), new Position(14, 0, "MG"), new Position(23, 6, "MP"), new Position(23, 19, "PP")};
		for(int i = 1; i < playerCount + 1; i++){
			Player newPlayer = new Player((String) characters.get(i - 1), initialPosition[i - 1], playerColors.get(i - 1));
			players.add(newPlayer);
			//System.out.println("Player " + i + " is " + characters.get(i - 1));
			newPlayer.setPlayerName(gui.gameSetup.getPlayerNames().get(i - 1));
		}
		board.players = players;
		board.updateBoard();
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

		// For each card place it in a players hand, some players may end up with more as odd divsor
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

		//System.out.println("Player hands assigned... ");


	}

	/**
	 * Before the game is set up the solution is assigned and a new Solution instacne is made.
	 * @return
	 */

	public Solution assignSolution() {
		//System.out.println("Creating Cluedo Solution... ");
		int randomChar = (int) (Math.random() * 6);
		Character character = new Character(characters.get(randomChar));

		int randomItem = (int) (Math.random() * 6);
		Item item = new Item(items.get(randomItem));

		int randomRoom = (int) (Math.random() * 9);
		Room room = new Room(rooms.get(randomRoom));

		solution = new Solution(character, item, room);
//		System.out.println("The murderer is: " + solution.getMurderer().getName());
//		System.out.println("The murder weapon is: " + solution.getWeapon().getName());
//		System.out.println("The murder room is: " + solution.getMurderRoom().getName());

//		System.out.println("Solution done... ");
		return solution;
	}

	public Player playerTurns() {

		int currentTurn = 1;

		while (!board.getRestart()) {
			for (int s = 0; s < players.size(); s++) {
				Player p = players.get(s);

				if (!p.getIsOut()) {
					p.setDiceRoll();
					p.setMoves(p.getDiceRoll());


					// For each move the player can make an action
					while (p.getMoves() > 0) {
						gui.playGUI(board.getButtons(), currentTurn, p, board);
						gui.displayGUI();

						// Do nothing until the player makes an action
						while (!p.actionMade) {
							System.out.print("");
							if (board.getRestart()) {
								return p;
							}
						}
						p.actionMade = false;

					}
				}
			}
			currentTurn++;
		}

		return null;
	}

}
