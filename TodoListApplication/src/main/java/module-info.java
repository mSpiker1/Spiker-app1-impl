module todobase.todolistapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.junit.jupiter.api;

    opens todobase.todolistapplication to javafx.fxml;
    exports todobase.todolistapplication;
}