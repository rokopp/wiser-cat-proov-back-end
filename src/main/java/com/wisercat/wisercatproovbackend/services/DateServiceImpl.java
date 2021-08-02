package com.wisercat.wisercatproovbackend.services;

import com.wisercat.wisercatproovbackend.database.Date;
import com.wisercat.wisercatproovbackend.database.Filter;
import com.wisercat.wisercatproovbackend.datatransferobjects.DateDTO;
import com.wisercat.wisercatproovbackend.repositories.DateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DateServiceImpl implements DateService {

    private final DateRepository dateRepository;
    private final FilterServiceImpl filterService;

    @Override
    public Optional<DateDTO> saveDate(DateDTO dateDTO) {
        try {
            Optional<Filter> filter = filterService.getFilterObjectById(dateDTO.getFilterId());
            if (filter.isEmpty()) return Optional.empty();

            Date date = new Date();
            date.setCompareCondition(dateDTO.getCompareCondition());
            date.setType(dateDTO.getType());
            date.setDate(dateDTO.getDate());

            Filter filter1 = new Filter();
            filter1.setId(dateDTO.getFilterId());
            date.setFilter(filter1);

            Date savedDate = dateRepository.save(date);

            return Optional.of(convertToDateDTO(savedDate));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<DateDTO> updateDate(DateDTO dateDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<DateDTO> getDateById(Long id) {
        Optional<Date> date = dateRepository.findById(id);
        if (date.isEmpty()) return Optional.empty();
        return Optional.of(convertToDateDTO(date.get()));
    }

    @Override
    public Optional<List<DateDTO>> getAllDateByFilterId(Long filterId) {
        List<Date> dates = dateRepository.findByFilterId(filterId);
        if (dates.isEmpty()) return Optional.empty();
        return Optional.of(dates.stream()
                .map(this::convertToDateDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<DateDTO>> getAllDates() {
        return Optional.empty();
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
