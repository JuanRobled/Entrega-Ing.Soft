package entrega2.co.uparking.solid.clean.entidades.entities;

import entrega1.model.Cuenta;
import entrega2.co.uparking.solid.clean.infraestructura.oracle.ValetDAO;
import javafx.scene.control.Alert;

import java.util.*;

public class AssignValet {

    private Map<Cuenta, ValetParking> assigned = new HashMap<Cuenta, ValetParking>();

    private List<ValetParking> valets = new ArrayList<>();

    public AssignValet() {
    }

    public ValetParking associateValet(Cuenta user){

        boolean asg = false;
        ValetParking v = new ValetParking();
        ValetDAO valet = new ValetDAO();
        valets = valet.checkAccount();
        InService service = new InService();
        if(!asg) {
            v = valets.get(0);
            assigned.put(user, v);
            service.changeState(v);
            asg = true;

        }
        if(asg){
            valets.remove(v);
        }

       return v;
    }

    public Map<Cuenta, ValetParking> getAssigned() {
        return assigned;
    }

    public void setAssigned(Map<Cuenta, ValetParking> assigned) {
        this.assigned = assigned;
    }

    public List<ValetParking> getValets() {
        return valets;
    }

    public void setValets(List<ValetParking> valets) {
        this.valets = valets;
    }


}
