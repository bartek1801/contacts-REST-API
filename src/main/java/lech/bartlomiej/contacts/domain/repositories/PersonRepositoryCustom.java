package lech.bartlomiej.contacts.domain.repositories;

import lech.bartlomiej.contacts.api.PersonSearchCriteria;
import lech.bartlomiej.contacts.domain.Person;

import java.util.List;

public interface PersonRepositoryCustom {

    List<Person> search(PersonSearchCriteria personSearchCriteria);

}
