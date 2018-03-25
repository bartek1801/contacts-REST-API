package lech.bartlomiej.contacts.api.handlers;

import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.DeletePersonCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DeletePersonHandler {

    private PersonRepository personRepository;


    public DeletePersonHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void handle(DeletePersonCommand command){
        Person person = personRepository.getById(command.getId());
        person.delete();
        personRepository.save(person);
    }
}
