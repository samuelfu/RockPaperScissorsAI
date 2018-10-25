import java.util.Random;

/**
 * The purpose of this class is to create random throws from the computer.
 * 
 * @author Samuel Fu ssf2130
 *
 */
public class Computer {
	private int computerChoice;
	private final int[] POSSIBLE_CHOICE = { 0, 1, 2, 3, 4 };
	private int randomNumber;

	/**
	 * Creates and sets the random computer choice
	 */
	public void generateComputerChoice() {
		getRandomNumber();
		setComputerChoice();
	}

	/**
	 * @return random computer choice
	 */
	public int getComputerChoice() {
		return computerChoice;
	}

	/**
	 * Generates a random number
	 */
	private void getRandomNumber() {
		Random generator = new Random();
		randomNumber = generator.nextInt(POSSIBLE_CHOICE.length);
	}

	/**
	 * Uses the random number to set a random computer choice
	 */
	private void setComputerChoice() {
		computerChoice = POSSIBLE_CHOICE[randomNumber];
	}

}
