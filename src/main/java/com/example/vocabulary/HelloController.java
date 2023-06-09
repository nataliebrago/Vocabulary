package com.example.vocabulary;


import javafx.event.ActionEvent;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloController {

    public ListView listView = new ListView();

    public void load(ActionEvent actionEvent) {
        ArrayList<String> mNames = new ArrayList();
        File file = new File("src\\main\\resources\\words.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);

            while (input.hasNext()) {
                mNames.add(input.next());
           }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        listView.getItems().clear();
        listView.getItems().addAll(mNames);
    }
}