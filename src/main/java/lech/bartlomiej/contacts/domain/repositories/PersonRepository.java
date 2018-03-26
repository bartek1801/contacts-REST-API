package lech.bartlomiej.contacts.domain.repositories;

import lech.bartlomiej.contacts.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom {

    //void save(Person person);

    Person getById(Long id);

    List<Person> findByPesel(Long pesel);

    List<Person> findByFirstName(String firstName);

    List<Person> findByFirstNameOrLastName(String firstName, String lastName);
}
