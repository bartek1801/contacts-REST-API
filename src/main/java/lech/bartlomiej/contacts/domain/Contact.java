package lech.bartlomiej.contacts.domain;

import lech.bartlomiej.contacts.domain.commands.AddContactCommand;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection
    private Set<String> phoneNumbers;

    @ElementCollection
    private Set<String> emailAddresses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contactId")
    private Set<Address> addresses;

    @OneToOne(mappedBy = "contact")
    private Person person;

    public Contact() {
    }

    public Contact(Set<String> phoneNumbers, Set<String> emailAddresses, Set<Address> addresses) {
        this.phoneNumbers = phoneNumbers;
        this.emailAddresses = emailAddresses;
        this.addresses = addresses;
    }

    public Contact(AddContactCommand command) {
        this.phoneNumbers = command.getPhoneNumbers();
        this.emailAddresses = command.getEmailAddresses();
        this.addresses = command.getAddresses();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Set<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(Set<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
