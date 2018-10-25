import java.util.Scanner;

/**
 * Creates a player that takes user input for its choice. It checks the user
 * input for validity (r,p,s,k,l or z) and stops if the user input is z. After
 * every round, the player is asked to print what each player threw.
 * 
 * @author Samuel Fu ssf2130
 *
 */
public class Talker {
	private String playerChoiceString;
	private String computerChoiceString;
	private int playerChoiceInt;
	private Convertor convertor = new Convertor();
	private final String[] POSSIBLE_CHOICE_CHAR = { "r", "p", "s", "k", "l" };

	/**
	 * Asks for the user input and checks its validity
	 */
	public void askPlayerChoice() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your choice (select from r, p, s, l, k, and z)");

		checkChoiceValidity(scanner);
		playerChoiceInt = convertor.convertChoiceToInt(playerChoiceString);
	}

	/**
	 * 
	 * @return player choice as integer
	 */
	public int getPlayerChoice() {
		return playerChoiceInt;
	}

	/**
	 * Checks if user wishes to stop game
	 * @return true for stop, false for continue
	 */
	public Boolean wantsToStop() {
		if (playerChoiceInt == -1)
			return true;
		else
			return false;
	}
/**
 * Prints what each player threw
 * @param playerChoice
 * @param computerChoice
 */
	public void printThrows(int playerChoice, int computerChoice) {
		playerChoiceString = convertor.convertChoicetoString(playerChoice);
		computerChoiceString = convertor.convertChoicetoString(computerChoice);
		System.out.println("You threw " + playerChoiceString + ", the computer threw " + computerChoiceString);
	}

	/**
	 * Takes in scanner and checks if user input is valid (r,p,s,l,k or z)
	 * @param scanner
	 */
	private void checkChoiceValidity(Scanner scanner) {
		Boolean properInput = false;
		while (!properInput) {
			playerChoiceString = scanner.next();
			if (playerChoiceString.equals(POSSIBLE_CHOICE_CHAR[0]) || playerChoiceString.equals(POSSIBLE_CHOICE_CHAR[1])
					|| playerChoiceString.equals(POSSIBLE_CHOICE_CHAR[2])
					|| playerChoiceString.equals(POSSIBLE_CHOICE_CHAR[3])
					|| playerChoiceString.equals(POSSIBLE_CHOICE_CHAR[4]) || playerChoiceString.equals("z")) {
				properInput = true;
			} else
				System.out.println("Invalid input! Try again.");

		}

	}

}
