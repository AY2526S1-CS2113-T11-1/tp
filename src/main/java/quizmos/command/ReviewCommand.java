package quizmos.command;

import java.io.IOException;
import java.util.Scanner;

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
    private final Scanner in = new Scanner(System.in);
    /**
     * Executes the review session.
     * Iterates through the flashcard list, prompting the user to type "ans" to see the answer,
     * "next" to continue to the next flashcard, or "exit" to stop the session.
     *
     * @param flashcards The list of flashcards to review.
     * @param storage The storage system (not modified during review).
     * @throws IOException Not expected in this command, but required by interface.
     */
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
                System.out.print(Messages.reviewPrompt);
                String input = in.nextLine().trim().toLowerCase();

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
