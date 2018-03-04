package lech.bartlomiej.contacts.domain.repositories;

import lech.bartlomiej.contacts.domain.Person;

public interface PersonRepository {

    void save(Person person);

    Person getById(Long id);

}
