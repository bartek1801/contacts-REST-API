package lech.bartlomiej.contacts.domain.commands;

public class DeleteContactForPersonCommand implements ValidCommand {

    private Long personId;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public void validate(ValidationErrors errors) {

    }
}
