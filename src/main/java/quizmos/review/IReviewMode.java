package quizmos.review;

import quizmos.flashcard.Flashcard;

public interface IReviewMode {
    void displayQuestion(Flashcard flashcard, int index);
    boolean checkAnswer(String input, Flashcard flashcard);
    String getPrompt();
}
