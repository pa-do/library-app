package com.group.libraryapp.controller.day2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1")
public class DayOfTheWeekController {
    @GetMapping("/day-of-the-week")
    public Map<String, Object> getDayOfTheWeek(@RequestParam String date) {
        return Map.of("dayOfTheWeek",
                LocalDate.parse(date).getDayOfWeek().toString().substring(0,3));
    }
}
