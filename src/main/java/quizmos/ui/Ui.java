package quizmos.ui;

import quizmos.common.Messages;

public class Ui {
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

    public static void invalidCommandRespond(){
        respond(Messages.invalidCommandMessage);
    }

}
