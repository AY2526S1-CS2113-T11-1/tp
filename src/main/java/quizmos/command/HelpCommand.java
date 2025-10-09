package quizmos.command;

import quizmos.flashcardList.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

public class HelpCommand extends Command {
    @Override
    public void execute(FlashcardList flashcards, Ui ui, Storage storage) {
        Ui.help();
    }
}
