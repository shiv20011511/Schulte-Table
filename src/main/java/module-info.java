module org.example.schultetable {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.schultetable to javafx.fxml;
    exports org.example.schultetable;
}