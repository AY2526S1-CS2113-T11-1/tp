package quizmos.parser;

import quizmos.command.AddFlashcardCommand;
import quizmos.command.Command;
import quizmos.command.ExitCommand;
import quizmos.command.HelpCommand;
import quizmos.command.InvalidCommand;
import quizmos.command.ListCommand;
import quizmos.command.RemoveFlashcardCommand;
import quizmos.command.ReviewCommand;

public class Parser {
    /**
     * Parse user's raw command and return the Command object
     *
     * @param command
     * @return suitable Command object
     */
    private static final String FLASHCARD_QUESTION_KEY = "q/";
    private static final String FLASHCARD_ANSWER_KEY = "a/";
    public static Command parseCommand(String command) {
        String trimmed = command.trim();
        String[] parts = trimmed.split(" ", 2);
        String commandKeyword = parts[0].toLowerCase();

        try {
            return switch (commandKeyword) {
            case "help" -> new HelpCommand();
            case "exit" -> new ExitCommand();
            case "list" -> new ListCommand();
            case "add" -> new AddFlashcardCommand(parts);
            case "delete" -> new RemoveFlashcardCommand(parts[1].trim());
            case "review" -> new ReviewCommand();
            default -> new InvalidCommand();
            };
        } catch (ArrayIndexOutOfBoundsException e) {
            return new InvalidCommand();
        }
    }
}
