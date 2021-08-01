package com.wisercat.wisercatproovbackend.repositories;

import com.wisercat.wisercatproovbackend.database.Filter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilterRepository extends JpaRepository<Filter, Long> {

    Optional<Filter> findFilterByFilterName(String name);

}
