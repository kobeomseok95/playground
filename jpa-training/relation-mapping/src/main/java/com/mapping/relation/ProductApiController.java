package com.mapping.relation;

import com.mapping.relation.command.ProductCommandService;
import com.mapping.relation.query.ProductData;
import com.mapping.relation.query.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products/{productId}")
public class ProductApiController {

    private final ProductQueryService productQueryService;
    private final ProductCommandService productCommandService;

    @GetMapping("")
    public ProductData getProduct(@PathVariable Long productId) {
        return productQueryService.getProduct(productId);
    }

    @PatchMapping("")
    public void setPrice(@PathVariable Long productId,
                         @RequestBody ChangeProductNameRequest changeProductNameRequest) {
        productCommandService.setName(productId, changeProductNameRequest.getName());
    }
}
