package lech.bartlomiej.contacts.infrastructure;

import lech.bartlomiej.contacts.api.PersonSearchCriteria;
import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.repositories.PersonRepositoryCustom;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Component
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    private EntityManager entityManager;

    public PersonRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> search(PersonSearchCriteria personSearchCriteria) {
        return Collections.emptyList();
    }
}
