import java.util.Random;

/**
 * Creates a simulated player that has either a strategy of rotating through
 * rock, paper, scissors, Spock and lizard, or strategy that uses random throws.
 * 
 * @author Samuel Fu ssf2130
 *
 */
public class Simulator {
	private int simulatorChoiceInt;
	private final int[] POSSIBLE_CHOICE = { 0, 1, 2, 3, 4 };
	private int randomNumber;
	private String simulatorChoiceString;
	private String computerChoiceString;
	private Convertor convertor = new Convertor();
	private int counter = 0;

	/**
	 * Generates the simulated player choice based on the counter. Player choice
	 * cycles through rock, paper, scissors, spock, and lizard. If the counter
	 * overflows it resets.
	 */
	public void generateSimulatorChoice() {
		simulatorChoiceInt = POSSIBLE_CHOICE[counter];
		counter++;
		if (counter == POSSIBLE_CHOICE.length)
			counter = 0;
	}

	/**
	 * 
	 * @return simulator choice in integer format.
	 */
	public int getSimulatorChoice() {
		return simulatorChoiceInt;
	}

	/**
	 * Prints out what each player threw
	 * 
	 * @param simulatorChoice
	 * @param computerChoice
	 */
	public void printThrows(int simulatorChoice, int computerChoice) {
		simulatorChoiceString = convertor.convertChoicetoString(simulatorChoice);
		computerChoiceString = convertor.convertChoicetoString(computerChoice);
		System.out.println(
				"Simulated player threw " + simulatorChoiceString + ", the computer threw " + computerChoiceString);
	}

	/**
	 * In case a client wishes to use the random simulated player instead, use this
	 * method and setSimulatorChoice() together.
	 */
	private void getRandomNumber() {
		Random generator = new Random();
		randomNumber = generator.nextInt(POSSIBLE_CHOICE.length);
	}

	/**
	 * In case a client wishes to use the random simulated player instead, use this
	 * method and getRandomNumber() together.
	 * 
	 */
	private void setSimulatorChoice() {
		simulatorChoiceInt = POSSIBLE_CHOICE[randomNumber];
	}
}
