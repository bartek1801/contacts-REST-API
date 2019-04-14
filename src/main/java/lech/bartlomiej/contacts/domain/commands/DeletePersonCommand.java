package lech.bartlomiej.contacts.domain.commands;

import java.util.UUID;

public class DeletePersonCommand implements ValidCommand {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public void validate(ValidationErrors errors) {

    }
}
