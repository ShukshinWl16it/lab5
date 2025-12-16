package shukshin.streamPeople;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class PeopleSolution {
    private List<String> readFileLines(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        }

        return lines;
    }

    public Map<Integer, List<String>> processFile(String fileName) throws IOException {
        List<String> lines = readFileLines(fileName);

        return lines.stream()
                .filter(line -> line.contains(":"))
                .map(line -> line.split(":", 2))
                .filter(parts -> parts.length == 2 && !parts[1].trim().isEmpty())
                .collect(Collectors.groupingBy(
                        parts -> Integer.parseInt(parts[1].trim()),
                        Collectors.mapping(
                                parts -> formatName(parts[0].trim()),
                                Collectors.toList()
                        )
                ));
    }

    private String formatName(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        String lowerName = name.toLowerCase();
        return lowerName.substring(0, 1).toUpperCase() +
                lowerName.substring(1);
    }

}
