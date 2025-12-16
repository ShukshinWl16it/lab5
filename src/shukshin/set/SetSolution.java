package shukshin.set;

import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.nio.file.*;
import java.io.*;

public class SetSolution {

    private static boolean isRussianLetter(char c) {
        return (c >= 'а' && c <= 'я') || c == 'ё';
    }

    public static int analyzeText(String text) {
        System.out.println("=== Анализ текста из файла ===");
        System.out.println("Длина текста: " + text.length() + " символов");

        String lowerText = text.toLowerCase();

        char[] russianAlphabet = {
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й',
                'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
                'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'
        };

        // Множество для найденных букв
        Set<Character> foundLetters = new HashSet<>();

        for (char c : lowerText.toCharArray()) {
            if (isRussianLetter(c)) {
                foundLetters.add(c);
            }
        }
        List<Character> present = new ArrayList<>();//встречаются
        List<Character> missing = new ArrayList<>();//не встречаются

        for (char letter : russianAlphabet) {
            if (foundLetters.contains(letter)) {
                present.add(letter);
            } else {
                missing.add(letter);
            }
        }
        toString("Встречающиеся буквы", present);
        toString("Не встречающиеся буквы", missing);
        return missing.size();
    }
    private static void toString(String title, List<Character> letters) {
        System.out.println(title);

        if (letters.isEmpty()) {
            System.out.println("(нет)");
            return;
        }

        for (int i = 0; i < letters.size(); i++) {
            System.out.print(letters.get(i));
            if (i < letters.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    public static String readFile(String fileName) throws IOException {
        StringBuilder textBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textBuilder.append(line).append(" ");
            }
        }

        return textBuilder.toString();
    }
}
