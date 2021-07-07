package github.devokado.ecommerce.common.application.message;

public interface QueryHandler<TQuery extends Query<TResult>, TResult> {
    TResult Handle(TQuery query);
}
