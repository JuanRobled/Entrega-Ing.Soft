package entrega2.co.uparking.solid.clean.aplicacion.agregados;

import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage.Observer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Subscriber implements Observer {
    private String name;
    private Channel channel = new Channel();
    public Subscriber(String name)
    {
        super();
        this.name = name;
    }
    @Override
    public void update() throws IOException {
        boolean archivoleido;
        try {
            LogValets.archivoValets();
            LogValets.escribirarchivo("Valet " + name + " fue borrado\n");
            archivoleido=true;
        } catch (IOException e)
        {
            archivoleido=false;
        }

    }

    @Override
    public void subscribeChannel(Channel ch)
    {
        channel =ch;
    }
}