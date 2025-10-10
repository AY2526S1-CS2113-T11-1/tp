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
    public void execute(FlashcardList flashcards, Ui ui, Storage storage) throws IOException {
        Flashcard deletedFlashcard = flashcards.get(index);
        flashcards.remove(index);
        ui.showFlashcardRemoved(deletedFlashcard);
        storage.writeToFile(flashcards);
    }
}
