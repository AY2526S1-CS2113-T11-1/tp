package quizmos.command;

import quizmos.storage.Storage;
import quizmos.ui.Ui;
import quizmos.flashcardlist.FlashcardList;
import quizmos.flashcard.Flashcard;

import java.io.IOException;

public class AddFlashcardCommand extends Command {
    String question;
    String answer;

    public AddFlashcardCommand(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    @Override
    public void execute(FlashcardList flashcards, Storage storage) throws IOException {
        Flashcard flashcard = new Flashcard(question, answer);
        flashcards.addFlashcard(flashcard);
        Ui.showFlashcardAdded(flashcard);
        storage.writeToFile(flashcards);

    }
}
