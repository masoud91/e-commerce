package github.devokado.ecommerce.catalog.presentation.rest.controller;

import io.swagger.annotations.Api;
import github.devokado.ecommerce.catalog.application.command.AddProductCommand;
import github.devokado.ecommerce.catalog.application.command.UpdateProductStockCountCommand;
import github.devokado.ecommerce.common.application.message.Message;
import github.devokado.ecommerce.catalog.presentation.dto.NewProductDTO;
import github.devokado.ecommerce.catalog.presentation.dto.NewProductStockCountDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/products")
@Api(tags="Product")
public class ProductCommandController {

    Message message;

    public ProductCommandController(Message message) {
        this.message = message;
    }

    @PostMapping("/add")
    ResponseEntity<?> add(@Valid @RequestBody NewProductDTO addProductDTO) {
        AddProductCommand command = new AddProductCommand(
                addProductDTO.getName(),
                addProductDTO.getPrice(),
                addProductDTO.getStock_count()
        );
        message.dispatch(command);
        return ResponseEntity.ok(addProductDTO);
    }

    @PutMapping("{id}/update_stock_count")
    ResponseEntity<?> update_stock_count(@PathVariable String id,
                                         @RequestBody NewProductStockCountDTO newProductStockCountDTO) {
        UpdateProductStockCountCommand command = new UpdateProductStockCountCommand(
                id,
                newProductStockCountDTO.getStock_count()
        );
        message.dispatch(command);
        return ResponseEntity.noContent().build();
    }

}
