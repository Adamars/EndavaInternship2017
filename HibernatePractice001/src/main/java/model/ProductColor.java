package model;
import javax.persistence.*;

@Entity
@Table(name = "productcolors")
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn
    private int productId;

    @JoinColumn
    private int colorId;

    public ProductColor(int productId, int colorId) {
        this.productId = productId;
        this.colorId = colorId;
    }

    public ProductColor() {
    }
}
