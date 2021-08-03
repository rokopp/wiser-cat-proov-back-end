package com.wisercat.wisercatproovbackend.controllers;

import com.wisercat.wisercatproovbackend.datatransferobjects.AmountDTO;
import com.wisercat.wisercatproovbackend.datatransferobjects.FilterDTO;
import com.wisercat.wisercatproovbackend.services.FilterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filters")
@RequiredArgsConstructor
public class FilterController {

    private final FilterServiceImpl filterService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<FilterDTO> saveFilter(@RequestBody FilterDTO filterDTO) {
        Optional<FilterDTO> filter = filterService.saveFilter(filterDTO);
        if (filter.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(filter.get(), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<FilterDTO>> getAllFilters() {
        Optional<List<FilterDTO>> filters = filterService.getAllFilters();
        if (filters.isEmpty()) return new ResponseEntity<>(List.of(), HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(filters.get());
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<FilterDTO> getFilterById(@PathVariable Long id) {
        Optional<FilterDTO> filter = filterService.getFilterById(id);
        if (filter.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(filter.get());
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity<Boolean> deleteFilter(@PathVariable Long id) {
        boolean deleted = filterService.deleteFilter(id);
        if (!deleted) return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(true);
    }

    @GetMapping("{filterName}")
    @ResponseBody
    public ResponseEntity<FilterDTO> getFilterByFilterName(@PathVariable String filterName) {
        Optional<FilterDTO> filter = filterService.getFilterByFilterName(filterName);
        if (filter.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(filter.get());
    }
}
