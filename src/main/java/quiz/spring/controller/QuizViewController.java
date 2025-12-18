package quiz.spring.controller;

import quiz.spring.repository.QuizRepository;
import quiz.spring.entity.QuizEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuizViewController {

    private final QuizRepository quizRepository;

    public QuizViewController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @GetMapping("/quizzes-view")
    public String showQuizzes(Model model) {
        model.addAttribute("quizzes", quizRepository.findAll());
        return "quizzes";
    }

    @GetMapping("/quizzes-view/{id}")
    public String takeQuiz(@PathVariable Long id, Model model) {
        QuizEntity quiz = quizRepository.findById(id).orElseThrow();
        model.addAttribute("quiz", quiz);
        return "quiz";
    }
}
