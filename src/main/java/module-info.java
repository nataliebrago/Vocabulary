module com.example.vocabulary {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.vocabulary to javafx.fxml;
    exports com.example.vocabulary;
}