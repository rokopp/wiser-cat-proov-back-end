package com.wisercat.wisercatproovbackend.controllers;

import com.wisercat.wisercatproovbackend.datatransferobjects.TitleDTO;
import com.wisercat.wisercatproovbackend.services.TitleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/titles")
@RequiredArgsConstructor
public class TitleController {

    private final TitleServiceImpl titleService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<TitleDTO> saveTitle(@RequestBody TitleDTO titleDTO) {
        Optional<TitleDTO> title = titleService.saveTitle(titleDTO);
        if (title.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(title.get(), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<TitleDTO>> getAllTitles() {
        Optional<List<TitleDTO>> titles = titleService.getAllTitles();
        if (titles.isEmpty()) return new ResponseEntity<>(List.of(), HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(titles.get());
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<TitleDTO> getTitleById(@PathVariable Long id) {
        Optional<TitleDTO> title = titleService.getTitleById(id);
        if (title.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(title.get());
    }

    @GetMapping("filters/{filterId}")
    @ResponseBody
    public ResponseEntity<List<TitleDTO>> getTitleByFilterId(@PathVariable long filterId) {
        Optional<List<TitleDTO>> titles = titleService.getAllTitleByFilterId(filterId);
        if (titles.isEmpty()) return new ResponseEntity<>(List.of(), HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(titles.get());
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity<Boolean> deleteTitle(@PathVariable Long id) {
        boolean deleted = titleService.deleteTitle(id);
        if (!deleted) return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(true);
    }
}
