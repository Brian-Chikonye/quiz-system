package quiz.model;

import quiz.interfaces.Quiz;

import java.util.List;

public class SimpleQuiz implements Quiz {

    private List<QuizQuestion> questions;

    public SimpleQuiz() {}

    public SimpleQuiz(List<QuizQuestion> questions) {
        this.questions = questions;
    }

    @Override
    public List<QuizQuestion> getQuestions() {
        return questions;
    }
}
