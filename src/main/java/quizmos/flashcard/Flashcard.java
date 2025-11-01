package quizmos.flashcard;

public class Flashcard {
    private String question;
    private String answer;
    private boolean isStarred;
    private String starMarker;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.isStarred = false;
        this.starMarker = "";

    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean checkIsStarred() {
        return isStarred;
    }

    public void toggleStar() {
        this.isStarred = true;
        this.starMarker = "Starred";
    }

    public String toSaveFormat() {
        return getQuestion() + " | " + getAnswer() + " | " + starMarker;
    }

    public String toString() {
        return "Question: " + getQuestion() + " | " + "Answer: " + getAnswer() + " | " + starMarker;

    }
}
