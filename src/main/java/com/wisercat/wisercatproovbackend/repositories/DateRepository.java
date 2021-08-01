package com.wisercat.wisercatproovbackend.repositories;

import com.wisercat.wisercatproovbackend.database.Date;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DateRepository extends JpaRepository<Date, Long> {

    List<Date> findByFilterId(long filterId);

}
