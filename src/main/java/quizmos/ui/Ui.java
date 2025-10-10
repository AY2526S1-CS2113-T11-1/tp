package quizmos.ui;

import quizmos.common.Messages;
import quizmos.flashcard.Flashcard;
import quizmos.flashcardlist.FlashcardList;

import java.util.Scanner;

public class Ui {
    private final Scanner in = new Scanner(System.in);

    /**
     * Reads a line of input from the user.
     *
     * @return The user's input as a string.
     */
    public String readCommand() {
        return in.nextLine();
    }

    /**
     * Announce the message with UI format
     * @param message
     */
    public static void respond(String message){
        System.out.println(Messages.separator);
        System.out.println(message);
        System.out.println(Messages.separator);
    }
    
    public static void greeting(){
        respond(Messages.hello + Messages.logo + Messages.beginInstruction);
    }

    public static void help(){
        respond(Messages.helpMessage);
    }

    public static void goodbye(){
        respond(Messages.goodbyeMessage);
    }

    public void showFlashcardAdded(Flashcard flashcard) {
        String response = Messages.addedTaskMessage + flashcard;
        respond(response);
    }

    public void showFlashcardRemoved(Flashcard flashcard) {
        String response = Messages.removedTaskMessage + flashcard;
        respond(response);
    }

    public static void invalidCommandRespond(){
        respond(Messages.invalidCommandMessage);
    }

    public void showFlashcards(FlashcardList flashcards) {
        if (flashcards.size() == 0) {
            respond(Messages.emptyTaskListMessage);
            return;
        }
        int count = 1;
        for (Flashcard f : flashcards.getAll()) {
            respond(count + ". " + f);
            count++;
        }
    }

}

