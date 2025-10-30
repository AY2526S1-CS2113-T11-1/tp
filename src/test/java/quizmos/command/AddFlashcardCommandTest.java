package quizmos.command;

import org.junit.jupiter.api.Test;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AddFlashcardCommandTest {

    @Test
    void testExecuteAddsFlashcard() throws IOException {
        FlashcardList flashcards = new FlashcardList();
        Storage storage = new Storage("data/QuizMos.txt") {
            @Override
            public void writeToFile(FlashcardList list) { /* skip actual writing */ }
        };

        AddFlashcardCommand command = new AddFlashcardCommand(new String[] {"add", "q/Q1 a/A1"});
        command.execute(flashcards, storage);

        assertEquals(1, flashcards.getSize());
        assertEquals("Q1", flashcards.getFlashcard(0).getQuestion());
        assertEquals("A1", flashcards.getFlashcard(0).getAnswer());
    }

    @Test
    void testInvalidFormatMissingAnswer() throws IOException {
        FlashcardList flashcards = new FlashcardList();
        Storage storage = new Storage("data/QuizMos.txt") {
            @Override
            public void writeToFile(FlashcardList list) { }
        };

        AddFlashcardCommand command = new AddFlashcardCommand(new String[] {"add", "q/Q1"});
        command.execute(flashcards, storage);

        assertEquals(0, flashcards.getSize());
    }

    @Test
    void testInvalidFormatMissingQuestion() throws IOException {
        FlashcardList flashcards = new FlashcardList();
        Storage storage = new Storage("data/QuizMos.txt") {
            @Override
            public void writeToFile(FlashcardList list) { }
        };

        AddFlashcardCommand command = new AddFlashcardCommand(new String[] {"add", "a/A1"});
        command.execute(flashcards, storage);

        assertEquals(0, flashcards.getSize());
    }

    @Test
    void testInvalidReversedOrder() throws IOException {
        FlashcardList flashcards = new FlashcardList();
        Storage storage = new Storage("data/QuizMos.txt") {
            @Override
            public void writeToFile(FlashcardList list) { }
        };

        // a/ before q/
        AddFlashcardCommand command = new AddFlashcardCommand(new String[] {"add", "a/A1 q/Q1"});
        command.execute(flashcards, storage);

        assertEquals(0, flashcards.getSize());
    }
}
