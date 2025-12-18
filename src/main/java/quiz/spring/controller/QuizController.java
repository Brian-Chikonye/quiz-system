package quiz.spring.controller;

import org.springframework.web.bind.annotation.*;
import quiz.spring.entity.QuizEntity;
import quiz.spring.repository.QuizRepository;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizRepository quizRepository;

    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @PostMapping
    public QuizEntity createQuiz(@RequestBody QuizEntity quiz) {
        return quizRepository.save(quiz);
    }

    @GetMapping
    public List<QuizEntity> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @GetMapping("/{id}")
    public QuizEntity getQuiz(@PathVariable Long id) {
        return quizRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        quizRepository.deleteById(id);
    }
}
