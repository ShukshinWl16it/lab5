package shukshin.list;

import java.util.ArrayList;
import java.util.List;

public class ListSolution {
    public static List<Integer> insertAfterFirst(List<Integer> L, int E, List<Integer> L1) {
        List<Integer> result = new ArrayList<>();
        boolean found = false;

        for (int i = 0; i < L.size(); i++) {
            result.add(L.get(i));
            if (!found && L.get(i) == E) {
                result.addAll(L1); // вставляем весь список L
                found = true;
            }
        }
        return result;
    }
    public static String ToString(List<Integer> list) {
        // возвращаем стандартное представление
        return list == null ? "null" : list.toString();
    }
}



