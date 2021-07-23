package github.devokado.ecommerce.catalog.application.service;


import github.devokado.ecommerce.catalog.application.command.AddProductCommand;
import github.devokado.ecommerce.catalog.domain.product.*;
import github.devokado.ecommerce.common.application.message.CommandHandler;
import github.devokado.ecommerce.common.application.message.Result;
import github.devokado.ecommerce.common.application.event.DomainEventDispatcher;
import github.devokado.ecommerce.common.domain.Money;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class AddProductCommandHandler implements CommandHandler<AddProductCommand> {

    private final ProductRepository productRepository;
    private final DomainEventDispatcher eventDispatcher;

    public AddProductCommandHandler(ProductRepository productRepository, DomainEventDispatcher eventDispatcher) {
        this.productRepository = productRepository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    @Transactional
    public Result handle(AddProductCommand aCommand) {
        ProductId id = productRepository.nextId();
        Product product = new Product(
                id,
                new ProductName(aCommand.getName()),
                new Money(aCommand.getPrice()),
                new StockCount(aCommand.getStockCount())
        );

        productRepository.save(product);

        eventDispatcher.dispatch(product);

        return new Result();
    }
}
