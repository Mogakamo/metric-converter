package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.text.DecimalFormat;


public class Main extends Application {

    @Override
    public void start (Stage stage) {
        DecimalFormat df = new DecimalFormat("0.0#");

        //first the components for converting back and forth from inches to centimetres

        //Create input fields and label to show the units
        TextField cmText  = new TextField();
        Label cmLabel = new Label("Cm");
        TextField inchText = new TextField();
        Label inchLabel = new Label("Inches");

        //Create buttons to perform the calculations
        Button cmToInchButton = new Button("===>");
        Button inchToCmButton = new Button("<===");

        //Create a VBox to hold the buttons
        VBox inchCmButtons = new VBox();
        inchCmButtons.getChildren().addAll(cmToInchButton, inchToCmButton);

        //Create an HBox to hold all the items of the first row
        HBox inchCmPanel = new HBox(10);
        inchCmPanel.getChildren().addAll(cmText, cmLabel, inchCmButtons, inchText, inchLabel);
        inchCmPanel.setAlignment(Pos.CENTER);

        //Next the components for converting back and forth from miles to kilometeres

        //Create input fields and labels to show the units
        TextField kmText = new TextField();
        Label kmLabel = new Label(" Km                      ");
        TextField mileText = new TextField();
        Label mileLabel = new Label(" Miles    ");//Extra spaces make all the labels the same length

        //Create the buttons to  perform the calculations
        Button kmToMileButton = new Button("===>");
        Button mileToKmButton = new Button("<===");

        //Create a VBox to hold the buttons
        VBox mileKmButtons = new VBox();
        mileKmButtons.getChildren().addAll(kmToMileButton, mileToKmButton);

        //Create an HBox to hold all the items in the second row
        HBox mileKmPanel = new HBox(10);
        mileKmPanel.getChildren().addAll(kmText, kmLabel, mileKmButtons, mileText, mileLabel);

        //Finally the components for converting back and forth from pounds to kilograms

        //Create the input fields and labels to show the units
        TextField kgText = new TextField();
        Label kgLabel = new Label("Kg");
        TextField poundText = new TextField();
        Label poundLabel = new Label("Lb    ");

        //Create buttons to perform the calculations
        Button kgToPoundButton = new Button("===>");
        Button poundToKgButton = new Button("<===");

        //Create a VBox to hold the buttons
        VBox poundKgButtons = new VBox();
        poundKgButtons.getChildren().addAll(kgToPoundButton, poundToKgButton);

        //create an HBox to hold all the items for the third row
        HBox poundKgPanel = new HBox(10);
        poundKgPanel.getChildren().addAll(kgText, kgLabel, poundKgButtons, poundText, poundLabel);
        poundKgPanel.setAlignment(Pos.CENTER);

        //Create a VBox to hold all the three rows
        VBox root = new VBox(10);
        root.getChildren().addAll(inchCmPanel, mileKmPanel, poundKgPanel);
        root.setAlignment(Pos.CENTER);

        //Code for the buttons
        cmToInchButton.setOnAction(e-> {
            String s = new String(cmText.getText());
            double d = Double.parseDouble(s);
            d = d/2.54;
            s = df.format(d);
            inchText.setText(s);
        });

        inchToCmButton.setOnAction(e-> {
            String s = new String(inchText.getText());
            double d = Double.parseDouble(s);
            d = d*2.54;
            s = df.format(d);
            cmText.setText(s);
        });

        kmToMileButton.setOnAction(e-> {
            String s = new String(kmText.getText());
            double d = Double.parseDouble(s);
            d = d/1.609;
            s = df.format(d);
            mileText.setText(s);
        });

        mileToKmButton.setOnAction( e -> {
            String s = new String(mileText.getText());
            double d = Double.parseDouble(s);
            d = d * 1.609;
            s = df.format(d);
            kmText.setText(s);
                });


        kgToPoundButton.setOnAction( e -> {
            String s = new String(kgText.getText());
            double d = Double.parseDouble(s);
            d = d * 2.2;
            s = df.format(d);
            poundText.setText(s);
                });


        poundToKgButton.setOnAction( e -> {
            String s = new String(poundText.getText());
            double d = Double.parseDouble(s);
            d = d / 2.2;
            s = df.format(d);
            kgText.setText(s);
                });

        //Create a new Scene
        Scene scene = new Scene(root);

        //Add the scene to the stage then configure the stage and make it visible
        stage.setScene(scene);
        stage.setTitle("Metric Converter");
        stage.setWidth(700);
        stage.setHeight(300);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
