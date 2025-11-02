package quizmos.review;

import quizmos.common.ReviewMessages;
import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;
import quizmos.ui.Ui;

import java.util.List;

public class TrueFalseReview implements IReviewMode {
    private final FlashcardList flashcardList;
    private final List<String> choices = List.of("t", "f", "quit");
    private boolean currentAnswer;

    public TrueFalseReview(FlashcardList flashcardList) {
        super();
        this.flashcardList = flashcardList;
    }

    public int randomQuestion(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    /**
     * create a random index (random flashcard)
     * if the random flashcard is the correct one so set currentAnswer = true
     *
     * @param flashcard reviewing
     * @param index flashcard's index
     */
    public void displayQuestion(Flashcard flashcard, int index) {
        assert flashcardList != null: "FlashcardList can not be null";

        Ui.printSeparator();
        Ui.printMessage(ReviewMessages.flashcardQuestionString(flashcard, index));

        int size = flashcardList.getSize();
        int random = randomQuestion(0, size - 1);
        String rightAnswer = flashcard.getAnswer();
        String randomAnswer = flashcardList.getFlashcard(random).getAnswer();

        currentAnswer = (random == index) || (rightAnswer.equals(randomAnswer));
        Ui.printMessage(ReviewMessages.showStatementTF(randomAnswer));
    }

    /**
     * @param input user's input (t/f)
     * @param flashcard reviewing
     * @return true if correct, false if not
     */
    public boolean checkAnswer(String input, Flashcard flashcard) {
        assert input.equals("t") || input.equals("f"): "Input can only be (t/f)";

        if (input.equals("t")) {
            if (currentAnswer) {
                Ui.printMessage(ReviewMessages.CORRECT_ANSWER);
                Ui.printSeparator();
                return true;
            } else {
                Ui.printMessage(ReviewMessages.INCORRECT_ANSWER);
                Ui.printMessage(ReviewMessages.showCorrectAnswerTF(flashcard));
                Ui.printSeparator();
                return false;
            }
        } else {
            if (!currentAnswer) {
                Ui.printMessage(ReviewMessages.CORRECT_ANSWER);
                Ui.printMessage(ReviewMessages.showCorrectAnswerTF(flashcard));
                Ui.printSeparator();
                return true;
            } else {
                Ui.printMessage(ReviewMessages.INCORRECT_ANSWER);
                Ui.printSeparator();
                return false;
            }
        }
    }

    /**
     * @return user's input (t/f/quit)
     */
    public String getPrompt() {
        while (true) {
            Ui.printMessage(ReviewMessages.PROMPT_TF);
            String input = Ui.readCommand().trim().toLowerCase();
            if (choices.contains(input)) {
                return input;
            }
            Ui.printError(ReviewMessages.INVALID_INPUT_TF);
        }
    }

}
