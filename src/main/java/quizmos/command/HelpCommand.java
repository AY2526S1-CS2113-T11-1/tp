package quizmos.command;

import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

public class HelpCommand extends Command {
    @Override
    public void execute(FlashcardList flashcards, Storage storage) {
        Ui.help();
    }
}
