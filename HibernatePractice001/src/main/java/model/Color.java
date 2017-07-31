package model;

import javax.persistence.*;

@Entity
@Table(name = "colors")

public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn
    private int id;


    @Column
    public String name;

    public Color() {
    }

    public Color(String name) {

        this.name = name;
    }
}
