package quizmos.command;

import quizmos.common.Messages;
import quizmos.flashcardlist.FlashcardList;
import quizmos.ui.Ui;
import quizmos.storage.Storage;

public class ExitCommand extends Command {
    public ExitCommand() {
        this.isExit = true;
    }

    @Override
    public void execute(FlashcardList flashcards, Storage storage) throws Exception {
        Ui.respond(Messages.goodbyeMessage);
    }
}
