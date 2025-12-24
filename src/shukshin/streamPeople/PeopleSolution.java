package shukshin.streamPeople;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class PeopleSolution {
    public Map<String, List<String>> processFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines()
                    .filter(line -> !line.trim().isEmpty()) // пропускаем пустые строки
                    .map(this::parseLine)
                    .filter(Objects::nonNull) // фильтруем null (людей без номеров)
                    .collect(Collectors.groupingBy(
                            Person::getNumber,
                            Collectors.mapping(
                                    person -> formatName(person.getName()),
                                    Collectors.toList()
                            )
                    ));
        }
    }

    private Person parseLine(String line) {
        String[] parts = line.split(":", 2);

        if (parts.length < 2) {
            return null; // нет номера
        }

        String name = parts[0].trim();
        String number = parts[1].trim();

        if (number.isEmpty()) {
            return null; // номер пустой
        }
        return new Person(name, number);
    }

    private String formatName(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        String lowerName = name.toLowerCase();
        return lowerName.substring(0, 1).toUpperCase() +
                (lowerName.length() > 1 ? lowerName.substring(1) : "");
    }

}
