package Manage;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;

public class TitrePdf {

    public static final String Fontbold = "C:\\Users\\joelm\\Documents\\Spring_Pay\\project\\pdf\\files\\Policies\\OpenSans-Bold.ttf";
    Font f1 = FontFactory.getFont(Fontbold, BaseFont.WINANSI, BaseFont.EMBEDDED, 22);

    public Paragraph titredocument() {
        Paragraph nomDocument = new Paragraph("QUITTANCE", f1);
        nomDocument.setAlignment(Element.ALIGN_CENTER);
        nomDocument.setSpacingAfter(0f);
        nomDocument.setSpacingBefore(0f);

        return nomDocument;
    }
}
