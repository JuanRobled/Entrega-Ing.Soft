package entrega2.co.uparking.solid.clean.aplicacion.agregados;



import entrega1.model.Cuenta;
//import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage.IPayment;
import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage.IPayment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    public Button btnRegisterVehicle;
    public Button btnNewService;
    public Button btnReceipt;

    MenuController stage2;
    Cuenta user;

    @FXML
    public void registerVehicle(ActionEvent actionEvent) throws IOException {

        if(btnRegisterVehicle.equals(actionEvent.getSource())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/entrega1/view/RegistroVehiculo.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }

    }


    @FXML
    public void createNewService(ActionEvent actionEvent) throws IOException {

       QRController QR = new QRController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/entrega1/view/QRService.fxml"));
        Scene scene = new Scene(loader.load());
        QRController controlador = (QRController) loader.getController();
        controlador.receiveInfoUser(QR, this.user);
        controlador.generateQR();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    public void generateReceipt(ActionEvent event) throws Exception {

        boolean generated = false;
        ShowReceiptController payment = new ShowReceiptController();
        IPayment manageReceipt = new GenerateReceipt();

        generated = manageReceipt.generateDocument(this.user);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Información");
        alert.setContentText("¡La Factura ha sido creada!");
        alert.showAndWait();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/entrega1/view/ReceiptPay.fxml"));
        Scene scene = new Scene(loader.load());
        ShowReceiptController controlador = loader.getController();
        controlador.setInfoPayment(payment, this.user);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


    }

    public void receiveparameters(MenuController controller, Cuenta user){
        stage2 = controller;
        this.user = user;
    }

}
