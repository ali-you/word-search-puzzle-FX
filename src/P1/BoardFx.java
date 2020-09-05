//package P1;
//
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Orientation;
//import javafx.geometry.Pos;
//import javafx.scene.Node;
//import javafx.scene.control.Label;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.FlowPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import javafx.scene.text.TextAlignment;
//
//public class BoardFx {
//    public FlowPane boardFx(int gameLevel, int size, String category){
//        GridPane gridPane = new GridPane();
//        gridPane.setAlignment(Pos.CENTER_LEFT);
//        gridPane.setGridLinesVisible(true);
//
//        GridPane gridPane1 = new GridPane();
//        gridPane1.setAlignment(Pos.BOTTOM_RIGHT);
//        gridPane1.setGridLinesVisible(true);
//
//
//        FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL, 100, 200);
//        flowPane.setAlignment(Pos.CENTER);
//
//        Board board = new Board(gameLevel, 20, 20, category);
//        board.create();
//        for (int i = 0; i < 20; i++) {
//            for (int j = 0; j < 20; j++) {
//                Label label = new Label(board.getMatrixIJ(i, j) + "");
//                label.setMouseTransparent(true);
//                GridPane.setRowIndex(label, j);
//                GridPane.setColumnIndex(label, i);
//                GridPane.setMargin(label, new Insets(2.5, 5, 2.5, 5));
//                label.setTextAlignment(TextAlignment.CENTER);
//                gridPane.add(label, j, i);
//            }
//        }
//
//        gridPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                for (Node node : gridPane.getChildren()) {
//                    if (node instanceof Label && node.getBoundsInParent().contains(event.getSceneX(), event.getSceneY())) {
//                        System.out.print(GridPane.getRowIndex(node) + 1 + " ");
//                        System.out.println(GridPane.getColumnIndex(node) + 1);
//                        System.out.println(category);
//                    }
//                }
//            }
//        });
//
//
//        for (int i = 0; i < board.words.length / 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                Text text5 = new Text(board.words[(5*i) + j]);
//                text5.setFont(new Font("Segoe UI Black", 11));
//                text5.setTextAlignment(TextAlignment.CENTER);
//                gridPane1.add(text5, j, i);
//            }
//        }
//    flowPane.getChildren().addAll(gridPane, gridPane1);
//        return flowPane;
//    }
//}
