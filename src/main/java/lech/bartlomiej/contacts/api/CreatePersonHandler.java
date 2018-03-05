package lech.bartlomiej.contacts.api;

import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.CreatePersonCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class CreatePersonHandler {

    private PersonRepository personRepository;

    public CreatePersonHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Transactional
    public void handle(CreatePersonCommand cmd){
        Person person = new Person(cmd.getFirstName(), cmd.getLastName(), cmd.getGender(), cmd.getBirthDate(), cmd.getPesel());
//        if (!isPeselExist(cmd))
            personRepository.save(person); //TODO a może jeśli jest ten sam pesel to update???
    }

//    private boolean isPeselExist(CreatePersonCommand cmd) {
//        return personRepository.findByPesel(cmd.getPesel()).isPresent();
//    }
}
