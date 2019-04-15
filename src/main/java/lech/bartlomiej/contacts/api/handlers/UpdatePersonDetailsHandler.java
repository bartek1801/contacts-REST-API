package lech.bartlomiej.contacts.api.handlers;

import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.UpdatePersonDetailsCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Component
public class UpdatePersonDetailsHandler {

    private PersonRepository personRepository;


    public UpdatePersonDetailsHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void handle(UpdatePersonDetailsCommand command){
        Person person = personRepository.findByPesel(command.getPesel());
        if (person != null){
            person.updateDetails(command);
            personRepository.save(person);
        }
    }

}
