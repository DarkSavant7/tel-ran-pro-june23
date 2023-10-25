package de.telran.practice.lectures.exception;

public class ArraySummator {

  //Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
  // При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
  //Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
  // Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
  // должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
  //В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
  // и вывести результат расчета.
  public static final int SIZE = 4;

  public static int sum(String[][] arr) {
    if (arr == null) {
      //.....
      throw new NullPointerException("You've given null instead array!");
    }
    if (arr.length != SIZE) {
      throw new MyArraySizeException("We can work only with 4x4 array!");
    }

    for (String[] strings : arr) {
      if (strings.length != SIZE) {
        throw new MyArraySizeException("We can work only with 4x4 array!");
      }
    }

    int sum = 0;

    for (int y = 0; y < arr.length; y++) {
      for (int x = 0; x < arr[y].length; x++) {
        try {
          sum += Integer.parseInt(arr[y][x]);
        } catch (NumberFormatException e) {
          var message = String.format("Not a number in the cell [%d][%d]. Data: [%s]%n", x + 1,
              y + 1, arr[y][x]);
          throw new MyArrayDataException(message);
        }
      }
    }
    return sum;
  }

}
