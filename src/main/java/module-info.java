module org.example.mod4ct_anishiyama {
    opens org.example.mod4ct_anishiyama to javafx.fxml, javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging; // Add this line to include java.util.logging module
    exports org.example.mod4ct_anishiyama;
}
