package lech.bartlomiej.contacts.ui;


import lech.bartlomiej.contacts.api.*;
import lech.bartlomiej.contacts.domain.commands.CreatePersonCommand;
import lech.bartlomiej.contacts.domain.commands.DeletePersonCommand;
import lech.bartlomiej.contacts.domain.commands.UpdatePersonCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private CreatePersonHandler createPersonHandler;
    private DeletePersonHandler deletePersonHandler;
    private UpdatePersonHandler updatePersonHandler;
    private PersonFinder personFinder;


    public PersonController(CreatePersonHandler createPersonHandler, DeletePersonHandler deletePersonHandler,
                            UpdatePersonHandler updatePersonHandler, PersonFinder personFinder) {
        this.createPersonHandler = createPersonHandler;
        this.deletePersonHandler = deletePersonHandler;
        this.updatePersonHandler = updatePersonHandler;
        this.personFinder = personFinder;
    }


    @PutMapping
    public void savePerson(@RequestBody CreatePersonCommand command){
        createPersonHandler.handle(command);
    }

    @GetMapping("/{id}")
    public BasicPersonDto getPerson(@PathVariable Long id){
        return new BasicPersonDto(personFinder.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        DeletePersonCommand command = new DeletePersonCommand();
        command.setId(id);
        deletePersonHandler.handle(command);
    }

    @PutMapping("/{id}")
    public void updatePerson(@RequestBody UpdatePersonCommand command, @PathVariable Long id){
        updatePersonHandler.handle(command);
    }

}
