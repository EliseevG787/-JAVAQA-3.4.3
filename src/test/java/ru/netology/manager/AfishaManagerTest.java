package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    AfishaManager manager = new AfishaManager();
    AfishaItem first = new AfishaItem(1, 1, "first", 1, 1);
    AfishaItem second = new AfishaItem(2, 2, "second", 1, 1);
    AfishaItem third = new AfishaItem(3, 3, "third", 1, 1);
    AfishaItem fourth = new AfishaItem(4, 4, "fourth", 1, 1);
    AfishaItem fifth = new AfishaItem(5, 5, "fifth", 1, 1);
    AfishaItem sixth = new AfishaItem(6, 6, "sixth", 1, 1);
    AfishaItem seventh = new AfishaItem(7, 7, "seventh", 1, 1);
    AfishaItem eighth = new AfishaItem(8, 8, "eighth", 1, 1);
    AfishaItem ninth = new AfishaItem(9, 9, "ninth", 1, 1);
    AfishaItem tenth = new AfishaItem(10, 10, "tenth", 1, 1);
    AfishaItem eleven = new AfishaItem(11, 11, "eleven", 1, 1);
    @Test
    public void shouldGetLatestIfEmpty() {
        AfishaItem[] actual = manager.getLatest();
        AfishaItem[] expected = new AfishaItem[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLatestIfOneItem() {
        manager.add(first);

        AfishaItem[] actual = manager.getLatest();
        AfishaItem[] expected = new AfishaItem[]{first};

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

        AfishaItem[] actual = manager.getLatest();
        AfishaItem[] expected = new AfishaItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

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

        AfishaItem[] actual = manager.getLatest();
        AfishaItem[] expected = new AfishaItem[]{eleven, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLatestIfNumberLessLength() {
        AfishaManager manager = new AfishaManager(3);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        AfishaItem[] actual = manager.getLatest();
        AfishaItem[] expected = new AfishaItem[]{fourth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLatestIfNumberMoreLength() {
        AfishaManager manager = new AfishaManager(15);

        manager.add(first);
        manager.add(second);

        AfishaItem[] actual = manager.getLatest();
        AfishaItem[] expected = new AfishaItem[]{second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLatestIfNumberLessThanNull() {
        AfishaManager manager = new AfishaManager(-2);

        manager.add(first);

        AfishaItem[] actual = manager.getLatest();
        AfishaItem[] expected = new AfishaItem[]{first};

        assertArrayEquals(expected, actual);
    }
}