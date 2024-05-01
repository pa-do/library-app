package com.group.libraryapp.controller.day2;

import com.group.libraryapp.dto.day2.request.Calculate2NumbersRequest;
import com.group.libraryapp.dto.day2.response.Calculate2NumbersResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class Calculate2NumbersController {
    @GetMapping("/calc")
    public Calculate2NumbersResponse calculateTwoNumbers(Calculate2NumbersRequest request) {
        return new Calculate2NumbersResponse(request);
    }
}
