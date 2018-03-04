package lech.bartlomiej.contacts.domain.commands;

public class DeletePersonCommand implements ValidCommand {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void validate(ValidationErrors errors) {
        //TODO
    }
}
