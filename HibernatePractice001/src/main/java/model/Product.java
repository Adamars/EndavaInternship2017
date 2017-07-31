package model;

import javax.persistence.*;
@Entity
@Table(name = "products")
public class Product {
    @Id
    @JoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    public String name;

    @Column
    public String description;

    @Column
    public int stock;

    public Product(String name, String description, int stock) {
        this.name = name;
        this.description = description;
        this.stock = stock;
    }

    public Product() {
    }
}
