package ru.netology.manager;

import ru.netology.domain.PurchaseItem;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CartManager {
    private PurchaseItem[] items = new PurchaseItem[0];
    private int number = 10;

    public CartManager(int number) {
        if (number >= 0) {
            this.number = number;
        }
    }

    public void add(PurchaseItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] getLatest() {
        int count = 0;
        if (number < items.length) {
            count = number;
        } else {
            count = items.length;
        }
        PurchaseItem[] result = new PurchaseItem[count];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}

