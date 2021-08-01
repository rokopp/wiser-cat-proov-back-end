package com.wisercat.wisercatproovbackend.services;

import com.wisercat.wisercatproovbackend.database.Filter;
import com.wisercat.wisercatproovbackend.datatransferobjects.FilterDTO;
import com.wisercat.wisercatproovbackend.repositories.FilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService{

    private final FilterRepository filterRepository;

    @Override
    public Optional<FilterDTO> saveFilter(FilterDTO filterDTO) {
        try {
            Optional<Filter> findFilterByFilterName = filterRepository.findFilterByFilterName(filterDTO.getFilterName());
            if (findFilterByFilterName.isPresent()) return Optional.empty();

            Filter filter = new Filter();
            filter.setFilterName(filterDTO.getFilterName());

            Filter savedFilter = filterRepository.save(filter);
            return Optional.of(convertFilterToDto(savedFilter));

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<FilterDTO> getFilterById(Long id) {
        Optional<Filter> filter = filterRepository.findById(id);
        if (filter.isEmpty()) return Optional.empty();
        return Optional.of(convertFilterToDto(filter.get()));
    }

    @Override
    public Optional<FilterDTO> getFilterByFilterName(String filterName) {
        Optional<Filter> filter = filterRepository.findFilterByFilterName(filterName);
        if (filter.isEmpty()) return Optional.empty();
        return Optional.of(convertFilterToDto(filter.get()));
    }

    @Override
    public Optional<List<FilterDTO>> getAllFilters() {
        List<Filter> filters = filterRepository.findAll();
        if (filters.isEmpty()) return Optional.empty();
        return Optional.of(filters.stream()
                .map(this::convertFilterToDto)
                .collect(Collectors.toList()));
    }

    @Override
    public Boolean deleteFilter(Long id) {
        Optional<Filter> filter = filterRepository.findById(id);
        if (filter.isEmpty()) return false;
        filterRepository.deleteById(id);
        return true;
    }

    private FilterDTO convertFilterToDto(Filter filter){
        FilterDTO filterDTO = new FilterDTO();
        filterDTO.setFilterName(filter.getFilterName());
        filterDTO.setId(filter.getId());

        return filterDTO;
    }
}
