package Manage;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.IOException;

public class Qrcode {
    public static final String qrcode= "C:\\Users\\joelm\\Documents\\Spring_Pay\\project\\pdf\\files\\q.png";
    public static final String chemin = "C:\\Users\\joelm\\Documents\\Spring_Pay\\project\\pdf\\files\\Facture.pdf";
    Image img = Image.getInstance(qrcode);

    private static Font catFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 12 );

    public Qrcode() throws IOException, BadElementException {
    }

    public PdfPCell getCell(String value, int alignment, int colspan, int fixedheight, int rectangle, Font font) {
        final PdfPCell cell = new PdfPCell();
        cell.setUseAscender(true);
        cell.setUseDescender(true);
        cell.setPadding(5f);
        cell.setColspan(colspan);
        cell.setFixedHeight(fixedheight);
        //cell.setRowspan(rowspan);
        cell.setBorder(rectangle);
        final Paragraph p = new Paragraph(value, font);
        p.setAlignment(alignment);
        cell.addElement(p);
        return cell;
    }
    public PdfPCell getCellimage(Image image, int colspan, int fixedheight, int rectangle) {
        final PdfPCell cell = new PdfPCell();
        cell.setUseAscender(true);
        cell.setUseDescender(true);
        cell.setPadding(5f);
        cell.setColspan(colspan);
        cell.setFixedHeight(fixedheight);
        cell.setImage(image);
        //cell.setRowspan(rowspan);
        cell.setBorder(rectangle);
        return cell;
    }

    PdfPTable qrcode() throws DocumentException {
        PdfPTable table5 = new PdfPTable(3);
        table5.setWidthPercentage(100f);
        table5.setSpacingBefore(20f);
        table5.setSpacingAfter(10f);
        float[] columnwidths = {2f,2f,1f};
        table5.setWidths(columnwidths);


        table5.addCell(getCell(" ", Element.ALIGN_CENTER,2,0, Rectangle.NO_BORDER,catFont1));
        table5.addCell(getCellimage(img,1,120, Rectangle.NO_BORDER));



        return table5;
    }
}
