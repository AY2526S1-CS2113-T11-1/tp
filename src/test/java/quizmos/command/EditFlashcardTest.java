package quizmos.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quizmos.exception.QuizMosFileException;
import quizmos.exception.QuizMosInputException;
import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class EditFlashcardCommandTest {
    private FlashcardList flashcards;
    private StorageStub storage;

    static class StorageStub extends Storage {
        StorageStub() throws QuizMosFileException {
            super("dummy.txt");
        }

        @Override
        public void writeToFile(FlashcardList list) {
        }
    }

    @BeforeEach
    void setUp() throws QuizMosFileException {
        flashcards = new FlashcardList();
        flashcards.addFlashcard(new Flashcard("Q1", "A1"));
        flashcards.addFlashcard(new Flashcard("Q2", "A2"));
        storage = new StorageStub();
    }

    @Test
    void constructor_validIndex_createsCommand() throws QuizMosInputException {
        EditFlashcardCommand command = new EditFlashcardCommand("1");
        assertFalse(command.getIsExit());
    }

    @Test
    void constructor_validIndexTwo_createsCommand() throws QuizMosInputException {
        EditFlashcardCommand command = new EditFlashcardCommand("2");
        assertFalse(command.getIsExit());
    }

    @Test
    void constructor_invalidIndexNonNumeric_throwsException() {
        QuizMosInputException exception = assertThrows(QuizMosInputException.class, 
            () -> new EditFlashcardCommand("abc"));
        assertTrue(exception.getMessage().contains("Invalid index"));
    }

    @Test
    void constructor_invalidIndexNull_throwsException() {
        assertThrows(QuizMosInputException.class, () -> new EditFlashcardCommand(null));
    }

    @Test
    void constructor_invalidIndexEmpty_throwsException() {
        assertThrows(QuizMosInputException.class, () -> new EditFlashcardCommand(""));
    }

    @Test
    void constructor_invalidIndexWithSpaces_throwsException() {
        assertThrows(QuizMosInputException.class, () -> new EditFlashcardCommand("  "));
    }

    @Test
    void constructor_invalidIndexNegative_createsCommandButWillFailOnExecute() 
            throws QuizMosInputException {
        EditFlashcardCommand command = new EditFlashcardCommand("-1");
        assertFalse(command.getIsExit());
    }

    @Test
    void constructor_invalidIndexZero_createsCommandButWillFailOnExecute() 
            throws QuizMosInputException {
        EditFlashcardCommand command = new EditFlashcardCommand("0");
        assertFalse(command.getIsExit());
    }

    @Test
    void constructor_invalidIndexOutOfBounds_createsCommandButWillFailOnExecute() 
            throws QuizMosInputException {
        EditFlashcardCommand command = new EditFlashcardCommand("100");
        assertFalse(command.getIsExit());
    }

    @Test
    void execute_indexOutOfBoundsPositive_throwsException() throws QuizMosInputException {
        EditFlashcardCommand command = new EditFlashcardCommand("100");
        assertThrows(QuizMosInputException.class, () -> command.execute(flashcards, storage));
    }

    @Test
    void execute_indexOutOfBoundsNegative_throwsException() throws QuizMosInputException {
        EditFlashcardCommand command = new EditFlashcardCommand("-1");
        assertThrows(QuizMosInputException.class, () -> command.execute(flashcards, storage));
    }

    @Test
    void execute_indexZero_throwsException() throws QuizMosInputException {
        EditFlashcardCommand command = new EditFlashcardCommand("0");
        assertThrows(QuizMosInputException.class, () -> command.execute(flashcards, storage));
    }

    @Test
    void execute_nullFlashcardList_shouldFailAssertion() throws QuizMosInputException {
        EditFlashcardCommand command = new EditFlashcardCommand("1");
        AssertionError e = assertThrows(AssertionError.class, 
            () -> command.execute(null, storage));
        assertTrue(e.getMessage().contains("FlashcardList should not be null"));
    }

    @Test
    void execute_nullStorage_shouldFailAssertion() throws QuizMosInputException {
        EditFlashcardCommand command = new EditFlashcardCommand("1");
        AssertionError e = assertThrows(AssertionError.class, 
            () -> command.execute(flashcards, null));
        assertTrue(e.getMessage().contains("Storage should not be null"));
    }

    @Test
    void flashcard_settersWork_allowsEditing() {
        Flashcard flashcard = new Flashcard("Original Q", "Original A");
        
        flashcard.setQuestion("New Question");
        assertEquals("New Question", flashcard.getQuestion());
        
        flashcard.setAnswer("New Answer");
        assertEquals("New Answer", flashcard.getAnswer());
    }

    @Test
    void flashcard_settersPreserveStarStatus() {
        Flashcard flashcard = new Flashcard("Q", "A");
        flashcard.toggleStar();
        assertTrue(flashcard.checkIsStarred());
        
        flashcard.setQuestion("New Q");
        flashcard.setAnswer("New A");
        
        assertTrue(flashcard.checkIsStarred(), "Star status should be preserved after editing");
    }

    @Test
    void flashcardList_maintainsOrderAfterModification() {
        Flashcard first = flashcards.getFlashcard(0);
        Flashcard second = flashcards.getFlashcard(1);
        
        first.setQuestion("Modified Q1");
        first.setAnswer("Modified A1");
        
        assertEquals("Modified Q1", flashcards.getFlashcard(0).getQuestion());
        assertEquals("Q2", flashcards.getFlashcard(1).getQuestion());
        assertEquals(2, flashcards.getSize());
    }

    @Test
    void constructor_largeValidIndex_createsCommand() throws QuizMosInputException {
        EditFlashcardCommand command = new EditFlashcardCommand("999");
        assertFalse(command.getIsExit());
    }

    @Test
    void constructor_indexWithLeadingZeros_parsesCorrectly() throws QuizMosInputException {
        EditFlashcardCommand command = new EditFlashcardCommand("01");
        assertFalse(command.getIsExit());
    }
}
