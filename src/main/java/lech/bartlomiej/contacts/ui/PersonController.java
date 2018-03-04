package lech.bartlomiej.contacts.ui;


import lech.bartlomiej.contacts.api.BasicPersonDto;
import lech.bartlomiej.contacts.api.CreatePersonHandler;
import lech.bartlomiej.contacts.api.DeletePersonHandler;
import lech.bartlomiej.contacts.api.PersonFinder;
import lech.bartlomiej.contacts.domain.commands.CreatePersonCommand;
import lech.bartlomiej.contacts.domain.commands.DeletePersonCommand;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private CreatePersonHandler createPersonHandler;
    private DeletePersonHandler deletePersonHandler;
    private PersonFinder personFinder;


    public PersonController(CreatePersonHandler createPersonHandler, DeletePersonHandler deletePersonHandler, PersonFinder personFinder) {
        this.createPersonHandler = createPersonHandler;
        this.deletePersonHandler = deletePersonHandler;
        this.personFinder = personFinder;
    }


    @PutMapping("/person")
    public void savePerson(@RequestBody CreatePersonCommand command){
        createPersonHandler.handle(command);
    }

    @GetMapping("/person/{id}")
    public BasicPersonDto getPerson(@PathVariable Long id){
        return new BasicPersonDto(personFinder.getById(id));
    }

    @DeleteMapping("person/{id}")
    public void deletePerson(@PathVariable Long id){
        DeletePersonCommand command = new DeletePersonCommand();
        command.setId(id);
        deletePersonHandler.handle(command);
    }

}
