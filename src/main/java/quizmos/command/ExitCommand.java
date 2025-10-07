package quizmos.command;

import quizmos.ui.Ui;

public class ExitCommand extends Command {
    public ExitCommand() {
        this.isExit = true;
    }

    @Override
    public void execute() {
        Ui.goodbye();
    }
}
