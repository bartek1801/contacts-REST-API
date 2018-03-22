package lech.bartlomiej.contacts.domain.repositories;

import lech.bartlomiej.contacts.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long>{

    //void save(Person person);

    Person getById(Long id);

    List<Person> findByPesel(Long pesel);

    List<Person> findByFirstName(String firstName);
}
