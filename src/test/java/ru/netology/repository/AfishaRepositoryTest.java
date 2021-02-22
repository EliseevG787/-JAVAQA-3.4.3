package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    AfishaRepository repository = new AfishaRepository();
    PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
    PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
    PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
    PurchaseItem fourth = new PurchaseItem(4, 4, "fourth", 1, 1);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    void shouldSave() {
        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = {first, second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        repository.save(fourth);

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third, fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        PurchaseItem actual = repository.findById(2);
        assertEquals(second, actual);
    }

    @Test
    void shouldFindByNotExistId() {
        PurchaseItem actual = repository.findById(5);
        assertEquals(null, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(1);
        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{second, third};
        assertArrayEquals(expected, actual);
    }
}