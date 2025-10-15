package quizmos.command;

import java.io.IOException;

import quizmos.common.Messages;
import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

/**
 * Represents a command that initiates a flashcard review session.
 * In review mode, each flashcard is shown one at a time, allowing the user
 * to view the question, reveal the answer, and proceed to the next card.
 * The session can be exited early with the "exit" command.
 */
public class ReviewCommand extends Command {

    @Override
    public void execute(FlashcardList flashcards, Storage storage) throws IOException {
        if (flashcards.getSize() == 0) {
            Ui.emptyListRespond();
            return;
        }

        Ui.respond(Messages.reviewStartMessage);

        for (int i = 0; i < flashcards.getSize(); i++) {
            Flashcard card = flashcards.getFlashcard(i);
            Ui.printSeparator();
            System.out.println("Flashcard " + (i + 1) + ":");
            System.out.println("Question: " + card.getQuestion());
            Ui.printSeparator();

            boolean answered = false;
            while (!answered) {
                System.out.print("Your input: ");
                String input = Ui.readCommand().trim().toLowerCase();

                switch (input) {
                case "ans" -> System.out.println("Answer: " + card.getAnswer());
                case "next" -> answered = true;
                case "exit" -> {
                    Ui.respond(Messages.reviewExitMessage);
                    return;
                }
                default -> System.out.println(Messages.reviewInvalidInputMessage);
                }
            }       
        }

        Ui.respond(Messages.reviewCompleteMessage);
    }
}
