package quizmos.command;

import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

public class InvalidIndexCommand extends Command {
    /**
     * Print the response when user typed invalid index
     */
    @Override
    public void execute(FlashcardList flashcards, Storage storage) {
        Ui.invalidIndexRespond();
    }
}
