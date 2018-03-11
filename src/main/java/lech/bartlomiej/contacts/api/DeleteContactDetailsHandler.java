package lech.bartlomiej.contacts.api;

import lech.bartlomiej.contacts.domain.Contact;
import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.DeleteContactDetailsCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DeleteContactDetailsHandler {

    private PersonRepository personRepository;

    public DeleteContactDetailsHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Transactional
    public void handle(DeleteContactDetailsCommand command) {
        Person person = personRepository.getById(command.getPersonId());
        Contact contact = person.getContact();
        contact.deleteDetailsIfExixt(command);
        personRepository.save(person);
    }
}
