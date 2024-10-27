import java.util.Arrays;
import java.util.Random;

public class WordleModel {
    public static final String RESET = "\u001B[0m";
    public static final String ZIELONY = "\u001B[32m";
    public static final String ZOLTY = "\u001B[33m";
    public static final String CZERWONY = "\u001B[31m";

    public StringBuilder alphabet = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    private String[] words = new String[] {"apple", "peach", "grape", "plank", "prank"};
    private String wordToGuess;

    private int attempts=0;
    private int maxAttempts=5;




    public WordleModel(){
        Random generator = new Random();
        this.wordToGuess=words[generator.nextInt(words.length)];
    }

    public boolean guessWord(String word)
    {
        if(word.equals(this.wordToGuess))
            return true;
        else {
            this.attempts++;
            return false;
        }
    }

    public StringBuilder hint(String word) {
        StringBuilder hint = new StringBuilder();

        for (int index = 0; index < word.length(); index++) {
            char letter = word.charAt(index);
            if (letter == this.wordToGuess.charAt(index)) {
                hint.append(ZIELONY).append(letter).append(RESET);
                updateAlphabetColor(letter, ZIELONY);
            } else if (this.wordToGuess.indexOf(letter) != -1) {
                hint.append(ZOLTY).append(letter).append(RESET);
                updateAlphabetColor(letter, ZOLTY);
            } else {
                hint.append(CZERWONY).append(letter).append(RESET);
                updateAlphabetColor(letter, CZERWONY);
            }
        }
        return hint;
    }

    private void updateAlphabetColor(char letter, String color) {
        letter=Character.toUpperCase(letter);
        int index = alphabet.indexOf(String.valueOf(letter));
        System.out.println(index);
        if (index != -1) {
            alphabet.replace(index, index + 1, color + letter + RESET);
        }
    }


    public String getWordToGuess()
    {
        return wordToGuess;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public StringBuilder getAlphabet(){
        return alphabet;
    }
}
