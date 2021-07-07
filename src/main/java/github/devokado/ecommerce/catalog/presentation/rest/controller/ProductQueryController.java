package github.devokado.ecommerce.catalog.presentation.rest.controller;

import io.swagger.annotations.Api;
import github.devokado.ecommerce.catalog.application.query.GetProductListQuery;
import github.devokado.ecommerce.catalog.application.query.GetProductQuery;
import github.devokado.ecommerce.catalog.application.query.dto.ProductDTO;
import github.devokado.ecommerce.common.application.message.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/products")
@Api(tags="Product")
public class ProductQueryController {

    Message message;

    public ProductQueryController(Message message) {
        this.message = message;
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getProductById(@PathVariable Long id) {
        GetProductQuery query = new GetProductQuery(id);
        ProductDTO productDTO = message.dispatch(query);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/")
    ResponseEntity<?> getProducts(@RequestParam(required = false, name = "name") String name,
                                  @PageableDefault(page = 0, size = 20) Pageable pageable) {

        GetProductListQuery query = new GetProductListQuery(name, pageable);
        Page<ProductDTO> productDTOs = message.dispatch(query);
        return ResponseEntity.ok(productDTOs);
    }

}
