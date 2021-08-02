package com.wisercat.wisercatproovbackend.services;

import com.wisercat.wisercatproovbackend.datatransferobjects.DateDTO;

import java.util.List;
import java.util.Optional;

public interface DateService {

    Optional<DateDTO> saveDate(DateDTO dateDTO);

    Optional<DateDTO> updateDate(DateDTO dateDTO);

    Optional<DateDTO> getDateById(Long id);

    Optional<List<DateDTO>> getAllDateByFilterId(Long filterId);

    Optional<List<DateDTO>> getAllDates();
}
