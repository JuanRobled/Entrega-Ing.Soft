package entrega2.co.uparking.solid.clean.aplicacion.agregados;

import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage.Subject;
import java.io.IOException;
import java.util.*;

public class Channel implements Subject {

    private List<Subscriber> subs = new ArrayList<>();
    String title;

    @Override
    public void subscribe(Subscriber sub) {
        subs.add(sub);
    }

    @Override
    public void unSubscribe(Subscriber sub) {
        subs.remove(sub);
    }

    @Override
    public void notifySubscribers() throws IOException {
        for (Subscriber sub : subs) {
            sub.update();
        }
    }

    @Override
    public void upload(String title) throws IOException {
        this.title = title;
        notifySubscribers();

    }
}
