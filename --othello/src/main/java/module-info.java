module com.example.othello {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.media;

    opens com.example.othello to javafx.fxml;
    exports com.example.othello;
}