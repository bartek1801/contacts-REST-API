package lech.bartlomiej.contacts.api.handlers

import lech.bartlomiej.contacts.InMemoryPersonRepository
import lech.bartlomiej.contacts.domain.Gender
import lech.bartlomiej.contacts.domain.Person
import lech.bartlomiej.contacts.domain.commands.CreatePersonCommand
import lech.bartlomiej.contacts.domain.commands.UpdatePersonDetailsCommand
import lech.bartlomiej.contacts.domain.repositories.PersonRepository
import spock.lang.Specification

import java.time.LocalDate

class UpdatePersonHandlerSpec extends Specification {

    private PersonRepository personRepository = new InMemoryPersonRepository()

    private CreatePersonHandler createPersonHandler
    private UpdatePersonDetailsHandler updatePersonHandler

    void setup() {
        createPersonHandler = new CreatePersonHandler(personRepository)
        updatePersonHandler = new UpdatePersonDetailsHandler(personRepository)
    }

    def "should update person details"() {
        given:
            def createPersonCmd = new CreatePersonCommand(
                            "Jan",
                            "Nowak",
                            "M",
                            LocalDate.of(2000, 01, 01),
                            90010122222L
                    )

            def uuid = createPersonHandler.handle(createPersonCmd)

        and:
            def command = new UpdatePersonDetailsCommand("Janek", "Nowak", Gender.M,
                    LocalDate.of(2000, 01, 01), 90010122222L)
        when:
            updatePersonHandler.handle(command)
        then:
            personRepository.getById(uuid).getPesel() == 90010122222L
            personRepository.findByFirstName("Janek").size() == 1
            personRepository.findByFirstName("Jan").size() == 0

    }

}
