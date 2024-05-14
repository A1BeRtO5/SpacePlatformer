module com.example.spaceplatformer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spaceplatformer to javafx.fxml;
    exports com.example.spaceplatformer;
}