package Manage;

import com.github.royken.converter.FrenchNumberToWords;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;


public class TableFacture {

    public static final String Font = "C:\\Users\\joelm\\Documents\\Spring_Pay\\project\\pdf\\files\\Policies\\OpenSans-Regular.ttf";
    public static final String Fontbold = "C:\\Users\\joelm\\Documents\\Spring_Pay\\project\\pdf\\files\\Policies\\OpenSans-Bold.ttf";

    Font f2 = FontFactory.getFont(Font, BaseFont.WINANSI, BaseFont.EMBEDDED, 10);
    Font f1 = FontFactory.getFont(Fontbold, BaseFont.WINANSI, BaseFont.EMBEDDED, 10);
    Font f3 = FontFactory.getFont(Fontbold, BaseFont.WINANSI, BaseFont.EMBEDDED, 14);
    Font f4 = FontFactory.getFont(Font, BaseFont.WINANSI, BaseFont.EMBEDDED, 12);



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

    PdfPTable decriptiffacture(JustificatifPaiementDTO justificatifPaiementDTO) throws DocumentException {
        PdfPTable table3 = new PdfPTable(6);
        table3.setWidthPercentage(105f);
        table3.setSpacingBefore(0f);
        table3.setSpacingAfter(10f);
        float[] columnwidths = {1f, 1f, 1f, 1f, 1f, 1f};
        table3.setWidths(columnwidths);

        table3.addCell(getCell("LIQUIDATION", Element.ALIGN_CENTER, 6, 0, Rectangle.BOTTOM | Rectangle.TOP, f3));
        table3.addCell(getCell("N° Déclaration", Element.ALIGN_LEFT, 1, 0, Rectangle.BOTTOM | Rectangle.TOP, f1));//20
        table3.addCell(getCell("IMPUTATION", Element.ALIGN_LEFT, 1, 0, Rectangle.BOTTOM | Rectangle.TOP, f1));
        table3.addCell(getCell("N° Opération", Element.ALIGN_LEFT, 1, 0, Rectangle.BOTTOM | Rectangle.TOP, f1));//20
        table3.addCell(getCell("NATURE DES DROITS", Element.ALIGN_LEFT, 2, 0, Rectangle.BOTTOM | Rectangle.TOP, f1));
        table3.addCell(getCell("MONTANT (XAF)", Element.ALIGN_LEFT, 1, 0, Rectangle.BOTTOM | Rectangle.TOP, f1));

        justificatifPaiementDTO.getImputations().forEach(imputationDTO -> {

            table3.addCell(getCell("" + imputationDTO.getNumDeclarationImputation(), Element.ALIGN_LEFT, 1, 20, Rectangle.NO_BORDER, f2));//20
            table3.addCell(getCell(" ", Element.ALIGN_LEFT, 1, 0, Rectangle.NO_BORDER, f2));
            table3.addCell(getCell(imputationDTO.getOperation(), Element.ALIGN_LEFT, 1, 0, Rectangle.NO_BORDER, f2));//20
            table3.addCell(getCell("" + imputationDTO.getNatrureDesDroits(), Element.ALIGN_LEFT, 2, 0, Rectangle.NO_BORDER, f2));
            table3.addCell(getCell("" + imputationDTO.getMontant(), Element.ALIGN_LEFT, 1, 0, Rectangle.NO_BORDER, f2));

        });


        final Double totalHT = justificatifPaiementDTO.getImputations().stream()
                .filter(imputationDTO -> imputationDTO.getMontant() > 0)
                .mapToDouble(imputationDTO -> imputationDTO.getMontant())
                .sum();

        Double totalHTarrondi = Math.ceil(totalHT);
        //Double totalHTarrondi = Math.round(totalHT*10000.0)/10000.0;

        String resultatenlettre = FrenchNumberToWords.convert(totalHTarrondi.longValue());

        table3.addCell(getCell("", Element.ALIGN_CENTER, 2, 0, Rectangle.TOP, f2));
        table3.addCell(getCell("TOTAL", Element.ALIGN_CENTER, 3, 0, Rectangle.TOP, f1));
        table3.addCell(getCell(totalHTarrondi+" FR CFA", Element.ALIGN_LEFT, 1, 10, Rectangle.TOP, f1));
        table3.addCell(getCell("", Element.ALIGN_CENTER, 6, 0, Rectangle.NO_BORDER, f2));
        table3.addCell(getCell("", Element.ALIGN_CENTER, 6, 0, Rectangle.NO_BORDER, f2));
        table3.addCell(getCell("", Element.ALIGN_CENTER, 6, 0, Rectangle.NO_BORDER, f2));
        table3.addCell(getCell("La présente quitance est arrêté à la somme de", Element.ALIGN_LEFT, 6, 0, Rectangle.NO_BORDER, f2));

        table3.addCell(getCell(resultatenlettre+" Fr CFA", Element.ALIGN_LEFT, 6, 0, Rectangle.NO_BORDER, f1));


        return table3;
    }

}
