package github.devokado.ecommerce.cart.application.service;

import github.devokado.ecommerce.cart.application.query.GetCartItemsQuery;
import github.devokado.ecommerce.cart.application.query.dto.CartItemDTO;
import github.devokado.ecommerce.cart.infrastructure.driven.presistence.CartItemQueryRepository;
import github.devokado.ecommerce.common.application.message.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCartItemsQueryHandler implements QueryHandler<GetCartItemsQuery, List<CartItemDTO>> {

    private final CartItemQueryRepository repository;

    public GetCartItemsQueryHandler(CartItemQueryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CartItemDTO> Handle(GetCartItemsQuery query) {
        return null;
    }
}
