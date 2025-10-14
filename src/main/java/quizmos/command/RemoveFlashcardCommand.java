package quizmos.command;

import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

import java.io.IOException;

public class RemoveFlashcardCommand extends Command {
    int index;

    public RemoveFlashcardCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(FlashcardList flashcards, Storage storage) throws IOException {
        if (index < 0 || index >= flashcards.getSize()) {
            Ui.invalidIndexRespond();
            return;
        }
        Flashcard deletedFlashcard = flashcards.getFlashcard(index);
        flashcards.removeFlashcard(index);
        Ui.showFlashcardRemoved(deletedFlashcard);
        storage.writeToFile(flashcards);
    }
}
