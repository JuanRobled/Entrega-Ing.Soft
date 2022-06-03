package entrega2.co.uparking.solid.clean.aplicacion.agregados;

import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.persistencia.IValetDAO;
import entrega2.co.uparking.solid.clean.entidades.entities.ValetParking;
import entrega2.co.uparking.solid.clean.infraestructura.oracle.ValetDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteValetController implements Initializable {
    public TableView<ValetParking> tableValets;
    public Button btnUpdate;
    public Button btnDeleteValet;

    private final IValetDAO manageValet = new ValetDAO();
    private List<ValetParking> valets ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        valets = manageValet.checkAccount();
        updateView(new ActionEvent());
    }
    ValetParking getSeleccionado() {
        return tableValets.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void updateView(ActionEvent event) {
        valets = manageValet.checkAccount();
        tableValets.getItems().clear();
        tableValets.getItems().addAll(valets);
    }

    public void deleteValet(ActionEvent event) throws IOException {
        String id = Integer.toString(getSeleccionado().getId());
        manageValet.deleteValet(getSeleccionado().getId());
        Channel canal = new Channel();
        Subscriber idValet = new Subscriber(id);
        canal.subscribe(idValet);
        idValet.subscribeChannel(canal);
        canal.upload("Valet Eliminado");
        updateView(event);

    }


}
