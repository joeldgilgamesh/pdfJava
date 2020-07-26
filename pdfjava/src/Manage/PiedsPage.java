package Manage;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class PiedsPage {

    public static final String Font = "C:\\Users\\joelm\\Documents\\Spring_Pay\\project\\pdf\\files\\Policies\\OpenSans-Regular.ttf";
    Font f1 = FontFactory.getFont(Font, BaseFont.WINANSI, BaseFont.EMBEDDED, 12);

    public PdfPCell getCell(String value, int alignment, int colspan, int fixedheight, int paddingtop, int rectangle, Font font) {
        final PdfPCell cell = new PdfPCell();
        cell.setUseAscender(true);
        cell.setUseDescender(true);
        cell.setPadding(5f);
        cell.setColspan(colspan);
        cell.setPaddingTop(paddingtop);
        cell.setFixedHeight(fixedheight);
        //cell.setRowspan(rowspan);
        cell.setBorder(rectangle);
        final Paragraph p = new Paragraph(value, font);
        p.setAlignment(alignment);
        cell.addElement(p);
        return cell;
    }

    PdfPTable pieddepage() throws DocumentException {
        PdfPTable table5 = new PdfPTable(3);
        table5.setWidthPercentage(110f);
        table5.setSpacingBefore(5f);
        table5.setSpacingAfter(0f);
        float[] columnwidths = {1f,1f,1f};
        table5.setWidths(columnwidths);

        table5.addCell(getCell(" Quitance No 2519746", Element.ALIGN_LEFT,1,0,10, Rectangle.TOP,f1));
        table5.addCell(getCell("", Element.ALIGN_CENTER,2,0,0, Rectangle.TOP,f1));



        return table5;
    }
}
