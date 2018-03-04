package lech.bartlomiej.contacts.ui;

import lech.bartlomiej.contacts.api.AddContactHandler;
import lech.bartlomiej.contacts.api.ContactDto;
import lech.bartlomiej.contacts.api.PersonFinder;
import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.AddContactCommand;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    private AddContactHandler addContactHandler;
    private PersonFinder personFinder;

    public ContactController(AddContactHandler addContactHandler, PersonFinder personFinder ) {
        this.addContactHandler = addContactHandler;
        this.personFinder = personFinder;
    }

    @PutMapping("/contact/{personId}")
    public void addContactToPerson(@PathVariable Long personId, @RequestBody AddContactCommand command){
        command.setPersonId(personId);
        addContactHandler.handle(command);
    }

    @GetMapping("/contact/{personId}")
    public ContactDto getContactsForPerson(@PathVariable Long personId){
        Person person = personFinder.getById(personId);
        return new ContactDto(person.getContact());
    }
}
