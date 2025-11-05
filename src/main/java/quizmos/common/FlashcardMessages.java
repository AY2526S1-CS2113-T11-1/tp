package quizmos.common;

import quizmos.flashcard.Flashcard;

public class FlashcardMessages {
    public static String invalidAddCommand = "Invalid command! Try add q/<QUESTION> a/<ANSWER>";
    public static String addedFlashcardMessage = "Added this flashcard\n";
    public static String noMatchesMessage = "No matches found";
    public static String invalidIndexMessage = "Invalid index! Use a correct integer flashcard index!\n" +
            "Try `list` to see a list of valid flashcards";
    public static String removedFlashcardMessage = "Removed this flashcard\n";
    public static String starredFlashcardMessage = "Starred this flashcard:\n";
    public static String unstarredFlashcardMessage = "Unstarred this flashcard:\n";
    public static final String EDIT_INSTRUCTION = "Press Enter when done editing:";
    public static final String NO_CHANGES_MADE = "No changes made to flashcard.";
    public static String editedFlashcardMessage = "Edited this flashcard\n";

    public static String showFlashcardAdded(Flashcard flashcard) {
        return addedFlashcardMessage + flashcard;
    }
    public static String showStarredFlashcard(Flashcard starredFlashcard) {
        return (starredFlashcardMessage + starredFlashcard.toString());
    }
    public static String showFlashcardRemoved(Flashcard flashcard) {
        return removedFlashcardMessage + flashcard;
    }

    public static String showUnstarredFlashcard(Flashcard unstarredFlashcard) {
        return(unstarredFlashcardMessage + unstarredFlashcard.toString());
    }

    public static String showCurrentQuestion(Flashcard flashcard) {
        return "Question: " + flashcard.getQuestion();
    }
    
    public static String showCurrentAnswer(Flashcard flashcard) {
        return "Answer: " + flashcard.getAnswer();
    }
    
    public static String showFlashcardEdited(Flashcard flashcard) {
        return editedFlashcardMessage + flashcard;
    }
}
