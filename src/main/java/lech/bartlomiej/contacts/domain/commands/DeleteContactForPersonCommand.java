package lech.bartlomiej.contacts.domain.commands;

import java.util.UUID;

public class DeleteContactForPersonCommand implements ValidCommand {

    private UUID personId;

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    @Override
    public void validate(ValidationErrors errors) {

    }
}
