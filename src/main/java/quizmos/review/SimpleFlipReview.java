package quizmos.review;

import quizmos.common.ReviewMessages;
import quizmos.flashcard.Flashcard;
import quizmos.ui.Ui;

import java.util.List;

public class SimpleFlipReview implements IReviewMode {
    private final List<String> choices = List.of("y", "n", "quit");

    public SimpleFlipReview() {}

    /**
     * Print separator, flashcard's index and question
     *
     * @param flashcard reviewing
     * @param index flashcard's index
     */
    public void displayQuestion(Flashcard flashcard, int index) {
        Ui.printSeparator();
        Ui.printMessage(ReviewMessages.flashcardQuestionString(flashcard, index));
    }

    /**
     * Print the answer if the user wants
     *
     * @param input user's input
     * @param flashcard reviewing
     * @return true (flip mode don't care about true/false)
     */
    public boolean checkAnswer(String input, Flashcard flashcard) {
        assert input.equals("y") || input.equals("n"): "Input can only be (y/n)";

        if (input.equals("y")) {
            Ui.printMessage(ReviewMessages.showAnswer(flashcard));
        }
        Ui.printSeparator();
        return true;
    }

    /**
     * Prompt user if they want to show answer or not (y/n)
     * Or they can just quit (quit)
     * @return user's input
     */
    public String getPrompt() {
        while (true) {
            Ui.printPrompt(ReviewMessages.PROMPT_FLIP);
            String input = Ui.readCommand().trim().toLowerCase();
            if (choices.contains(input)) {
                return input;
            }
            Ui.printError(ReviewMessages.INVALID_INPUT_FLIP);
        }
    }
}
