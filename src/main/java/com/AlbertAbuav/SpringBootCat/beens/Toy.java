package com.AlbertAbuav.SpringBootCat.beens;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "toys_column")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    //@ManyToOne
    //@JoinColumn(name = "cat_id")
    //private Cat catDetails;

    public Toy(String name) {
        this.name = name;
    }
}
