package com.example.regex;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HelloController {
    @FXML
    private Label outputName;

    @FXML
    private Label outputContactNumber;

    @FXML
    private Label outputPostalCode;

    @FXML
    private TextField txtContactNumber;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    void onSubmitButtonClicked(ActionEvent event) {
        String textName = txtName.getText();
        String textContactNumber = txtContactNumber.getText();
        String textPostalCode = txtPostalCode.getText();

        Pattern patternName = Pattern.compile("^[A-Z][a-zA-Z]*$");
        Pattern patternContactNumber = Pattern.compile("^(\\d{3} \\d{3} \\d{4}|\\(\\d{3}\\) \\d{3} \\d{4})$");
        Pattern patternPostalCode = Pattern.compile("^[A-Za-z]\\d[A-Za-z][ -]\\d[A-Za-z]\\d$");

        Matcher matcherName = patternName.matcher(textName);
        Matcher matcherContactNumber = patternContactNumber.matcher(textContactNumber);
        Matcher matcherPostalCode = patternPostalCode.matcher(textPostalCode);

        if (matcherName.matches()) {
            outputName.setText("Validated");
        } else {
            outputName.setText("Not Validated");
        }

        if (matcherContactNumber.matches()) {
            outputContactNumber.setText("Validated");
        } else {
            outputContactNumber.setText("Not Validated");
        }

        if (matcherPostalCode.matches()) {
            outputPostalCode.setText("Validated");
        } else {
            outputPostalCode.setText("Not Validated");
        }
    }
}