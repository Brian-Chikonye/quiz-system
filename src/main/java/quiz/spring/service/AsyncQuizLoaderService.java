package quiz.spring.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import quiz.spring.entity.QuizEntity;
import quiz.spring.repository.QuizRepository;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncQuizLoaderService {

    private final QuizRepository quizRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public AsyncQuizLoaderService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Async
    public CompletableFuture<Void> loadQuizzesAsync() {
        return CompletableFuture.runAsync(() -> {
            try {
                InputStream inputStream =
                        getClass().getResourceAsStream("/external-quizzes.json");

                List<QuizEntity> quizzes =
                        objectMapper.readValue(inputStream,
                                new TypeReference<List<QuizEntity>>() {});

                quizRepository.saveAll(quizzes);

                System.out.println("Async quiz loading completed");

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
