package entrega1.controller;

import entrega1.model.Cuenta;
import entrega2.co.uparking.solid.clean.aplicacion.agregados.MenuController;
import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.persistencia.ICuentasDAO;
import entrega2.co.uparking.solid.clean.infraestructura.oracle.CuentasDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * FXML Controller class
 * Manage the login of the system users
 * @author Juan Esteban Urquijo
 */
public class InicioSesionController{

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnLimpiarIng;

    private List<Cuenta> cuentas = new ArrayList<>();
    private ICuentasDAO model = new CuentasDAO();
    private MenuController menu;


    @FXML
    public void IniciarSesion(ActionEvent actionEvent) throws IOException {

        boolean encontrada = false;
        Object evt = actionEvent.getSource();

        if(btnIngresar.equals(evt)) {

            if((!txtUsuario.getText().isEmpty()) &&
                    (!txtPassword.getText().isEmpty())) {
                cuentas = model.checkAccount();

                if(cuentas != null) {

                    for (Cuenta c: cuentas) {
                        if((c.getUser().equals(txtUsuario.getText())) &&
                                (c.getPassword().equals(txtPassword.getText()))) {

                            encontrada = true;
                            FXMLLoader loader = new FXMLLoader(getClass().
                                    getResource("/entrega1/view/Menu.fxml"));
                            Scene scene = new Scene(loader.load());
                            MenuController controlador = loader.getController();
                            controlador.receiveparameters(menu, c);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.show();
                            cleanFields();
                            break;

                        }
                    }

                    if(encontrada) {

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Informaci??n");
                        alert.setContentText("??BIENVENIDO!");
                        alert.showAndWait();


                    }else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("ERROR");
                        alert.setContentText("??Usuario o contrase??a incorrectos!");
                        alert.showAndWait();
                        cleanFields();
                    }
                }
            }
        }else {
            cleanFields();
        }
    }



    @FXML
    public void limpiarCampos(ActionEvent actionEvent) {

        if(btnLimpiarIng.equals(actionEvent.getSource())) {
            cleanFields();
        }

    }

    public void cleanFields() {

        txtUsuario.setText("");
        txtPassword.setText("");

    }
}
