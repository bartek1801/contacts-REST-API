package lech.bartlomiej.contacts.api;

import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.UpdatePersonCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class UpdatePersonHandler {

    private PersonRepository personRepository;


    public UpdatePersonHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void handle(UpdatePersonCommand command){
        Optional<Person> person = Optional.of(personRepository.findByPesel(command.getPesel()));
        if (person.isPresent()){
            person.get().updateDetails(command);
            personRepository.save(person.get());
        }
    }

}
