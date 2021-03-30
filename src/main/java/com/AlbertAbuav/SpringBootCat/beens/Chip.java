package com.AlbertAbuav.SpringBootCat.beens;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Chip {

    @Id // ==> (JPA) Will make id primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ==> (JPA) Will make id auto increment
    private int id;

    private final String code = UUID.randomUUID().toString();
}
