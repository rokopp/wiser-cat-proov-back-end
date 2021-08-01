package com.wisercat.wisercatproovbackend.services;

import com.wisercat.wisercatproovbackend.database.Amount;
import com.wisercat.wisercatproovbackend.database.Filter;
import com.wisercat.wisercatproovbackend.datatransferobjects.AmountDTO;
import com.wisercat.wisercatproovbackend.repositories.AmountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AmountServiceImpl implements AmountService {

    private final AmountRepository amountRepository;
    private final FilterServiceImpl filterService;

    @Override
    public Optional<AmountDTO> saveAmount(AmountDTO amountDTO) {
        try {
            Optional<Filter> filter = filterService.getFilterObjectById(amountDTO.getFilterId());
            if (filter.isEmpty()) return Optional.empty();

            Amount amount = new Amount();
//            amount.setFilter(amountDTO.getFilterId());
            amount.setCompareCondition(amountDTO.getCompareCondition());

            Amount savedAmount = amountRepository.save(amount);

            return Optional.of(convertToAmountDTO(savedAmount));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<AmountDTO> updateAmount(AmountDTO amountDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<AmountDTO> getAmountById(Long id) {
        Optional<Amount> amount = amountRepository.findById(id);
        if (amount.isEmpty()) return Optional.empty();
        return Optional.of(convertToAmountDTO(amount.get()));
    }

    @Override
    public Optional<List<AmountDTO>> getAmountByFilterId(Long filterId) {
        List<Amount> amounts = amountRepository.findByFilterId(filterId);
        if (amounts.isEmpty()) return Optional.empty();
        return Optional.of(amounts.stream()
                .map(this::convertToAmountDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<AmountDTO>> getAllAmounts() {
        List<Amount> amount = amountRepository.findAll();
        if (amount.isEmpty()) return Optional.empty();
        return Optional.of(amount.stream()
                .map(this::convertToAmountDTO)
                .collect(Collectors.toList()));
    }

    private AmountDTO convertToAmountDTO(Amount amount) {
        AmountDTO amountDTO = new AmountDTO();
        amountDTO.setId(amount.getFilter().getId());
        amountDTO.setCompareCondition(amount.getCompareCondition());
        amountDTO.setId(amount.getId());
        amountDTO.setFilterId(amount.getFilter().getId());

        return amountDTO;
    }
}
