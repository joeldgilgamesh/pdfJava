package Manage;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class PdfFacture {
    public static final String chemin = "C:\\Users\\joelm\\Documents\\Spring_Pay\\project\\pdf\\files\\Facture.pdf";
    public static final String image = "C:\\Users\\joelm\\Documents\\Spring_Pay\\project\\pdf\\files\\minresi.png";


    public static void main(String[] args) throws IOException, DocumentException {
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //LocalDateTime ldt = LocalDateTime.now();
        //LocalDate localDate = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Rectangle pagecolor = new Rectangle(595, 842);
        pagecolor.setBackgroundColor(new BaseColor(255, 255, 224));
        Document document = new Document(pagecolor);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(chemin));

        Image img = Image.getInstance(image);
        float w = img.getScaledWidth();
        float h = img.getScaledHeight();


        JustificatifPaiementDTO justificatifPaiementDTO = new JustificatifPaiementDTO();
        ImputationDTO imputationDTO = new ImputationDTO();
        ImputationDTO imputationDTO1 = new ImputationDTO();
        ImputationDTO imputationDTO2 = new ImputationDTO();
        ImputationDTO imputationDTO3 = new ImputationDTO();
        ImputationDTO imputationDTO4 = new ImputationDTO();




        Entête entete = new Entête();
        TitrePdf titrePdf = new TitrePdf();
        DescriptifDocument descriptifDocument = new DescriptifDocument();
        TableFacture tableFacture = new TableFacture();
        Qrcode qrcode = new Qrcode();
        PiedsPage piedsPage = new PiedsPage();

        justificatifPaiementDTO.setLibelleCentre("REGION CENTRE");
        justificatifPaiementDTO.setLibelleCourtCentre("CENTER REGION");
        justificatifPaiementDTO.setNomOrganisation("CENTRE DIVISIONNAIRE DES IMPÔTS DE YAOUNDE I \n");
        justificatifPaiementDTO.setCodeOrganisation("CDI TYPE");
        justificatifPaiementDTO.setNumero(13000185696L);
        justificatifPaiementDTO.setCodePoste(612L);
        justificatifPaiementDTO.setDateCreation(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        justificatifPaiementDTO.setIfu("IFUS");
        justificatifPaiementDTO.setExercise("2020");
        justificatifPaiementDTO.setMois("03");
        justificatifPaiementDTO.setCode("045");
        justificatifPaiementDTO.setNui("U256626226Q");
        justificatifPaiementDTO.setNomPrenomClient("Antagana Mbah");
        justificatifPaiementDTO.setTypePaiement("MTN Mobile money");


        Set<ImputationDTO> imputationDTOSet = new HashSet<>();
        imputationDTOSet.add(imputationDTO);
        imputationDTOSet.add(imputationDTO1);
        imputationDTOSet.add(imputationDTO2);
        imputationDTOSet.add(imputationDTO3);
        imputationDTOSet.add(imputationDTO4);



        imputationDTO.setNumDeclarationImputation(000L);
        imputationDTO.setOperation("PA");
        imputationDTO.setNatrureDesDroits("Frais d'examens et concours");
        imputationDTO.setMontant(221.598);
        imputationDTO1.setNumDeclarationImputation(000L);
        imputationDTO1.setOperation("PA");
        imputationDTO1.setNatrureDesDroits("PATIENTE COMMUNE");
        imputationDTO1.setMontant(11.198);
        imputationDTO2.setNumDeclarationImputation(000L);
        imputationDTO2.setOperation("PA");
        imputationDTO2.setNatrureDesDroits("TOLPATIENTE");
        imputationDTO2.setMontant(123.970);
        imputationDTO3.setNumDeclarationImputation(000L);
        imputationDTO3.setOperation("PA");
        imputationDTO3.setNatrureDesDroits("FRAIS D'ADSSIETTE PATIENT");
        imputationDTO3.setMontant(22.398);
        imputationDTO4.setNumDeclarationImputation(12640068191953L);
        imputationDTO4.setOperation("PA");
        imputationDTO4.setNatrureDesDroits("CAC IRPP RELIQUAT CENT FC");
        imputationDTO4.setMontant(3.398);
        justificatifPaiementDTO.setImputations(imputationDTOSet);

//System.out.println(localDate);
        document.open();


        // properties
        PdfContentByte over;
        Rectangle pagesize;
        float x, y;

        pagesize = document.getPageSize();
        x = (pagesize.getLeft() + pagesize.getRight()) / 2;
        y = (pagesize.getTop() + pagesize.getBottom()) / 2;
        over = writer.getDirectContent();
        over.saveState();

        PdfGState state = new PdfGState();
        state.setFillOpacity(0.3f);
        over.setGState(state);
        over.addImage(img, w, 12, 0, h, x - (w / 2), y - (w / 2));

        over.restoreState();

        document.add(entete.entete(justificatifPaiementDTO));
        document.add(titrePdf.titredocument());
        document.add(descriptifDocument.decriptif(justificatifPaiementDTO));
        document.add(tableFacture.decriptiffacture(justificatifPaiementDTO));
        document.add(qrcode.qrcode());
        document.add(piedsPage.pieddepage());

        document.close();
    }
}
