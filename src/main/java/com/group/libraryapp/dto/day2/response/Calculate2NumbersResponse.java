package com.group.libraryapp.dto.day2.response;

import com.group.libraryapp.dto.day2.request.Calculate2NumbersRequest;

public class Calculate2NumbersResponse {
    private int add;
    private int minus;
    private int multiply;

    public Calculate2NumbersResponse(Calculate2NumbersRequest request) {
        this.add = request.getNum1() + request.getNum2();
        this.minus = request.getNum1() - request.getNum2();
        this.multiply = request.getNum1() * request.getNum2();
    }

    public int getAdd() {
        return add;
    }

    public int getMinus() {
        return minus;
    }

    public int getMultiply() {
        return multiply;
    }
}
