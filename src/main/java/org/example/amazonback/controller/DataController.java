package org.example.amazonback.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.amazonback.service.book.DataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<String> getAll() {
        return dataService.findAll();
    }
}
