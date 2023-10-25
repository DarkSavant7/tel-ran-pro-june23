package de.telran.practice.lectures.oop.maps;

import java.util.HashMap;
import java.util.Map;

public class ArraysComparator {

  /*
Проверьте, равны ли два массива или нет
Учитывая два массива, arr1 и arr2 одинаковой длины N, задача состоит в том, чтобы определить, равны ли данные массивы
или нет.

Два массива называются равными, если:
оба они содержат один и тот же набор элементов,
расположение (или перестановки) элементов может/не может быть одинаковым.
Если есть повторения, то количество повторяющихся элементов также должно быть одинаковым, чтобы два массива были равны.

Ввод: arr1[] = {1, 2, 5, 4, 0}, arr2[] = {2, 4, 5, 0, 1}
Вывод: Да
 */

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 5, 4, 0};
    int[] arr2 = {2, 4, 5, 0, 1};

    System.out.println(areArraysEqual(arr2, arr1));
  }

  private static boolean areArraysEqual(int[] arr2, int[] arr1) {
    if (arr2.length != arr1.length) {
      return false;
    }
    Map<Integer, Integer> map = new HashMap<>();

    for (int i : arr1) {
      map.merge(i, 1, Integer::sum);
    }

    for (int i : arr2) {
      Integer value = map.get(i);
      if (value == null || value == 0) {
        return false;
      }
      map.put(i, --value);
    }
    return true;
  }
}
