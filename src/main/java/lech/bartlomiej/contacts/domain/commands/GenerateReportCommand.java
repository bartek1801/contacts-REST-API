package lech.bartlomiej.contacts.domain.commands;

import java.util.UUID;

public class GenerateReportCommand {

    private UUID personId;

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }
}
