package quiz.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import quiz.model.QuizAnswer;
import quiz.model.QuizQuestion;

import java.util.List;

public class QuizApp extends Application {

    @Override
    public void start(Stage stage) {

        QuizAnswer a1 = new QuizAnswer("Paris", true);
        QuizAnswer a2 = new QuizAnswer("London", false);
        QuizAnswer a3 = new QuizAnswer("Rome", false);

        QuizQuestion question = new QuizQuestion(
                "What is the capital of France?",
                List.of(a1, a2, a3)
        );

        Label questionLabel = new Label(question.getQuestionText());

        ToggleGroup group = new ToggleGroup();
        VBox answersBox = new VBox(5);

        for (QuizAnswer answer : question.getAnswers()) {
            RadioButton rb = new RadioButton(answer.getText());
            rb.setToggleGroup(group);
            rb.setUserData(answer);
            answersBox.getChildren().add(rb);
        }

        Label resultLabel = new Label();

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            Toggle selected = group.getSelectedToggle();
            if (selected == null) {
                resultLabel.setText("Select an answer");
                return;
            }

            QuizAnswer chosen = (QuizAnswer) selected.getUserData();
            resultLabel.setText(chosen.isCorrect() ? "Correct" : "Wrong");
        });

        VBox root = new VBox(15, questionLabel, answersBox, submitButton, resultLabel);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 400, 300));
        stage.setTitle("Quiz Application");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
