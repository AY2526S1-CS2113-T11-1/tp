package quizmos.parser;

import quizmos.command.AddFlashcardCommand;
import quizmos.command.Command;
import quizmos.command.ExitCommand;
import quizmos.command.HelpCommand;
import quizmos.command.InvalidCommand;
import quizmos.command.InvalidIndexCommand;
import quizmos.command.ListCommand;
import quizmos.command.RemoveFlashcardCommand;

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
            case "add" -> {
                // return a false command if the command is not formatted correctly
                if (parts.length == 1
                        || !trimmed.contains(FLASHCARD_QUESTION_KEY)
                        || !trimmed.contains(FLASHCARD_ANSWER_KEY)) {
                    yield new InvalidCommand();
                }
                String args = parts[1];
                int qIndex = args.indexOf(FLASHCARD_QUESTION_KEY);
                int aIndex = args.indexOf(FLASHCARD_ANSWER_KEY);
                String question = args.substring(qIndex + 2, aIndex).trim();
                String answer = args.substring(aIndex + 2).trim();

                yield new AddFlashcardCommand(question, answer);
            }
            case "delete" -> {
                try {
                    int oneIndex = Integer.parseInt(parts[1].trim());
                    int zeroIndex =  oneIndex - 1;
                    yield new RemoveFlashcardCommand(zeroIndex);
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException | NullPointerException e) {
                    yield new InvalidIndexCommand();
                }
            }
            default -> new InvalidCommand();
            };
        } catch (ArrayIndexOutOfBoundsException e) {
            return new InvalidCommand();
        }
    }
}
