package de.telran.practice.lectures.oop.collections;

import de.telran.practice.lectures.oop.farm.Cat;
import java.util.Arrays;

public class ArraysExample {

  public static void main(String[] args) {
//    oneDimensionArrayExample();
//    twoDArraysExample();

    int[][][] arr = new int[3][3][3];
    int[][][] arr1 = {
        {
            {1, 2, 3},
            {1, 1, 1}
        },
        {
            {1, 2, 3, 4},
            {3, 3, 3, 3},
            {}
        },
        {
            {}
        }
    };

    System.out.println(Arrays.deepToString(arr1));

    int[][][][][][][][][][][][][][][][] multyDimensionArray = new int[2][][][][][][][][][][][][][][][];
  }

  private static void twoDArraysExample() {
    //    int[][] arr = new int[2][3];
//    System.out.println(Arrays.deepToString(arr));
    int[][] arr = new int[3][];
    arr[0] = new int[10];
    arr[1] = new int[3];
    arr[2] = new int[5];

    System.out.println(Arrays.deepToString(arr));

    arr[1][0] = 20;
    arr[1][1] = 11;
    arr[1][2] = -5;
    arr[0][4] = 99;
    var cat = new Cat("", "");
    System.out.println(Arrays.deepToString(arr));
    int[][] arr1 = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    System.out.println(Arrays.deepToString(arr1));

    print2dArray(arr1);

    int[][] arr2 = new int[9][9];
    fillDiagonales(arr2, 9);
    print2dArray(arr2);
  }

  private static void fillDiagonales(int[][] arr, int number) {
    for (int y = 0; y < arr.length; y++) {
      arr[y][y] = number;
      arr[y][arr.length - y - 1] = number;
    }
  }


  private static void print2dArray(int[][] arr) {
    System.out.println("==================================");
    for (int y = 0; y < arr.length; y++) {
      for (int x = 0; x < arr[y].length; x++) {
        System.out.print(arr[y][x] + " ");
      }
      System.out.println();
    }
  }

  private static void oneDimensionArrayExample() {
    int[] intArray = new int[10];
    int anotherIntArray[] = new int[10];
    Cat[] catArray = new Cat[10];

    int[] arr = {1, 2, 3, 45};
    System.out.println(arr);
    System.out.println(catArray);
    System.out.println(arr.length);
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(intArray));
    System.out.println(Arrays.toString(catArray));

    System.out.println(arr[3]);
//    System.out.println(arr[4]);
    arr[3] = 98;
    System.out.println(arr[3]);
    arr[3] = 98 - 45;
    System.out.println(arr[3]);
    arr[3] = square(12);
    System.out.println(arr[3]);

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
    System.out.println();
    for (int i : arr) {
      System.out.println(i);
      if (i == 3) {
        break;
      }
    }
  }

  static int square(int number) {
    return number * number;
  }

}
