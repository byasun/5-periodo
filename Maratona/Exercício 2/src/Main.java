import java.util.Scanner;
import java.io.IOException;

/**
 * IMPORTANT:
 * O nome da classe deve ser "Main" para que a sua solução execute
 * Class name must be "Main" for your solution to execute
 * El nombre de la clase debe ser "Main" para que su solución ejecutar
 */

class Element {
  int id;
  Element prev;
  Element next;

  public Element(int id) {
    this.id = id;
  }
}

public class Main {

  static Element fill(int size) {
    Element node = null;
    Element start = null;
    Element prevNode = null;

    for (int i = 1; i <= size; ++i) {
      node = new Element(i);

      if (start == null)
        start = node;
      else {
        prevNode.next = node;
        node.prev = prevNode;
      }

      prevNode = node;
    }

    start.prev = prevNode;
    prevNode.next = start;

    return start;
  }

  static Element delete(Element list, Element reg) {
    Element prevNode = reg.prev;
    Element nextNode = reg.next;

    if (reg == list) {
      list = list.next;
      prevNode.next = list;
      list.prev = reg.prev;
    } else {
      prevNode.next = nextNode;
      nextNode.prev = prevNode;
    }

    return list;
  }

  static int count(Element list) {
    int i = 1;
    Element node = list;
    while (list != node.next) {
      node = node.next;
      i++;
    }
    return i;
  }

  static Element traverse(Element list, int n, int direction) {
    Element node = list;
    if (direction == 0)
      while (--n > 0)
        node = node.next;
    else
      while (--n > 0)
        node = node.prev;

    return node;
  }

  public static void main(String[] args) throws IOException {

    /**
     * Escreva a sua solução aqui
     * Code your solution here
     * Escriba su solución aquí
     */

    Scanner scan = new Scanner(System.in);
    int n, k, m;
    Element list, K, M, auxK, auxM;

    while ((n = scan.nextInt()) != 0) {
      k = scan.nextInt();
      m = scan.nextInt();

      list = fill(n);
      K = list;
      M = list.prev;

      while (count(list) > 2) {
        K = traverse(K, k, 0);
        M = traverse(M, m, 1);

        if (K.next == M)
          auxK = M.next;
        else
          auxK = K.next;

        if (M.prev == K)
          auxM = K.prev;
        else
          auxM = M.prev;

        if (K == M) {
          System.out.printf("%3d,", M.id);
          list = delete(list, K);
        } else {
          System.out.printf("%3d%3d,", K.id, M.id);
          list = delete(list, M);
          list = delete(list, K);
        }

        K = auxK;
        M = auxM;
      }

      if (count(list) == 2) {
        K = traverse(K, k, 0);
        M = traverse(M, m, 1);

        if (K == M)
          System.out.printf("%3d,%3d\n", K.id, K.next.id);
        else
          System.out.printf("%3d%3d\n", K.id, K.next.id);
      } else
        System.out.printf("%3d\n", list.id);
    }
    scan.close();
  }

}