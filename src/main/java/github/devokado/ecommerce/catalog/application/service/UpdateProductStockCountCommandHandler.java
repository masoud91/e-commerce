package github.devokado.ecommerce.catalog.application.service;


import github.devokado.ecommerce.catalog.application.command.UpdateProductStockCountCommand;
import github.devokado.ecommerce.catalog.domain.product.ProductId;
import github.devokado.ecommerce.common.application.message.CommandHandler;
import github.devokado.ecommerce.common.application.message.Result;
import github.devokado.ecommerce.common.domain.DomainEventDispatcher;
import github.devokado.ecommerce.catalog.domain.product.Product;
import github.devokado.ecommerce.catalog.domain.product.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.UUID;


@Service
public class UpdateProductStockCountCommandHandler implements CommandHandler<UpdateProductStockCountCommand> {

    private final ProductRepository productRepository;
    private final DomainEventDispatcher eventDispatcher;

    public UpdateProductStockCountCommandHandler(ProductRepository productRepository,
                                                 DomainEventDispatcher eventDispatcher) {
        this.productRepository = productRepository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    @TransactionalEventListener
    public Result Handle(UpdateProductStockCountCommand aCommand) {
        // TODO: fix this
        Product product = (productRepository.productOfId(new ProductId(UUID.fromString(aCommand.getId())))).get();

        product.updateStockCount(aCommand.getStock_count());

        productRepository.save(product);

        eventDispatcher.dispatch(product);

        return new Result();
    }
}
