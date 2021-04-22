package com.AlbertAbuav.SpringBootCat.beens;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * For Data will use Javax Persistence (JPA)
 * witch is the interface how defines what to do and hibernate will do it.
 */

@Entity  // ==> This is Javax Persistence (JPA). will do -> (ORM) Object Relational Mapping (The relation between a bean and the Table)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cats") // ==> will define the name of the Table in SQL to be "cats"
@Builder
public class Cat {

    @Id // ==> (JPA) Will make id primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ==> (JPA) Will make id auto increment
    private int id;

    @Column(nullable = false)  // ==> Define the column as not null
    private String name;

    @Column(name = "cat_weight", nullable = false)  // ==> Will define the name of the column to be "cat_weight" and not null
    private float weight;

    //@OneToOne  // ==> One Cat have One Chip
    @OneToOne(cascade = CascadeType.ALL)  // ==> One Cat have One Chip and we don't need to enter the chip first to the DB
    @JoinColumn(name = "cat_chip")  // ==> Will define the name of the column to be "cat_chip"
    private Chip chip;

    @OneToMany  // ==> One Cat have Many Chips
    //@JoinColumn(name = "cat_toy")
    @JoinTable(name = "CAT_TOY", joinColumns = @JoinColumn(name = "CAT_ID"),
            inverseJoinColumns = @JoinColumn(name = "TOY_ID")
    )  // ==> Will create a new Table named "cat_toy" with to columns: "cat_id" and "chip_id"
    private List<Toy> toys = new ArrayList<>();

//    @OneToMany(mappedBy = "catDetails")  // ==> One Cat have Many Chip
//    @JoinTable(name = "CAT_CHIP", joinColumns = @JoinColumn(name = "CAT_ID"),
//            inverseJoinColumns = @JoinColumn(name = "CHIP_ID")
//    )  // ==> Will create a new Table named "CAT_CHIP" with to columns: "CAT_ID" and "CHIP_ID"
//    private List<Chip> chip = new ArrayList<>();

    public Cat(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void removeToy(Toy toy) {
        toys.remove(toy);
    }
}
