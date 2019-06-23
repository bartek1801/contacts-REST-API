package lech.bartlomiej.contacts.api.handlers;

import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.CreatePersonCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.UUID;

@Component
public class CreatePersonHandler {

    private PersonRepository personRepository;

    public CreatePersonHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Transactional
    public UUID handle(CreatePersonCommand cmd) {
        return personRepository
                .findByPesel(cmd.getPesel())
                .orElseGet(() -> personRepository.save(createNewPerson(cmd)))
                .toDto()
                .getId();
    }

    private Person createNewPerson(CreatePersonCommand cmd) {
        return new Person(cmd.getFirstName(), cmd.getLastName(), cmd.getGender(), cmd.getBirthDate(), cmd.getPesel());
    }

}
