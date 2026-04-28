module org.example.programacionjorgecristobal {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.xml.bind;
    opens org.example.programacionjorgecristobal.controller to javafx.fxml;
    opens org.example.programacionjorgecristobal.Model to javafx.base, javafx.fxml;
    opens org.example.programacionjorgecristobal to javafx.fxml;
    exports org.example.programacionjorgecristobal;
    exports org.example.programacionjorgecristobal.controller;

    exports util;
    opens util to javafx.fxml;
}