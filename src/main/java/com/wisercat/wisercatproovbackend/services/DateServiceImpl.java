package com.wisercat.wisercatproovbackend.services;

import com.wisercat.wisercatproovbackend.database.Date;
import com.wisercat.wisercatproovbackend.database.Title;
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

    @Override
    public Optional<DateDTO> createDate(DateDTO dateDTO) {
        return Optional.empty();
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

        return dateDTO;
    }
}
