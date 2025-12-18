package quiz.interfaces;

import java.util.List;

public interface Quiz {
    List<? extends Question> getQuestions();
}
