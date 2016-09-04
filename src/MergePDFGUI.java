import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;

public class MergePDFGUI extends Application {

    Stage window;
    VBox layout2 = new VBox(20);

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
            MergePDF.pdfGet(file);
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
                MergePDF.pdfGet(file);
                System.out.println(file.toString());
            });
            layout.getChildren().addAll(label1);
            layout2.getChildren().add(openButton2);
        });
        Button make = new Button("make");
        Label label2 = new Label();
        make.setOnAction(e -> {
            //hier kommt die Methode zum mergen hin

            try {
                MergePDF.merge();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
            label2.setText("C:\\Users\\FrankenMEXX-Karaoke2\\Desktop\\java\\blubb.pdf");
        });
        Label label3 = new Label("Choose one file at first");
        Label labelx = new Label("Hier steht das Ergebnis");

        layout.getChildren().addAll(label, labelx, label2);
        layout2.getChildren().addAll(openButton, extendButton, make);
        BorderPane border = new BorderPane();
        border.setRight(layout2);
        border.setCenter(layout);
        border.setTop(label3);
        Scene scene = new Scene(border, 500,200);
        window.setScene(scene);
        window.show();
    }

}
