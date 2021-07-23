package github.devokado.ecommerce.common.infrastructure;

import github.devokado.ecommerce.common.application.message.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

@Component
public class SpringMessage implements Message {

    private final Map<String, CommandHandler<? extends Command>> injectedCommandHandlerMap;
    private final Map<String, QueryHandler<? extends Query<?>, ?>> injectedQueryHandlerMap;

    public SpringMessage(Map<String, CommandHandler<? extends Command>> injectedCommandHandlerMap,
                         Map<String, QueryHandler<? extends Query<?>, ?>> injectedQueryHandlerMap) {
        this.injectedCommandHandlerMap = injectedCommandHandlerMap;
        this.injectedQueryHandlerMap = injectedQueryHandlerMap;

        this.registerCommandHandlers();
        this.registerQueryHandlers();
    }

    private void registerCommandHandlers(){
        if (injectedCommandHandlerMap == null || injectedCommandHandlerMap.isEmpty()) {
            return;
        }

        for (CommandHandler<? extends Command> commandHandler : injectedCommandHandlerMap.values()) {
            Type command =
                    ((ParameterizedType) commandHandler.getClass().getGenericInterfaces()[0])
                            .getActualTypeArguments()[0];

            commandHandlerMap.put((Class<?>) command, commandHandler);
        }
    }

    private void registerQueryHandlers(){
        if (injectedQueryHandlerMap == null || injectedQueryHandlerMap.isEmpty()) {
            return;
        }

        for (QueryHandler<? extends Query<?>, ?> queryHandler : injectedQueryHandlerMap.values()) {
            Type query =
                    ((ParameterizedType) queryHandler.getClass().getGenericInterfaces()[0])
                            .getActualTypeArguments()[0];

            queryHandlerMap.put((Class<?>) query, queryHandler);
        }
    }

}
