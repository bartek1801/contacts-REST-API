package lech.bartlomiej.contacts.infrastructure;

import lech.bartlomiej.contacts.api.BasicPersonDto;
import lech.bartlomiej.contacts.api.PersonFinder;
import lech.bartlomiej.contacts.domain.Person;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class JPAPersonFinder  {

//    private EntityManager entityManager;
//
//    public JPAPersonFinder(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public Person getById(Long id) {
//        return entityManager.find(Person.class, id);
//    }
}
