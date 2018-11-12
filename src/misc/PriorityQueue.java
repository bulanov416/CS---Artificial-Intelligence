package misc;
import java.util.ArrayList;

public class PriorityQueue {

    public ArrayList<PriorityQueueObject> priorityQueue;

    public static void main(String[] args) {

        PriorityQueue pq = new PriorityQueue();
        pq.add(1,"hi");
        pq.add(5, "test");
        pq.add(3,"this");

        pq.printQueue();
        System.out.println();
        pq.peek();
    }

    public PriorityQueue() {
         priorityQueue = new ArrayList<PriorityQueueObject>();
    }

    public void queueSort() {
        for (int i = 0; i < priorityQueue.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < priorityQueue.size(); j++)
                if (priorityQueue.get(j).priority < priorityQueue.get(index).priority)
                    index = j;

            PriorityQueueObject temp = priorityQueue.get(index);
            priorityQueue.set(index, priorityQueue.get(i));
            priorityQueue.set(i, temp);
        }
    }

    public void add(double priority, String data) {
        priorityQueue.add( new PriorityQueueObject(priority, data) );
        queueSort();
    }

    public void remove() {
        priorityQueue.remove(0);
    }

    public void peek() {
        priorityQueue.get(0);
    }

    public void printQueue() {
        for (int i = 0; i < priorityQueue.size(); i++) {
            System.out.println("Priority: " + priorityQueue.get(i).priority + "        " + "Value: " + priorityQueue.get(i).value);
        }
    }

    public class PriorityQueueObject {

        double priority;
        String value;

        public PriorityQueueObject(double prio, String val) {
            priority = prio;
            value = val;
        }

        public void changePriority(double newPriority) {
            priority = newPriority;
        }

        public void changeValue(String newValue) {
            value = newValue;
        }
    }
}




