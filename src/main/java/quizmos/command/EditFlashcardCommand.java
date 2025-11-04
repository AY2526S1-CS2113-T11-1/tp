package quizmos.command;

import quizmos.common.FlashcardMessages;
import quizmos.exception.QuizMosInputException;
import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

public class EditFlashcardCommand extends Command {
    private int index;

    public EditFlashcardCommand(String indexStr) throws QuizMosInputException {
        try {
            int oneIndex = Integer.parseInt(indexStr);
            this.index = oneIndex - 1;
        } catch (NumberFormatException | NullPointerException e) {
            throw new QuizMosInputException(FlashcardMessages.invalidIndexMessage);
        }
    }

    @Override
    public void execute(FlashcardList flashcards, Storage storage) throws Exception {
        assert flashcards != null : "FlashcardList should not be null";
        assert storage != null : "Storage should not be null";

        if (index < 0 || index >= flashcards.getSize()) {
            throw new QuizMosInputException(FlashcardMessages.invalidIndexMessage);
        }

        Flashcard flashcard = flashcards.getFlashcard(index);
        
        Ui.printSeparator();
        Ui.printMessage(FlashcardMessages.showCurrentQuestion(flashcard));
        Ui.printMessage(FlashcardMessages.EDIT_INSTRUCTION);
        String newQuestion = Ui.readCommand();
        
        Ui.printMessage(FlashcardMessages.showCurrentAnswer(flashcard));
        Ui.printMessage(FlashcardMessages.EDIT_INSTRUCTION);
        String newAnswer = Ui.readCommand();
        
        boolean questionChanged = !newQuestion.isEmpty() && !newQuestion.equals(flashcard.getQuestion());
        boolean answerChanged = !newAnswer.isEmpty() && !newAnswer.equals(flashcard.getAnswer());
        
        if (questionChanged || answerChanged) {
            if (questionChanged) {
                flashcard.setQuestion(newQuestion);
            }
            
            if (answerChanged) {
                flashcard.setAnswer(newAnswer);
            }
            
            storage.writeToFile(flashcards);
            Ui.respond(FlashcardMessages.showFlashcardEdited(flashcard));
        } else {
            Ui.respond(FlashcardMessages.NO_CHANGES_MADE);
        }
    }
}
