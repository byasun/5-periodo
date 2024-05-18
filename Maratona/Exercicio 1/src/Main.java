import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        // Prompt for the number of sentences
        System.out.println("Enter the number of sentences: ");
        int numSentences = scanner.nextInt();
        scanner.nextLine();

        // Read all sentences into a list
        List<String> sentences = new ArrayList<>();
        for (int i = 0; i < numSentences; i++) {
            System.out.println("Enter sentence " + (i + 1) + ": ");
            sentences.add(scanner.nextLine());
        }

        // Sort each sentence individually
        for (int i = 0; i < sentences.size(); i++) {
            String sentence = sentences.get(i);

            String[] words = sentence.split(" ");
            Arrays.sort(words, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    // Sort from largest to smallest
                    return -1 * (s1.length() - s2.length()); // Reverse size comparison
                }
            });

            StringBuilder reconstructedSentence = new StringBuilder();
            for (String word : words) {
                reconstructedSentence.append(word).append(" ");
            }
            sentences.set(i, reconstructedSentence.toString().trim());
        }

        // Print all sorted sentences
        System.out.println("\nSorted sentences:");
        for (String sentence : sentences) {
            System.out.println(sentence);
        }

        scanner.close();
    }
}
