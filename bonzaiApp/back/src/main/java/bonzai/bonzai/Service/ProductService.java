package bonzai.bonzai.Service;
import bonzai.bonzai.dto.ProductDTO;
import bonzai.bonzai.model.Category;
import bonzai.bonzai.model.Product;
import bonzai.bonzai.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public void createProduct(ProductDTO productDto, Category category) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setImgURL(productDto.getImgURL());
        product.setName(productDto.getName());
        product.setCategory(category);
        product.setPrice(productDto.getPrice());
        productRepo.save(product);
    }

    public ProductDTO getProductDTO(Product product){
        ProductDTO ProductDTO = new ProductDTO();
        ProductDTO.setDescription(product.getDescription());
        ProductDTO.setImgURL(product.getImgURL());
        ProductDTO.setName(product.getName());
        ProductDTO.setCategoryId(product.getCategory().getId());
        ProductDTO.setPrice(product.getPrice());
        ProductDTO.setId(product.getId());
        return ProductDTO;
    }

    public List<ProductDTO> getAllProducts() {
      List<Product> allProducts = productRepo.findAll();
      List<ProductDTO> productDtos = new ArrayList<>();
      for(Product product: allProducts){
          productDtos.add(getProductDTO(product));
      }
      return productDtos;
    }

    public void updateProduct(ProductDTO productDto, Long productId) throws Exception {
       Optional<Product> optionalProduct = productRepo.findById(productId);
       if (!optionalProduct.isPresent()){
           throw new Exception("Product not present");
       }
       Product product = optionalProduct.get();
        product.setDescription(productDto.getDescription());
        product.setImgURL(productDto.getImgURL());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productRepo.save(product);
    }
    @DeleteMapping
    public boolean deleteProduct(Long Id) {
        Optional<Product> productOptional = productRepo.findById(Id);
        if (productOptional.isPresent()) {
            productRepo.deleteById(Id);
            return true;
        } else {
            System.out.println("Product not exist with this ID: " + Id);
            return false;
        }
    }
}
