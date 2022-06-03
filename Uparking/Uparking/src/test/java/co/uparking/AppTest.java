package co.uparking;

import entrega1.controller.RegistroUsuarioController;
import entrega1.controller.RegistroVehiculoController;
import entrega1.model.Cuenta;
import entrega1.model.Vehiculo;
import entrega2.co.uparking.solid.clean.aplicacion.agregados.GenerateReceipt;
import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage.IState;
import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.persistencia.IAdminDAO;
import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.persistencia.ICuentasDAO;
import entrega2.co.uparking.solid.clean.entidades.entities.*;
import entrega2.co.uparking.solid.clean.infraestructura.oracle.AdminDAO;
import entrega2.co.uparking.solid.clean.infraestructura.oracle.CuentasDAO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class AppTest {


    @Test
    public void validateUserRegister()
    {
        try {
            RegistroUsuarioController accounts = new RegistroUsuarioController();
            ArrayList<Cuenta> listUsers= new ArrayList<>();
            Cuenta account = new Cuenta("Pepito Perez", "CC",
                    1010970987, "pepito@gmail.com", "1234");
            listUsers.add(account);
            assertTrue(accounts.InsertarCuenta(listUsers));
        }catch(RuntimeException ex) {
            ex.toString();
        }
    }


    @Test
    public void validateSignIn()
    {
        ICuentasDAO account = new CuentasDAO();
        List<Cuenta> listAccounts =  new ArrayList<>();
        Cuenta acc = new Cuenta();

        listAccounts = account.checkAccount();

        for (Cuenta c: listAccounts) {
            if ((c.getUser().equals("Juan04")) &&
                    (c.getPassword().equals("juan04"))) {
                acc = c;
                break;

            }
        }

        assertEquals(acc.getUser(),"Juan04");
        assertEquals(acc.getPassword(),"juan04");
    }


    @Test
    public void validateRegisterValet()
    {
        Random rnd = new Random();
        long number= rnd. nextInt (999999999);

        try {
            Administrator admin = new Administrator();
            ValetParking valet = new ValetParking("Pedro","CC",
                    number,24,"4 años manejando moto");

            assertTrue(admin.insertValet(valet));
        }catch (RuntimeException ex){
            ex.toString();
        }
    }

    @Test
    public void validateAssignValet()
    {
        try {

            AssignValet assignValet = new AssignValet();
            ValetParking valet = new ValetParking();
            assignValet.getValets().add(valet);
            assertEquals(1, assignValet.getValets().size());

        }catch(IndexOutOfBoundsException ex) {
            ex.toString();
        }
    }

    @Test
    public void validateSignInAdmin()
    {
        Administrator admin = new Administrator();
        IAdminDAO adm = new AdminDAO();
        List<Administrator> listAdmin;
        listAdmin = adm.checkAccounts();

        assertEquals(listAdmin.get(0).getNameUser(),"admin");
        assertEquals(listAdmin.get(0).getPassword(),"1234");
    }

    @Test
    public void validarRegisterVehicle()
    {
        try {
            RegistroVehiculoController regVehicle = new RegistroVehiculoController();
            ArrayList<Vehiculo> listVehicles= new ArrayList<>();
            Vehiculo vehiculo = new Vehiculo("Juan","Moto",
                    "ACB123","F14",2005,"Honda","Negro");
            listVehicles.add(vehiculo);
            assertNotNull(vehiculo);
            assertNotNull(regVehicle.InsertarVehiculo(listVehicles));
        }catch(RuntimeException ex) {
            ex.toString();
        }
    }

    @Test
    public void validateEmail()
    {
        Cuenta account = new Cuenta();
        assertTrue(account.validateEmail("example@gmail.com"));

    }

    @Test
    public void validateChangeStateAvailable()
    {
        IState state = new Available();
        ValetParking valet = new ValetParking();
        valet.setState("OCUPADO");
        state.changeState(valet);
        assertEquals("DISPONIBLE",valet.getState());

    }

    @Test

    public void validateChangeStateInService()
    {
        IState state = new InService();
        ValetParking valet = new ValetParking();
        valet.setState("DISPONIBLE");
        state.changeState(valet);
        assertEquals("OCUPADO",valet.getState());

    }

    @Test
    public void validateGeneratedPayment() throws Exception {

        try {
            Cuenta account = new Cuenta("Andres", "CC",
                    1010365487, "andres@correo.com", "mipass");
            GenerateReceipt payment = new GenerateReceipt();
            assertTrue(payment.generateDocument(account));
        }catch (RuntimeException exception){
            exception.toString();
        }
    }


}