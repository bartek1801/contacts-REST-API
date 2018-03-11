package lech.bartlomiej.contacts.domain.commands;

import lech.bartlomiej.contacts.domain.Address;

import java.util.Set;

public class AddContactCommand implements ValidCommand {

    public static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    private Long personId;
    private Set<String> phoneNumbers;
    private Set<String> emailAddresses;
    private Set<Address> addresses;

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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public void validate(ValidationErrors errors) {
        if (phoneNumbers == null || phoneNumbers.isEmpty())
            errors.add("phoneNumbers", "can't be blank");
        if (emailAddresses == null || emailAddresses.isEmpty())
            errors.add("emailAddresses", "can't be blank");
        if (addresses == null || addresses.isEmpty())
            errors.add("addresses", "can't be blank");
        if (phoneNumbers != null)
            validatePhoneNumbersSet(errors, phoneNumbers);
        if (emailAddresses != null)
            validateEmailAddressesSet(errors, emailAddresses);
        if (addresses != null)
            validateAddressesSetFields(errors, addresses);
    }

    private void validateEmailAddressesSet(ValidationErrors errors, Set<String> emailAddresses) {
        for (String email : emailAddresses){
            if (isEmpty(email) || !email.matches(EMAIL_REGEX))
                errors.add("emailAddresses.email", "email is blank or wrong email format");

        }
    }


    private void validatePhoneNumbersSet(ValidationErrors errors, Set<String> phoneNumbers) {
        for (String phone : phoneNumbers){
            if (isEmpty(phone))
                errors.add("phoneNumbers.phoneNummber", "can't be blank");
        }
    }

    private void validateAddressesSetFields(ValidationErrors errors, Set<Address> addresses) {
        for (Address address : addresses) {
            if (isEmpty(address.getCity()))
                errors.add("address.city", "can't be blank");
            if (isEmpty(address.getPostalCode()))
                errors.add("address.postalCode", "can't be blank");
            if (isEmpty(address.getStreet()))
                errors.add("address.street", "can't be blank");
        }

    }


}
