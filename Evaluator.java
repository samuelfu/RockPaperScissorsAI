/**
 * Evaluator helps decide the winner of each round, and determine the reason for
 * each win/loss/tie.
 * 
 * @author Samuel Fu ssf2130
 *
 */
public class Evaluator {
	private int playerChoiceInt;
	private int computerChoiceInt;
	private String playerChoiceString;
	private String computerChoiceString;
	private final int[] POSSIBLE_CHOICE = { 0, 1, 2, 3, 4 };

	/**
	 * Determines the winner between player and computer.
	 * Algorithm from www.stackoverflow.com/questions/9553058/scalable-solution-for-rock-paper-scissor
	 * @param game
	 * @return 0 for win, 1 for lose, 2 for draw
	 */
	public int determineWinnerOfLastRound(GameData game) {
		playerChoiceInt = game.getLastPlayerChoice();
		computerChoiceInt = game.getLastComputerChoice();

		int d = (POSSIBLE_CHOICE.length + playerChoiceInt - computerChoiceInt) % POSSIBLE_CHOICE.length;

		if (d == 1 || d == 3)
			return 0; //win
		else if (d == 2 || d == 4)
			return 1; //lose
		else
			return 2; //draw

	}

	/**
	 * Determines the reason for win/loss/tie
	 * @param game
	 * @return a String indicating the reason for win/loss/tie.
	 */
	public String determineWinnerAndReason(GameData game) {
		Convertor convertor = new Convertor();
		playerChoiceInt = game.getLastPlayerChoice();
		computerChoiceInt = game.getLastComputerChoice();

		playerChoiceString = convertor.convertChoicetoString(playerChoiceInt);
		computerChoiceString = convertor.convertChoicetoString(computerChoiceInt);

		if (determineWinnerOfLastRound(game) == 0)
			return "Player won because " + playerChoiceString + " beats " + computerChoiceString;
		else if (determineWinnerOfLastRound(game) == 1)
			return "Player lost because " + computerChoiceString + " beats " + playerChoiceString;
		else
			return "Game tied because " + playerChoiceString + " is the same as " + computerChoiceString;
	}
}
