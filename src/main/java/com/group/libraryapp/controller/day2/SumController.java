package com.group.libraryapp.controller.day2;

import com.group.libraryapp.dto.day2.request.SumRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class SumController {
    @PostMapping("/sum")
    public int sumNumbers(@RequestBody SumRequest request) {
        List<Integer> numbers = request.getNumbers();
        return numbers
                .stream().mapToInt(Integer::intValue).sum();
    }
}
