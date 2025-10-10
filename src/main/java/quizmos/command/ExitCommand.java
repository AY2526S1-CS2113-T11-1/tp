package quizmos.command;

import quizmos.flashcardlist.FlashcardList;
import quizmos.ui.Ui;
import quizmos.storage.Storage;

import java.io.IOException;

public class ExitCommand extends Command {
    public ExitCommand() {
        this.isExit = true;
    }

    @Override
    public void execute(FlashcardList flashcards, Ui ui, Storage storage) throws IOException {
        ui.goodbye();
        storage.writeToFile(flashcards);
    }
}
