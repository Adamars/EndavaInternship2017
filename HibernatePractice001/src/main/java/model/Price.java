package model;

import javax.persistence.*;
@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    public double price;

    @JoinColumn
    public int productid;

    @Column
    public String currency;

    @Column
    public int vat;

    public Price( int productid, double price, String currency, int vat) {
        this.price = price;
        this.productid = productid;
        this.currency = currency;
        this.vat = vat;
    }

    public Price() {
    }
}
