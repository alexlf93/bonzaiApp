package bonzai.bonzai.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private String name;
@Column(nullable = false)
private String description;
@Column(nullable = false)
private double price;
private String imgURL;

@ManyToOne
@JoinColumn(name = "category_id")
Category category;

}
