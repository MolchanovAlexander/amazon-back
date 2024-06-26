package org.example.amazonback.service.data.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.example.amazonback.dto.user.LimitDto;
import org.example.amazonback.service.data.DataService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DataServiceImpl implements DataService {
    private final static Random random = new Random();
    private Integer limit = 100;
    @Override
    public List<Integer> findAll() {
        List<Integer> list = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            list.add(random.nextInt(limit));
        }
        return list;
    }

    @Override
    public List<Integer> setLimit(LimitDto limitDto) {
        limit = limitDto.limit();
        return findAll();
    }
}
