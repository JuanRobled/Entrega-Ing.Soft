package entrega1.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
<<<<<<< HEAD
import javafx.scene.Scene;
=======
>>>>>>> main
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.fxml.Initializable;
<<<<<<< HEAD
import javafx.stage.Stage;

public class UserController implements Initializable{

    public Button btnAdmin;
=======

public class UserController implements Initializable{

>>>>>>> main
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
            sesionForm = loadForm("/entrega1/view/InicioSesion.fxml");
            registroForm = loadForm("/entrega1/view/RegistroUsuario.fxml");
            containerForm.getChildren().addAll(sesionForm, registroForm);
            sesionForm.setVisible(true);
            registroForm.setVisible(false);
        } catch (IOException ex) {
             System.err.println("¡Error!");
        }
        
    }    
    
<<<<<<< HEAD
    @FXML
    private VBox loadForm(String url) throws IOException{    
        return (VBox) FXMLLoader.load(getClass().getResource(url));    
    }

    @FXML
    public void EnterAdmin(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/entrega1/view/SignInAdmin.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
=======
   
    private VBox loadForm(String url) throws IOException{    
        return (VBox) FXMLLoader.load(getClass().getResource(url));    
    }
    
>>>>>>> main
}
