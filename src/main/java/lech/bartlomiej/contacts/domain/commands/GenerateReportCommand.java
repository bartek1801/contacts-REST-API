package lech.bartlomiej.contacts.domain.commands;

public class GenerateReportCommand {

    private Long personId;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
