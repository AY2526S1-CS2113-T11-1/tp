package quizmos.command;

import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

import java.io.IOException;

public class RemoveFlashcardCommand extends Command {
    int index = -1; // default index is false
    private boolean isValid = true;

    public RemoveFlashcardCommand(String arg) {
        try {
            int oneBasedIndex = Integer.parseInt(arg.trim());
            this.index = oneBasedIndex - 1; // convert to zero-based
        } catch (NumberFormatException | NullPointerException e) {
            this.isValid = false;
        }
    }

    @Override
    public void execute(FlashcardList flashcards, Storage storage) throws IOException {
        if (!isValid || index < 0 || index >= flashcards.getSize()) {
            Ui.invalidIndexRespond();
            return;
        }
        Flashcard deletedFlashcard = flashcards.getFlashcard(index);
        flashcards.removeFlashcard(index);
        Ui.showFlashcardRemoved(deletedFlashcard);
        storage.writeToFile(flashcards);
    }
}
