package bonzai.bonzai.Service;
import bonzai.bonzai.dto.ProductDTO;
import bonzai.bonzai.model.Category;
import bonzai.bonzai.model.Product;
import bonzai.bonzai.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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
}
