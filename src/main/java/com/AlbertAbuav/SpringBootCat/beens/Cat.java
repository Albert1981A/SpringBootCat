package com.AlbertAbuav.SpringBootCat.beens;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @GeneratedValue  // ==> (JPA) Will make id auto increment
    private int id;

    @Column(nullable = false)  // ==> Define the column as not null
    private String name;

    @Column(name = "cat_weigh", nullable = false)  // ==> Will define the name of the column to be "cat_weight" and not null
    private float weight;

    public Cat(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }
}
