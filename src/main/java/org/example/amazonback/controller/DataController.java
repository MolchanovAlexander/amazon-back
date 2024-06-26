package org.example.amazonback.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.amazonback.dto.user.LimitDto;
import org.example.amazonback.service.book.DataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/data")
@RequiredArgsConstructor
@CrossOrigin(origins = "")
public class DataController {
    private static final String LOCAL_URL = "http://localhost:5173";
    private final DataService dataService;

    @GetMapping
    @CrossOrigin(origins = {LOCAL_URL})
    public List<Integer> getAll() {
        return dataService.findAll();
    }

    @PostMapping
    @CrossOrigin(origins = {LOCAL_URL})
    public List<Integer> getAll(@Valid @RequestBody LimitDto limitDto) {
        return dataService.setLimit(limitDto);
    }
}
