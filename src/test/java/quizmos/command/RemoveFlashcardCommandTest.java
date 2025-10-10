package quizmos.command;

import org.junit.jupiter.api.Test;
import quizmos.flashcardlist.FlashcardList;
import quizmos.flashcard.Flashcard;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveFlashcardCommandTest {

    @Test
    void testExecuteRemovesFlashcard() throws IOException {
        FlashcardList flashcards = new FlashcardList();
        flashcards.addFlashcard(new Flashcard("Q1", "A1"));

        Ui ui = new Ui();
        Storage storage = new Storage("data/QuizMos.txt") {
            @Override
            public void writeToFile(FlashcardList list) { /* no-op */ }
        };

        RemoveFlashcardCommand command = new RemoveFlashcardCommand(0);
        command.execute(flashcards, storage);

        assertEquals(0, flashcards.getSize());
    }
}
