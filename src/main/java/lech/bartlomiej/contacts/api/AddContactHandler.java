package lech.bartlomiej.contacts.api;

import lech.bartlomiej.contacts.domain.Contact;
import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.AddContactCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AddContactHandler {

    private PersonRepository personRepository;


    public AddContactHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void handle(AddContactCommand command){
        Person person = personRepository.getById(command.getPersonId());
        person.setContact(new Contact(command));
        personRepository.save(person);
    }
}
