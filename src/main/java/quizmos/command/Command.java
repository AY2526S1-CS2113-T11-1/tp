package quizmos.command;

import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;

public abstract class Command {
    protected boolean isExit = false;

    public boolean  getIsExit() {
        return isExit;
    }

    public abstract void execute(FlashcardList flashcards, Storage storage) throws Exception;
}
