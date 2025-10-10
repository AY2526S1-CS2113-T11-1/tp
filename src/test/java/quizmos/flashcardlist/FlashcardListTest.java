package quizmos.flashcardlist;

import org.junit.jupiter.api.Test;
import quizmos.flashcard.Flashcard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

class FlashcardListTest {

    @Test
    void testAddAndGetFlashcard() {
        FlashcardList list = new FlashcardList();
        Flashcard card = new Flashcard("Q1", "A1");
        list.addFlashcard(card);
        assertEquals(1, list.getSize());
        assertEquals(card, list.getFlashcard(0));
    }

    @Test
    void testRemoveFlashcard() {
        FlashcardList list = new FlashcardList();
        Flashcard card = new Flashcard("Q1", "A1");
        list.addFlashcard(card);
        list.removeFlashcard(0);
        assertEquals(0, list.getSize());
    }

    @Test
    void testGetAll() {
        ArrayList<Flashcard> cards = new ArrayList<>();
        cards.add(new Flashcard("Q1", "A1"));
        cards.add(new Flashcard("Q2", "A2"));
        FlashcardList list = new FlashcardList(cards);

        assertEquals(2, list.getSize());
        assertEquals(cards, list.getAll());
    }
}
