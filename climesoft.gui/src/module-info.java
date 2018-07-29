module climesoft.gui {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    exports climesoft.gui;
    opens climesoft.gui;
    requires climesoft.data;
    requires climesoft.net;
    requires com.github.benmanes.caffeine;
    exports climesoft.gui.data;
    opens climesoft.gui.data;
}