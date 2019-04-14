package lech.bartlomiej.contacts.domain.repositories;

import lech.bartlomiej.contacts.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID>, PersonRepositoryCustom {

    //void save(Person person);

    Person getById(UUID id);

    Optional<Person> findByPesel(Long pesel);

    List<Person> findByFirstName(String firstName);

    List<Person> findByFirstNameOrLastName(String firstName, String lastName);
}
