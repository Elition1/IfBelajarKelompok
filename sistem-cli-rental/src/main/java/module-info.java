module io.github.romusha {
    requires javafx.controls;
    requires javafx.fxml;

    opens io.github.romusha to javafx.fxml;
    exports io.github.romusha;
}
