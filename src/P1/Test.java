package P1;

import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.math.BigInteger;
import java.util.Stack;

/**
 * the main body of the game
 */
public class Test extends Application {
    Scene scene1, scene2, scene3, scene4, gameScene, credit, help;
    String category;
    int gameLevel1, gameLevel2, boardSize, check;
    static int checkNew = 1;
    Board board;
    Rectangle rectangle;
    StackPane stackPane;
    static int counter = 1;
    @Override
    public void start(Stage primaryStage) throws Exception {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

//Scene 1

        FlowPane welcome = new FlowPane(Orientation.VERTICAL, 20, 20);

        FadeTransition ft = new FadeTransition(Duration.seconds(3), welcome);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();



        welcome.setAlignment(Pos.CENTER);
        welcome.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
        Text text = new Text("WElCOME TO");
        text.setFont(new Font("Garamond", 55));
        Text text1 = new Text("WORD SEARCH PUZZLE");
        text1.setFont(new Font("Segoe UI Black", 15));
        welcome.getChildren().addAll(text, text1);
        scene1 = new Scene(welcome, width, height);



        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished( event ->{
            primaryStage.setMaximized(true);
            primaryStage.setScene(scene2);
        });
        delay.play();


//Scene 2



        FlowPane categoryPane = new FlowPane(Orientation.VERTICAL, 20, 20);

        if (checkNew == 2){
            FadeTransition ft1 = new FadeTransition(Duration.seconds(2), categoryPane);
            ft1.setFromValue(0);
            ft1.setToValue(1);
            ft1.play();
        }

        categoryPane.setAlignment(Pos.CENTER);
        categoryPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Text text2 = new Text("Please choose category :");
        text2.setFont(new Font(20));


        Button animals = new Button("Animals");
        animals.setMaxWidth(Integer.MAX_VALUE);
        animals.setFont(new Font(20));
        animals.setOnAction(event -> {
            category = "animals";
            primaryStage.setScene(scene3);
        });


        Button cars = new Button("Cars");
        cars.setMaxWidth(Integer.MAX_VALUE);
        cars.setFont(new Font(20));
        cars.setOnAction(event -> {
            category = "cars";
            primaryStage.setScene(scene3);
        });


        Button countries = new Button("Countries & Cities");
        countries.setMaxWidth(Integer.MAX_VALUE);
        countries.setFont(new Font(20));
        countries.setOnAction(event -> {
            category = "countries";
            primaryStage.setScene(scene3);
        });


        Button flowers = new Button("Flowers");
        flowers.setMaxWidth(Integer.MAX_VALUE);
        flowers.setFont(new Font(20));
        flowers.setOnAction(event -> {
            category = "flowers";
            primaryStage.setScene(scene3);
        });


        Button foods = new Button("Foods");
        foods.setMaxWidth(Integer.MAX_VALUE);
        foods.setFont(new Font(20));
        foods.setOnAction(event -> {
            category = "foods";
            primaryStage.setScene(scene3);
        });


        Button fruits = new Button("Fruits");
        fruits.setMaxWidth(Integer.MAX_VALUE);
        fruits.setFont(new Font(20));
        fruits.setOnAction(event -> {
            category = "fruits";
            primaryStage.setScene(scene3);
        });


        Button names = new Button("Names");
        names.setMaxWidth(Integer.MAX_VALUE);
        names.setFont(new Font(20));
        names.setOnAction(event -> {
            category = "names";
            primaryStage.setScene(scene3);
        });

        categoryPane.getChildren().addAll(text2,animals, cars, countries, flowers, foods, fruits, names);
        scene2 = new Scene(categoryPane, width, height);

//Scene 3

        FlowPane levelPane = new FlowPane(Orientation.VERTICAL, 20, 20);
        levelPane.setAlignment(Pos.CENTER);
        levelPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Text text3 = new Text("Please choose level :");
        text3.setFont(new Font(20));


        Button easy = new Button("Easy");
        easy.setMaxWidth(Integer.MAX_VALUE);
        easy.setFont(new Font(20));
        easy.setOnAction(event -> {
            gameLevel1 = 5;
            gameLevel2 = 10;
            primaryStage.setScene(scene4);
        });

        Button average = new Button("Average");
        average.setMaxWidth(Integer.MAX_VALUE);
        average.setFont(new Font(20));
        average.setOnAction(event -> {
            gameLevel1 = 10;
            gameLevel2 = 20;
            primaryStage.setScene(scene4);
        });

        Button difficult = new Button("Difficult");
        difficult.setMaxWidth(Integer.MAX_VALUE);
        difficult.setFont(new Font(20));
        difficult.setOnAction(event -> {
            gameLevel1 = 15;
            gameLevel2 = 30;
            primaryStage.setScene(scene4);
        });

        levelPane.getChildren().addAll(text3, easy, average, difficult);
        scene3 = new Scene(levelPane, width, height);

//Scene 4

        FlowPane sizePane = new FlowPane(Orientation.VERTICAL, 10, 20);
        sizePane.setAlignment(Pos.CENTER);
        sizePane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Text text4 = new Text("Please choose size of board :");
        text4.setFont(new Font(20));


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        gridPane.setGridLinesVisible(true);


        GridPane gridPane1 = new GridPane();
        gridPane1.setAlignment(Pos.BOTTOM_CENTER);
        gridPane1.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        gridPane1.setGridLinesVisible(true);



        HBox hBox1 = new HBox();
        hBox1.setBackground(new Background(new BackgroundFill(Color.web("#171B2A"), CornerRadii.EMPTY, Insets.EMPTY)));
        hBox1.setSpacing(30);
        hBox1.setAlignment(Pos.CENTER);


        FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL, 25, 50);
        flowPane.setBackground(new Background(new BackgroundFill(Color.web("#6EDBA1"), CornerRadii.EMPTY, Insets.EMPTY)));
        flowPane.setAlignment(Pos.CENTER);


