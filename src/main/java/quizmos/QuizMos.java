package quizmos;

import quizmos.command.Command;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.parser.Parser;
import quizmos.ui.Ui;

import java.io.IOException;

public class QuizMos {
    private FlashcardList flashcards;
    private Storage storage;

    public QuizMos() {
        this.flashcards = new FlashcardList();
        this.storage = new Storage("data/QuizMos.txt");
        try {
            flashcards = new FlashcardList(storage.load());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            flashcards = new FlashcardList();
        }
    }

    /**
     *
     */
    public void run() throws IOException {
        Ui.greeting();
        boolean isExit = false;

        while (!isExit){
            String command = Ui.readCommand();
            Command c = Parser.parseCommand(command);
            c.execute(flashcards, storage);
            isExit = c.getIsExit();
        }
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        new QuizMos().run();
    }
}
