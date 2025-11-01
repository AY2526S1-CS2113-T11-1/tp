package quizmos.flashcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlashcardTest {

    @Test
    void testFlashcardCreationAndGetters() {
        Flashcard flashcard = new Flashcard("Question?", "Answer!");
        assertEquals("Question?", flashcard.getQuestion());
        assertEquals("Answer!", flashcard.getAnswer());
    }

    @Test
    void testToStringFormat() {
        Flashcard flashcard = new Flashcard("What is Java?", "A programming language");
        String expected = "Question: What is Java? | Answer: A programming language | ";
        assertEquals(expected, flashcard.toString());
    }

    @Test
    void testToSaveFormat() {
        Flashcard flashcard = new Flashcard("Q1", "A1");
        assertEquals("Q1 | A1 | ", flashcard.toSaveFormat());
    }
}
