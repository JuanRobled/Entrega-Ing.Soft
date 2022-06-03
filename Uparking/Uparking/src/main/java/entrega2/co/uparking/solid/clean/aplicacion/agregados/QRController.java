package entrega2.co.uparking.solid.clean.aplicacion.agregados;

import entrega1.model.Cuenta;
import entrega2.co.uparking.solid.clean.entidades.entities.AssignValet;
import entrega2.co.uparking.solid.clean.entidades.entities.QR;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class QRController implements Initializable {
    public ImageView imageQR;
    public Label lblDate;
    public TextField txtKey;
    public Button btnConfirm;
    public Button btnLeave;

    private static final String dir = "src/main/resources/entrega1/view/icons";
    private static final String format = ".png";
    private static final String nameImage = "temp";
    private QR manageQR = new QR();

    QRController stage;
    Cuenta user;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        manageQR.setDirectory(new File("").getAbsolutePath());
        manageQR.setDirectory(manageQR.getDirectory()+File.separator + dir);
    }

    public void generateQR() throws FileNotFoundException {

        try{

            String content = "";
            content += "Usuario: " + user.getUser() + "\n";
            content += "Tipo de Documento: " + user.getTipoDoc() + "\n";
            content += "Documento: " + user.getDocument()+ "\n";
            content += "Email: " + user.getEmail();

            FileOutputStream output = new FileOutputStream(manageQR.getDirectory() + File.separator + nameImage + format);
            ByteArrayOutputStream bos = QRCode.from(content).withSize(150,150).to(ImageType.PNG).stream();
            output.write(bos.toByteArray());

            bos.close();
            output.close();
            output.flush();

            Image image = new Image(new FileInputStream(manageQR.getDirectory()+File.separator+nameImage+format));
            imageQR.setImage(image);
            manageQR.setDateService(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
            lblDate.setText(manageQR.getDateService().format(LocalDateTime.now()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void confirmService(ActionEvent event) throws IOException {

        ShowValetController showValet = new ShowValetController();
        AssignValet valetAssigned = new AssignValet();
        if(txtKey.getText().equals(manageQR.confirmKey())) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/entrega1/view/ShowValetAssigned.fxml"));
            Scene scene = new Scene(loader.load());
            ShowValetController controlador = (ShowValetController) loader.getController();
            controlador.showAssignment(showValet, valetAssigned.associateValet(this.user));
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Advertencia");
            alert.setContentText("¡El código de ingreso no es válido!");
            alert.showAndWait();
        }
    }

    public void leave(ActionEvent event) {
        Stage stage = (Stage) btnLeave.getScene().getWindow();
        stage.close();
    }

    public void receiveInfoUser(QRController stage, Cuenta user){
        this.stage = stage;
        this.user = user;
    }


}
