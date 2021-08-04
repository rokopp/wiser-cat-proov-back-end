package com.wisercat.wisercatproovbackend.services;

import com.wisercat.wisercatproovbackend.database.Filter;
import com.wisercat.wisercatproovbackend.datatransferobjects.FilterDTO;

import java.util.List;
import java.util.Optional;

public interface FilterService {

    Optional<FilterDTO> saveFilter(FilterDTO filterDTO);

    Optional<FilterDTO> getFilterById(Long id);

    Optional<FilterDTO> getFilterByFilterName(String filterName);

    Optional<Filter> getFilterObjectById(Long id);

    Optional<List<FilterDTO>> getAllFilters();

    Optional<FilterDTO> updateFilter(FilterDTO filterDTO);

    Boolean deleteFilter(Long id);
}
