package entrega2.co.uparking.solid.clean.entidades.entities;

import java.time.format.DateTimeFormatter;

public class QR {

    private String directory;

    private DateTimeFormatter dateService;

    private String key;

    public String confirmKey(){
        key = "3535";
        return key;
    }
    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public DateTimeFormatter getDateService() {
        return dateService;
    }

    public void setDateService(DateTimeFormatter dateService) {
        this.dateService = dateService;
    }
}
