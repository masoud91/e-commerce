package github.devokado.ecommerce.common.application.message;

public interface QueryHandler<Q extends Query<R>, R> {
    R Handle(Q query);
}
