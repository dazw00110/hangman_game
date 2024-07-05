package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    ArrayList<String> words = new ArrayList<>(Arrays.asList("laptop", "internet", "program", "house"));

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(words.size());
        String word = words.get(number);
        System.out.println("Word to guess: " + word);

        int length = word.length();
        char[] tab = new char[length];
        Arrays.fill(tab, '_');

        int chances = 5;

        System.out.println("Try to guess the word");

        do {
            for (int i = 0; i < length; i++) {
                System.out.print(tab[i] + " ");
            }
            System.out.println("\nType your character");
            String character = scanner.nextLine();
            if (character.length() != 1) {
                System.out.println("You have to type only 1 char\nTry again");
                continue;
            }

            char guess = character.charAt(0);
            boolean guessed = false;
            for (int i = 0; i < length; i++) {
                if (word.charAt(i) == guess && tab[i] == '_') {
                    tab[i] = guess;
                    guessed = true;
                }
            }
            if (guessed) {
                System.out.println("Good job! There is '" + guess + "' in the word.");
            } else {
                System.out.println("Incorrect guess! '" + guess + "' is not in the word.");
                chances--;
                System.out.println("You have " + chances + " chances left.");
            }

        } while (!new String(tab).equals(word) && chances > 0);

        // Wyświetl pełne słowo po zakończeniu gry
        System.out.print("The word was: ");
        for (int i = 0; i < length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();

        if (new String(tab).equals(word)) {
            System.out.println("Congratulations! You guessed the word: " + word);
        } else {
            System.out.println("Game over! You ran out of chances. The word was: " + word);
        }

        scanner.close();
    }


}
