package com.example.demo2;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

public class HelloController {
    @FXML
    Button credit, mortgage, autocredit;
    @FXML
    public void creditWindow() throws IOException { // потреб
        credit.getScene().getWindow().hide();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("credit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 420);
        stage.setTitle("Кредитный калькулятор");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void mortgageWindow() throws IOException { // ипотека
        mortgage.getScene().getWindow().hide();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mortgage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 420);
        stage.setTitle("Кредитный калькулятор");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void autoWindow() throws IOException { // авто
        autocredit.getScene().getWindow().hide();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("auto.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 420);
        stage.setTitle("Кредитный калькулятор");
        stage.setScene(scene);
        stage.show();
    }

}