package quizmos.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class InvalidCommandTest {
    @Test
    void invalidCommandTest_constructor_isExitSetToFalse(){
        InvalidCommand invalidCommand = new InvalidCommand();
        assertFalse(invalidCommand.getIsExit());
    }
}
