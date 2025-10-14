package quizmos.command;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;

public class ReviewCommandTest {

    @Test
    public void testReviewCommand() throws IOException {
        FlashcardList flashcardList = new FlashcardList();
        flashcardList.addFlashcard(new Flashcard("What is the capital of France?", "Paris"));
        flashcardList.addFlashcard(new Flashcard("What is 2 + 2?", "4"));

        Storage dummyStorage = new Storage("test/dummy.txt");

        String simulatedInput = "ans\nnext\nans\nexit\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();

        System.setIn(testIn);
        System.setOut(new PrintStream(testOut));

        ReviewCommand reviewCommand = new ReviewCommand();
        reviewCommand.execute(flashcardList, dummyStorage);

        System.setIn(originalIn);
        System.setOut(originalOut);

        String output = testOut.toString();

        assertTrue(output.contains("Question: What is the capital of France?"));
        assertTrue(output.contains("Answer: Paris"));
        assertTrue(output.contains("Question: What is 2 + 2?"));
        assertTrue(output.contains("Answer: 4"));
        assertTrue(output.contains("Review session ended.") || output.contains("You've reviewed all flashcards!"));
    }
}
