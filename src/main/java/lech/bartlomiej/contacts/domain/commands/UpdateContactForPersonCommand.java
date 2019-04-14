package lech.bartlomiej.contacts.domain.commands;

import lech.bartlomiej.contacts.domain.Address;

import java.util.Set;
import java.util.UUID;

public class UpdateContactForPersonCommand {

    private UUID personId;
    private Set<String> phoneNumbers;
    private Set<String> emailAddresses;
    private Set<Address> addresses;

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
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
}
