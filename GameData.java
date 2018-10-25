import java.util.ArrayList;

/**
 * GameData stores the individual rounds played and returns the fields when
 * asked.
 * 
 * @author Samuel Fu ssf2130
 *
 */
public class GameData {
	private int currentRound = 0;
	private ArrayList<Integer> playerChoice = new ArrayList<Integer>(0);
	private ArrayList<Integer> computerChoice = new ArrayList<Integer>(0);

	/**
	 * Stores both choices to the ArrayLists, adds 1 to the round count
	 * 
	 * @param playerChoice
	 * @param computerChoice
	 */
	public void addGame(Integer playerChoice, Integer computerChoice) {
		this.playerChoice.add(playerChoice);
		this.computerChoice.add(computerChoice);

		currentRound += 1;
	}

	/**
	 * returns current round number
	 * 
	 * @return current round number
	 */
	public int getCurrentRound() {
		return currentRound;
	}

	/**
	 * returns player's last choice
	 * 
	 * @return player's last choice
	 */
	public int getLastPlayerChoice() {
		return playerChoice.get(playerChoice.size() - 1);
	}

	/**
	 * returns computer's last choice
	 * 
	 * @return computer's last choice
	 */
	public int getLastComputerChoice() {
		return computerChoice.get(computerChoice.size() - 1);
	}

}
