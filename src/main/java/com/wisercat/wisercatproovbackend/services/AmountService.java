package com.wisercat.wisercatproovbackend.services;

import com.wisercat.wisercatproovbackend.datatransferobjects.AmountDTO;

import java.util.List;
import java.util.Optional;

public interface AmountService {

    Optional<AmountDTO> saveAmount(AmountDTO amountDTO);

    Optional<AmountDTO> updateAmount(AmountDTO amountDTO);

    Optional<AmountDTO> getAmountById(Long id);

    Optional<List<AmountDTO>> getAmountByFilterId(Long filterId);

    Optional<List<AmountDTO>> getAllAmounts();
}
