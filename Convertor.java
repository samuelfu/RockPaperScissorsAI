/**
 * Convertor converts integer choices to String choices, and vice versa.
 * 
 * @author Samuel Fu ssf2130
 *
 */
public class Convertor {
	private final String[] POSSIBLE_CHOICE_CHAR = { "r", "p", "s", "k", "l" };
	private final String[] POSSIBLE_CHOICE_STRING = { "rock", "paper", "scissors", "spock", "lizard" };

	/**
	 * @param playerChoiceString
	 *            player choice in String form
	 * @return player choice in integer form
	 */
	public int convertChoiceToInt(String playerChoiceString) {
		if (playerChoiceString.equals("z"))
			return -1;
		else if (playerChoiceString.equals(POSSIBLE_CHOICE_CHAR[0]))
			return 0;
		else if (playerChoiceString.equals(POSSIBLE_CHOICE_CHAR[1]))
			return 1;
		else if (playerChoiceString.equals(POSSIBLE_CHOICE_CHAR[2]))
			return 2;
		else if (playerChoiceString.equals(POSSIBLE_CHOICE_CHAR[3]))
			return 3;
		else
			return 4;
	}

	/**
	 * @param choice
	 *            player choice in integer form
	 * @return player choice in String form
	 */
	public String convertChoicetoString(int choice) {
		return POSSIBLE_CHOICE_STRING[choice];
	}
}
