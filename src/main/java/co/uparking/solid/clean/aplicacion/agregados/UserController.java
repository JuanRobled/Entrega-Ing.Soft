package co.uparking.solid.clean.aplicacion.agregados;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable{

    @FXML
    private Button btnSesion, btnRegistrarse;
    
    @FXML
    private StackPane containerForm;
    
    private VBox sesionForm;
    @FXML
    private VBox registroForm; 
    
    @FXML
    public void actionEvent(ActionEvent e){
        
        Object evt = e.getSource();
        
        if(evt.equals(btnSesion)){
            sesionForm.setVisible(true);
            registroForm.setVisible(false);                    
        }else if(evt.equals(btnRegistrarse)){
            registroForm.setVisible(true);                                
            sesionForm.setVisible(false);
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            sesionForm = loadForm("/co/uparking/solid/clean/main/InicioSesion.fxml");
            registroForm = loadForm("/co/uparking/solid/clean/main/RegistroUsuario.fxml");
            containerForm.getChildren().addAll(sesionForm, registroForm);
            sesionForm.setVisible(true);
            registroForm.setVisible(false);
        } catch (IOException ex) {
             System.err.println("¡Error!");
        }
        
    }    
    
   
    private VBox loadForm(String url) throws IOException{    
        return (VBox) FXMLLoader.load(getClass().getResource(url));    
    }
    
}
