package quizmos;

import quizmos.command.Command;
import quizmos.flashcardList.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;
import quizmos.parser.Parser;

public class QuizMos {
    private FlashcardList flashcards;
    private Storage storage;
    private Ui ui;

    public QuizMos() {
        this.flashcards = new FlashcardList();
        this.storage = new Storage();
        this.ui = new Ui();
    }

    /**
     *
     */
    public void run(){
        ui.greeting();
        boolean isExit = false;

        while (!isExit){
            String command = ui.readCommand();
            Command c = Parser.parseCommand(command);
            c.execute(flashcards, ui, storage);
            isExit = c.getIsExit();
        }
        System.exit(0);
    }

    public static void main(String[] args) { new QuizMos().run(); }
}
