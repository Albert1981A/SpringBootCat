package com.AlbertAbuav.SpringBootCat.repos;

import com.AlbertAbuav.SpringBootCat.beens.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Integer> {
}
