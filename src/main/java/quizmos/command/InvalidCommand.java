package quizmos.command;

import quizmos.ui.Ui;

public class InvalidCommand extends Command{
    /**
     * Print the response and suggestion when user typed invalid command
     */
    @Override
    public void execute() {
        Ui.invalidCommandRespond();
    }
}
