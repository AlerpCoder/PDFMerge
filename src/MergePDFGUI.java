import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

        Label labelt = new Label("Choose one file at first");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(labelt, label, openButton);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

}