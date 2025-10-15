package quizmos.command;

import java.io.IOException;

import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

public class ReviewCommand extends Command {

    @Override
    public void execute(FlashcardList flashcards, Storage storage) throws IOException {
        if (flashcards.getSize() == 0) {
            Ui.emptyListRespond();
            return;
        }

        Ui.respond("Starting flashcard review. Type 'ans' to see the answer, 'next' to continue, or 'exit' to stop.");

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
                    Ui.respond("Review session ended.");
                    return;
                }
                default -> System.out.println("Invalid input. Type 'ans', 'next', or 'exit'.");
                }
            }
        }

        Ui.respond("You've reviewed all flashcards!");
    }
}
