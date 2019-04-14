package lech.bartlomiej.contacts.ui;

import lech.bartlomiej.contacts.api.*;
import lech.bartlomiej.contacts.api.dtos.ContactDto;
import lech.bartlomiej.contacts.api.handlers.AddContactHandler;
import lech.bartlomiej.contacts.api.handlers.DeleteContactDetailsHandler;
import lech.bartlomiej.contacts.api.handlers.DeleteContactForPersonHandler;
import lech.bartlomiej.contacts.api.handlers.UpdateContactForPersonHandler;
import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.AddContactCommand;
import lech.bartlomiej.contacts.domain.commands.DeleteContactDetailsCommand;
import lech.bartlomiej.contacts.domain.commands.DeleteContactForPersonCommand;
import lech.bartlomiej.contacts.domain.commands.UpdateContactForPersonCommand;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private AddContactHandler addContactHandler;
    private UpdateContactForPersonHandler updateContactForPersonHandler;
    private DeleteContactForPersonHandler deleteContactForPersonHandler;
    private DeleteContactDetailsHandler deleteContactDetailsHandler;
    private PersonFinder personFinder;

    public ContactController(AddContactHandler addContactHandler, UpdateContactForPersonHandler updateContactForPersonHandler, DeleteContactForPersonHandler deleteContactForPersonHandler, DeleteContactDetailsHandler deleteContactDetailsHandler, PersonFinder personFinder) {
        this.addContactHandler = addContactHandler;
        this.updateContactForPersonHandler = updateContactForPersonHandler;
        this.deleteContactForPersonHandler = deleteContactForPersonHandler;
        this.deleteContactDetailsHandler = deleteContactDetailsHandler;
        this.personFinder = personFinder;
    }

    @PostMapping("/{personId}")
    public void addContactToPerson(@PathVariable UUID personId, @RequestBody AddContactCommand command){
        command.setPersonId(personId);
        addContactHandler.handle(command);
    }

    @GetMapping("/{personId}")
    public ContactDto getContactsForPerson(@PathVariable UUID personId){
        Person person = personFinder.getById(personId);
        return new ContactDto(person.getContact());
    }


    @PutMapping("/update/{personId}")
    public void updateContactForPerson(@RequestBody UpdateContactForPersonCommand command, @PathVariable UUID personId){
        command.setPersonId(personId);
        updateContactForPersonHandler.handle(command);
    }

    @DeleteMapping("/delete/{personId}")
    public void deleteContactForPerson(@PathVariable UUID personId){
        DeleteContactForPersonCommand command = new DeleteContactForPersonCommand();
        command.setPersonId(personId);
        deleteContactForPersonHandler.handle(command);
    }

    @PutMapping("delete/{personId}/details")
    public void deleteContactDetails(@RequestBody DeleteContactDetailsCommand command, @PathVariable UUID personId){
        command.setPersonId(personId);
        deleteContactDetailsHandler.handle(command);
    }

}
