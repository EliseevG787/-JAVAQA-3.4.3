package ru.netology.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class AfishaItem {
    private int id;
    private int productId;
    private String productName;
    private int productPrice;
    private int count;
}
