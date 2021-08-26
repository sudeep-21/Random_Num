package EngineManager;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WindowManager extends Application {
    @Override
    public void start(Stage stage) {
        Label heading = new Label("Random Number Generator");
        Label minTxt = new Label("Minimum value: ");
        Label maxTxt = new Label("Maximum value: ");

        TextField maxField = new TextField();
        TextField minField = new TextField();

        Slider numItems = new Slider(1, 5, 1);

        Button submit = new Button("Submit");
        Button reset = new Button("Reset");

        TextArea answer = new TextArea();

        VBox root = new VBox(20);
        VBox minmax = new VBox(10);
        HBox minitems = new HBox(9);
        HBox maxitems = new HBox();
        HBox buttons = new HBox(150);

        heading.setId("heading");
        maxField.setPrefWidth(200);
        minField.setPrefWidth(200);
        numItems.setMaxWidth(300);
        numItems.setShowTickMarks(true);
        numItems.setShowTickLabels(true);
        numItems.setMinorTickCount(0);
        numItems.setMajorTickUnit(1);
        numItems.setSnapToTicks(true);
        answer.setMaxWidth(350);

        minitems.getChildren().addAll(minTxt, minField);
        maxitems.getChildren().addAll(maxTxt, maxField);
        minmax.getChildren().addAll(minitems, maxitems);
        minitems.setAlignment(Pos.BASELINE_CENTER);
        maxitems.setAlignment(Pos.BASELINE_CENTER);
        buttons.getChildren().addAll(submit, reset);
        buttons.setAlignment(Pos.BASELINE_CENTER);
        root.getChildren().addAll(heading, minmax, numItems, buttons, answer);
        root.setAlignment(Pos.TOP_CENTER);
        Scene main = new Scene(root, 450, 600);

        main.getStylesheets().addAll(this.getClass().getResource("/styles/styles.css").toExternalForm());

        stage.setScene(main);
        stage.setResizable(false);
        stage.show();
    }
}