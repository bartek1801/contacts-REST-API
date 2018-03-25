package lech.bartlomiej.contacts.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lech.bartlomiej.contacts.domain.Gender;
import lech.bartlomiej.contacts.domain.Person;

import java.time.LocalDate;

public class BasicPersonDto {

    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private Long pesel;
    private boolean active;

    public BasicPersonDto(Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.gender = person.getGender();
        this.birthDate = person.getBirthDate();
        this.pesel = person.getPesel();
        this.active = person.isActive();
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
}
