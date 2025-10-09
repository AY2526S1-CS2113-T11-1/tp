package quizmos.command;

import quizmos.flashcard.Flashcard;
import quizmos.flashcardList.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

public class RemoveFlashcardCommand extends Command {
    int index;

    public RemoveFlashcardCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(FlashcardList flashcards, Ui ui, Storage storage) {
        Flashcard deletedFlashcard = flashcards.get(index);
        flashcards.remove(index);
        ui.showFlashcardRemoved(deletedFlashcard);
    }
}
