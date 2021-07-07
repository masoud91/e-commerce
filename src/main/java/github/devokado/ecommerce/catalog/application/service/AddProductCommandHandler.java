package github.devokado.ecommerce.catalog.application.service;


import github.devokado.ecommerce.catalog.application.command.AddProductCommand;
import github.devokado.ecommerce.catalog.domain.product.ProductId;
import github.devokado.ecommerce.common.application.message.CommandHandler;
import github.devokado.ecommerce.common.application.message.Result;
import github.devokado.ecommerce.catalog.domain.product.Product;
import github.devokado.ecommerce.catalog.domain.product.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;


@Service
public class AddProductCommandHandler implements CommandHandler<AddProductCommand> {

    private final ProductRepository productRepository;

    public AddProductCommandHandler(
            ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @TransactionalEventListener
    public Result Handle(AddProductCommand aCommand) {
        ProductId id = productRepository.nextId();
        Product product = new Product(
                id,
                aCommand.getName(),
                aCommand.getPrice(),
                aCommand.getStock_count()
        );
        productRepository.save(product);

        return new Result();
    }
}
