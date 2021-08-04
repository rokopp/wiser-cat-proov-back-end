package com.wisercat.wisercatproovbackend.services;

import com.wisercat.wisercatproovbackend.database.Amount;
import com.wisercat.wisercatproovbackend.database.Date;
import com.wisercat.wisercatproovbackend.database.Filter;
import com.wisercat.wisercatproovbackend.database.Title;
import com.wisercat.wisercatproovbackend.datatransferobjects.AmountDTO;
import com.wisercat.wisercatproovbackend.datatransferobjects.DateDTO;
import com.wisercat.wisercatproovbackend.datatransferobjects.FilterDTO;
import com.wisercat.wisercatproovbackend.datatransferobjects.TitleDTO;
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
            filter.setSelectedFilter(filterDTO.getSelectedFilter());

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
    public Optional<Filter> getFilterObjectById(Long id) {
        return filterRepository.findById(id);
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
    public Optional<FilterDTO> updateFilter(FilterDTO filterDTO) {
        try {
            Optional<Filter> filterOptional = filterRepository.findById(filterDTO.getId());
            if (filterOptional.isEmpty()) return Optional.empty();
            Filter filter = filterOptional.get();

            String filterName = filterDTO.getFilterName();
            Long selectedFilter = filterDTO.getSelectedFilter();

            if (filterName != null) filter.setFilterName(filterName);
            if (selectedFilter != null) filter.setSelectedFilter(selectedFilter);

            Filter savedFilter = filterRepository.save(filter);

            return Optional.of(convertFilterToDto(savedFilter));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
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
        filterDTO.setSelectedFilter(filter.getSelectedFilter());

        List<Amount> amounts = filter.getAmounts();
        if (amounts == null) filterDTO.setAmounts(List.of());
        else filterDTO.setAmounts(filter.getAmounts().stream()
                .map(this::convertToAmountDTO).collect(Collectors.toList()));

        List<Title> titles = filter.getTitles();
        if (titles == null) filterDTO.setTitles(List.of());
        else filterDTO.setTitles(filter.getTitles().stream()
                .map(this::convertToTitleDTO).collect(Collectors.toList()));

        List<Date> dates = filter.getDates();
        if (dates == null) filterDTO.setDates(List.of());
        else filterDTO.setDates(filter.getDates().stream()
                .map(this::convertToDateDTO).collect(Collectors.toList()));

        return filterDTO;
    }

    private AmountDTO convertToAmountDTO(Amount amount) {
        AmountDTO amountDTO = new AmountDTO();
        amountDTO.setId(amount.getFilter().getId());
        amountDTO.setCompareCondition(amount.getCompareCondition());
        amountDTO.setId(amount.getId());
        amountDTO.setFilterId(amount.getFilter().getId());
        amountDTO.setType(amount.getType());
        amountDTO.setNumber(amount.getNumber());

        return amountDTO;
    }

    private TitleDTO convertToTitleDTO(Title title) {
        TitleDTO titleDTO = new TitleDTO();
        titleDTO.setId(title.getFilter().getId());
        titleDTO.setCompareCondition(title.getCompareCondition());
        titleDTO.setId(title.getId());
        titleDTO.setFilterId(title.getFilter().getId());
        titleDTO.setType(title.getType());
        titleDTO.setText(title.getText());

        return titleDTO;
    }

    private DateDTO convertToDateDTO(Date date) {
        DateDTO dateDTO = new DateDTO();
        dateDTO.setId(date.getFilter().getId());
        dateDTO.setCompareCondition(date.getCompareCondition());
        dateDTO.setId(date.getId());
        dateDTO.setFilterId(date.getFilter().getId());
        dateDTO.setType(date.getType());
        dateDTO.setDate(date.getDate());

        return dateDTO;
    }
}
