module org.example.programacionjorgecristobal {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens org.example.programacionjorgecristobal to javafx.fxml;
    exports org.example.programacionjorgecristobal;
    exports org.example.programacionjorgecristobal.controller;
    opens org.example.programacionjorgecristobal.controller to javafx.fxml;
}