package lech.bartlomiej.contacts.ui;


import lech.bartlomiej.contacts.api.*;
import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.CreatePersonCommand;
import lech.bartlomiej.contacts.domain.commands.DeletePersonCommand;
import lech.bartlomiej.contacts.domain.commands.UpdatePersonDetailsCommand;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {

    private CreatePersonHandler createPersonHandler;
    private DeletePersonHandler deletePersonHandler;
    private UpdatePersonDetailsHandler updatePersonDetailsHandler;
    private PersonFinder personFinder;


    public PersonController(CreatePersonHandler createPersonHandler, DeletePersonHandler deletePersonHandler,
                            UpdatePersonDetailsHandler updatePersonDetailsHandler, PersonFinder personFinder) {
        this.createPersonHandler = createPersonHandler;
        this.deletePersonHandler = deletePersonHandler;
        this.updatePersonDetailsHandler = updatePersonDetailsHandler;
        this.personFinder = personFinder;
    }


    @PostMapping
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
    public void updatePersonDetails(@RequestBody UpdatePersonDetailsCommand command, @PathVariable Long id){
        updatePersonDetailsHandler.handle(command);
    }

    @GetMapping("/persons")
    public List<BasicPersonDto> findPersonsByName(String firstName){
        List<Person> personList = personFinder.findByFirstName(firstName);
        return personList.stream().map(BasicPersonDto::new).collect(Collectors.toList());
    }

}
