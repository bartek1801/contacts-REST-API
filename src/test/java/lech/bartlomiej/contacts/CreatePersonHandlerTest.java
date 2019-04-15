package lech.bartlomiej.contacts;

import lech.bartlomiej.contacts.api.dtos.BasicPersonDto;
import lech.bartlomiej.contacts.api.handlers.CreatePersonHandler;
import lech.bartlomiej.contacts.domain.commands.CreatePersonCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;


public class CreatePersonHandlerTest {


    private PersonRepository personRepository = new InMemoryPersonRepository();

    private CreatePersonHandler createPersonHandler = new CreatePersonHandler(personRepository);

    @Test
    void shouldCreateAndSavePerson() {

        //given
        CreatePersonCommand cmd = new CreatePersonCommand("Jan", "Nowak", "M", LocalDate.of(1990, 2, 11), 12345678901L);
        //when
        UUID id = createPersonHandler.handle(cmd);
        //then
        Assertions.assertNotNull(id);
        Assertions.assertNotNull(personRepository.getById(id));

    }
}
