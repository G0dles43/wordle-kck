import java.util.Random;

public class WordleModel {
    public static final String RESET = "\u001B[0m";
    public static final String ZIELONY = "\u001B[32m";
    public static final String ZOLTY = "\u001B[33m";
    public static final String CZERWONY = "\u001B[31m";

    private StringBuilder alphabet = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    private String[] words = {"apple", "peach", "grape", "plank", "prank", "happy", "heart", "track"};
    private String wordToGuess;
    private int attempts = 0;
    private final int maxAttempts = 5;
    private WordleWordProvider wordProvider;

    public WordleModel() {
        this.wordProvider = new WordleWordProvider();
        this.wordToGuess = wordProvider.fetchRandomWord();
    }

    public boolean guessWord(String word) {
        if (word.equals(this.wordToGuess)) {
            return true;
        } else {
            this.attempts++;
            return false;
        }
    }

    public String colorHint(String color, char letter) {
        return " " + color + Character.toUpperCase(letter) + RESET + " |";
    }

    public StringBuilder hint(String word) {
        StringBuilder hint = new StringBuilder();
        StringBuilder pomWordToGuess = new StringBuilder(wordToGuess);

        for (int index = 0; index < word.length(); index++) {
            char letter = word.charAt(index);
            if (letter == pomWordToGuess.charAt(index)) {
                hint.append(colorHint(ZIELONY, letter));
                updateAlphabetColor(letter, ZIELONY);
                pomWordToGuess.setCharAt(index, '~');
            } else if (pomWordToGuess.indexOf(Character.toString(letter)) != -1) {
                hint.append(colorHint(ZOLTY, letter));
                updateAlphabetColor(letter, ZOLTY);
                int foundIndex = pomWordToGuess.indexOf(Character.toString(letter));
                pomWordToGuess.setCharAt(foundIndex, '~');
            } else {
                hint.append(colorHint(CZERWONY, letter));
                updateAlphabetColor(letter, CZERWONY);
            }
            System.out.println(pomWordToGuess);
        }
        return hint;
    }

    private void updateAlphabetColor(char letter, String color) {
        letter = Character.toUpperCase(letter);
        int index = alphabet.indexOf(String.valueOf(letter));
        if (index != -1) {
            alphabet.replace(index, index + 1, color + letter + RESET);
        }
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public StringBuilder getAlphabet() {
        return alphabet;
    }
}
