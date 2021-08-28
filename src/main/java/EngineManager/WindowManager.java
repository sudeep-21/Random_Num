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
        Label error = new Label("Max value should be greater than minimum.");

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
        error.setId("error");
        error.setVisible(false);

        submit.setOnMouseClicked(mouseEvent -> {
            int min = 0, max = 0, num = 0, temp = 0;
            String finalans;
            StringBuffer buffer = new StringBuffer();

            answer.setText("");
            error.setVisible(false);

            if (minField.getText().equals("")) {
                minField.setText("1");
                min = Integer.valueOf(minField.getText());
            }
            if (maxField.getText().equals("")) {
                error.setVisible(true);
            } else {
                max = Integer.valueOf(maxField.getText());
            }
            num = (int)(numItems.getValue());
            int[] ans = new int[num];

            for (int i = 0; i < num; i++) {
                temp =  (int)(Math.random() * ((max - min + 1) + min) + 1);
                ans[i] = temp;
                buffer.append(ans[i] + "\n");
            }
            finalans = buffer.toString();
            answer.setText(finalans);
        });

        reset.setOnMouseClicked(mouseEvent -> {
            minField.setText("");
            maxField.setText("");
            numItems.setValue(1);
            answer.setText("");
        });

        minitems.getChildren().addAll(minTxt, minField);
        maxitems.getChildren().addAll(maxTxt, maxField);
        minmax.getChildren().addAll(minitems, maxitems);
        minitems.setAlignment(Pos.BASELINE_CENTER);
        maxitems.setAlignment(Pos.BASELINE_CENTER);

        buttons.getChildren().addAll(submit, reset);
        buttons.setAlignment(Pos.BASELINE_CENTER);

        root.getChildren().addAll(heading, minmax, numItems, buttons, answer, error);
        root.setAlignment(Pos.TOP_CENTER);
        Scene main = new Scene(root, 450, 620);

        main.getStylesheets().addAll(this.getClass().getResource("/styles/styles.css").toExternalForm());

        stage.setScene(main);
        stage.setResizable(false);
        stage.show();
    }
}