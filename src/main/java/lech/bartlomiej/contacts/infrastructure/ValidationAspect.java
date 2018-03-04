package lech.bartlomiej.contacts.infrastructure;

import lech.bartlomiej.contacts.domain.commands.ValidCommand;
import lech.bartlomiej.contacts.domain.commands.InvalidCommandException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    @Before("execution(* lech.bartlomiej.contacts.api..*.*(..)) && args(command,..)")
    public void validate(ValidCommand command) {
        ValidCommand.ValidationErrors errors = new ValidCommand.ValidationErrors();
        command.validate(errors);
        if (!errors.isValid())
            throw new InvalidCommandException(errors);
    }
}
