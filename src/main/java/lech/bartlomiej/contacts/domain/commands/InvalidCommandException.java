package lech.bartlomiej.contacts.domain.commands;

public class InvalidCommandException extends RuntimeException {

    private ValidCommand.ValidationErrors errors;


    public InvalidCommandException(ValidCommand.ValidationErrors errors) {
        this.errors = errors;
    }

    public ValidCommand.ValidationErrors getErrors() {
        return errors;
    }
}
