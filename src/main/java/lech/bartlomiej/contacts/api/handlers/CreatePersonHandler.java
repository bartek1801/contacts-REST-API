package lech.bartlomiej.contacts.api.handlers;

import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.CreatePersonCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class CreatePersonHandler {

    private PersonRepository personRepository;

    public CreatePersonHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Transactional
    public void handle(CreatePersonCommand cmd){
        List<Person> persons = personRepository.findByPesel(cmd.getPesel());
        if (persons.isEmpty()) {
            Person person = new Person(cmd.getFirstName(), cmd.getLastName(), cmd.getGender(), cmd.getBirthDate(), cmd.getPesel());
            personRepository.save(person);
        }
    }

}
