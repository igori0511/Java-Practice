import com.linkedlist.QueueLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueLinkedListTest {

    private QueueLinkedList<Integer> testQueue;
    private final int NUMBER_OF_TEST_REPETITIONS = 1;

    @BeforeEach
    void init() {
        testQueue = new QueueLinkedList<>();
    }

    @DisplayName("Test enqueue and dequeue with one element")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testEnqueueAndDequeueWithOneElement() {

        final Integer value = 5;
        final Integer expectedValue = 5;
        testQueue.enqueue(value);

        assertEquals(expectedValue, testQueue.dequeue(),
                "Expected value should be equal to " + expectedValue);
        assertTrue(testQueue.empty(), "Queue should be empty");
    }

    @DisplayName("Test enqueue and dequeue with multiple elements")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testEnqueueAndDequeueWithMultipleElements() {

        final int numberOfValues = 5;

        for (Integer i = 0; i < numberOfValues; i++) {
            testQueue.enqueue(i);
        }

        for (Integer i = 0; i < numberOfValues; i++) {
            assertEquals(i, testQueue.dequeue(),
                    "Expected value should be equal to " + i);
        }

        assertTrue(testQueue.empty(), "Queue should be empty");
    }


}
