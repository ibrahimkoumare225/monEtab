package ci.digitalacademy.monetab.monetab.models;

import java.util.List;
import java.util.Map;

import ci.digitalacademy.monetab.monetab.services.dto.StudentDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;
public class StudentDataExcelExport extends AbstractXlsxView{


    /**
     * Application-provided subclasses must implement this method to populate
     * the Excel workbook document, given the model.
     *
     * @param model    the model Map
     * @param workbook the Excel workbook to populate
     * @param request  in case we need locale etc. Shouldn't look at attributes.
     * @param response in case we need to set cookies. Shouldn't write to it.
     */
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws Exception {
        response.addHeader("Content-Disposition", "attachment;fileName=StudentsData.xlsx");

        // read data provided by controller
        @SuppressWarnings("unchecked")
        List<StudentDTO> list = (List<StudentDTO>) model.get("list");

        // create one sheet
        Sheet sheet = workbook.createSheet("STUDENTS");

        // create row0 as a header
        Row row0 = sheet.createRow(0);
        row0.createCell(0).setCellValue("NOM");
        row0.createCell(1).setCellValue("PRENOM");
        row0.createCell(2).setCellValue("GENRE");
        row0.createCell(3).setCellValue("ADRESSE");
        row0.createCell(4).setCellValue("MATRICULE");
        row0.createCell(5).setCellValue("BIRTHDAY");
        row0.createCell(6).setCellValue("TELEPHONE");


        // create row1 onwards from List<T>
        int rowNum = 1;
        for(StudentDTO spec : list) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(spec.getNom());
            row.createCell(1).setCellValue(spec.getPrenom());
            row.createCell(2).setCellValue(spec.getGenre().toString());
            row.createCell(3).setCellValue(spec.getAddress().getCity());
            row.createCell(4).setCellValue(spec.getMatricule());
            row.createCell(5).setCellValue(spec.getBirthday());
            row.createCell(6).setCellValue(spec.getTelephone());



        }
    }
}
