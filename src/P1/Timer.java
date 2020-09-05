package P1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.util.Duration;


public class Timer extends Label {
    public Timer(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            int mins = 0, secs = 0;
            @Override
            public void handle(ActionEvent event) {
                secs++;
                if(secs == 60) {
                    mins++;
                    secs = 0;
                }
                setText("Time   " + (((mins/10) == 0) ? "0" : "") + mins + ":" + (((secs/10) == 0) ? "0" : "") + secs + " ");
                setFont(new Font("Segoe UI Black", 20));
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.play();
    }
}