        Button size1 = new Button("15 * 15");
        size1.setMaxWidth(Integer.MAX_VALUE);
        size1.setFont(new Font(20));
        size1.setOnAction(event -> {
            boardSize = 15;


            board = new Board(gameLevel1, boardSize, boardSize, category);
            board.create();

            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    Text textBoard = new Text();
                    if (check == 1){
                        textBoard.setText("");
                    }
                    textBoard.setText(board.getMatrixIJ(i, j) + "");
                    rectangle = new Rectangle();
                    stackPane = new StackPane();
                    stackPane.setPrefSize( 28, 28);
                    stackPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    stackPane.getChildren().addAll(rectangle, textBoard);
                    textBoard.setMouseTransparent(true);
                    GridPane.setRowIndex(stackPane, j);
                    GridPane.setColumnIndex(stackPane, i);
                    textBoard.setTextAlignment(TextAlignment.CENTER);
                    gridPane.add(stackPane, j, i);
                }
            }

            for (int i = 0; i < board.words.length / 5; i++) {
                for (int j = 0; j < 5; j++) {
                    Text text5 = new Text(" "+board.words[(5*i) + j] +"  ");
                    text5.setFont(new Font("Segoe UI Black", 13));
                    text5.setTextAlignment(TextAlignment.CENTER);
                    Rectangle rectangle1 = new Rectangle();
                    StackPane stackPane1 = new StackPane();
                    stackPane1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    stackPane1.getChildren().addAll(rectangle1, text5);
                    gridPane1.add(stackPane1, j, i);
                }
            }



