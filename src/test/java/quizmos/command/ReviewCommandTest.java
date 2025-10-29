package quizmos.command;

import org.junit.jupiter.api.Test;
import quizmos.exception.QuizMosInputException;
import quizmos.exception.QuizMosLogicException;
import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReviewCommandTest {

    @Test
    void constructor_missingMode_throwsQuizMosInputException() {
        String command1 = "review";
        String command2 = "review abc";
        assertThrows(QuizMosInputException.class, () -> {
            new ReviewCommand(command1);
        });
        assertThrows(QuizMosInputException.class, () -> {
            new ReviewCommand(command2);
        });
    }

    @Test
    void constructor_validMode_success() {
        String mcq = "review m/mcq";
        String tf = "review m/tf";
        String flip = "review m/flip";
        assertDoesNotThrow(() -> {
            new ReviewCommand(mcq);
        });
        assertDoesNotThrow(() -> {
            new ReviewCommand(tf);
        });
        assertDoesNotThrow(() -> {
            new ReviewCommand(flip);
        });
    }

    @Test
    void execute_emptyList_throwsQuizMosLogicException() {
        FlashcardList emptyList = new FlashcardList();
        Storage storage = null;

        assertDoesNotThrow(() -> {
            ReviewCommand reviewCommand = new ReviewCommand("review m/mcq");
            assertThrows(QuizMosLogicException.class, () -> {
                reviewCommand.execute(emptyList, storage);
            });
        });
    }

    @Test
    void execute_mcqWithNotEnoughCards_throwsQuizMosLogicException() {
        FlashcardList shortList = new FlashcardList();
        shortList.addFlashcard(new Flashcard("1", "1"));
        shortList.addFlashcard(new Flashcard("2", "2"));
        shortList.addFlashcard(new Flashcard("3", "3"));

        Storage storage = null;

        assertDoesNotThrow(() -> {
            ReviewCommand reviewCommand = new ReviewCommand("review m/mcq");

            assertThrows(QuizMosLogicException.class, () -> {
                reviewCommand.execute(shortList, storage);
            });
        });
    }
}
