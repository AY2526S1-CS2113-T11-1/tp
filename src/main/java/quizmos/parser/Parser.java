package quizmos.parser;

import quizmos.command.Command;
import quizmos.command.ExitCommand;
import quizmos.command.HelpCommand;
import quizmos.command.InvalidCommand;

public class Parser {
    public static Command parseCommand(String command) {
        String commandKeyWord = command.split(" ")[0].toLowerCase();
        try {
            switch (commandKeyWord) {
            case "help":
                return new HelpCommand();
            case "exit":
                return new ExitCommand();
            default:
                return new InvalidCommand();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return new InvalidCommand();
        }
    }
}
