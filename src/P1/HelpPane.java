package P1;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class HelpPane {
    Button button = new Button("Back To Game");
    public BorderPane helpPane(){
        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.web("#6EDBA1"), null, null)));
        button.setBackground(new Background(new BackgroundFill(Color.web("#6EDBA1"), null, null)));
        button.setFont(new Font(20));
        AnchorPane anchorPane = new AnchorPane();
        Text text = new Text("1. Find specified word in board\n2. Click to start position of founded word\n3. Click to end position of founded word");
        text.setFont(new Font("Segoe UI Black", 30));
        text.setFill(Color.web("#171B2A"));
        text.setTextAlignment(TextAlignment.CENTER);
        anchorPane.getChildren().add(button);
        AnchorPane.setTopAnchor(button, 20.0);
        AnchorPane.setLeftAnchor(button, 20.0);
        borderPane.setTop(anchorPane);
        borderPane.setCenter(text);
        return borderPane;
    }
}
