package shukshin.map;
import java.util.*;
import java.io.*;
public class SolutionMap {
    private Map<String, int[]> students;
    private List<String> admitted;

    public SolutionMap() {
        this.students = new HashMap<>();
        this.admitted = new ArrayList<>();
    }

    public void readDataFromFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println("Чтение данных " + n + " абитуриентов");

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] parts = line.split(" ");
                if (parts.length != 5) {
                    continue;
                }

                String surname = parts[0];
                String name = parts[1];
                String fullName = surname + " " + name;

                int[] scores = new int[3];
                scores[0] = Integer.parseInt(parts[2]);
                scores[1] = Integer.parseInt(parts[3]);
                scores[2] = Integer.parseInt(parts[4]);
                students.put(fullName, scores);

                if (isAdmitted(scores)) {
                    admitted.add(fullName); // проверяем условия допуска
                }
            }
        }

    }

    private boolean isAdmitted(int[] scores) {
        return scores[0] >= 30 && scores[1] >= 30 && scores[2] >= 30 && (scores[0] + scores[1] + scores[2]) >= 140;
    }
    public void printResults() {
        System.out.println("Результаты тестирования:");
        System.out.println("Всего абитуриентов: " + students.size());
        System.out.println("Допущено к первому потоку: " + admitted.size());

        if (admitted.isEmpty()) {
            System.out.println("Нет допущенных абитуриентов.");
        } else {
            System.out.println("Допущенные абитуриенты:");
            for (String fullName : admitted) {
                int[] scores = students.get(fullName);
                int total = scores[0] + scores[1] + scores[2];
                System.out.println(fullName + " | Баллы: "+ scores[0] +" "+ scores[1]+" " + scores[2] + " | Общая сумма: " + total);
            }
        }
    }
}
