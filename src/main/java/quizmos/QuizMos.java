package quizmos;

import quizmos.command.Command;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;
import quizmos.parser.Parser;

import java.io.IOException;

public class QuizMos {
    private FlashcardList flashcards;
    private Storage storage;
    private Ui ui;

    public QuizMos() {
        this.flashcards = new FlashcardList();
        this.storage = new Storage("data/QuizMos.txt");
        this.ui = new Ui();
        try {
            flashcards = new FlashcardList(storage.load());
        } catch (Exception e) {
            e.getMessage();
            flashcards = new FlashcardList();
        }
    }

    /**
     *
     */
    public void run() throws IOException {
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

    public static void main(String[] args) throws IOException { new QuizMos().run(); }
}
