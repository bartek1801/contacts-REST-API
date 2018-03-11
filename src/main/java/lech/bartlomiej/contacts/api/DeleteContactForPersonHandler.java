package lech.bartlomiej.contacts.api;

import lech.bartlomiej.contacts.domain.Contact;
import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.DeleteContactForPersonCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DeleteContactForPersonHandler {

    private PersonRepository personRepository;

    public DeleteContactForPersonHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Transactional
    public void handle(DeleteContactForPersonCommand command) {
        Person person = personRepository.getById(command.getPersonId());
        Contact contact = person.getContact();
        contact.delete();
        personRepository.save(person);
    }
}
