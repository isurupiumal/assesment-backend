package com.isuru.assessment.repositories;

import com.isuru.assessment.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {

    @Query("SELECT d FROM Discount d WHERE d.id = :id")
    Discount findObjectById(@Param("id")Integer id);
}
