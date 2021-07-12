package github.devokado.ecommerce.common.application.message;

public interface CommandHandler<tCommand extends Command> {
    Result handle(tCommand command);
}
