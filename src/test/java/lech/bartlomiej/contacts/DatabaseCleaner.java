package lech.bartlomiej.contacts;


import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class DatabaseCleaner {

    @PersistenceContext
    private EntityManager entityManager;

    public void cleanDatabase(){
        entityManager.createNativeQuery("TRUNCATE TABLE persons");
        entityManager.createNativeQuery("TRUNCATE TABLE addresses");
//        entityManager.createNativeQuery("TRUNCATE TABLE contact_phone_numbers");
//        entityManager.createNativeQuery("TRUNCATE TABLE contact_email_addresses");
        entityManager.createNativeQuery("TRUNCATE TABLE contacts");

    }

}
