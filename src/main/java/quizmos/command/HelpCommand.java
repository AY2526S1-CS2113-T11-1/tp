package quizmos.command;

import quizmos.ui.Ui;

public class HelpCommand extends Command {
    @Override
    public void execute() {
        Ui.help();
    }
}
