package quizmos.parser;

import quizmos.command.AddFlashcardCommand;
import quizmos.command.Command;
import quizmos.command.ExitCommand;
import quizmos.command.HelpCommand;
import quizmos.command.InvalidCommand;
import quizmos.command.RemoveFlashcardCommand;

public class Parser {
    /**
     * Parse user's raw command and return the Command object
     *
     * @param command
     * @return suitable Command object
     */
    public static Command parseCommand(String command) {
        String trimmed = command.trim();
        String[] parts = trimmed.split(" ", 2);
        String commandKeyword = parts[0].toLowerCase();

        try {
            return switch (commandKeyword) {
            case "help" -> new HelpCommand();
            case "exit" -> new ExitCommand();
            case "add" -> {
                String args = parts[1];
                int qIndex = args.indexOf("q/");
                int aIndex = args.indexOf("a/");
                String question = args.substring(qIndex + 2, aIndex).trim();
                String answer = args.substring(aIndex + 2).trim();

                yield new AddFlashcardCommand(question, answer);
            }
            case "delete" -> {
                int oneIndex = Integer.parseInt(parts[1].trim());
                int zeroIndex =  oneIndex - 1;
                yield new RemoveFlashcardCommand(zeroIndex);
            }
            default -> new InvalidCommand();
            };
        } catch (ArrayIndexOutOfBoundsException e) {
            return new InvalidCommand();
        }
    }
}
