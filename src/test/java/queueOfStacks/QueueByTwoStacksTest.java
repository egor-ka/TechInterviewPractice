package queueOfStacks;

import org.junit.Assert;
import org.junit.Test;
import queueOfstacks.QueueByTwoStacks;

/**
 * Created by Egor on 28-Feb-17.
 */
public class QueueByTwoStacksTest {

    QueueByTwoStacks queue = new QueueByTwoStacks();

    @Test
    public void testInputAndOutput() {
        queue.enqueue(1);
        queue.enqueue(2);
        Assert.assertEquals(1, queue.dequeue());
        queue.enqueue(3);
        queue.enqueue(4);
        Assert.assertEquals(2, queue.dequeue());
        Assert.assertEquals(3, queue.dequeue());
        Assert.assertEquals(4, queue.dequeue());
        Assert.assertEquals(null, queue.dequeue());
    }
}
