package quizmos.command;

import org.junit.jupiter.api.Test;
import quizmos.exception.QuizMosFileException;
import quizmos.exception.QuizMosInputException;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddFlashcardCommandTest {

    @Test
    void execute_validInput_addsFlashcard() throws QuizMosFileException, IOException, QuizMosInputException {
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
    void constructor_missingAnswer_doesNotAddFlashcard() throws  QuizMosFileException, QuizMosInputException {
        FlashcardList flashcards = new FlashcardList();
        Storage storage = new Storage("data/QuizMos.txt") {
            @Override
            public void writeToFile(FlashcardList list) { }
        };

        AddFlashcardCommand command = new AddFlashcardCommand(new String[] {"add", "q/Q1"});
        try {
            command.execute(flashcards, storage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(0, flashcards.getSize());
    }

    @Test
    void constructor_missingQuestion_doesNotAddFlashcard() throws QuizMosFileException, QuizMosInputException {
        FlashcardList flashcards = new FlashcardList();
        Storage storage = new Storage("data/QuizMos.txt") {
            @Override
            public void writeToFile(FlashcardList list) { }
        };

        AddFlashcardCommand command = new AddFlashcardCommand(new String[] {"add", "a/A1"});
        try {
            command.execute(flashcards, storage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(0, flashcards.getSize());
    }

    @Test
    void constructor_reversedOrder_doesNotAddFlashcard() throws QuizMosFileException, QuizMosInputException {
        FlashcardList flashcards = new FlashcardList();
        Storage storage = new Storage("data/QuizMos.txt") {
            @Override
            public void writeToFile(FlashcardList list) { }
        };

        // a/ appears before q/
        AddFlashcardCommand command = new AddFlashcardCommand(new String[] {"add", "a/A1 q/Q1"});
        try {
            command.execute(flashcards, storage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(0, flashcards.getSize());
    }
}
