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

    public FlashcardList(ArrayList<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    public void addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
    }

    public void removeFlashcard(int index) {
        flashcards.remove(index);
    }

    public Flashcard getFlashcard(int index) {
        return flashcards.get(index);
    }

    public int getSize() {
        return flashcards.size();
    }

    public ArrayList<Flashcard> getAll() {
        return flashcards;
    }

    /**
     * List all cards in the flashcard list
     */
    public void showList() {
        if (this.getSize() == 0) {
            Ui.emptyListRespond();
            return;
        }
        int count = 1;
        Ui.printSeparator();
        for (Flashcard f : flashcards) {
            String response = count + "." + f.toString();
            System.out.println(response);
            count++;
        }
        Ui.printSeparator();
    }

    @Override
    public Iterator<Flashcard> iterator() {
        return flashcards.iterator();
    }
}
