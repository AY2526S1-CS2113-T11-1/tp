package quizmos.command;

import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

import java.io.IOException;

public class StarCommand extends Command{
    private final int index;
    public StarCommand(String index) {
        this.index = Integer.parseInt(index)-1;
    }
    @Override
    public void execute(FlashcardList flashcards, Storage storage) throws IOException {
        flashcards.getFlashcard(index).toggleStar();
        Ui.showStarredFlashcard();
        storage.writeToFile(flashcards);

    }
}
