package quizmos;

import quizmos.command.Command;
import quizmos.ui.Ui;
import quizmos.parser.Parser;

import java.util.Scanner;

public class QuizMos {
    public QuizMos(){}

    /**
     *
     */
    public static void run(){
        Ui.greeting();
        Scanner in = new Scanner(System.in);

        boolean isExit = false;

        while (!isExit){
            String command = in.nextLine();
            Command c = Parser.parseCommand(command);

            c.execute();
            isExit = c.getIsExit();
        }
        System.exit(0);
    }

    public static void main(String[] args){
        QuizMos.run();
    }
}
