import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.io.File;

public class MergePDFGUI extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Choose Choose Choose");

        FileChooser firstFile = new FileChooser();
        final TextField txtfield = null;

        Button openButton = new Button("Open a link");
        Label label = new Label();
        openButton.setOnAction(e -> {
            File file = firstFile.showOpenDialog(primaryStage);
            label.setText(file.toString());
            System.out.println(file.toString());
        });
        VBox layout = new VBox(20);

        Button extendButton = new Button("extend");
        extendButton.setOnAction(e -> {
            Button openButton2 = new Button("Open a link");
            Label label1 = new Label();
            openButton2.setOnAction(f -> {
                File file = firstFile.showOpenDialog(primaryStage);
                label1.setText(file.toString());
            });
            layout.getChildren().addAll(label1, openButton2);
        });

        Label label3 = new Label("Choose one file at first");

        layout.getChildren().addAll(label3, label, openButton, extendButton);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

}