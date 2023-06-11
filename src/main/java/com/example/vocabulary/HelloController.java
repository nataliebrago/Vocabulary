package com.example.vocabulary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class HelloController {

    @FXML
    public Button closeButton;

    @FXML
    public TextField inputTextField;

    HashMap<String,String> mWordHashMap = new HashMap<>();

    @FXML
    ListView originListView = new ListView();

    @FXML
    ListView translationListView = new ListView();


    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void addWord(ActionEvent actionEvent) {
        try {
            checkInputWords(inputTextField.getText(),true);
        }catch (Exception ex){
            showAlert("Input text is incorrect");
        }
    }

    private void checkInputWords(String text,boolean isAdd){
        if(text == null || text.isEmpty()) {
            showAlert("Input text is empty");
            return;
        }
        String[] values =  text.split("\\s+");
        String originWord = values[0];

        if(isAdd){
            String translateWord = values[1];
            if(originWord == null || originWord.isEmpty() || translateWord == null || translateWord.isEmpty()){
                showAlert("Input text is incorrect");
                return;
            }
            mWordHashMap.put(originWord,translateWord);
        }
        else {
             if(mWordHashMap.containsKey(originWord))
                 mWordHashMap.remove(originWord);
             else {
                 showAlert("Input text is not found");
                 return;
             }
        }
        updateListView();
    }

    public void delete(ActionEvent actionEvent) {
        try {
            checkInputWords(inputTextField.getText(),false);
        }catch (Exception ex){
            showAlert("Input text is incorrect");
        }
    }

    private void updateListView(){
        originListView.getItems().clear();
        translationListView.getItems().clear();

        for(Map.Entry<String, String> entry : mWordHashMap.entrySet()) {
            String originWord = entry.getKey();
            String translateWord = entry.getValue();
            originListView.getItems().add(originWord);
            translationListView.getItems().add(translateWord);
        }
    }

    private void showAlert(String text){
        Locale.setDefault(new Locale("en", "English"));
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(text);
        alert.showAndWait();
    }

}