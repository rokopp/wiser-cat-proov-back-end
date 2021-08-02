package com.wisercat.wisercatproovbackend.services;

import com.wisercat.wisercatproovbackend.database.Filter;
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
    private final FilterServiceImpl filterService;

    @Override
    public Optional<TitleDTO> saveTitle(TitleDTO titleDTO) {
        try {
            Optional<Filter> filter = filterService.getFilterObjectById(titleDTO.getFilterId());
            if (filter.isEmpty()) return Optional.empty();

            Title title = new Title();
            title.setCompareCondition(titleDTO.getCompareCondition());
            title.setType(titleDTO.getType());
            title.setText(titleDTO.getText());

            Filter filter1 = new Filter();
            filter1.setId(titleDTO.getFilterId());
            title.setFilter(filter1);

            Title savedTitle = titleRepository.save(title);

            return Optional.of(convertToTitleDTO(savedTitle));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
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
        titleDTO.setType(title.getType());
        titleDTO.setText(title.getText());

        return titleDTO;
    }
}
