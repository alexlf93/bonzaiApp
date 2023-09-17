package bonzai.bonzai.repository;
import bonzai.bonzai.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
