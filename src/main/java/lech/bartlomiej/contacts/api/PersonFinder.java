package lech.bartlomiej.contacts.api;

import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.repositories.PersonRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonFinder extends JpaRepository<Person, Long> {

    Person getById(Long id);

    List<Person> findByFirstName(String firstName);


    List<Person> findByContactActive(Boolean active);

    List<Person> findByFirstNameOrLastName(String firstName, String lastName);
}
