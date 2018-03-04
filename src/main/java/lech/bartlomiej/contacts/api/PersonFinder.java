package lech.bartlomiej.contacts.api;

import lech.bartlomiej.contacts.domain.Person;

public interface PersonFinder {

    Person getById(Long id);

}
