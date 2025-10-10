package quizmos.command;

import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;

import java.io.IOException;

public class ListCommand extends Command {
    /**
     * Indicates that this command does not exit the application.
     *
     * @return false always
     */
    public boolean isExit() {
        return false;
    }

    /**
     * Executes the list command.
     * Shows all tasks if the task list is not empty.
     * Throws TwinException if the task list is empty.
     *
     * @param storage    Storage instance (not used for this command)
     * @param flashcards containing all flashcards
     */

    @Override
    public void execute(FlashcardList flashcards, Storage storage) throws IOException {
        flashcards.showList();
    }
}
