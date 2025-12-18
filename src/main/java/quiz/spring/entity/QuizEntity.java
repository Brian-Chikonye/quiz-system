package quiz.spring.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class QuizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    private List<QuestionEntity> questions;

    public QuizEntity() {
    }

    public QuizEntity(String title, List<QuestionEntity> questions) {
        this.title = title;
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }
}
