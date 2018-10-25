package lech.bartlomiej.contacts.api.handlers;

import lech.bartlomiej.contacts.domain.commands.UpdatePersonDetailsCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class UpdatePersonDetailsHandler {

    private PersonRepository personRepository;


    public UpdatePersonDetailsHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void handle(UpdatePersonDetailsCommand command) {

        personRepository.findByPesel(command.getPesel())
                .ifPresent(
                        person -> {
                            person.updateDetails(command);
                            personRepository.save(person);
                        });
    }

}
