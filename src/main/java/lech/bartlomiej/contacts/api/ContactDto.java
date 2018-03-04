package lech.bartlomiej.contacts.api;

import lech.bartlomiej.contacts.domain.Contact;

import java.util.Set;
import java.util.stream.Collectors;

public class ContactDto {

    private Long personId;
    private Set<String> phoneNumbers;
    private Set<String> emailAddresses;
    private Set<AddressDto> addresses;

    public ContactDto(Contact contact) {
        this.personId = contact.getPerson().getId();
        this.phoneNumbers = contact.getPhoneNumbers();
        this.emailAddresses = contact.getEmailAddresses();
        this.addresses = contact.getAddresses().stream().map(AddressDto::new).collect(Collectors.toSet());
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
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

    public Set<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressDto> addresses) {
        this.addresses = addresses;
    }
}
