package lech.bartlomiej.contacts.ui;

import lech.bartlomiej.contacts.api.*;
import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.AddContactCommand;
import lech.bartlomiej.contacts.domain.commands.DeleteContactForPersonCommand;
import lech.bartlomiej.contacts.domain.commands.UpdateContactForPersonCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private AddContactHandler addContactHandler;
    private UpdateContactForPersonHandler updateContactForPersonHandler;
    private DeleteContactForPersonHandler deleteContactForPersonHandler;
    private PersonFinder personFinder;

    public ContactController(AddContactHandler addContactHandler, UpdateContactForPersonHandler updateContactForPersonHandler, DeleteContactForPersonHandler deleteContactForPersonHandler, PersonFinder personFinder) {
        this.addContactHandler = addContactHandler;
        this.updateContactForPersonHandler = updateContactForPersonHandler;
        this.deleteContactForPersonHandler = deleteContactForPersonHandler;
        this.personFinder = personFinder;
    }

    @PutMapping("/{personId}")
    public void addContactToPerson(@PathVariable Long personId, @RequestBody AddContactCommand command){
        command.setPersonId(personId);
        addContactHandler.handle(command);
    }

    @GetMapping("/{personId}")
    public ContactDto getContactsForPerson(@PathVariable Long personId){
        Person person = personFinder.getById(personId);
        return new ContactDto(person.getContact());
    }


    @PutMapping("/update/{personId}")
    public void updateContactForPerson(@RequestBody UpdateContactForPersonCommand command, @PathVariable Long personId){
        command.setPersonId(personId);
        updateContactForPersonHandler.handle(command);
    }

    @DeleteMapping("/delete/{personId}")
    public void deleteContactForPerson(@PathVariable Long personId){
        DeleteContactForPersonCommand command = new DeleteContactForPersonCommand();
        command.setPersonId(personId);
        deleteContactForPersonHandler.handle(command);
    }

}
