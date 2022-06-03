package entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage;

import entrega2.co.uparking.solid.clean.aplicacion.agregados.Channel;
import java.io.IOException;

public interface Observer {

    void update() throws IOException;
    void subscribeChannel(Channel ch);

}
