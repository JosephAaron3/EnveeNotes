package enveenotes.notes;

import enveenotes.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Note {
    private final Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;

    public Note(Main controller, Stage primaryStage) {
        this.stage = new Stage();
        this.stage.setMinHeight(200);
        this.stage.setMinWidth(200);
        TextArea textArea = new TextArea();
        textArea.setPrefSize(300, 300);
        Button newNoteBtn = new Button();
        Button closeBtn = new Button();
        Image addImg = new Image("resources/add.png");
        ImageView addView = new ImageView(addImg);
        addView.setFitHeight(12);
        addView.setFitWidth(12);
        addView.setPreserveRatio(true);
        Image deleteImg = new Image("resources/delete.png");
        ImageView deleteView = new ImageView(deleteImg);
        deleteView.setFitHeight(12);
        deleteView.setFitWidth(12);
        deleteView.setPreserveRatio(true);
        newNoteBtn.setGraphic(addView);
        closeBtn.setGraphic(deleteView);
        closeBtn.setOnAction(controller.closeNote(this.stage));
        newNoteBtn.setOnAction(controller.addNewNote());
        HBox hBox = new HBox();
        Region r = new Region();
        HBox.setHgrow(r, Priority.ALWAYS);
        hBox.getChildren().addAll(newNoteBtn, r, closeBtn);
        hBox.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        hBox.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
        VBox vBox = new VBox();
        VBox.setVgrow(textArea, Priority.ALWAYS);
        vBox.setStyle("-fx-background-color: #dbdb79;" +
                "-fx-border-color: #dbdb79");
        vBox.getChildren().addAll(hBox, textArea);
        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("resources/CustomStyling.css");
        this.stage.initOwner(primaryStage);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.setScene(scene);
    }

    public void show() {
        this.stage.show();
    }

}