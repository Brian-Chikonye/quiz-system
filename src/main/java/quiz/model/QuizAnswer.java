package quiz.model;

import quiz.interfaces.Answer;

public class QuizAnswer implements Answer {

    private String text;
    private boolean correct;

    public QuizAnswer() {}

    public QuizAnswer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public boolean isCorrect() {
        return correct;
    }
}
