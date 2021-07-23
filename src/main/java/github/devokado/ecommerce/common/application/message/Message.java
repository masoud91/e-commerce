package github.devokado.ecommerce.common.application.message;

import java.util.HashMap;
import java.util.Map;

public interface Message {

    Map<Class<?>, CommandHandler<? extends Command>> commandHandlerMap = new HashMap<>();
    Map<Class<?>, QueryHandler<? extends Query<?>, ?>> queryHandlerMap = new HashMap<>();

    default <T extends Command> Result dispatch(T command) {
        CommandHandler<T> handler = (CommandHandler<T>) commandHandlerMap.get(command.getClass());
        return (Result) handler.handle(command);
    }

    default <T> T dispatch(Query<T> query) {
        QueryHandler<Query<T>, T> handler = (QueryHandler<Query<T>, T>) queryHandlerMap.get(query.getClass());
        return (T) handler.Handle(query);
    }

}
