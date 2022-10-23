module com.works._10_days {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.works._10_days to javafx.fxml;
    exports com.works._10_days;
}