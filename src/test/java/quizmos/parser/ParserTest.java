package quizmos.parser;

import org.junit.jupiter.api.Test;
import quizmos.command.Command;
import quizmos.command.ExitCommand;
import quizmos.command.HelpCommand;
import quizmos.command.InvalidCommand;
import quizmos.command.AddFlashcardCommand;
import quizmos.command.RemoveFlashcardCommand;
import quizmos.command.SearchFlashcardCommand;
import quizmos.exception.QuizMosInputException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ParserTest {
    @Test
    void parseCommand_validCommand_correctCommandType() throws QuizMosInputException {
        // help command
        Command helpCommand = Parser.parseCommand("help");
        assertInstanceOf(HelpCommand.class, helpCommand);
        assertFalse(helpCommand.getIsExit());

        Command untrimHelpCommand = Parser.parseCommand("   help   ");
        assertInstanceOf(HelpCommand.class, untrimHelpCommand);
        assertFalse(untrimHelpCommand.getIsExit());

        // exit command
        Command exitCommand = Parser.parseCommand("exit");
        assertInstanceOf(ExitCommand.class, exitCommand);
        assertTrue(exitCommand.getIsExit());

        Command untrimExitCommand = Parser.parseCommand("   exit   ");
        assertInstanceOf(ExitCommand.class, untrimExitCommand);
        assertTrue(untrimExitCommand.getIsExit());
    }

    @Test
    void parseCommand_validAddCommand_returnsAddFlashcardCommand() throws QuizMosInputException {
        Command command = Parser.parseCommand("add q/What is Java? a/A programming language");
        assertInstanceOf(AddFlashcardCommand.class, command);
    }

    @Test
    void parseCommand_addCommandMissingArgs_returnsAddFlashcardCommand() throws QuizMosInputException {
        // missing both q/ and a/
        Command noArgs = Parser.parseCommand("add something random");
        assertInstanceOf(AddFlashcardCommand.class, noArgs);

        // missing a/
        Command missingAnswer = Parser.parseCommand("add q/What is Java?");
        assertInstanceOf(AddFlashcardCommand.class, missingAnswer);

        // missing q/
        Command missingQuestion = Parser.parseCommand("add a/A programming language");
        assertInstanceOf(AddFlashcardCommand.class, missingQuestion);
    }

    @Test
    void parseCommand_validDeleteCommand_returnsRemoveFlashcardCommand() throws QuizMosInputException {
        Command command = Parser.parseCommand("delete 1");
        assertInstanceOf(RemoveFlashcardCommand.class, command);
    }

    @Test
    void parseCommand_deleteCommandMissingOrInvalidIndex_returnsRemoveFlashcardCommand() throws QuizMosInputException {
        // missing index
        Command noIndex = Parser.parseCommand("delete");
        assertInstanceOf(InvalidCommand.class, noIndex);

        // not a number
        Command notNumber = Parser.parseCommand("delete abc");
        assertInstanceOf(RemoveFlashcardCommand.class, notNumber);

        // negative number
        Command negativeNumber = Parser.parseCommand("delete -3");
        assertInstanceOf(RemoveFlashcardCommand.class, negativeNumber);

        // extra spaces
        Command spacedOut = Parser.parseCommand("delete    ");
        assertInstanceOf(InvalidCommand.class, spacedOut);
    }

    @Test
    void parseCommand_validSearchCommand_returnsSearchFlashcardCommand() throws QuizMosInputException {
        Command command = Parser.parseCommand("search java");
        assertInstanceOf(SearchFlashcardCommand.class, command);

        Command spacedCommand = Parser.parseCommand("   search   oop   ");
        assertInstanceOf(SearchFlashcardCommand.class, spacedCommand);
    }

    @Test
    void parseCommand_searchCommandMissingKeyword_returnsInvalidCommand() throws QuizMosInputException {
        // no keyword
        Command noKeyword = Parser.parseCommand("search");
        assertInstanceOf(InvalidCommand.class, noKeyword);

        // only spaces after search
        Command onlySpaces = Parser.parseCommand("search     ");
        assertInstanceOf(InvalidCommand.class, onlySpaces);
    }

    @Test
    void parseCommand_invalidCommand_invalidCommandInstance() throws QuizMosInputException {
        // empty string
        Command emptyCommand = Parser.parseCommand("");
        assertInstanceOf(InvalidCommand.class, emptyCommand);
        assertFalse(emptyCommand.getIsExit());

        // string only contains space
        Command spaceCommand = Parser.parseCommand(" ");
        assertInstanceOf(InvalidCommand.class, spaceCommand);
        assertFalse(spaceCommand.getIsExit());

        // invalid alphabet string
        Command alphabeticCommand = Parser.parseCommand("alphabetic");
        assertInstanceOf(InvalidCommand.class, alphabeticCommand);
        assertFalse(alphabeticCommand.getIsExit());

        // invalid numeric string
        Command numericCommand = Parser.parseCommand("123456");
        assertInstanceOf(InvalidCommand.class, numericCommand);
        assertFalse(numericCommand.getIsExit());

        // invalid symbol string
        Command symbolCommand = Parser.parseCommand("@#$@*(&  #@$_+_+");
        assertInstanceOf(InvalidCommand.class, symbolCommand);
        assertFalse(symbolCommand.getIsExit());
    }
}
