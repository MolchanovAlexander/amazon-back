package org.example.amazonback.service.book.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.amazonback.service.book.DataService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DataServiceImpl implements DataService {
    private static final String MESSAGE_BOOK = "book";

    @Override
    public List<String> findAll() {
        return List.of(MESSAGE_BOOK);
    }
}
