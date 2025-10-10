package quizmos.command;

import org.junit.jupiter.api.Test;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AddFlashcardCommandTest {

    @Test
    void testExecuteAddsFlashcard() throws IOException {
        FlashcardList flashcards = new FlashcardList();
        Ui ui = new Ui();
        Storage storage = new Storage("data/QuizMos.txt") {
            @Override
            public void writeToFile(FlashcardList list) { /* skip actual writing */ }
        };

        AddFlashcardCommand command = new AddFlashcardCommand("Q1", "A1");
        command.execute(flashcards, ui, storage);

        assertEquals(1, flashcards.size());
        assertEquals("Q1", flashcards.get(0).getQuestion());
        assertEquals("A1", flashcards.get(0).getAnswer());
    }
}
