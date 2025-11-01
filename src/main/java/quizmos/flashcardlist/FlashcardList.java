package quizmos.flashcardlist;

import quizmos.flashcard.Flashcard;
import quizmos.ui.Ui;

import java.util.ArrayList;
import java.util.Iterator;

public class FlashcardList implements Iterable<Flashcard> {
    private final ArrayList<Flashcard> flashcards;

    public FlashcardList() {
        this.flashcards = new ArrayList<Flashcard>();
    }

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
    public void addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
    }

    /**
     * Removes a flashcard from the flashcard list at the specified index.
     *
     * @param index The index of the flashcard to removeFlashcard (0-based).
     */
    public void removeFlashcard(int index) {
        flashcards.remove(index);
    }

    /**
     * Returns a flashcard  from the flashcard  list at the specified index.
     *
     * @param index The index of the flashcard to retrieve (0-based).
     * @return The flashcard at the specified index.
     */
    public Flashcard getFlashcard(int index) {
        return flashcards.get(index);
    }

    /**
     * Returns the total number of flashcards in the list.
     *
     * @return The getSize of the flashcard list.
     */
    public int getSize() {
        return flashcards.size();
    }

    /**
     * Returns the entire list of flashcards.
     *
     * @return An ArrayList containing all flashcards.
     */
    public ArrayList<Flashcard> getAll() {
        return flashcards;
    }


    public ArrayList<Flashcard> getStarredFlashcards() {
        ArrayList<Flashcard> starredFlashcards = new ArrayList<>();
        for (Flashcard f : flashcards) {
            if (f.checkIsStarred()) {
                starredFlashcards.add(f);
            }
        }
        return starredFlashcards;
    }

    /**
     * List all cards in the flashcard list
     */

    public void showList() {
        if (this.getSize() == 0) {
            Ui.emptyListRespond();
        } else {
            Ui.showFlashcardsList(this.flashcards);
        }
//        int count = 1;
//        Ui.printSeparator();
//        for (Flashcard f : flashcards) {
//            String response = count + "." + f.toString();
//            System.out.println(response);
//            count++;
//        }
//        Ui.printSeparator();
//        return null;
    }

    @Override
    public Iterator<Flashcard> iterator() {
        return flashcards.iterator();
    }
}
