package quizmos;

import quizmos.command.Command;
import quizmos.common.Messages;
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
        Ui.respond(Messages.greeting);
        boolean isExit = false;

        while (!isExit){
            try {
                String command = Ui.readCommand();
                Command c = Parser.parseCommand(command);
                c.execute(flashcards, storage);
                isExit = c.getIsExit();
            } catch (Exception e) {
                Ui.respondError(e.getMessage());
            }
        }
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        if (args.length > 0 && args[0].equals("--test")) {
            Ui.isTestMode = true;
        }
        new QuizMos().run();
    }
}
