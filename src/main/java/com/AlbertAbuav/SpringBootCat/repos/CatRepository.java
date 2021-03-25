package com.AlbertAbuav.SpringBootCat.repos;

import com.AlbertAbuav.SpringBootCat.beens.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
}
