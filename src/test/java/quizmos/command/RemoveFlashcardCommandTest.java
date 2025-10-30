package quizmos.command;

import org.junit.jupiter.api.Test;
import quizmos.flashcardlist.FlashcardList;
import quizmos.flashcard.Flashcard;
import quizmos.storage.Storage;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveFlashcardCommandTest {

    @Test
    void testExecuteRemovesFlashcard() throws IOException {
        FlashcardList flashcards = new FlashcardList();
        flashcards.addFlashcard(new Flashcard("Q1", "A1"));

        Storage storage = new Storage("data/QuizMos.txt") {
            @Override
            public void writeToFile(FlashcardList list) { /* no-op */ }
        };

        RemoveFlashcardCommand command = new RemoveFlashcardCommand("1");
        command.execute(flashcards, storage);

        assertEquals(0, flashcards.getSize());
    }

    @Test
    void testInvalidIndexNonInteger() throws IOException {
        FlashcardList flashcards = new FlashcardList();
        flashcards.addFlashcard(new Flashcard("Q1", "A1"));

        Storage storage = new Storage("data/QuizMos.txt") {
            @Override
            public void writeToFile(FlashcardList list) { }
        };

        RemoveFlashcardCommand command = new RemoveFlashcardCommand("abc");
        command.execute(flashcards, storage);

        // List should remain unchanged
        assertEquals(1, flashcards.getSize());
    }

    @Test
    void testInvalidNegativeIndex() throws IOException {
        FlashcardList flashcards = new FlashcardList();
        flashcards.addFlashcard(new Flashcard("Q1", "A1"));

        Storage storage = new Storage("data/QuizMos.txt") {
            @Override
            public void writeToFile(FlashcardList list) { }
        };

        RemoveFlashcardCommand command = new RemoveFlashcardCommand("-1");
        command.execute(flashcards, storage);

        assertEquals(1, flashcards.getSize());
    }

    @Test
    void testInvalidIndexTooLarge() throws IOException {
        FlashcardList flashcards = new FlashcardList();
        flashcards.addFlashcard(new Flashcard("Q1", "A1"));

        Storage storage = new Storage("data/QuizMos.txt") {
            @Override
            public void writeToFile(FlashcardList list) { }
        };

        RemoveFlashcardCommand command = new RemoveFlashcardCommand("5");
        command.execute(flashcards, storage);

        assertEquals(1, flashcards.getSize());
    }
}
