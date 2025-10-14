package quizmos.command;

import java.io.IOException;
import java.util.Scanner;

import quizmos.common.Messages;
import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

public class ReviewCommand extends Command {
    private final Scanner in = new Scanner(System.in);

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
