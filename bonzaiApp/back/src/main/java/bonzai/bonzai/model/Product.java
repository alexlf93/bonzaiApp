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
@ManyToOne
@JoinColumn(name = "category_id")
Category category;
@Column(nullable = false)

private String Name;
private String Description;
private double Price;
private String ImgURL;

}
