package entrega2.co.uparking.solid.clean.entidades.entities;

import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.persistencia.IValetDAO;
import entrega2.co.uparking.solid.clean.infraestructura.oracle.ValetDAO;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> main
public class Administrator implements IValetDAO {

    private int id;
    private String nameUser;
    private String password;

    @Override
    public boolean insertValet(ValetParking valet) {

<<<<<<< HEAD
        boolean insert = false;
=======
>>>>>>> main
        IValetDAO valetDAO = new ValetDAO();

        if(valetDAO.insertValet(valet))
        {
<<<<<<< HEAD
            insert = true;
        }
        return insert;
    }

    @Override
    public List<ValetParking> checkAccount() {

        List<ValetParking> valets = new ArrayList<>();
        IValetDAO valetDAO = new ValetDAO();
        valets = valetDAO.checkAccount();

       return valets;
    }

    @Override
    public boolean deleteValet(int id) {
        boolean delete =  false;
        IValetDAO valetDAO = new ValetDAO();

        if(valetDAO.deleteValet(id)){
            delete = true;
        }

        return delete;
=======
            return true;
        }
        return false;
>>>>>>> main
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
