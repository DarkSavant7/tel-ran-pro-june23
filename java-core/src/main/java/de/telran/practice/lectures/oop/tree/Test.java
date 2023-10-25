package de.telran.practice.lectures.oop.tree;

/**
 * Самый дешёвый путь
 * В каждой клетке прямоугольной таблицы N*M записано некоторое число.
 * Изначально игрок находится в левой верхней клетке.
 * За один ход ему разрешается перемещаться в соседнюю клетку либо вправо, либо вниз (влево и вверх перемещаться запрещено).
 * При проходе через клетку игрок платит определенную сумму, какое число записано в этой клетке.
 * Требуется найти минимальную стоимость пути, отдав которую игрок может попасть в правый нижний угол.
 */
public class Test {

  public static void main(String[] args) {

    AnotherBinaryTree tree = new AnotherBinaryTree();

//    System.out.println("Пустое ли дерево? - " + tree.isEmpty());

    tree.add(10, "Node 10");
    tree.add(2, "Node 2");
    tree.add(13, "Node 13");
    tree.add(1, "Node 1");
    tree.add(6, "Node 6");
    tree.add(12, "Node 12");
    tree.add(81, "Node 81");
    tree.add(5, "Node 5");
    TreeUtils.depthInorder(tree);
    System.out.println();
    tree.delete(13);
    TreeUtils.depthInorder(tree);
    tree.delete(1);
    TreeUtils.depthInorder(tree);

//    System.out.println("Пустое ли дерево? - " + tree.isEmpty());

    // 10  2  13  1  6  12  81  5
//    TreeUtils.breadthFirstSearch(tree);

//     1  2  5  6  10  12  13  81
//    TreeUtils.depthInorder(tree);

    // 10  2  1  6  5  13  12  81
//    TreeUtils.depthPreorder(tree);

    // 1  5  6  2  12  81  13  10
//    TreeUtils.depthPostorder(tree);

//    System.out.println(tree.search(12));
//    System.out.println(tree.search(81));
  }
}
