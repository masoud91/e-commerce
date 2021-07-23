package github.devokado.ecommerce.common.application.message;

public interface CommandHandler<C extends Command> {
    Result handle(C command);
}
