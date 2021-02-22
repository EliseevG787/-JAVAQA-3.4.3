package ru.netology.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class PurchaseItem {
    private int id;
    private int productId;
    private String productName;
    private int productPrice;
    private int count;
}
