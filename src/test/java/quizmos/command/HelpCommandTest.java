package quizmos.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class HelpCommandTest {
    @Test
    void helpCommand_constructor_isExitSetToFalse(){
        HelpCommand helpCommand = new HelpCommand();
        assertFalse(helpCommand.getIsExit());
    }
}
