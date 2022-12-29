package com.example.ui_calculator;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaFxApplication extends Application {

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void start(Stage window) {
        Label textComponent = new Label("Введите выражение в  привычном алгебраическом виде через пробелы >>");
        TextField leftText = new TextField();
        leftText.setMinSize(400,100);
        TextField rightText = new TextField();
        rightText.setMinSize(400,100);
        Button button = new Button("|Вычислить|");

        button.setOnAction((event) -> {
            String valueToConvert = leftText.getText();
            if(checkInput(valueToConvert)==0) {
                String[] arrayOfStrings = valueToConvert.split(" ");
                Converting someValue = new Converting(arrayOfStrings);
                ArrayList<String> list = someValue.convertToRPN(arrayOfStrings);
                System.out.println("Польская запись введённого вами выражения будет иметь вид >> ");
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");
                }
                String input = "";
                for (String s : list) {
                    input += s + " ";
                }
                Calculator inputToCalculate = new Calculator(input);
                inputToCalculate.rewriteArray();
                Fraction result =  inputToCalculate.countPolandNotation();
                System.out.println("\nФинальный ответ всех вычислений >>");
                String answer = Fraction.print(result);
                rightText.setText(Fraction.print(result));


            } else {
                rightText.setText("Ошибка! Убедитесь в корректности ввода.");
                //System.exit(0);
            }
        });

        HBox componentGroup = new HBox();
        componentGroup.getChildren().add(textComponent);
        componentGroup.setSpacing(20);
        componentGroup.getChildren().addAll(leftText, button, rightText);

        Scene viewport = new Scene(componentGroup);

        window.setScene(viewport);
        window.show();
    }

    public static void main(String[] args) {
        launch(JavaFxApplication.class);
    }
    public static int checkInput (String input){
        int returnedValue = 0;
        String newInput = input.replaceAll("[^\\d /+\\-*:()]", "");
        if(input.length()!=newInput.length()){
            returnedValue =1;
        }
        return returnedValue;
    }
}