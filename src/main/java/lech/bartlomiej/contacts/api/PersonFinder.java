package lech.bartlomiej.contacts.api;

import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.repositories.PersonRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PersonFinder extends JpaRepository<Person, UUID> {

    Person getById(UUID id);

    List<Person> findByFirstName(String firstName);


    List<Person> findByContactActive(Boolean active);

    List<Person> findByFirstNameOrLastName(String firstName, String lastName);
}
