import java.util.Scanner;

public class WordleController {
    private final WordleModel model;
    private final WordleView view;

    public WordleController(WordleModel model, WordleView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            view.displayMessage("Input 5-letter word: ");
            String word = scanner.nextLine().toUpperCase();

            if (word.length() != 5) {
                view.displayMessage("Input word with exactly 5 letters!.");
                continue;
            }

            if (model.guessWord(word)) {
                view.displayWinMessage();
                break;
            } else {
                view.displayHint(model.hint(word));
                view.displayAlphabet(model.getAlphabet());
            }

            if (model.getAttempts() >= model.getMaxAttempts()) {
                view.displayLoseMessage(model.getWordToGuess());
                break;
            }
        }

    }
}
