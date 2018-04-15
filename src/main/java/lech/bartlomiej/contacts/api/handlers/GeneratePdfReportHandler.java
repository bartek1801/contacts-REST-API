package lech.bartlomiej.contacts.api.handlers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lech.bartlomiej.contacts.api.dtos.BasicPersonDto;
import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.GenerateReportCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;

@Component
public class GeneratePdfReportHandler {

    private PersonRepository personRepository;

    public GeneratePdfReportHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public byte[] handle(GenerateReportCommand command) throws DocumentException {
        Person person = personRepository.getById(command.getPersonId());
        BasicPersonDto personDto = new BasicPersonDto(person);
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, baos);
        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);

        Chunk chunk = new Chunk("chapter", font);
        Chapter chapter = new Chapter(new Paragraph(chunk), 1);
        document.add(chapter);

        document.add(new Paragraph("Pdf Report", font));
        document.add(new Paragraph("Auto created document", font));

        document.add(new Paragraph("Auto ordered list "));
        List list = new List(List.ORDERED);
        list.setFirst(0);
        for (int i = 0; i < 5; i++){
            list.add(personDto.getLastName());
        }
        document.add(list);

        PdfPTable table = new PdfPTable(8);
        for (int aw = 0; aw < 16 ; aw++){
            table.addCell(personDto.getFirstName());
        }

        document.add(table);
        document.close();

        //TODO Zrobic porzadny raport w tabeli, pobawic sie w tworzenie tabeli itp

        return baos.toByteArray();
    }
}
