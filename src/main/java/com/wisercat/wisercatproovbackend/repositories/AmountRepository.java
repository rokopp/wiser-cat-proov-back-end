package com.wisercat.wisercatproovbackend.repositories;

import com.wisercat.wisercatproovbackend.database.Amount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmountRepository extends JpaRepository<Amount, Long> {

    List<Amount> findByFilterId(long filterId);

}
