package raf.console.springshopdemo.controllers;


import org.springframework.web.bind.annotation.*;
import raf.console.springshopdemo.dto.ProductDto;
import raf.console.springshopdemo.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

    private final ProductService productService;


    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDto dto){
        productService.addProduct(dto);
    }

}
