package lech.bartlomiej.contacts.api.dtos;

import lech.bartlomiej.contacts.domain.Address;

public class AddressDto {

    private String street;
    private String postalCode;
    private String city;

    public AddressDto(Address address) {
        this.street = address.getStreet();
        this.postalCode = address.getPostalCode();
        this.city = address.getCity();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
