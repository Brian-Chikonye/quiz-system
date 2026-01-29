package quiz.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import quiz.spring.service.AsyncQuizLoaderService;

@RestController
public class AsyncQuizController {

    private final AsyncQuizLoaderService asyncQuizLoaderService;

    public AsyncQuizController(AsyncQuizLoaderService asyncQuizLoaderService) {
        this.asyncQuizLoaderService = asyncQuizLoaderService;
    }

    @GetMapping("/async/load-quizzes")
    public String loadQuizzes() {
        asyncQuizLoaderService.loadQuizzesAsync();
        return "Async quiz loading started";
    }
}
