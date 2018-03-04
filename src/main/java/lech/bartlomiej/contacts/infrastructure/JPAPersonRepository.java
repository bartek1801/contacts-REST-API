package lech.bartlomiej.contacts.infrastructure;

import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class JPAPersonRepository implements PersonRepository {

    private EntityManager entityManager;

    public JPAPersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Override
    public Person getById(Long id) {
        return entityManager.find(Person.class, id);
    }
}
