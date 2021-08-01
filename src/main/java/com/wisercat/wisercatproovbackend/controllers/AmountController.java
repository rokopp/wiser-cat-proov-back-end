package com.wisercat.wisercatproovbackend.controllers;

import com.wisercat.wisercatproovbackend.datatransferobjects.AmountDTO;
import com.wisercat.wisercatproovbackend.services.AmountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/amounts")
@RequiredArgsConstructor
public class AmountController {

    private final AmountServiceImpl amountService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<AmountDTO> saveAmount(@RequestBody AmountDTO amountDTO) {
        Optional<AmountDTO> amount = amountService.saveAmount(amountDTO);
        if (amount.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(amount.get(), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<AmountDTO>> getAllAmounts() {
        Optional<List<AmountDTO>> amounts = amountService.getAllAmounts();
        if (amounts.isEmpty()) return new ResponseEntity<>(List.of(), HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(amounts.get());
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<AmountDTO> getAmountById(@PathVariable Long id) {
        Optional<AmountDTO> filter = amountService.getAmountById(id);
        if (filter.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(filter.get());
    }

    @GetMapping("filters/{filterId}")
    @ResponseBody
    public ResponseEntity<List<AmountDTO>> getAmountByFilterId(@PathVariable long filterId) {
        Optional<List<AmountDTO>> amounts = amountService.getAmountByFilterId(filterId);
        if (amounts.isEmpty()) return new ResponseEntity<>(List.of(), HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(amounts.get());
    }
}
