package Manage;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.time.LocalDate;

public class DescriptifDocument {

    public static final String Font = "C:\\Users\\joelm\\Documents\\Spring_Pay\\project\\pdf\\files\\Policies\\OpenSans-Regular.ttf";
    public static final String Fontbold = "C:\\Users\\joelm\\Documents\\Spring_Pay\\project\\pdf\\files\\Policies\\OpenSans-Bold.ttf";
    Font f1 = FontFactory.getFont(Font, BaseFont.WINANSI, BaseFont.EMBEDDED, 10);
    Font f2 = FontFactory.getFont(Fontbold, BaseFont.WINANSI, BaseFont.EMBEDDED, 10);


    public PdfPCell getCell(String value, int alignment, int colspan, int rectangle, Font font) {
        final PdfPCell cell = new PdfPCell();
        cell.setUseAscender(true);
        cell.setUseDescender(true);
        cell.setPadding(5f);
        cell.setColspan(colspan);
        //cell.setRowspan(rowspan);
        cell.setBorder(rectangle);
        final Paragraph p = new Paragraph(value, font);
        p.setAlignment(alignment);
        cell.addElement(p);
        return cell;
    }
    public PdfPCell getCell1(long value, int alignment, int colspan, int rectangle, Font font) {
        final PdfPCell cell = new PdfPCell();
        cell.setUseAscender(true);
        cell.setUseDescender(true);
        cell.setPadding(5f);
        cell.setColspan(colspan);
        //cell.setRowspan(rowspan);
        cell.setBorder(rectangle);

        final Paragraph p = new Paragraph(String.valueOf(value), font);
        p.setAlignment(alignment);
        cell.addElement(p);
        return cell;
    }
    public PdfPCell getCell2(LocalDate value, int alignment, int colspan, int rectangle, Font font) {
        final PdfPCell cell = new PdfPCell();
        cell.setUseAscender(true);
        cell.setUseDescender(true);
        cell.setPadding(5f);
        cell.setColspan(colspan);
        //cell.setRowspan(rowspan);
        cell.setBorder(rectangle);
        final Paragraph p = new Paragraph(String.valueOf(value), font);
        p.setAlignment(alignment);
        cell.addElement(p);
        return cell;
    }

    PdfPTable decriptif(JustificatifPaiementDTO justificatifPaiementDTO) throws DocumentException {
        PdfPTable table2 = new PdfPTable(6);
        table2.setWidthPercentage(100f);
        table2.setSpacingBefore(10f);
        table2.setSpacingAfter(50f);
        float[] columnwidths = {1f, 1f, 1f, 1f, 1f, 1f};
        table2.setWidths(columnwidths);

        table2.addCell(getCell(justificatifPaiementDTO.getNomOrganisation()+justificatifPaiementDTO.getCodeOrganisation(), Element.ALIGN_LEFT, 4, Rectangle.NO_BORDER, f2));
        table2.addCell(getCell("N°: "+justificatifPaiementDTO.getNumero()+"\n"+"CODE POSTE: "+justificatifPaiementDTO.getCodePoste()+"\n"+"Date de creation: "+justificatifPaiementDTO.getDateCreation(), Element.ALIGN_RIGHT, 2, Rectangle.NO_BORDER, f1));
        table2.addCell(getCell("IFU: "+justificatifPaiementDTO.getIfu()+"\n"+"Exercise: "
                +justificatifPaiementDTO.getExercise()+"\n"+"Mois: "+justificatifPaiementDTO.getMois()+"\n"+"Code: "
                +justificatifPaiementDTO.getCode(), Element.ALIGN_LEFT, 2, Rectangle.NO_BORDER, f1));
        table2.addCell(getCell("NUI: "+justificatifPaiementDTO.getNui()+"\n"+"Raison sociale: "
                +justificatifPaiementDTO.getRaisonSociale()+"\n"+"NoM: "+justificatifPaiementDTO.getNomPrenomClient()+"\n"+"Sigle: "
                +justificatifPaiementDTO.getSigle(), Element.ALIGN_LEFT, 2, Rectangle.NO_BORDER, f1));
        table2.addCell(getCell("\n Type Paiement: "+justificatifPaiementDTO.getTypePaiement(), Element.ALIGN_RIGHT, 2, Rectangle.NO_BORDER, f1));



        return table2;
    }
}
