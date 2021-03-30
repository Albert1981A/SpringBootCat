package com.AlbertAbuav.SpringBootCat.repos;

import com.AlbertAbuav.SpringBootCat.beens.Chip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChipRepository extends JpaRepository<Chip, Integer> {
}
