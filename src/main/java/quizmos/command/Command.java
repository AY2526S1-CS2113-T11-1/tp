package quizmos.command;

import quizmos.flashcardlist.FlashcardList;
import quizmos.ui.Ui;
import quizmos.storage.Storage;

import java.io.IOException;

public abstract class Command {
    protected boolean isExit = false;

    public boolean  getIsExit() {
        return isExit;
    }

    public abstract void execute(FlashcardList flashcards, Ui ui, Storage storage) throws IOException;
}
