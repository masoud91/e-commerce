package github.devokado.ecommerce.common.application.message;

public interface CommandHandler<TCommand extends Command> {
    Result Handle(TCommand command);
}
