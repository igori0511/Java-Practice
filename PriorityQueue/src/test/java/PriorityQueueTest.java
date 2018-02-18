import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.Assert.assertEquals;


public class PriorityQueueTest {

    private PriorityQueue<Integer> priorityQueue;
    private int capacity = 5;
    private final int NUMBER_OF_TEST_REPETITIONS = 10;

    @BeforeEach
    void init() {
        priorityQueue = new PriorityQueue<>(capacity);
    }

    @DisplayName("Test initial size of pq")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testInitialCapacity() {
        final int expectedCapacity = 2;
        priorityQueue.insert(1);
        priorityQueue.insert(34);

        assertEquals("Queue size is wrong", expectedCapacity, priorityQueue.getSize());
    }
}
