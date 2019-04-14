package lech.bartlomiej.contacts.domain.commands;

import java.time.LocalDate;

public class CreatePersonCommand implements ValidCommand {


    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;
    private Long pesel;

    public CreatePersonCommand(String firstName, String lastName, String gender, LocalDate birthDate, Long pesel) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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
        if (isEmpty(firstName))
            errors.add("firstName", "can't be blank");
        if (isEmpty(lastName))
            errors.add("lastName", "can't be blank");
        if (gender == null)
            errors.add("gender", "can't be blank");
        if (gender != null && !gender.equals("M") && !gender.equals("F"))
            errors.add("gender", "incorrect value, chose 'F' or 'M'");
        if (birthDate == null)
            errors.add("birthDate", "can't be blank");
        if (pesel == null)
            errors.add("pesel", "can't be blank");
        if (pesel != null && pesel.toString().length() != 11)
            errors.add("pesel", "pesel should consist of 11 digits");
    }
}
