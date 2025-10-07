package quizmos.command;

import quizmos.deck.Deck;
import quizmos.storage.Storage;

public abstract class Command {
    protected boolean isExit = false;

    public boolean  getIsExit() {
        return isExit;
    }

    public abstract void execute();
}
