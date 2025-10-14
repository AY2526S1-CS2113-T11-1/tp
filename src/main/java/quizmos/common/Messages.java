package quizmos.common;

public class Messages {
    // common
    public static String separator = "____________________________________________________________";


    // greeting
    public static String logo = "  ___        _     __  __\n" +
            " / _ \\ _   _(_)___|  \\/  | ___  ___\n" +
            "| | | | | | | |_  / |\\/| |/ _ \\/ __|\n" +
            "| |_| | |_| | |/ /| |  | | (_) \\__ \\\n" +
            " \\__\\_\\\\__,_|_/___|_|  |_|\\___/|___/\n";
    public static String hello = "Hello, I'm QuizMos\n";
    public static String beginInstruction = "Try command `help` for more information";

    // help
    public static String helpMessage = "Available commands:\n"
            + "help: show all commands\n"
            + "list: show all flashcards\n"
            + "add q/<QUESTION> a/<ANSWER>: add a flashcard with question and answer\n"
            + "delete <INDEX>: delete a flashcard by its index\n"
            + "review: start a review session\n"
            + "exit: exit the program, MUST run this for file saving";

    // invalid command
    public static String invalidCommandMessage = "Invalid command! Try `help` for more information";

    public static String invalidIndexMessage = "Invalid index! Use a correct integer flashcard index!\n" +
                                                "Try `list` to see a list of valid flashcards";

    public static String removedTaskMessage = "Removed this flashcard\n";

    public static String addedTaskMessage = "Added this flashcard\n";

    // goodbye
    public static String goodbyeMessage = "Bye. Hope to see you again soon!";

    // flashcard list
    public static String emptyListMessage = "Your task list is empty!";

    // review command
    public static String reviewStartMessage =
    "Starting flashcard review. Type 'ans' to see the answer, "
    + "'next' to continue, or 'exit' to stop.";
    public static String reviewPrompt = "Your input: ";
    public static String reviewExitMessage = "Review session ended.";
    public static String reviewCompleteMessage = "You've reviewed all flashcards!";
    public static String reviewInvalidInputMessage = "Invalid input. Type 'ans', 'next', or 'exit'.";

}
