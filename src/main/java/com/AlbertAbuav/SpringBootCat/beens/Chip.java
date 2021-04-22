package com.AlbertAbuav.SpringBootCat.beens;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Chip {

    @Id // ==> (JPA) Will make id primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ==> (JPA) Will make id auto increment
    private int id;

    private final String code = UUID.randomUUID().toString();

    //    @ManyToOne
//    @JoinColumn(name = "cat_id")
//    private Cat catDetails;
}
