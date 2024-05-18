import java.util.Arrays;
import java.util.Scanner;

/**
 * IMPORTANT:
 *   Class name must be "Main" for your solution to execute
 *   El nombre de la clase debe ser "Main" para que su solución ejecutar
 */


class Texto implements Comparable<Texto> {
    String prim;

    public Texto(String prim) {
        this.prim = prim;
    }

    public int compareTo(Texto outro) {
        return this.prim.compareTo(outro.prim);
    }
}

public class Main {
    /**
     * Escreva a sua solução aqui
     * Code your solution here
     * Escriba su solución aquí
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()) {
            int quantidade = scan.nextInt();
            scan.nextLine(); // Consumes newline character after integer

            Texto[] textos = new Texto[quantidade];
            for (int i = 0; i < quantidade; i++) {
                String prim = scan.nextLine(); // String content stored in "prim"
                textos[i] = new Texto(prim);
            }

            Arrays.sort(textos);

            int contador = 0;
            for (int i = 1; i < quantidade; i++) {
                String primAtual = textos[i].prim;
                String primAnterior = textos[i - 1].prim;
                int tamanhoMinimo = Math.min(primAtual.length(), primAnterior.length());
                for (int j = 0; j < tamanhoMinimo; j++) {
                    if (primAtual.charAt(j) == primAnterior.charAt(j)) {
                        contador++;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(contador);
        }

        scan.close();
    }
}
