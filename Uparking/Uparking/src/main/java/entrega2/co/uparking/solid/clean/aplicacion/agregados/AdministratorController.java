package entrega2.co.uparking.solid.clean.aplicacion.agregados;

import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.persistencia.IAdminDAO;
import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.persistencia.IValetDAO;
import entrega2.co.uparking.solid.clean.entidades.entities.Administrator;
import entrega2.co.uparking.solid.clean.entidades.entities.AssignValet;
import entrega2.co.uparking.solid.clean.entidades.entities.ValetParking;
import entrega2.co.uparking.solid.clean.infraestructura.oracle.AdminDAO;
import entrega2.co.uparking.solid.clean.infraestructura.oracle.ValetDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdministratorController implements Initializable {
    @FXML
    public TextField txtValetName;
    public ComboBox<String> cbTypeDoc;
    public TextField txtDocNum;
    public TextField txtAge;
    public TextField txtExp;
    public Button btnRegister;
    public Button btnLeave;

    private boolean accepted = false;
    private boolean exists = false;

    List<ValetParking> listValets = new ArrayList<>();

    private final Administrator manageValet = new Administrator();
    private final AssignValet assign = new AssignValet();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cleanFields();
    }
    @FXML
    public void registerValet(ActionEvent actionEvent) {

        if(btnRegister.equals(actionEvent.getSource())){

            if(!txtValetName.getText().isEmpty() && !txtDocNum.getText().isEmpty() && !txtAge.getText().isEmpty() &&
                    !txtExp.getText().isEmpty()){

                    if(txtValetName.getText().length()>=10 && txtValetName.getText().length()<=20){

                        listValets = manageValet.checkAccount();

                        if (listValets != null) {

                            for (ValetParking c : listValets) {
                                if (String.valueOf(c.getNumDoc()).equals(txtDocNum.getText())) {
                                    exists = true;
                                    break;
                                }else {
                                    exists = false;
                                }
                            }
                        }

                        if(exists){
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("OPERACIÓN FALLIDA");
                            alert.setContentText("Ya se ha registrado un valet con ese documento");
                            alert.showAndWait();

                        }

                            ValetParking valet = new ValetParking();
                            valet.setName(txtValetName.getText());
                            valet.setAge(Integer.valueOf(txtAge.getText()));
                            valet.setExperience(txtExp.getText());
                            valet.setTypeDoc(cbTypeDoc.getSelectionModel().getSelectedItem());
                            try{
                                valet.setNumDoc(Long.valueOf(txtDocNum.getText()));
                                accepted = true;
                            }catch(NumberFormatException e){
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setHeaderText(null);
                                alert.setTitle("ERROR");
                                alert.setContentText("El número de documento no es válido");
                                alert.showAndWait();
                                accepted = false;

                            }


                             assign.getValets().add(valet);


                        if (manageValet.insertValet(valet) && accepted) {

                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setHeaderText(null);
                            alert.setTitle("OPERACIÓN ÉXITOSA");
                            alert.setContentText("El valet ha sido registrado de manera éxitosa");
                            alert.showAndWait();

                            cleanFields();

                        } else {

                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("ERROR");
                            alert.setContentText("No se pudo agregar el valet!");
                            alert.showAndWait();
                        }

                    }else{

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("ERROR");
                        alert.setContentText("El Nombre de usuario debe contener al menos veinte caracteres");
                        alert.showAndWait();
                    }

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("Debe llenar, todos los campos son obligatorios");
                alert.showAndWait();

            }

        }
    }

    @FXML
    public void leaveRegister(ActionEvent actionEvent) {
        Stage stage = (Stage) btnLeave.getScene().getWindow();
        stage.close();
    }

    public void cleanFields(){

        txtValetName.setText("");
        txtDocNum.setText("");
        txtAge.setText("");
        txtExp.setText("");
        if(cbTypeDoc.getItems().size()>0){
            cbTypeDoc.getSelectionModel().select(0);
        }else{
            cbTypeDoc.setItems(FXCollections.observableArrayList("CC","CE","PP"));
            this.cbTypeDoc.setVisible(true);
        }
    }

}
