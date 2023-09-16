package bonzai.bonzai.controller;
import bonzai.bonzai.Service.ProductService;
import bonzai.bonzai.dto.ProductDTO;
import bonzai.bonzai.model.Category;
import bonzai.bonzai.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepo categoryRepo;

    @PostMapping("/add")
    public String createProduct(@RequestBody ProductDTO productDto) {
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return "Category does not exist";
        }
        productService.createProduct(productDto, optionalCategory.get());
        return "Product has been added";
    }
    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getProducts(){
        final List<ProductDTO> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/update/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDTO productDto) throws Exception {
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return "Category does not exist";
        }
        productService.updateProduct(productDto, productId);
        return "Product has been added";
    }
}
