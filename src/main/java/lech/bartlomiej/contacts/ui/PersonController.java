package lech.bartlomiej.contacts.ui;


import lech.bartlomiej.contacts.api.*;
import lech.bartlomiej.contacts.api.dtos.BasicPersonDto;
import lech.bartlomiej.contacts.api.handlers.CreatePersonHandler;
import lech.bartlomiej.contacts.api.handlers.DeletePersonHandler;
import lech.bartlomiej.contacts.api.handlers.UpdatePersonDetailsHandler;
import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.CreatePersonCommand;
import lech.bartlomiej.contacts.domain.commands.DeletePersonCommand;
import lech.bartlomiej.contacts.domain.commands.UpdatePersonDetailsCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
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
    private PersonRepository personRepository;


    public PersonController(CreatePersonHandler createPersonHandler, DeletePersonHandler deletePersonHandler,
                            UpdatePersonDetailsHandler updatePersonDetailsHandler, PersonFinder personFinder, PersonRepository personRepository) {
        this.createPersonHandler = createPersonHandler;
        this.deletePersonHandler = deletePersonHandler;
        this.updatePersonDetailsHandler = updatePersonDetailsHandler;
        this.personFinder = personFinder;
        this.personRepository = personRepository;
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

    @GetMapping("/search")
    public List<BasicPersonDto> findPersonsByNames(String firstName, String lastName){
        List<Person> personList = personFinder.findByFirstNameOrLastName(firstName, lastName);
        return personList.stream().map(BasicPersonDto::new).collect(Collectors.toList());
    }

    @GetMapping("/search/contact")
    public List<BasicPersonDto> findPersonsWithActiveContact(Boolean active){
        List<Person> personList = personFinder.findByContactActive(active);
        return personList.stream().map(BasicPersonDto::new).collect(Collectors.toList());
    }

    @PostMapping("/")
    public List<BasicPersonDto> findPerson(@RequestBody PersonSearchCriteria personSearchCriteria){
        return personRepository.search(personSearchCriteria).stream().map(BasicPersonDto::new).collect(Collectors.toList());
    }

}
