public class Main {
    public static void main(String[] args) {
        WordleModel model = new WordleModel();
        WordleView view = new WordleView();
        WordleController controller = new WordleController(model, view);

        controller.startGame();
    }
}
