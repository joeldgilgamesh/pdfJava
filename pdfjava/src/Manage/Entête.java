package Manage;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class Entête {
    public static final String Font = "C:\\Users\\joelm\\Documents\\Spring_Pay\\project\\pdf\\files\\Policies\\OpenSans-Regular.ttf";
    public static final String Fontbold = "C:\\Users\\joelm\\Documents\\Spring_Pay\\project\\pdf\\files\\Policies\\OpenSans-Bold.ttf";

    Font f1 = FontFactory.getFont(Fontbold, BaseFont.WINANSI, BaseFont.EMBEDDED,12, com.itextpdf.text.Font.UNDERLINE);
    Font f2 = FontFactory.getFont(Font, BaseFont.WINANSI, BaseFont.EMBEDDED,12);
    Font f3 = FontFactory.getFont(Fontbold, BaseFont.WINANSI, BaseFont.EMBEDDED,12);


    public PdfPCell getCell(String value, int alignment, int colspan, int rectangle, Font font) {
        final PdfPCell cell = new PdfPCell();
        cell.setUseAscender(true);
        cell.setUseDescender(true);
        cell.setPadding(5f);
        cell.setColspan(colspan);
        cell.setBorder(rectangle);
        final Paragraph p = new Paragraph(value, font);
        p.setAlignment(alignment);
        cell.addElement(p);
        return cell;
    }

    PdfPTable entete(JustificatifPaiementDTO justificatifPaiementDTO) throws DocumentException {
        PdfPTable table1 = new PdfPTable(6);
        table1.setWidthPercentage(100f);
        table1.setSpacingBefore(0f);
        table1.setSpacingAfter(0f);
        float[] columnwidths = {1f,1f,1f,1f,1f,1f};
        table1.setWidths(columnwidths);

        table1.addCell(getCell("REPUBLIQUE DU CAMEROUN", Element.ALIGN_CENTER,3, Rectangle.NO_BORDER,f1));
        table1.addCell(getCell("REPUBLIC OF CAMEROUN", Element.ALIGN_CENTER,3, Rectangle.NO_BORDER,f1));
        table1.addCell(getCell("MINISTERE DES FINANCES", Element.ALIGN_CENTER,3, Rectangle.NO_BORDER,f2));
        table1.addCell(getCell("MINISTRY OF FINANCES", Element.ALIGN_CENTER,3, Rectangle.NO_BORDER,f2));
        table1.addCell(getCell("TRESOR PUBLIC", Element.ALIGN_CENTER,3, Rectangle.NO_BORDER,f2));
        table1.addCell(getCell("PUBLIC TREASURY", Element.ALIGN_CENTER,3, Rectangle.NO_BORDER,f2));
        table1.addCell(getCell(justificatifPaiementDTO.getLibelleCentre(), Element.ALIGN_CENTER,3, Rectangle.NO_BORDER,f3));
        table1.addCell(getCell(justificatifPaiementDTO.getLibelleCourtCentre(), Element.ALIGN_CENTER,3, Rectangle.NO_BORDER,f3));




        return table1;
    }
}
