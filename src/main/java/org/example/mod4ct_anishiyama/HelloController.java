package org.example.mod4ct_anishiyama;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

//Controller Class
public class HelloController {

    @FXML
    private TextArea outputTextArea;

    @FXML
    private BorderPane rootPane;

    private final String[] greenShades;

    //Random Green Shade Array
    {
        greenShades = new String[]{
                "#00112C", "#00252E", "#004030", "#005B31", "#007633",
                "#009136", "#00AC39", "#00C73B", "#00E23D", "#00FF3F"
        };
    }

    //Start with blank background
    private boolean initialized = false;

    //Initialize Background
    @FXML
    private void initialize() {
        // Start with a blank background color
        rootPane.setStyle("-fx-background-color: #FFFFFF;");
    }

    //Generate Date
    @FXML
    private void onDateMenuItemClicked() {
        String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        outputTextArea.appendText(dateTime + "\n");
    }

    //Write to file
    @FXML
    private void onWriteToFileMenuItemClicked() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(outputTextArea.getText());
            outputTextArea.appendText("Content saved to log.txt\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Change Background Color
    @FXML
    private void onChangeColorMenuItemClicked() {
        if (!initialized) {
            // If not initialized, select the first shade
            rootPane.setStyle("-fx-background-color: " + greenShades[0] + ";");
            initialized = true;
            outputTextArea.appendText("Background color initialized to: " + greenShades[0] + "\n");
        } else {
            // Get a random shade of green
            String hexColor = greenShades[new Random().nextInt(greenShades.length)];

            // Set the background color
            rootPane.setStyle("-fx-background-color: " + hexColor + ";");

            outputTextArea.appendText("Background color changed to: " + hexColor + "\n");
        }
    }

    //Exit Menu
    @FXML
    private void onExitMenuItemClicked() {
        System.exit(0);
    }
}
