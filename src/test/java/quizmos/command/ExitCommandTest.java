package quizmos.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ExitCommandTest {
    @Test
    void exitCommand_constructor_isExitSetToTrue() {
        ExitCommand exitCommand = new ExitCommand();
        assertTrue(exitCommand.getIsExit());
    }
}
