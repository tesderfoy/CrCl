package com.example.demo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class Credit extends Component {

    @FXML
    Button end, back;
    @FXML
    TextField amount, persent;
    @FXML
    private ChoiceBox<Integer> choiceBox;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    Integer month;
    double sum, per, monthStavka, koefAnn, monthPlatej, endCredit;
    @FXML
    private void initialize(){
        choiceBox.getItems().addAll(12,24,36,48,60);
    }
    @FXML
    public void back() throws IOException {
        back.getScene().getWindow().hide();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("choice_win_one.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 420);
        stage.setTitle("Кредитный калькулятор");
        stage.setScene(scene);
        stage.show();
    }
    public void result(){
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            month = choiceBox.getSelectionModel().getSelectedItem();
            sum = Double.parseDouble(amount.getText());
            per = (Double.parseDouble(persent.getText())) / 100;
            monthStavka = per / 12; //Процентная ставка в месяц
            koefAnn = monthStavka * ((Math.pow(1 + monthStavka, month)) / ((Math.pow(1 + monthStavka, month)) - 1)); //Коэффициент аннуитета
            monthPlatej = koefAnn * sum; // Ежемесячный аннуитетный платеж
            endCredit = monthPlatej * month; //Вся сумма кредита
            if (sum >= 300001 || sum <= 29999){
                alert.setTitle("Ошибка");
                alert.setHeaderText(null);
                alert.setContentText("Максимальная и минимальная сумма кредита сумма кредита 300000 и 30000!");
                alert.showAndWait();
            }
            else {
                JFileChooser dialog = new JFileChooser();
                if (dialog.showSaveDialog( this ) != JFileChooser.APPROVE_OPTION)
                    return;
                String fname = dialog.getSelectedFile().getAbsolutePath();
                try(FileWriter writer = new FileWriter(fname + ".txt", false))
                {
                    writer.append("Общая суммма кредита: " + df.format(endCredit));
                    writer.append('\n');
                    writer.append("Переплата: " + df.format(endCredit - sum));
                    writer.append('\n');
                    for (int i = 1; i<= month; i++){
                        endCredit = endCredit  - monthPlatej;
                        writer.append("Номер платежа: " + i + " Ежемесячный платеж: " + df.format(monthPlatej) + " Остаток: " + df.format(endCredit));
                        writer.append('\n');
                        writer.flush();}
                }
                catch(IOException ex)
                {System.out.println(ex.getMessage());}
            }
        }catch (Exception exception){
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Некорректные данные!");
            alert.showAndWait();
        }
        }



}