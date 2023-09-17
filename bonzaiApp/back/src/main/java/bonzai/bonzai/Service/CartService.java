package bonzai.bonzai.Service;

import bonzai.bonzai.model.CartItem;
import bonzai.bonzai.model.Product;
import bonzai.bonzai.repository.CartItemRepository;
import bonzai.bonzai.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CartService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductRepo productRepo;

    public void addToCart(Long productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItemRepository.save(cartItem);
    }

    public List<CartItem> viewCart() {
        return cartItemRepository.findAll();
    }

    public void removeFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
