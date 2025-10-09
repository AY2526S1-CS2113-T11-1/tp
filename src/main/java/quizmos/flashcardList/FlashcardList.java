package quizmos.flashcardList;

import quizmos.flashcard.Flashcard;
import java.util.ArrayList;

public class FlashcardList {
    private final ArrayList<Flashcard> flashcards;

    /**
     * Constructs an empty FlashcardList.
     */
    public FlashcardList() { this.flashcards = new ArrayList<Flashcard>(); }

    /**
     * Constructs a FlashcardList with an existing list of flashcards.
     *
     * @param flashcards The list of flashcards to initialize this FlashcardList with.
     * */
    public FlashcardList(ArrayList<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    /**
     * Adds a flashcard to the flashcards list.
     *
     * @param flashcard The flashcard to be added.
     */
    public void add(Flashcard flashcard) {
        flashcards.add(flashcard);
    }

    /**
     * Removes a flashcard from the flashcard list at the specified index.
     *
     * @param index The index of the flashcard to remove (0-based).
     */
    public void remove(int index) {
        flashcards.remove(index);
    }

    /**
     * Returns a flashcard  from the flashcard  list at the specified index.
     *
     * @param index The index of the flashcard to retrieve (0-based).
     * @return The flashcard at the specified index.
     */
    public Flashcard get(int index) {
        return flashcards.get(index);
    }

    /**
     * Returns the total number of flashcards in the list.
     *
     * @return The size of the flashcard list.
     */
    public int size() {
        return flashcards.size();
    }

    /**
     * Returns the entire list of flashcards.
     *
     * @return An ArrayList containing all flashcards.
     */
    public ArrayList<Flashcard> getAll() { return flashcards; }
}
