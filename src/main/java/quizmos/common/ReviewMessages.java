package quizmos.common;

import quizmos.flashcard.Flashcard;

public class ReviewMessages {

    public static final String REVIEW_EMPTY_LIST = "List is empty\n" +
            "Try add some flashcards: add q/<QUESTION> a/<ANSWER>";

    public static final String REVIEW_MISSING_MODE = "Please pick a review mode: review m/[FLIP | MCQ | TF]";
    public static final String REVIEW_INVALID_MODE = "Invalid review mode: review m/[FLIP | MCQ | TF]";

    public static final String PROMPT_FLIP = "Do you want to show answer? (y/n/quit): ";
    public static final String INVALID_INPUT_FLIP = "Invalid input, just use (y/n/quit)";

    public static final String PROMPT_MCQ = "Your input (1/2/3/4/quit): ";
    public static final String INVALID_INPUT_MCQ = "Invalid input, just use (1/2/3/4/quit)";

    public static final String PROMPT_TF = "Your input (t/f/quit): ";
    public static final String INVALID_INPUT_TF = "Invalid input, just use (t/f/quit)";

    public static final String ANSWER = "Answer: ";
    public static final String CORRECT_ANSWER = "Correct answer :)";
    public static final String INCORRECT_ANSWER = "Incorrect answer :(";

    public static final String MCQ_NOT_ENOUGH_FLASHCARDS = "Not enough flashcards, " +
            "MCQ mode requires at least 4 flashcards\n" +
            "Please add more flashcard";

    private ReviewMessages() {}

    public static String endReview(int count) {
        return "Review session ended!\n" + "Total reviewed: " + count;
    }

    public static String reviewResult(int count, int correct) {
        float percentage;
        if (count == 0) {
            percentage = 0;
        } else {
            percentage = Math.round((float)correct / (float)count * 100);
        }
        return "Correct questions: " + correct + " (" + percentage + "%)";
    }

    public static String showStatementTF(Flashcard flashcard) {
        return "Statement: " + flashcard.getAnswer();
    }

    public static String showCorrectAnswerTF(Flashcard flashcard) {
        return "True answer: " + flashcard.getAnswer();
    }

    public static String showCorrectAnswerMCQ(int currentAnswer, Flashcard flashcard) {
        return "Correct answer: " + (currentAnswer + 1) + ". " + flashcard.getAnswer();
    }

    public static String showAnswer(Flashcard flashcard) {
        return ANSWER + flashcard.getAnswer();
    }

    public static String flashcardQuestionString(Flashcard flashcard, int index) {
        String card = "Flashcard no." + (index + 1) + "\n";
        String question = "Question: " + flashcard.getQuestion();
        return card + question;
    }

    public static String mcqChoice(Flashcard flashcard, int choiceIndex) {
        return (choiceIndex + 1) + ". " + flashcard.getAnswer();
    }
}
