package shukshin.main;
import java.io.*;

import java.util.*;

import shukshin.cat.Cat;
import shukshin.cat.CountingMeowable;
import shukshin.cat.Funs;
import shukshin.list.ListSolution;
import shukshin.map.SolutionMap;
import shukshin.set.SetSolution;
import shukshin.queue.QueueSolution;
import shukshin.streamPoint.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1: Дробь ");
            System.out.println("2: Кот");
            System.out.println("3: Список №4");
            System.out.println("4: Мап №6");
            System.out.println("5: Сет №8");
            System.out.println("6: Очередь №2");
            System.out.println("7: Стрим №1");
            System.out.println("8: Стрим №2");
            System.out.println("0: Выход");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    break;
                case 2:
                    Cat cat=new Cat("Барсик");
                    System.out.println("Создан: " + cat.toString());
                    CountingMeowable m = new CountingMeowable(cat);
                    Funs.meowsCare(m);
                    System.out.println("кот мяукал " + m.getMeowCount() + " раз");
                    break;
                case 3:
                    List<Integer> L = new ArrayList<>(List.of(1, 2, 3, 4, 5));
                    System.out.println("L=" +L);
                    System.out.print("Введите элемент E (целое число): ");
                    int E = scanner.nextInt();
                    List<Integer> result = ListSolution.insertAfterFirst(L, E, L);
                    System.out.println("Результат: " + result);
                    break;
                case 4:
                    SolutionMap solution = new SolutionMap();
                    try {
                        // Читаем данные из файла
                        solution.readDataFromFile("stud.txt");
                        // Выводим результаты
                        solution.printResults();
                    } catch (FileNotFoundException e) {
                        System.out.println("Убедитесь, что файл 'stud.txt' существует в текущей директории.");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    SetSolution sol1 = new SetSolution();// Имя файла с текстом
                    try {
                        String text = sol1.readFile("text.txt");
                        System.out.println("Текст из файла: " + text);
                        // Подсчет отсутствующих букв
                        int missingCount = SetSolution.analyzeText(text);
                        System.out.println("Результат: " + missingCount + " букв русского алфавита не встречается в этом тексте.");
                    } catch (FileNotFoundException e) {
                        System.out.println("Убедитесь, что файл 'text.txt' существует в текущей директории.");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 6:
                    QueueSolution sol2 = new QueueSolution();
                    LinkedList<Integer> list = new  LinkedList<>(List.of(1, 2, 3));
                    Queue<Integer> queue = sol2.buildQueueFromList(list);
                    System.out.println("Исходный список: " + list);
                    System.out.print("Результирующая очередь: ");
                    sol2.toString(queue);
                    break;
                case 7:
                    List<Point> points = Arrays.asList(
                        new Point(1, -2),
                        new Point(5, 4),
                        new Point(1, -2), // Дубликат - должен быть удален
                        new Point(2, -5),
                        new Point(5, 4),  // Дубликат - должен быть удален
                        new Point(-1, 3),
                        new Point(5, 1),
                        new Point(0, -3)
                    );
                    Polyline polyline=Polyline.createPolyline(points);
                    System.out.println("Исходные точки: " + points);
                    System.out.println("Результирующая полилиния: " + polyline);

                    break;
                case 8:
                    break;
            }
        }while(choice!=0);
    }
}