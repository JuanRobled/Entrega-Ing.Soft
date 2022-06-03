package entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage;

import entrega2.co.uparking.solid.clean.aplicacion.agregados.Subscriber;
import java.io.IOException;

public interface Subject {
    void subscribe(Subscriber sub);

    void unSubscribe(Subscriber sub);

    void notifySubscribers() throws IOException;

    void upload(String title) throws IOException;
}