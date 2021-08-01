package com.wisercat.wisercatproovbackend.repositories;

import com.wisercat.wisercatproovbackend.database.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitleRepository extends JpaRepository<Title, Long> {

    List<Title> findByFilterId(long filterId);

}
