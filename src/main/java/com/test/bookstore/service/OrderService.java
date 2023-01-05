package com.test.bookstore.service;

import com.test.bookstore.core.result.Result;
import com.test.bookstore.core.result.SuccessResult;
import com.test.bookstore.entity.Book;
import com.test.bookstore.entity.Order;
import com.test.bookstore.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final BookService bookService;
    private final OrderRepository orderRepository;

    public Result putAnOrder(List<Integer> bookIdList, String userName) {
        List<Optional<Book>> bookList = bookIdList.stream().map(bookService::getById).collect(Collectors.toList());

        Double totalPrice = bookList.stream()
                .map(optionalBook -> optionalBook.map(Book::getPrice).orElse(0.0))
                .reduce(0.0, Double::sum);

        Order order = Order.builder()
                .bookIdList(bookIdList)
                .totalPrice(totalPrice)
                .userName(userName)
                .build();

        orderRepository.save(order);

        return new SuccessResult("Order saved.");
    }
}
