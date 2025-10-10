package quizmos.ui;

import quizmos.common.Messages;
import quizmos.flashcard.Flashcard;

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

    public static void printSeparator(){
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

    public static void invalidCommandRespond(){
        respond(Messages.invalidCommandMessage);
    }

    // Flashcard
    public static void showFlashcardAdded(Flashcard flashcard) {
        String response = "Added this flashcard\n" + flashcard;
        respond(response);
    }

    public static void showFlashcardRemoved(Flashcard flashcard) {
        String response = "Removed this flashcard\n" + flashcard;
        respond(response);
    }

    // FlashcardList
    public static void emptyListRespond() {
        respond(Messages.emptyListMessage);
    }


}

