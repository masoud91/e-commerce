package github.devokado.ecommerce.common.application.message;

import java.util.HashMap;
import java.util.Map;

public abstract class Message {

    protected Map<Class<?>, CommandHandler<? extends Command>> commandHandlerMap = new HashMap<>();
    protected Map<Class<?>, QueryHandler<? extends Query<?>, ?>> queryHandlerMap = new HashMap<>();

    public <T extends Command> Result dispatch(T command) {
        CommandHandler<T> handler = (CommandHandler<T>) commandHandlerMap.get(command.getClass());
        return (Result) handler.Handle(command);
    }

    public <T> T dispatch(Query<T> query) {
        QueryHandler<Query<T>, T> handler = (QueryHandler<Query<T>, T>) queryHandlerMap.get(query.getClass());
        return (T) handler.Handle(query);
    }

}
