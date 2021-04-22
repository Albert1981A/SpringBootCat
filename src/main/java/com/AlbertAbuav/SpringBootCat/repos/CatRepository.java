package com.AlbertAbuav.SpringBootCat.repos;

import com.AlbertAbuav.SpringBootCat.beens.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * Repository give us:  50% / 40% / 10%
 * 50% CRUD
 * 40% Dialect queries
 * 10% Query("...")
 */
public interface CatRepository extends JpaRepository<Cat, Integer> {

    /**
     * 40% Dialect queries
     */
    List<Cat> findByNameAndWeight(String name, float weight);

    List<Cat> findByNameOrWeight(String name, float weight);

    List<Cat> findByWeightGreaterThan(float weight);

    List<Cat> findByWeightLessThan(float weight);

    /*
    JPA SMART Keywords:
And	==>	findByLastnameAndFirstname
Or ==>	findByLastnameOrFirstname
Between	==>	findByStartDateBetween
LessThan ==>	findByAgeLessThan
GreaterThan	findByAgeGreaterThan
After ==>	findByStartDateAfter
Before ==>	findByStartDateBefore
IsNull ==>	findByAgeIsNull
IsNotNull,NotNull ==> 	findByAge(Is)NotNull
Like ==>	findByFirstnameLike
NotLike	==>	findByFirstnameNotLike
StartingWith ==>	findByFirstnameStartingWith
EndingWith ==>	findByFirstnameEndingWith
     */

    /**
     * 10% Query("...")
     * HQL = Hibernate Query Language
     */
    @Query(value = "SELECT cat_weight, count(*) FROM intellijsample129.cats group by cat_weigh;", nativeQuery = true)
    List<Object> groupByWeight();

}
