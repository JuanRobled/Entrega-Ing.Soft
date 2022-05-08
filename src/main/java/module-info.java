module co.uparking.solid.clean.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens co.uparking.solid.clean.main to javafx.fxml;
    exports co.uparking.solid.clean.main;
    exports co.uparking.solid.clean.aplicacion.agregados;
    opens co.uparking.solid.clean.aplicacion.agregados to javafx.fxml;

}