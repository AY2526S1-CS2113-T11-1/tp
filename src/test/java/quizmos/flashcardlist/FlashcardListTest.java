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
        list.add(card);
        assertEquals(1, list.size());
        assertEquals(card, list.get(0));
    }

    @Test
    void testRemoveFlashcard() {
        FlashcardList list = new FlashcardList();
        Flashcard card = new Flashcard("Q1", "A1");
        list.add(card);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    void testGetAll() {
        ArrayList<Flashcard> cards = new ArrayList<>();
        cards.add(new Flashcard("Q1", "A1"));
        cards.add(new Flashcard("Q2", "A2"));
        FlashcardList list = new FlashcardList(cards);

        assertEquals(2, list.size());
        assertEquals(cards, list.getAll());
    }
}
