package entrega2.co.uparking.solid.clean.aplicacion.agregados;

import entrega1.model.Cuenta;
import entrega2.co.uparking.solid.clean.aplicacion.ports.Infra.manage.IPayment;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.util.Calendar;
import java.util.Date;

public class GenerateReceipt implements IPayment {

    boolean generated = false;
    public boolean generateDocument(Cuenta user) throws Exception {
        try (PDDocument factura = new PDDocument()) {

            Date fechaActual = new Date();
            Calendar fecha = Calendar.getInstance();
            PDPage page = new PDPage(PDRectangle.A6);
            factura.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(factura, page);

            // Text
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD_ITALIC, 32);
            contentStream.newLineAtOffset(100, page.getMediaBox().getHeight() - 60);
            contentStream.showText("Upark");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
            contentStream.newLineAtOffset(100, page.getMediaBox().getHeight() - 86);
            contentStream.showText("Factura del mes " + (fecha.get(Calendar.MONTH) + 1));
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
            contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 116);
            contentStream.showText("Fecha: ");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.newLineAtOffset(56, page.getMediaBox().getHeight() - 116);
            contentStream.showText("" + fechaActual);
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
            contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 146);
            contentStream.showText("Nombre: ");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.newLineAtOffset(68, page.getMediaBox().getHeight() - 146);
            contentStream.showText(user.getUser());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
            contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 176);
            contentStream.showText("Tipo de documento: ");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.newLineAtOffset(124, page.getMediaBox().getHeight() - 176);
            contentStream.showText(user.getTipoDoc());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
            contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 206);
            contentStream.showText("Numero del documento: ");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.newLineAtOffset(147, page.getMediaBox().getHeight() - 206);
            contentStream.showText(String.valueOf(user.getDocument()));
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
            contentStream.newLineAtOffset(20, page.getMediaBox().getHeight() - 236);
            contentStream.showText("Correo: ");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.newLineAtOffset(62, page.getMediaBox().getHeight() - 236);
            contentStream.showText(user.getEmail());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
            contentStream.newLineAtOffset(90, page.getMediaBox().getHeight() - 266);
            contentStream.showText("Valor a pagar: $20.000");
            contentStream.endText();


            contentStream.close();

            factura.save("Recibo_de_pago.pdf");
            generated = true;
        }

        return generated;
    }
}
