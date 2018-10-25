import java.util.Scanner;

/**
 * Runner class executes the main program. The different game modes below are
 * for different parts of the homework assignment. startGameHumanVSComputer is
 * for parts 1 and 2, while startGameSimulatedHumanVSComputer is for part 3, and
 * startGameComputerVSThinker is for part 4. Change the game mode to
 * switch method of playing.
 * 
 * The main method creates an instance of Runner and calls a method below to
 * start the game. The methods start by creating instances of GameData, Reporter
 * and Evaluator. In some kind of a loop, player and computer are created from
 * specific classes depending on the method (player from either Talker or
 * Simulator, computer from either Computer or Thinker). Player and computer's
 * throws are given to GameData to store. Evaluator decides the winner, and
 * Reporter records the data. The player prints what each player threw in the
 * game. The loop ends either when "z" is pressed or when the simulation is
 * over. The statistics are printed. Game ends.
 * 
 * @author Samuel Fu ssf2130
 */
public class Runner {
	/**
	 * Set the game mode through gameMode = 0 or 1 or 2. A welcome message is
	 * displayed, and the system asks for input for what game mode the user wants.
	 * Invalid inputs are filtered. Then, main() calls on the method that the user
	 * requested.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int gameMode;
		Runner runner = new Runner();

		runner.welcome();
		Scanner scanner = new Scanner(System.in);
		gameMode = Integer.parseInt(runner.checkChoiceValidity(scanner));

		if (gameMode == 1)
			runner.startGameHumanVSComputer();
		else if (gameMode == 2)
			runner.startGameSimulatedHumanVSComputer();
		else
			runner.startGameComputerVSThinker();
	}

	/**
	 * Creates a game between a Computer that throws random choices, and an AI.
	 * Generates a player from Computer and a thinker from Thinker. Computer
	 * generates a choice and thinker generates a choice based on the computer's
	 * previous choice. The choices are added to rpsGame and the result of the round
	 * added to report. After the loop ends a report is generated and printed.
	 * A comparison of Step 3 and Step 4 is included in the word document.
	 */
	public void startGameComputerVSThinker() {
		GameData rpsGame = new GameData();
		Reporter report = new Reporter();
		Evaluator judge = new Evaluator();
		int playerLastChoice = -1;
		int computerLastChoice;
		final int NUMBER_OF_ROUNDS = 10000;

		for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
			Computer computer = new Computer();
			Thinker thinker = new Thinker();

			thinker.generateComputerChoice(playerLastChoice);
			computer.generateComputerChoice();

			playerLastChoice = computer.getComputerChoice();
			computerLastChoice = thinker.getComputerChoice();

			rpsGame.addGame(playerLastChoice, computerLastChoice);
			report.addGameResult(judge.determineWinnerOfLastRound(rpsGame));

		}

		System.out.println(report.generateReport(rpsGame));
	}

	/**
	 * Creates a game between a simulated human from Simulator and a computer from
	 * Computer that generates random choices. Player and computer both generate
	 * choices. The choices are added to rpsGame, and the result of the round added
	 * to report. After the loop ends a report is generated and printed. 5000 rounds
	 * gets the percentage of ties to +/-1%, while 7500 rounds is enough to
	 * generally make the percentage of ties +/-0.5%, and rounds to 20%. Therefore
	 * 7500 rounds is "enough" to get the right number of rounds to get reliable
	 * outputs.
	 */
	public void startGameSimulatedHumanVSComputer() {
		GameData rpsGame = new GameData();
		Reporter report = new Reporter();
		Evaluator judge = new Evaluator();
		int playerChoice;
		int computerChoice;
		final int NUMBER_OF_ROUNDS = 7500;

		for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
			Simulator player = new Simulator();
			Computer computer = new Computer();

			computer.generateComputerChoice();
			player.generateSimulatorChoice();

			playerChoice = player.getSimulatorChoice();
			computerChoice = computer.getComputerChoice();

			rpsGame.addGame(playerChoice, computerChoice);
			report.addGameResult(judge.determineWinnerOfLastRound(rpsGame));

		}

		System.out.println(report.generateReport(rpsGame));
	}

	/**
	 * Creates a game between a player from Talker and a computer from Computer. In
	 * a never-ending loop (unless the user types z), the console asks the user for
	 * their input. The input is taken as the player choice, while a computer choice
	 * is generated. The choices are added to rpsGame, and the results to of the
	 * round added to report. After the user stops the loop, a report is generated
	 * and printed.
	 */
	public void startGameHumanVSComputer() {
		GameData rpsGame = new GameData();
		Reporter report = new Reporter();
		Evaluator judge = new Evaluator();
		int playerChoice;
		int computerChoice;

		while (true) {
			Talker player = new Talker();
			Computer computer = new Computer();

			player.askPlayerChoice();
			computer.generateComputerChoice();

			if (player.wantsToStop()) {
				break;
			}

			playerChoice = player.getPlayerChoice();
			computerChoice = computer.getComputerChoice();

			rpsGame.addGame(playerChoice, computerChoice);
			report.addGameResult(judge.determineWinnerOfLastRound(rpsGame));

			player.printThrows(playerChoice, computerChoice);
			System.out.println(judge.determineWinnerAndReason(rpsGame));

		}

		System.out.println(report.generateReport(rpsGame));
	}

	/**
	 * Displays a welcome message and prompts for the game mode.
	 */
	public void welcome() {
		System.out.println("Welcome to ssf2130 Samuel Fu's Rock Paper Scissor Lizard Spock Game! The rules are as following:");
		System.out.println("Scissors cuts paper. Paper covers rock. Rock crushes lizard. Lizard poisons\n"
				+ "Spock. Spock smashes scissors. Scissors decapitates lizard. Lizard eats\n"
				+ "paper. Paper disproves Spock. Spock vaporizes rock. And as it always has,\n"
				+ "rock crushes scissors.");
		System.out.println(
				"Choose your game mode: 1. Human vs. Computer  2. Simulated Human vs. Computer  3. Computer vs. AI");

	}

	/**
	 * Asks for and checks if the user input is valid (either 1, 2, or 3)
	 * 
	 * @param scanner
	 *            used to ask for the user input
	 * @return the game mode that the user wants (in String)
	 */
	public String checkChoiceValidity(Scanner scanner) {
		Boolean properInput = false;
		String gameModeString = null;
		while (!properInput) {
			gameModeString = scanner.next();
			if (gameModeString.equals("1") || gameModeString.equals("2") || gameModeString.equals("3")) {
				properInput = true;
			} else
				System.out.println("Invalid input! Try again.");
		}
		return gameModeString;
	}

}
