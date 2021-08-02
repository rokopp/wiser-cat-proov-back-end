package com.wisercat.wisercatproovbackend.controllers;

import com.wisercat.wisercatproovbackend.datatransferobjects.AmountDTO;
import com.wisercat.wisercatproovbackend.datatransferobjects.DateDTO;
import com.wisercat.wisercatproovbackend.services.DateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dates")
@RequiredArgsConstructor
public class DateController {

    private final DateServiceImpl dateService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<DateDTO> saveDate(@RequestBody DateDTO dateDTO) {
        Optional<DateDTO> date = dateService.saveDate(dateDTO);
        if (date.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(date.get(), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<DateDTO>> getAllDates() {
        Optional<List<DateDTO>> dates = dateService.getAllDates();
        if (dates.isEmpty()) return new ResponseEntity<>(List.of(), HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(dates.get());
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<DateDTO> getDateById(@PathVariable Long id) {
        Optional<DateDTO> date = dateService.getDateById(id);
        if (date.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(date.get());
    }

    @GetMapping("filters/{filterId}")
    @ResponseBody
    public ResponseEntity<List<DateDTO>> getDateByFilterId(@PathVariable long filterId) {
        Optional<List<DateDTO>> dates = dateService.getAllDateByFilterId(filterId);
        if (dates.isEmpty()) return new ResponseEntity<>(List.of(), HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(dates.get());
    }
}
