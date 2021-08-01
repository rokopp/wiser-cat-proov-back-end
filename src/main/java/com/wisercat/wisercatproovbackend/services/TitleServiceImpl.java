package com.wisercat.wisercatproovbackend.services;

import com.wisercat.wisercatproovbackend.database.Amount;
import com.wisercat.wisercatproovbackend.database.Title;
import com.wisercat.wisercatproovbackend.datatransferobjects.TitleDTO;
import com.wisercat.wisercatproovbackend.repositories.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TitleServiceImpl implements TitleService {

    private final TitleRepository titleRepository;

    @Override
    public Optional<TitleDTO> createTitle(TitleDTO titleDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<TitleDTO> updateTitle(TitleDTO titleDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<TitleDTO> getTitleById(Long id) {
        Optional<Title> title = titleRepository.findById(id);
        if (title.isEmpty()) return Optional.empty();
        return Optional.of(convertToTitleDTO(title.get()));
    }

    @Override
    public Optional<List<TitleDTO>> getAllTitleByFilterId(Long filterId) {
        List<Title> titles = titleRepository.findByFilterId(filterId);
        if (titles.isEmpty()) return Optional.empty();
        return Optional.of(titles.stream()
                .map(this::convertToTitleDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TitleDTO>> getAllTitles() {
        return Optional.empty();
    }

    private TitleDTO convertToTitleDTO(Title title) {
        TitleDTO titleDTO = new TitleDTO();
        titleDTO.setId(title.getFilter().getId());
        titleDTO.setCompareCondition(title.getCompareCondition());
        titleDTO.setId(title.getId());
        titleDTO.setFilterId(title.getFilter().getId());

        return titleDTO;
    }
}
