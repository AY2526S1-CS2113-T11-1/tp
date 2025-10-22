package quizmos.command;

import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

import java.io.IOException;

public class SearchFlashcardCommand extends Command {
    String keyPhrase;
    public SearchFlashcardCommand(String keyPhrase) {
        this.keyPhrase = keyPhrase;
    }

    @Override
    public void execute(FlashcardList flashcards, Storage storage) throws IOException {
        FlashcardList matches = new FlashcardList();
        // go through all existing flashcards and see if the question or answer contains the keyword/keyphrase
        for (Flashcard f : flashcards.getAll()) {
            if (f.getQuestion().contains(keyPhrase) || f.getAnswer().contains(keyPhrase)) {
                matches.addFlashcard(f);
            }
        }
        if (matches.getSize() == 0) {
            Ui.noMatchesRespond();
            return;
        }

        matches.showList();
    }
}
