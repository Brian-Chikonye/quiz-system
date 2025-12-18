package quiz.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import quiz.model.SimpleQuiz;

import java.io.File;
import java.io.IOException;

public class QuizFileManager {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void save(SimpleQuiz quiz, String file) throws IOException {
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File(file), quiz);
    }

    public static SimpleQuiz load(String file) throws IOException {
        return mapper.readValue(new File(file), SimpleQuiz.class);
    }
}
