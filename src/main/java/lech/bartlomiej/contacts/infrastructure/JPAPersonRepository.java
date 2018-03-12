package lech.bartlomiej.contacts.infrastructure;

import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

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

    @Override
    public List<Person> findByPesel(Long pesel) {
        Query query = entityManager.createQuery("SELECT p FROM Person p WHere p.pesel = :pesel");
        query.setParameter("pesel", pesel);
        return  (List<Person>) query.getResultList();
    }
}
