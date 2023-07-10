package de.telran.practice.lectures.oop.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class PracticeArrays {

  private static final Random random;

  static {
    random = new Random();
  }

  public static void main(String[] args) {
    var arr = createIntArrayWithRandom(100);
    var min = findMin(arr);
    var max = findMax(arr);
    var avg = avgArray(arr);

    System.out.println("ARR:");
    System.out.println(Arrays.toString(arr));
    System.out.println("Min: " + min);
    System.out.println("Max: " + max);
    System.out.println("Avg: " + avg);

    bubbleSort(arr);
    System.out.println("After sort ARR:");
    System.out.println(Arrays.toString(arr));

    int[] arrForRemoving = {1, 2, 3, 1, 2, 3, 1, 2, 3};
    var arrAfterRemoving = removeElement(arrForRemoving, 1);
    System.out.println("\nAfter removing: " + Arrays.toString(arrAfterRemoving));
  }

  public static int binarySearchRecursively(int[] sortedArray, int key) {
    return binarySearchRecursively(sortedArray, key, 0, sortedArray.length);
  }

  public static int binarySearchRecursively
      (int[] sortedArray, int key, int low, int high) {
    int middle = (low + high) / 2; // середина

    if (high < low) { // больше делить нечего
      return -1;
    }

    if (key == sortedArray[middle]) { // если нашёлся
      return middle;
    } else if (key < sortedArray[middle]) { // ищем в левой половине
      return binarySearchRecursively(
          sortedArray, key, low, middle - 1);
    } else {
      return binarySearchRecursively( // ищем в правой половине
          sortedArray, key, middle + 1, high);
    }
  }

  public static int[] removeElement(int[] arr, int val) {
    int offset = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == val) {
        offset++;
      } else {
        arr[i - offset] = arr[i];
      }
    }
    return Arrays.copyOf(arr, arr.length - offset);
  }

  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  public static double avgArray(int[] arr) {
    var sum = sumArray(arr);
    return 1.0 * sum / arr.length;
  }

  public static long sumArray(int[] arr) {
    var sum = 0L;

    for (int i : arr) {
      sum += i;
    }
    return sum;
  }

  public static int findMin(int... arr) {
    int min = arr[0];
    for (int i : arr) {
      if (min > i) {
        min = i;
      }
    }
    return min;
  }

  public static void invertArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 1) {
//                arr[i] = 0;
//            } else {
//                arr[i] = 1;
//            }
//            arr[i] = (arr[i] + 1) % 2;
//            arr[i] ^= 1;
//            arr[i] = arr[i] == 0 ? 1 : 0;
      arr[i] = (arr[i] - 1) * -1;
    }
  }

  //7. **** Написать метод, которому на вход подается одномерный массив
  // и число n (может быть положительным, или отрицательным),
  // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
  // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
  // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) ->  [ 3, 1, 2 ];
  // [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
  // При каком n в какую сторону сдвиг можете выбирать сами.
  public static void shiftLong(int[] arr, int n) {
    int shift = (arr.length + n % arr.length) % arr.length;
    for (int i = 0; i < shift; i++) {
      int temp = arr[arr.length - 1];
      for (int j = arr.length - 1; j > 0; j--) {
        arr[j] = arr[j - 1];
      }
      arr[0] = temp;
    }
  }

  public static void shiftOptimal(int[] arr, int n) {
    if (arr == null || arr.length < 2) {
      return;
    }
    int shift = (arr.length + n % arr.length) % arr.length;
    int count = 0;
    for (int i = 0; count < arr.length; i++) {
      int currentIndex = i;
      int prevElement = arr[i];
      do {
        int nextElement = (currentIndex + shift) % arr.length;
        int temp = arr[nextElement];
        arr[nextElement] = prevElement;
        prevElement = temp;
        currentIndex = nextElement;
        count++;
      } while (i != currentIndex);
    }
  }

  //Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
  // если в массиве есть место, в котором сумма левой и правой части массива равны.
  // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
  // граница показана символами ||, эти символы в массив не входят.
  public static boolean checkBalance(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    if (sum % 2 != 0) {
      return false;
    }

    int half = sum / 2;
    int left = 0;

    for (int i : arr) {
      left += i;
      if (left == half) {
        return true;
      }
    }
    return false;
  }

  public static int findMax(int... arr) {
    int max = arr[0];
    for (int i : arr) {
      if (max < i) {
        max = i;
      }
    }
    return max;
  }

  public static int[] createIntArrayWithRandom(int size) {
    if (size < 0) {
      throw new IllegalArgumentException("Size mustn't be less than zero!");
    }
    var arr = new int[size];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt();
    }
    return arr;
  }

  static class Array2d<T> implements Iterable<T> {

    private T[][] array;

    public Array2d(T[][] array) {
      this.array = array;
    }

    @Override
    public Iterator<T> iterator() {
      return new Iterator<T>() {

        private int i, j;

        @Override
        public boolean hasNext() {
          for (int i = this.i; i < array.length; i++) {
            for (int j = this.j; j < array[i].length; j++) {
              return true;
            }
          }
          return false;
        }

        @Override
        public T next() {
          if (!hasNext()) {
            throw new NoSuchElementException();
          }
          T t = array[i][j];
          j++;
          for (int i = this.i; i < array.length; i++) {
            for (int j = (i == this.i ? this.j : 0); j < array[i].length; j++) {
              this.i = i;
              this.j = j;
              return t;
            }
          }

          return t;
        }
      };
    }
  }

  static class ConcatIterator<T> implements Iterator<T> {

    private Iterator<T> innerIterator1;
    private Iterator<T> innerIterator2;

    public ConcatIterator (Iterator<T> innerIterator1, Iterator<T> innerIterator2) {
      this.innerIterator1 = innerIterator1;
      this.innerIterator2 = innerIterator2;
    }

    @Override
    public boolean hasNext() {
      while (innerIterator1.hasNext()) return true;
      while (innerIterator2.hasNext()) return true;
      return false;
    }

    @Override
    public T next() {
      if(!hasNext())
        throw new NoSuchElementException();

      while (innerIterator1.hasNext()) return innerIterator1.next();
      while (innerIterator2.hasNext()) return innerIterator2.next();
      return null;
    }
  }

}
