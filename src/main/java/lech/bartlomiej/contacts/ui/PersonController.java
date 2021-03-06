package lech.bartlomiej.contacts.ui;


import lech.bartlomiej.contacts.api.PersonFinder;
import lech.bartlomiej.contacts.api.PersonSearchCriteria;
import lech.bartlomiej.contacts.api.dtos.BasicPersonDto;
import lech.bartlomiej.contacts.api.handlers.CreatePersonHandler;
import lech.bartlomiej.contacts.api.handlers.DeletePersonHandler;
import lech.bartlomiej.contacts.api.handlers.UpdatePersonDetailsHandler;
import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.commands.CreatePersonCommand;
import lech.bartlomiej.contacts.domain.commands.DeletePersonCommand;
import lech.bartlomiej.contacts.domain.commands.UpdatePersonDetailsCommand;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
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
    public UUID savePerson(@RequestBody CreatePersonCommand command) {
        return createPersonHandler.handle(command);
    }

    @GetMapping("/{id}")
    public BasicPersonDto getPerson(@PathVariable UUID id) {
        return new BasicPersonDto(personFinder.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable UUID id) {
        DeletePersonCommand command = new DeletePersonCommand();
        command.setId(id);
        deletePersonHandler.handle(command);
    }

    @PutMapping("/{id}")
    public void updatePersonDetails(@RequestBody UpdatePersonDetailsCommand command, @PathVariable UUID id) {
        updatePersonDetailsHandler.handle(command);
    }

    @GetMapping("/search")
    public List<BasicPersonDto> findPersonsByNames(String firstName, String lastName) {
        List<Person> personList = personFinder.findByFirstNameOrLastName(firstName, lastName);
        return personList.stream().map(BasicPersonDto::new).collect(Collectors.toList());
    }

    @GetMapping("/search/contact")
    public List<BasicPersonDto> findPersonsWithActiveContact(Boolean active) {
        List<Person> personList = personFinder.findByContactActive(active);
        return personList.stream().map(BasicPersonDto::new).collect(Collectors.toList());
    }

    @PostMapping("/")
    public List<BasicPersonDto> findPerson(@RequestBody PersonSearchCriteria personSearchCriteria) {
        return personRepository.search(personSearchCriteria).stream().map(BasicPersonDto::new).collect(Collectors.toList());
    }

    @GetMapping("search/all/{pageNo}")
    public Page<BasicPersonDto> findAllPersons(@PathVariable Integer pageNo) {
        return personRepository.findAll(new PageRequest(pageNo, 2, new Sort("lastName"))).map(BasicPersonDto::new);
    }


}
