package quizmos.command;

import quizmos.flashcardList.FlashcardList;
import quizmos.ui.Ui;
import quizmos.storage.Storage;
public class ExitCommand extends Command {
    public ExitCommand() {
        this.isExit = true;
    }

    @Override
    public void execute(FlashcardList flashcards, Ui ui, Storage storage) {
        ui.goodbye();
    }
}
