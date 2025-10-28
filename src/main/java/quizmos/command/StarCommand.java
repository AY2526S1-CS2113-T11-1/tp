package quizmos.command;

import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;

import java.io.IOException;

public class StarCommand extends Command{
    private final int index;
    public StarCommand(int index) {
        this.index = index;
    }
    @Override
    public void execute(FlashcardList flashcards, Storage storage) throws IOException {
        flashcards.getFlashcard(index).toggleStar();
    }
}
