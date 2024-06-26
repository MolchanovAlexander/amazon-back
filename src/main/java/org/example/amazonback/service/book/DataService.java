package org.example.amazonback.service.book;

import java.util.List;
import org.example.amazonback.dto.user.LimitDto;

public interface DataService {
    List<Integer> findAll();

    List<Integer> setLimit(LimitDto limitDto);
}
