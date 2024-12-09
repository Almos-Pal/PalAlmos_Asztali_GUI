package hu.petrik.countdown;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class HelloController {

    @FXML
    private TextField inputID;
    @FXML
    private Button submitId;
    @FXML
    private Label resultId;

    private AnimationTimer timer;

    @FXML
    public void onSubmit(ActionEvent actionEvent) {
        String input = inputID.getText();

        if (isValidDate(input)) {
            resultId.setText("Valid date");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid date");
            alert.showAndWait();
            return;
        }

        if (timer != null) {
            timer.stop();
        }

        LocalDateTime dateTime = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm:ss"));

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Duration duration = Duration.between(LocalDateTime.now(), dateTime);
                Period period = Period.between(LocalDateTime.now().toLocalDate(), dateTime.toLocalDate());

                if (duration.toSecondsPart() < 0) {
                    stop();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Time is up");

                    Platform.runLater(() -> {
                        alert.showAndWait();
                    });
                    return;
                }

                resultId.setText(String.format("%d év %d hó %d nap %02d:%02d:%02d",
                        period.getYears(), period.getMonths(), period.getDays(),
                        duration.toHours() % 24, duration.toMinutesPart() % 60, duration.toSecondsPart() % 60));
            }
        };

        timer.start();
    }

    private boolean isValidDate(String input) {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm:ss"));
            return dateTime.isAfter(LocalDateTime.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}