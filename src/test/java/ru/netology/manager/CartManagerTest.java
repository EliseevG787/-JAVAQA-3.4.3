package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

class CartManagerTest {
    CartManager manager = new CartManager();
    PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
    PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
    PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
    PurchaseItem fourth = new PurchaseItem(4, 4, "fourth", 1, 1);
    PurchaseItem fifth = new PurchaseItem(5, 5, "fifth", 1, 1);
    PurchaseItem sixth = new PurchaseItem(6, 6, "sixth", 1, 1);
    PurchaseItem seventh = new PurchaseItem(7, 7, "seventh", 1, 1);
    PurchaseItem eighth = new PurchaseItem(8, 8, "eighth", 1, 1);
    PurchaseItem ninth = new PurchaseItem(9, 9, "ninth", 1, 1);
    PurchaseItem tenth = new PurchaseItem(10, 10, "tenth", 1, 1);
    PurchaseItem eleven = new PurchaseItem(11, 11, "eleven", 1, 1);
    @Test
    public void shouldGetLatestIfEmpty() {
        PurchaseItem[] actual = manager.getLatest();
        PurchaseItem[] expected = new PurchaseItem[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLatestIfOneItem() {
        manager.add(first);

        PurchaseItem[] actual = manager.getLatest();
        PurchaseItem[] expected = new PurchaseItem[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLatestIfTenItems() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        PurchaseItem[] actual = manager.getLatest();
        PurchaseItem[] expected = new PurchaseItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLatestIfMoreThanTenItems() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleven);

        PurchaseItem[] actual = manager.getLatest();
        PurchaseItem[] expected = new PurchaseItem[]{eleven, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLatestIfNumberLessLength() {
        CartManager manager = new CartManager(3);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        PurchaseItem[] actual = manager.getLatest();
        PurchaseItem[] expected = new PurchaseItem[]{fourth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLatestIfNumberMoreLength() {
        CartManager manager = new CartManager(15);

        manager.add(first);
        manager.add(second);

        PurchaseItem[] actual = manager.getLatest();
        PurchaseItem[] expected = new PurchaseItem[]{second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLatestIfNumberLessThanNull() {
        CartManager manager = new CartManager(-2);

        manager.add(first);

        PurchaseItem[] actual = manager.getLatest();
        PurchaseItem[] expected = new PurchaseItem[]{first};

        assertArrayEquals(expected, actual);
    }
}