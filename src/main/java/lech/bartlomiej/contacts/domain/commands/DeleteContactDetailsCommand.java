package lech.bartlomiej.contacts.domain.commands;

import lech.bartlomiej.contacts.domain.Address;

import java.util.Set;
import java.util.UUID;

import static lech.bartlomiej.contacts.domain.commands.AddContactCommand.EMAIL_REGEX;

public class DeleteContactDetailsCommand implements ValidCommand {

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

    @Override
    public void validate(ValidationErrors errors) {
        if (emailAddresses != null)
            validateEmailAddressesSet(errors, emailAddresses);
    }

    private void validateEmailAddressesSet(ValidationErrors errors, Set<String> emailAddresses) {
        for (String email : emailAddresses){
            if (!email.matches(EMAIL_REGEX))
                errors.add("emailAddresses.email", " wrong email format");

        }
    }



}
