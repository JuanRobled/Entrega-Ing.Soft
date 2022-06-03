package entrega2.co.uparking.solid.clean.aplicacion.agregados;

import entrega1.model.Cuenta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShowReceiptController {

    public Button btnLeave;
    public TextField txtDate;
    public TextField txtName;
    public TextField txtTypeDoc;
    public TextField txtNumDoc;
    public TextField txtEmail;
    public Label lblPayment;

    private DateTimeFormatter datePayment;
    private final String pay = "$20.000";
    Cuenta user;
    ShowReceiptController stage2;




    public void setInfoPayment(ShowReceiptController payment, Cuenta user){
        this.stage2 = payment;
        this.user = user;

        datePayment = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        txtDate.setText(String.valueOf(datePayment.format(LocalDateTime.now())));
        txtName.setText(user.getUser());
        txtName.setEditable(false);
        txtTypeDoc.setText(user.getTipoDoc());
        txtTypeDoc.setEditable(false);
        txtNumDoc.setText(String.valueOf(user.getDocument()));
        txtNumDoc.setEditable(false);
        txtEmail.setText(user.getEmail());
        txtEmail.setEditable(false);
        lblPayment.setText(pay);

    }
    @FXML
    public void leave(ActionEvent event) {
        Stage stage = (Stage) btnLeave.getScene().getWindow();
        stage.close();
    }
}
