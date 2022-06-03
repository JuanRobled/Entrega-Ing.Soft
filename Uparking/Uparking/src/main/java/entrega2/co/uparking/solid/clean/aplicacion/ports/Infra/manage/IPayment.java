package entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage;

import entrega1.model.Cuenta;

public interface IPayment {

    public boolean generateDocument(Cuenta user) throws Exception;

}
