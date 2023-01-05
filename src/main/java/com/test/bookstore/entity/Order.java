package com.test.bookstore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "bookOrder")
@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;

    @ElementCollection(targetClass = Integer.class)
    private List<Integer> bookIdList;
    private Double totalPrice;
}
