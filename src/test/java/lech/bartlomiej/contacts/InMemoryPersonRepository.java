package lech.bartlomiej.contacts;

import lech.bartlomiej.contacts.api.PersonSearchCriteria;
import lech.bartlomiej.contacts.domain.Person;
import lech.bartlomiej.contacts.domain.repositories.PersonRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;

public class InMemoryPersonRepository implements PersonRepository {

    private static final Map<UUID, Person> REPO = new HashMap<>();

    public Person save(Person person) {
        REPO.put(person.getId(), person);
        return REPO.get(person.getId());
    }


    @Override
    public Person getById(UUID id) {
        return REPO.get(id);
    }

    @Override
    public Optional<Person> findByPesel(Long pesel) {
        return Optional.empty();
    }

    @Override
    public List<Person> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Person> findByFirstNameOrLastName(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<Person> search(PersonSearchCriteria personSearchCriteria) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public List<Person> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Person> findAllById(Iterable<UUID> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public void deleteAll(Iterable<? extends Person> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Person> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Person> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Person> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Person> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Person getOne(UUID uuid) {
        return null;
    }

    @Override
    public <S extends Person> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Person> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Person> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Person> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Person> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Person> boolean exists(Example<S> example) {
        return false;
    }
}