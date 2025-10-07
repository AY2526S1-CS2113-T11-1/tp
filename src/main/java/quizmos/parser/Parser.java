package quizmos.parser;

import quizmos.command.Command;
import quizmos.command.ExitCommand;
import quizmos.command.HelpCommand;
import quizmos.command.InvalidCommand;

public class Parser {
    /**
     * Parse user's raw command and return the Command object
     *
     * @param command
     * @return suitable Command object
     */
    public static Command parseCommand(String command) {
        String commandKeyWord = command.trim().split(" ")[0].toLowerCase();
        try {
            return switch (commandKeyWord) {
            case "help" -> new HelpCommand();
            case "exit" -> new ExitCommand();
            default -> new InvalidCommand();
            };
        } catch (ArrayIndexOutOfBoundsException e) {
            return new InvalidCommand();
        }
    }
}