            primaryStage.setScene(gameScene);
        });




        Button size2 = new Button("20 * 20");
        size2.setMaxWidth(Integer.MAX_VALUE);
        size2.setFont(new Font(20));
        size2.setOnAction(event -> {
            boardSize = 20;


            board = new Board(gameLevel2, boardSize, boardSize, category);
            board.create();

            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    Text textBoard = new Text(board.getMatrixIJ(i, j) + "");
                    rectangle = new Rectangle();
                    stackPane = new StackPane();
                    stackPane.setPrefSize( 28, 28);
                    stackPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    stackPane.getChildren().addAll(rectangle, textBoard);
                    textBoard.setMouseTransparent(true);
                    GridPane.setRowIndex(stackPane, j);
                    GridPane.setColumnIndex(stackPane, i);
                    textBoard.setTextAlignment(TextAlignment.CENTER);
                    gridPane.add(stackPane, j, i);
                }
            }

            for (int i = 0; i < board.words.length / 5; i++) {
                for (int j = 0; j < 5; j++) {
                    Text text5 = new Text(" "+board.words[(5*i) + j] +"  ");
                    text5.setFont(new Font("Segoe UI Black", 13));
                    text5.setTextAlignment(TextAlignment.CENTER);
                    Rectangle rectangle1 = new Rectangle();
                    StackPane stackPane1 = new StackPane();
                    stackPane1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    stackPane1.getChildren().addAll(rectangle1, text5);
                    gridPane1.add(stackPane1, j, i);
                }
            }

            primaryStage.setScene(gameScene);
        });




        Timer timer = new Timer();
        timer.setTextFill(Color.web("C1CDC6"));
        timer.setAlignment(Pos.CENTER_LEFT);
        Label label1 = new Label("XP : 0");
        label1.setTextFill(Color.web("C1CB1C"));
        label1.setFont(new Font("Segoe UI Black", 20));
        label1.setAlignment(Pos.CENTER_RIGHT);
        HBox hBox = new HBox();
        hBox.setBackground(new Background(new BackgroundFill(Color.web("#171B2A"), CornerRadii.EMPTY, Insets.EMPTY)));
        hBox.setSpacing(45);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(timer, label1);


        FlowPane flowPane1 = new FlowPane(Orientation.VERTICAL, 0, 140);
        flowPane1.getChildren().addAll(hBox, hBox1, gridPane1);
        flowPane1.setAlignment(Pos.CENTER);



        sizePane.getChildren().addAll(text4, size1, size2);





        flowPane.getChildren().addAll(gridPane, flowPane1);






        Text end = new Text("YOU WIN");
        end.setFont(new Font("Segoe UI Black", 100));
        end.setFill(Color.RED);


        Button buttonNew = new Button("New Game");
        buttonNew.setFont(new Font("Segoe UI Black", 20));
        buttonNew.setMaxWidth(Integer.MAX_VALUE);
        buttonNew.setAlignment(Pos.TOP_LEFT);
        buttonNew.setTextFill(Color.WHITE);
        buttonNew.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        Button buttonExit = new Button("Exit");
        buttonExit.setFont(new Font("Segoe UI Black", 20));
        buttonExit.setMaxWidth(Integer.MAX_VALUE);
        buttonExit.setAlignment(Pos.TOP_RIGHT);
        buttonExit.setTextFill(Color.WHITE);
        buttonExit.setTextAlignment(TextAlignment.CENTER);
        buttonExit.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        FlowPane endingPane = new FlowPane(Orientation.VERTICAL, 0, 10);
        endingPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        endingPane.setAlignment(Pos.CENTER);



        FlowPane endingButton = new FlowPane(Orientation.VERTICAL);
        endingButton.getChildren().addAll(buttonNew, buttonExit);
        endingButton.setAlignment(Pos.CENTER);

        endingPane.getChildren().addAll(end, endingButton);

        StackPane stacker = new StackPane();


        ToolBar toolBar = new ToolBar();
        toolBar.setBackground(new Background(new BackgroundFill(Color.web("#6EDBA1"), null, null)));


        Button menuNew = new Button("New Game");
        menuNew.setBackground(new Background(new BackgroundFill(Color.web("#6EDBA1"), null, null)));
        menuNew.setFont(new Font(15));
        menuNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkNew = 2;
                Test test = new Test();
                try {
                    test.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        Button menuHelp = new Button("Help");
        menuHelp.setBackground(new Background(new BackgroundFill(Color.web("#6EDBA1"), null, null)));
        menuHelp.setFont(new Font(15));
        HelpPane helpPane = new HelpPane();
        help = new Scene(helpPane.helpPane(), width, height);
        menuHelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(help);
            }
        });

        helpPane.button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(gameScene);
            }
        });



        Button menuCredit = new Button("Credits");
        menuCredit.setBackground(new Background(new BackgroundFill(Color.web("#6EDBA1"), null, null)));
        menuCredit.setFont(new Font(15));
        CreditPane creditPane = new CreditPane();
        credit = new Scene(creditPane.creditPane(), width, height);
        menuCredit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(credit);
            }
        });

        creditPane.button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(gameScene);
            }
        });



        Button menuExit = new Button("Exit");
        menuExit.setBackground(new Background(new BackgroundFill(Color.web("#6EDBA1"), null, null)));
        menuExit.setFont(new Font(15));
        menuExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("Exit Massage");
                alert.setHeaderText("");
                alert.setContentText("Are You Sure ?");
                alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.YES)
                    Platform.exit();
            }
        });


        toolBar.getItems().addAll(menuNew, menuHelp, menuCredit, menuExit);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(toolBar);
        AnchorPane.setTopAnchor(toolBar, 10.0);
        AnchorPane.setLeftAnchor(toolBar, 10.0);

        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.web("#6EDBA1"), null, null)));
        borderPane.setCenter(flowPane);
        borderPane.setTop(anchorPane);
        stacker.getChildren().addAll(borderPane);



        scene4 = new Scene(sizePane, width, height);

