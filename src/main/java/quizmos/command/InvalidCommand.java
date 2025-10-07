package quizmos.command;

import quizmos.ui.Ui;

public class InvalidCommand extends Command{
    @Override
    public void execute() {
        Ui.invalidCommandResponse();
    }
}
