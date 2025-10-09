package quizmos.command;

import quizmos.storage.Storage;
import quizmos.ui.Ui;
import quizmos.flashcardlist.FlashcardList;
import quizmos.flashcard.Flashcard;

public class AddFlashcardCommand extends Command {
    String question;
    String answer;

    public AddFlashcardCommand(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    @Override
    public void execute(FlashcardList flashcards, Ui ui, Storage storage) {
        Flashcard flashcard = new Flashcard(question, answer);
        flashcards.add(flashcard);
        Flashcard addedFlashcard = flashcards.get(flashcards.size() - 1);
        ui.showFlashcardAdded(addedFlashcard);
    }
}
