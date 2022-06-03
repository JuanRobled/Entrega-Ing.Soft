package entrega2.co.uparking.solid.clean.aplicacion.agregados;



import entrega1.model.Cuenta;
<<<<<<< HEAD
//import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage.IPayment;
import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage.IPayment;
=======
import entrega2.co.uparking.solid.clean.entidades.entities.AssignValet;
import entrega2.co.uparking.solid.clean.entidades.entities.ValetParking;
>>>>>>> main
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.util.HashMap;
import java.util.Map;
>>>>>>> main

public class MenuController {

    @FXML
    public Button btnRegisterVehicle;
    public Button btnNewService;
<<<<<<< HEAD
    public Button btnReceipt;

    MenuController stage2;
    Cuenta user;

    @FXML
=======
    public Button btnAdmin;

    MenuController stage2;

    ShowValetController showValet;
    Cuenta user;


>>>>>>> main
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

<<<<<<< HEAD
       QRController QR = new QRController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/entrega1/view/QRService.fxml"));
        Scene scene = new Scene(loader.load());
        QRController controlador = (QRController) loader.getController();
        controlador.receiveInfoUser(QR, this.user);
        controlador.generateQR();
=======
        ShowValetController showValet = new ShowValetController();
        AssignValet valet = new AssignValet();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/entrega1/view/ShowValetAssigned.fxml"));
        Scene scene = new Scene(loader.load());
        ShowValetController controlador = (ShowValetController) loader.getController();
        controlador.showAssignment(showValet, valet.associateValet(this.user));
>>>>>>> main
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


    }

<<<<<<< HEAD
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

=======

    @FXML
    public void EnterAdmin(ActionEvent actionEvent) throws IOException {

        if(btnAdmin.equals(actionEvent.getSource())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/entrega1/view/SignInAdmin.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }


    public void receiveparameters(MenuController controller, Cuenta user){
         stage2 = controller;
         this.user = user;
    }
>>>>>>> main
}