//Game Scene
        Player player = new Player();
        Text text5 = new Text();
        text5.setFill(Color.web("#C1CDC6"));
        text5.setFont(new Font("Segoe UI Black", 20));

        gridPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            int row, col, row1, col1;
            @Override
            public void handle(MouseEvent event) {
                for (Node node : gridPane.getChildren()) {
                    if (node instanceof StackPane && node.getBoundsInParent().contains(event.getX(), event.getY())) {
                        ((StackPane) node).setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                        PauseTransition transition = new PauseTransition(Duration.seconds(0.3));
                        transition.setOnFinished(event1 ->((StackPane) node).setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY))));
                        transition.play();
                        if (event.getButton() == MouseButton.PRIMARY && counter == 1) {
                            row = GridPane.getRowIndex(node);
                            col = GridPane.getColumnIndex(node);
                            counter = 2;
                        }
                        else if (event.getButton() == MouseButton.PRIMARY && counter == 2) {
                            row1 = GridPane.getRowIndex(node);
                            col1 = GridPane.getColumnIndex(node);
                            player.solve(board, row, col, row1, col1);
                            label1.setText("XP : " + (int) (player.point * 50));
                            text5.setText(player.words1);
                            PauseTransition transition1 = new PauseTransition(Duration.seconds(5));
                            transition1.setOnFinished(event1 -> text5.setText(""));
                            transition1.play();
                            counter = 1;

                            if (player.ending == 2) {
                                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), endingPane);
                                fadeTransition.setFromValue(0);
                                fadeTransition.setToValue(1);
                                fadeTransition.play();

                                stacker.getChildren().add(endingPane);
                            }
                        }
                    }
                }
            }
        });

        buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("Exit Massage");
                alert.setHeaderText("");
                alert.setContentText("Are You Sure ?");
                alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.YES)
                    Platform.exit();
            }
        });

        buttonNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkNew = 2;
                Test test = new Test();
                try {
                    test.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });




        hBox1.getChildren().add(text5);



        gameScene = new Scene(stacker, width, height);





        primaryStage.setMinHeight(height);
        primaryStage.setMinWidth(width);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Word Search Puzzle");
        if (checkNew == 1)
        primaryStage.setScene(scene1);
        if (checkNew == 2)
        primaryStage.setScene(scene2);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);

    }
}
