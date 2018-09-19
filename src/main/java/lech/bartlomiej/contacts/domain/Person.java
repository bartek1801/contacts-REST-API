package lech.bartlomiej.contacts.domain;

import lech.bartlomiej.contacts.domain.commands.CreatePersonCommand;
import lech.bartlomiej.contacts.domain.commands.UpdateContactForPersonCommand;
import lech.bartlomiej.contacts.domain.commands.UpdatePersonDetailsCommand;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private LocalDate birthDate;

    private Long pesel;

    private boolean active;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contact contact;

    public Person() {
    }

    public Person(String firstName, String lastName, String gender, LocalDate birthDate, Long pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = Gender.valueOf(gender);
        this.birthDate = birthDate;
        this.pesel = pesel;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void delete() {
        this.setActive(false);
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void updateDetails(UpdatePersonDetailsCommand command) {
        if (!(firstName.equals(command.getFirstName())) && command.getFirstName() != null)
            this.firstName = command.getFirstName();
    }


    public void addDetailsToContact(UpdateContactForPersonCommand command) {
        this.contact.addDetails(command);
    }
}
