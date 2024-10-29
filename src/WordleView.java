public class WordleView {
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayHint(StringBuilder hint) {
        System.out.println(hint);
    }

    public void displayAlphabet(StringBuilder alphabet) {
        System.out.println(alphabet);
    }

    public void displayWinMessage() {
        System.out.println("Brawo, wygrałeś!");
    }

    public void displayLoseMessage(String wordToGuess) {
        System.out.println("Przegrałeś! Słowo które było odgadnięcia to: " + wordToGuess);
    }
}
