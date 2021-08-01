package com.wisercat.wisercatproovbackend.services;

import com.wisercat.wisercatproovbackend.database.Filter;
import com.wisercat.wisercatproovbackend.datatransferobjects.FilterDTO;

import java.util.List;
import java.util.Optional;

public interface FilterService {

    Optional<FilterDTO> saveFilter(FilterDTO filterDTO);

    Optional<FilterDTO> getFilterById(Long id);

    Optional<FilterDTO> getFilterByFilterName(String filterName);

    Optional<List<FilterDTO>> getAllFilters();

    Boolean deleteFilter(Long id);
}
