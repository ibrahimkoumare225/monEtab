package ci.digitalacademy.monetab.monetab.models;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import ci.digitalacademy.monetab.monetab.services.dto.StudentDTO;

public class StudentDataPdfExport extends AbstractPdfView{


    protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request)
    {
        Font headerFont = new Font(Font.TIMES_ROMAN, 20, Font.BOLD, Color.magenta);
        HeaderFooter header = new HeaderFooter(new Phrase("LISTE DES ELEVES FORMAT PDF ", headerFont), false);
        header.setAlignment(Element.ALIGN_CENTER);
        document.setHeader(header);

        Font dateFont = new Font(Font.HELVETICA, 12, Font.NORMAL, Color.BLUE);

        HeaderFooter footer = new HeaderFooter(new Phrase("PDF Export Executed On : "+new Date(), dateFont), true);
        footer.setAlignment(Element.ALIGN_CENTER);
        document.setFooter(footer);
    }


    /**
     * Subclasses must implement this method to build an iText PDF document,
     * given the model. Called between {@code Document.open()} and
     * {@code Document.close()} calls.
     * <p>Note that the passed-in HTTP response is just supposed to be used
     * for setting cookies or other HTTP headers. The built PDF document itself
     * will automatically get written to the response after this method returns.
     *
     * @param model    the model Map
     * @param document the iText Document to add elements to
     * @param writer   the PdfWriter to use
     * @param request  in case we need locale etc. Shouldn't look at attributes.
     * @param response in case we need to set cookies. Shouldn't write to it.
     * @throws Exception any exception that occurred during document building
     * @see Document#open()
     * @see Document#close()
     */
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws Exception {
        //download PDF with a given filename
        response.addHeader("Content-Disposition", "attachment;filename=Students.pdf");

        //read data from controller
        List<StudentDTO> list = (List<StudentDTO>) model.get("list");

        //create element
        Font titleFont = new Font(Font.TIMES_ROMAN, 24, Font.BOLD, Color.blue);
        Paragraph title = new Paragraph("LISTES DES ELEVES", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingBefore(20.0f);
        title.setSpacingAfter(25.0f);
        //add to document
        document.add(title);

        Font tableHead = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.blue);
        PdfPTable table = new PdfPTable(7);// no.of columns
        table.addCell(new Phrase("NOM",tableHead));
        table.addCell(new Phrase("PRENOM",tableHead));
        table.addCell(new Phrase("GENRE",tableHead));
        table.addCell(new Phrase("ADRESSE",tableHead));
        table.addCell(new Phrase("MATRICULE",tableHead));
        table.addCell(new Phrase("BIRTHDAY",tableHead));
        table.addCell(new Phrase("TELEPHONE",tableHead));

        for(StudentDTO student : list ) {
            table.addCell(student.getNom());
            table.addCell(student.getPrenom());
            table.addCell(student.getGenre().toString());
            table.addCell(student.getAddress().getCity());
            table.addCell(student.getMatricule());
            table.addCell(student.getBirthday());
            table.addCell(student.getTelephone());



        }
        //add table data to document
        document.add(table);
    }
}
