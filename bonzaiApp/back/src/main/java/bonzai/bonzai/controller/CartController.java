package bonzai.bonzai.controller;
import bonzai.bonzai.Service.CartService;
import bonzai.bonzai.model.CartItem;
import bonzai.bonzai.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add/{productId}")
    public ResponseEntity<String> addToCart(@RequestParam Long productId) {
        cartService.addToCart(productId);
        return ResponseEntity.ok("Product added to the cart");
    }

    @GetMapping("/view")
    public List<CartItem> viewCart() {
        return cartService.viewCart();
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return ResponseEntity.ok("Item removed from the cart");
    }
}

