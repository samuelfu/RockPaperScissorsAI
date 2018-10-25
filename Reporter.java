import java.util.ArrayList;

/**
 * Reporter collects statistics with addGameResult(int gameResult) and returns
 * a report using generateReport(GameData game)
 * 
 * @author Samuel Fu ssf2130
 *
 */
public class Reporter {
	private int roundsComputerWon;
	private int roundsPlayerWon;
	private int roundsTied;
	private double percentageWinRate;
	private double percentageTieRate;
	private String finalReport;

	private ArrayList<Integer> gameResult = new ArrayList<Integer>();

	/**
	 * Stores the round result to gameResult
	 * @param gameResult
	 */
	public void addGameResult(int gameResult) {
		this.gameResult.add(gameResult);
	}

	/**
	 * Generates a report of statistics of the whole game and returns it
	 * @param game
	 * @return String of statistics
	 */
	public String generateReport(GameData game) {
		if (game.getCurrentRound() == 0) {
			return "No games played!";
		}

		else {
			for (int round : gameResult) {
				if (round == 0)
					roundsPlayerWon++;
			}

			for (int round : gameResult) {
				if (round == 1)
					roundsComputerWon++;
			}

			for (int round : gameResult) {
				if (round == 2)
					roundsTied++;
			}

			percentageWinRate = roundsPlayerWon / (double) (game.getCurrentRound()) * 100;
			percentageTieRate = roundsTied / (double) (game.getCurrentRound()) * 100;
			finalReport = "Rounds won for Player 1: " + roundsPlayerWon + "   Player 2: " + roundsComputerWon + "  Tie: "
					+ roundsTied + "  Total rounds: " + game.getCurrentRound() + "\n" + "Percentage of player 1 wins: "
					+ percentageWinRate + "%" + "  Percentage of ties: " + percentageTieRate + "%";

			return finalReport;

		}
	}
}
