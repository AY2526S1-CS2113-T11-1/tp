package quizmos.command;

import quizmos.deck.Deck;
import quizmos.storage.Storage;
import quizmos.ui.Ui;

public class HelpCommand extends Command {
    @Override
    public void execute() {
        Ui.help();
    }
}
