package quizmos.command;

import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

import java.util.ArrayList;

public class GetStarredCommand extends Command {
    @Override
    public void execute(FlashcardList flashcards, Storage storage) throws Exception {
        ArrayList<Flashcard> starredFlashcards = flashcards.getStarredFlashcards();
        Ui.showStarredFlashcardsList(starredFlashcards);
    }
}
