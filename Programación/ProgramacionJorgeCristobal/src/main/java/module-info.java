module org.example.programacionjorgecristobal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires jakarta.xml.bind;
    requires static lombok;
    opens org.example.programacionjorgecristobal.Model to jakarta.xml.bind, javafx.base, javafx.fxml;
    opens org.example.programacionjorgecristobal.controller to javafx.fxml;

    exports org.example.programacionjorgecristobal;
}