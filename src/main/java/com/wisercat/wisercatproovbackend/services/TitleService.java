package com.wisercat.wisercatproovbackend.services;

import com.wisercat.wisercatproovbackend.datatransferobjects.TitleDTO;

import java.util.List;
import java.util.Optional;

public interface TitleService {

    Optional<TitleDTO> saveTitle(TitleDTO titleDTO);

    Optional<TitleDTO> updateTitle(TitleDTO titleDTO);

    Optional<TitleDTO> getTitleById(Long id);

    Optional<List<TitleDTO>> getAllTitleByFilterId(Long filterId);

    Optional<List<TitleDTO>> getAllTitles();

    Boolean deleteTitle(Long id);
}
