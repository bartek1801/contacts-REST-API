package lech.bartlomiej.contacts.domain.repositories;

import lech.bartlomiej.contacts.domain.Person;

import java.util.Optional;

public interface PersonRepository {

    void save(Person person);

    Person getById(Long id);

    Person findByPesel(Long pesel);
}
