import java.util.Random;

/**
 * Thinker creates an AI that responds to the player's last choice. Important
 * differences between an intelligent Thinker and the original random Thinker is
 * that the intelligent Thinker can recognize if the random Thinker is throwing
 * in any patterns. However, because the random Thinker does not actually use
 * strategy, random Thinker is impossible to defeat using any strategy over a
 * long game. The AI, on the other hand, can be tricked and defeated if the
 * other player knows the strategy of the AI.
 * 
 * @author Samuel Fu ssf2130
 *
 */
public class Thinker {
	/**
	 * The data structure for learning the simulated human's strategy is a variable.
	 * This works because both the simulated human's strategy and that of the
	 * computer's are relatively simple. The computer only hows to counter one
	 * strategy so the data structure is more simple.
	 */
	private int computerChoice;
	private final int[] POSSIBLE_CHOICE = { 0, 1, 2, 3, 4 };
	private int randomNumber;

	/**
	 * Generates a computer choice based on the player's last choice. Knows that the
	 * player always cycles through its options so counters that directly by adding
	 * 1 to the player's choice. If the computer choice number goes over 4 then it
	 * resets to a number less than 5 but larger than or equal to 0.
	 * 
	 * @param playerLastChoice
	 */
	public void generateComputerChoice(int playerLastChoice) {
		if (playerLastChoice == -1) {
			generateComputerChoice();
			setComputerChoice();
		} else {
			computerChoice = playerLastChoice + 1;
			if (computerChoice > 4)
				computerChoice = computerChoice - 5;
		}
	}

	/**
	 * 
	 * @return computer choice
	 */
	public int getComputerChoice() {
		return computerChoice;
	}

	/**
	 * During the first round, before the player has made any decisions, the
	 * computer selects a random choice through first generating a random number
	 * then setting the computer choice using that random number.
	 */
	private void generateComputerChoice() {
		getRandomNumber();
		setComputerChoice();
	}

	/**
	 * Creates a random number and sets randomNumber equal to that random number
	 */
	private void getRandomNumber() {
		Random generator = new Random();
		randomNumber = generator.nextInt(POSSIBLE_CHOICE.length);
	}

	/**
	 * Sets computer choice according to the random number
	 */
	private void setComputerChoice() {
		computerChoice = POSSIBLE_CHOICE[randomNumber];
	}

}
