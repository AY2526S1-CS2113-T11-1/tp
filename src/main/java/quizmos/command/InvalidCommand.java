package quizmos.command;

import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

public class InvalidCommand extends Command{
    /**
     * Print the response and suggestion when user typed invalid command
     */
    @Override
    public void execute(FlashcardList flashcards, Storage storage) {
        Ui.invalidCommandRespond();
    }
}
