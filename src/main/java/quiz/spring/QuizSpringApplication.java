package quiz.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class QuizSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizSpringApplication.class, args);
    }
}
