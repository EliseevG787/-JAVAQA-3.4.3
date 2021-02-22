package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
    private PurchaseItem first = new PurchaseItem(1, 1, "first", 100, 2);
    private PurchaseItem second = new PurchaseItem(2, 2, "second", 10, 1);
    private PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 2);

    @Test
    public void shouldGetAll() {
        // настройка заглушки
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third};
        doReturn(returned).when(repository).findAll();

        PurchaseItem[] expected = new PurchaseItem[]{third, second, first};
        PurchaseItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана
        // но это уже проверка "внутренней" реализации
        verify(repository).findAll();
    }

    @Test
    public void shouldAdd() {
        // настройка заглушки
        PurchaseItem[] returned = new PurchaseItem[]{first, second};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(third);
        manager.add(third);
        PurchaseItem[] expected = new PurchaseItem[]{second, first};
        PurchaseItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана
        // но это уже проверка "внутренней" реализации
        verify(repository).findAll();
    }


    @Test
    public void shouldRemoveById() {
        // настройка заглушки
        PurchaseItem[] returned = new PurchaseItem[]{first, second};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(1);
        manager.removeById(1);
        PurchaseItem[] expected = new PurchaseItem[]{second, first};
        PurchaseItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана
        // но это уже проверка "внутренней" реализации
        verify(repository).findAll();
    }
}