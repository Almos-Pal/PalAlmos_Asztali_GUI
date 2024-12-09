module hu.petrik.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens hu.petrik.calculator to javafx.fxml;
    exports hu.petrik.calculator;
}