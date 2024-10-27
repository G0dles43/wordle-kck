import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        WordleModel wordleModel = new WordleModel();
        System.out.println(wordleModel.getWordToGuess());
        System.out.println(wordleModel.guessWord("peach"));
        Scanner scanner = new Scanner(System.in);
        while(true){
            if(wordleModel.getAttempts()==wordleModel.getMaxAttempts())
            {
                System.out.println("Przegrales!!");
                return;
            }
            System.out.println("Podaj  5 liter: ");
            String word = scanner.nextLine();
            if(word.length() != 5)
                continue;
            if(wordleModel.guessWord(word))
            {
                break;
            }else
            {
                System.out.println(wordleModel.hint(word));
                System.out.println(wordleModel.getAlphabet());
            }
        }
        System.out.println("Brawo wygrales!!!");
    }
}