package lech.bartlomiej.contacts.domain.commands;

import lech.bartlomiej.contacts.domain.Gender;

import java.time.LocalDate;

public class UpdatePersonDetailsCommand implements ValidCommand {

    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private Long pesel;

    public UpdatePersonDetailsCommand() {
    }

    public UpdatePersonDetailsCommand(String firstName, String lastName, Gender gender, LocalDate birthDate, Long pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.pesel = pesel;
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

    @Override
    public void validate(ValidationErrors errors) {
        if (pesel != null && pesel.toString().length() != 11)
            errors.add("pesel", "pesel should consist of 11 digits");
    }
}
