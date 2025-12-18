package quiz.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.spring.entity.QuizEntity;

public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
}
