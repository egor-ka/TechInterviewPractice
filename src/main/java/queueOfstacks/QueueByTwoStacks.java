package queueOfstacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Egor on 28-Feb-17.
 */
public class QueueByTwoStacks {
    private Deque<Object> input = new LinkedList<>();
    private Deque<Object> output = new LinkedList<>();

    public void enqueue(Integer element) {
        input.push(element);
    }

    public Object dequeue() {
        if (output.isEmpty()) {
            refillOutput();
            if (output.isEmpty()) {
                return null;
            }
        }
        return output.pop();
    }

    private void refillOutput() {
        while (!input.isEmpty()) {
            output.push(input.pop());
        };
    }
}
