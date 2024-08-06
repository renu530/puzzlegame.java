import java.util.Scanner;

 public class PuzzleStart {
    private Puzzle puzzle;
    private int numGuesses = 0;  // Keep track of the number of guesses

    public static void main(String[] args) {
        PuzzleStart game = new PuzzleStart();
        game.startPlaying();
    }

    public void startPlaying() {
        puzzle = new Puzzle();
        puzzle.placeCountries();
        boolean gameOver = false;

        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            System.out.print("Enter a guess: ");
            String userInput = scanner.nextLine();
            String result = checkGuess(userInput);
            System.out.println(result);
            if (result.equals("kill")) {
                gameOver = puzzle.allCountriesGuessed();
            }
        }
        finishGame();
        scanner.close();
    }

    public String checkGuess(String userInput) {
        numGuesses++;
        String result = puzzle.checkGuess(userInput);
        if (result.equals("kill")) {
            System.out.println("You guessed a country!");
        }
        return result;
    }

    public void finishGame() {
        System.out.println("All Countries are guessed!");
        System.out.println("It only took you " + numGuesses + " guesses.");
    }
}

