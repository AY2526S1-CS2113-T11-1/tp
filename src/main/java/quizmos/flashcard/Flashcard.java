package quizmos.flashcard;

public class Flashcard {
    private String question;
    private String answer;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String toSaveFormat() { return getQuestion() + " | " + getAnswer(); }

    public String toString() { return "Question: " + getQuestion() + " | " + "Answer: " + getAnswer(); }
}
