package lech.bartlomiej.contacts.api;

import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.UpdatePersonDetailsCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class UpdatePersonDetailsHandler {

    private PersonRepository personRepository;


    public UpdatePersonDetailsHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void handle(UpdatePersonDetailsCommand command){
        Optional<Person> person = personRepository.findByPesel(command.getPesel()).stream().findFirst();
        if (person.isPresent()){
            person.get().updateDetails(command);
            personRepository.save(person.get());
        }
    }

}
