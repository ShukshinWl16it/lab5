package shukshin.queue;

import java.util.Queue;
import java.util.*;
public class QueueSolution {
    public static Queue<Integer> buildQueueFromList(LinkedList<Integer> list) {
        Queue<Integer> resultQueue = new LinkedList<>();

        resultQueue.addAll(list);

        for (int i = list.size() - 1; i >= 0; i--) {
            resultQueue.add(list.get(i));
        }

        return resultQueue;
    }
    public static void toString(Queue<Integer> queue) {
        System.out.print("[");
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Integer item = queue.poll();
            System.out.print(item);
            queue.add(item);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
