package com.test.bookstore.controller;

import com.test.bookstore.dto.BookOrderRequest;
import com.test.bookstore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/bookstore")
public class BookStoreController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest) {
        return ResponseEntity.ok(orderService.putAnOrder(bookOrderRequest.getBookIdList(),
                bookOrderRequest.getUserName()));
    }
}
