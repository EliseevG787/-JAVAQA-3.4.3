package ru.netology.manager;

import ru.netology.domain.AfishaItem;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AfishaManager {
    private AfishaItem[] items = new AfishaItem[0];
    private int number = 10;

    public AfishaManager(int number) {
        if (number >= 0) {
            this.number = number;
        }
    }

    public void add(AfishaItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        AfishaItem[] tmp = new AfishaItem[length];
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

    public AfishaItem[] getLatest() {
        int count = 0;
        if (number < items.length) {
            count = number;
        } else {
            count = items.length;
        }
        AfishaItem[] result = new AfishaItem[count];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}

