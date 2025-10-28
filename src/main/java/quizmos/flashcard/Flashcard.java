package quizmos.flashcard;

public class Flashcard {
    private String question;
    private String answer;
    private boolean isStarred;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.isStarred = false;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isStarred() {
        return isStarred;
    }

    public void toggleStar() {
        isStarred = true;
    }

    public String toSaveFormat() {
        return getQuestion() + " | " + getAnswer();
    }

    public String toString() {
        return "Question: " + getQuestion() + " | " + "Answer: " + getAnswer();
    }
}
