package lech.bartlomiej.contacts.ui;


import com.itextpdf.text.DocumentException;
import lech.bartlomiej.contacts.api.PersonFinder;
import lech.bartlomiej.contacts.api.handlers.GeneratePdfReportHandler;
import lech.bartlomiej.contacts.domain.commands.GenerateReportCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/reports")
public class PersonPdfReportsController {

    private PersonFinder personFinder;
    private GeneratePdfReportHandler generatePdfReportHandler;

    public PersonPdfReportsController(PersonFinder personFinder, GeneratePdfReportHandler generatePdfReportHandler) {
        this.personFinder = personFinder;
        this.generatePdfReportHandler = generatePdfReportHandler;
    }


    @GetMapping("/test")
    public void getTestPdfReport(@PathVariable Long id, HttpServletResponse response) throws IOException, DocumentException {
        GenerateReportCommand command = new GenerateReportCommand();
        command.setPersonId(id);
        byte[] pdfData = generatePdfReportHandler.handle(command);
        response.setContentType("application.pdf");
        response.addHeader("Report", "person id - " + id);
        response.setContentLength(pdfData.length);
        response.getOutputStream().write(pdfData);
        response.getOutputStream().flush();
    }



}
