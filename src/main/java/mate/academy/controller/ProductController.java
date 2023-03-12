package mate.academy.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mate.academy.model.Product;
import mate.academy.model.dto.ProductRequestDto;
import mate.academy.model.dto.ProductResponseDto;
import mate.academy.service.ProductService;
import mate.academy.service.mapper.ProductDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductDtoMapper productDtoMapper;

    public ProductController(ProductService productService, ProductDtoMapper productDtoMapper) {
        this.productService = productService;
        this.productDtoMapper = productDtoMapper;
    }

    @GetMapping("/")
    public List<ProductResponseDto> getAllProducts() {
        return productService.findall()
                .stream()
                .map(productDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto create(@RequestBody @Valid ProductRequestDto product) {
        return productDtoMapper.parse(productService.save(productDtoMapper.toModel(product)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDto update(@PathVariable Long id,
                                     @RequestBody ProductRequestDto requestDto) {
        Product product = productDtoMapper.toModel(requestDto);
        product.setId(id);
        Product updatedProduct = productService.update(product);
        return productDtoMapper.parse(updatedProduct);
    }

    @GetMapping("/{id}")
    public ProductResponseDto get(@PathVariable Long id) {
        return productDtoMapper.parse(productService.get(id));
    }

    /*

    @GetMapping
    public  List<ProductResponseDto> getAllByBrand(@RequestParam String brand) {
        return productService.findAll();
    }

     */

    @GetMapping("/inject")
    public String injectMockData() {
        Product iphone = new Product();
        //Category category = new Category();
        iphone.setName("iphone 7");
        iphone.setPrice(BigDecimal.valueOf(499));
        iphone.setBrand("Apple");

        Product samsung = new Product();
        samsung.setName("S20");
        samsung.setPrice(BigDecimal.valueOf(695));
        samsung.setBrand("Samsung");

        productService.save(iphone);
        productService.save(samsung);

        return "Done!";
    }
}

















