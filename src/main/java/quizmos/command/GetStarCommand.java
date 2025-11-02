package quizmos.command;

import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;

import java.util.ArrayList;

public class GetStarCommand extends Command {
    @Override
    public void execute(FlashcardList flashcards, Storage storage) {
        ArrayList<Flashcard> starredFlashcards = new ArrayList<>();
        for (Flashcard f: flashcards) {
            if (f.checkIsStarred()) {
                starredFlashcards.add(f);
            }
        }
        flashcards.setStarredFlashcards(starredFlashcards);
        flashcards.getStarredFlashcards();
    }
}
