<<<<<<< HEAD
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
>>>>>>> main
package entrega1.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entrega1.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
<<<<<<< HEAD
 *Manage the register of a vehicle in a system
 * @author Juan Esteban Urquijo
 */

=======
 *
 * @author User
 */
>>>>>>> main
public class RegistroVehiculoController implements Initializable {

    @FXML
    private VBox panelRegistro;
    @FXML
    private TextField txtPropietario;
    @FXML
    private ComboBox<String> cbTipoVeh;
    @FXML
    private TextField txtPlaca;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtAnio;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtColor;
    @FXML
    private Button btnRegVeh;
    @FXML
    private Button btnLimpiarReg;
    
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    
    RegistroUsuarioController controlador2;
  
    private boolean aceptado = true;

    public void cleanFields(){
        txtPropietario.setText("");
        txtPlaca.setText("");
        txtModelo.setText("");
        txtAnio.setText("");
        txtMarca.setText("");
        txtColor.setText("");
        if(cbTipoVeh.getItems().size()>0){
            cbTipoVeh.getSelectionModel().select(0);            
        }else{
<<<<<<< HEAD
            cbTipoVeh.setItems(FXCollections.observableArrayList(
                    "Carro", "Moto","Van"));
=======
            cbTipoVeh.setItems(FXCollections.observableArrayList("Carro","Moto","Van"));
>>>>>>> main
            this.cbTipoVeh.setVisible(true);
        }                
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cleanFields();
    }    

    @FXML
    private void KeyEvent(KeyEvent event) {
         String c = event.getCharacter();
        
        if(c.equalsIgnoreCase(" ")){
            event.consume();
        }
    }

    @FXML
    private void RegisterEvent(ActionEvent event) throws IOException {
        
        Object evt = event.getSource();
        
          if(btnRegVeh.equals(evt)){
        
<<<<<<< HEAD
            if((!txtPropietario.getText().isEmpty()) &&
                    (!txtPlaca.getText().isEmpty()) &&
                    (!txtModelo.getText().isEmpty()) &&
                    (!txtAnio.getText().isEmpty()) &&
                    (!txtMarca.getText().isEmpty()) &&
                    (!txtColor.getText().isEmpty())) {

                    if(txtPropietario.getText().length()>=5) {
=======
            if(!txtPropietario.getText().isEmpty() && !txtPlaca.getText().isEmpty() && !txtModelo.getText().isEmpty() &&
               !txtAnio.getText().isEmpty() && !txtMarca.getText().isEmpty() && !txtColor.getText().isEmpty()){
                
                    
                    if(txtPropietario.getText().length()>=3){

>>>>>>> main

                                Vehiculo vehiculo = new Vehiculo();
                                vehiculo.setPropietrario(txtPropietario.getText());
                                vehiculo.setTipoVeh(cbTipoVeh.getSelectionModel().getSelectedItem());
                                vehiculo.setPlaca(txtPlaca.getText());
                                vehiculo.setModelo(txtModelo.getText());
                                vehiculo.setMarca(txtMarca.getText());
                                vehiculo.setColor(txtColor.getText());
                                
<<<<<<< HEAD
                                try {

                                vehiculo.setAnio(Integer.valueOf(txtAnio.getText()));
                                aceptado = true;

                                }catch(NumberFormatException e){

=======
                                try{
                                vehiculo.setAnio(Integer.valueOf(txtAnio.getText()));
                                aceptado = true;
                                }catch(NumberFormatException e){
>>>>>>> main
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setTitle("ERROR");
                                    alert.setContentText("El año no es válido");
                                    alert.showAndWait();
                                    aceptado = false;
                                  
                                }
<<<<<<< HEAD

=======
>>>>>>> main
                                vehiculos.add(vehiculo);
                                
                                if(InsertarVehiculo(vehiculos) && aceptado == true){
                                    
                                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setHeaderText(null);
                                    alert.setTitle("OPERACIÓN ÉXITOSA");
<<<<<<< HEAD
                                    alert.setContentText("El vehículo ha sido registrado" +
                                            " de manera éxitosa");
=======
                                    alert.setContentText("El vehículo ha sido registrado de manera éxitosa");
>>>>>>> main
                                    alert.showAndWait();
                                  
                                    cleanFields();

                                }else{

                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setTitle("ERROR");
                                    alert.setContentText("No se pudo agregar el vehiculo!");
                                    alert.showAndWait();

                                }

                      }else{
                       
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setTitle("ERROR");
<<<<<<< HEAD
                                    alert.setContentText("El Nombre de propietario debe contener" +
                                            " al menos CINCO caracteres");
=======
                                    alert.setContentText("El Nombre de propietario debe contener al menos TRES caracteres");
>>>>>>> main
                                    alert.showAndWait();           
                    }
                    
                                
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("Debe llenar todos los campos obligatorios");
                alert.showAndWait(); 
               
            }
            
    
        }else if(btnLimpiarReg.equals(evt)){        
            cleanFields();        
        }
          
        
    }
<<<<<<< HEAD
=======

>>>>>>> main
    @FXML
    private void CleanEvent(ActionEvent event) {
        cleanFields();
    }
<<<<<<< HEAD

    public boolean InsertarVehiculo(ArrayList<Vehiculo> vehiculos) {
=======
    
    
    public boolean InsertarVehiculo(ArrayList<Vehiculo> vehiculos){
>>>>>>> main
        
        boolean insertado = false;
        
           try {
       
            File archivo = new File("vehiculos.txt");
            FileWriter escribir = new FileWriter(archivo, true);
            
            for(int i = 0; i < vehiculos.size(); i++ )
            {
                 escribir.write(vehiculos.get(i) + "\n");
            }
            insertado = true;
            escribir.close();
        } catch (IOException e) {
            System.out.println("No se puedo escribir en el archivo!");
            insertado = false;
        }
        
        return insertado;
    }
    
    public void recibirParametros(RegistroUsuarioController controller, String texto) {
        txtPropietario.setText(texto);
        controlador2 = controller;
    }
}
