package lech.bartlomiej.contacts.api.handlers;

import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.UpdateContactForPersonCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class UpdateContactForPersonHandler {

    private PersonRepository personRepository;

    public UpdateContactForPersonHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Transactional
    public void handle(UpdateContactForPersonCommand command){
        Person person = personRepository.getById(command.getPersonId());
        person.addDetailsToContact(command);
    }

}
