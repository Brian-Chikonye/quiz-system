package quiz.model;

import quiz.interfaces.Question;

import java.util.List;

public class QuizQuestion implements Question {

    private String questionText;
    private List<QuizAnswer> answers;

    public QuizQuestion() {}

    public QuizQuestion(String questionText, List<QuizAnswer> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public List<QuizAnswer> getAnswers() {
        return answers;
    }
}
