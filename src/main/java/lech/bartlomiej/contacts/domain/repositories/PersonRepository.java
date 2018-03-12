package lech.bartlomiej.contacts.domain.repositories;

import lech.bartlomiej.contacts.domain.Person;

import java.util.List;

public interface PersonRepository {

    void save(Person person);

    Person getById(Long id);

    List<Person> findByPesel(Long pesel);
}
