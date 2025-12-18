package quiz;

import quiz.interfaces.Answer;
import quiz.interfaces.Question;
import quiz.model.QuizAnswer;
import quiz.model.QuizQuestion;
import quiz.model.SimpleQuiz;
import quiz.persistence.QuizFileManager;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        QuizAnswer a1 = new QuizAnswer("Paris", true);
        QuizAnswer a2 = new QuizAnswer("London", false);
        QuizAnswer a3 = new QuizAnswer("Rome", false);

        QuizQuestion question = new QuizQuestion(
                "What is the capital of France?",
                List.of(a1, a2, a3)
        );

        SimpleQuiz quiz = new SimpleQuiz(List.of(question));

        QuizFileManager.save(quiz, "quiz.json");

        SimpleQuiz loadedQuiz = QuizFileManager.load("quiz.json");

        for (Question q : loadedQuiz.getQuestions()) {
            System.out.println(q.getQuestionText());
            for (Answer a : q.getAnswers()) {
                System.out.println("- " + a.getText());
            }
        }
    }
}
