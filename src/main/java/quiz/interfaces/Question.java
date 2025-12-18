package quiz.interfaces;

import java.util.List;

public interface Question {
    String getQuestionText();
    List<? extends Answer> getAnswers();
}
