package entrega2.co.uparking.solid.clean.aplicacion.agregados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogValets {
    public static void archivoValets() throws IOException {
        boolean insertado;
        File file = new File("RemovedValets.txt");
        try {
            if (file.exists() == false) {
                file.createNewFile();
                insertado=true;
            }
        }
        catch (IOException e)
        {
            insertado=false;
        }

    }
    public static void escribirarchivo(String mensaje) throws IOException {
        FileWriter myWriter = new FileWriter("RemovedValets.txt", true);
        myWriter.append(mensaje);
        myWriter.close();
    }
}