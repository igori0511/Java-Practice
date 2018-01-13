import com.linkedlist.LinkedList;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {

    private LinkedList<Integer> testList;
    private final int NUMBER_OF_TEST_REPETITIONS = 100;

    @BeforeEach
    void init() {
        testList = new LinkedList<>();
    }

    @DisplayName("Test Initial List Size")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testInitialCapacity() {
        final Integer expectedInitialCapacity = 0;
        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);
    }

    @DisplayName("Test PushFront and PopFront List Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testPushFrontAndPopFrontListOperation() {
        final Integer val = 5;
        final Integer expectedInitialCapacity = 1;
        final Integer expectedCapacityAfterPop = 0;
        testList.pushFront(val);
        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);
        assertEquals(val, testList.popFront(), "List value should be equal to " + val);
        assertEquals(expectedCapacityAfterPop.intValue(), testList.size(),
                "Expected List capacity after pop should equal to " + expectedCapacityAfterPop);
    }

    @DisplayName("Test PushFront and PopBack List Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testPushFrontAndPopBackListOperation() {
        final Integer val = 5;
        final Integer expectedInitialCapacity = 1;
        final Integer expectedCapacityAfterPop = 0;
        testList.pushFront(val);
        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);
        assertEquals(val, testList.popBack(), "List value should be equal to " + val);
        assertEquals(expectedCapacityAfterPop.intValue(), testList.size(),
                "Expected List capacity after pop should equal to " + expectedCapacityAfterPop);
    }

    @DisplayName("Test PushBack and PopFront List Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testPushBackAndPopFrontListOperation() {
        final Integer val = 5;
        final Integer expectedInitialCapacity = 1;
        final Integer expectedCapacityAfterPop = 0;
        testList.pushBack(val);
        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);
        assertEquals(val, testList.popFront(), "List value should be equal to " + val);
        assertEquals(expectedCapacityAfterPop.intValue(), testList.size(),
                "Expected List capacity after pop should equal to " + expectedCapacityAfterPop);
    }

    @DisplayName("Test PushBack and PopBack List Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testPushBackAndPopBackListOperation() {
        final Integer val = 5;
        final Integer expectedInitialCapacity = 1;
        final Integer expectedCapacityAfterPop = 0;
        testList.pushBack(val);
        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);
        assertEquals(val, testList.popBack(), "List value should be equal to " + val);
        assertEquals(expectedCapacityAfterPop.intValue(), testList.size(),
                "Expected List capacity after pop should equal to " + expectedCapacityAfterPop);
    }

    @DisplayName("Test PushFront and PopFront List Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testPushFrontAndPopFrontListOperationsWithMultipleValues() {
        final Integer expectedInitialCapacity = 4;
        final Integer expectedCapacityAfterPop = 0;

        for (int i = 0; i < expectedInitialCapacity; i++) {
            testList.pushFront(i);
        }

        List<Integer> expectedArrayListValues = IntStream.range(0, expectedInitialCapacity)
                .boxed().collect(Collectors.toList());
        Collections.reverse(expectedArrayListValues);
        List<Integer> actualValues = new ArrayList<>();

        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);

        for (int i = 0; i < expectedInitialCapacity; i++) {
            actualValues.add(testList.popFront());
        }

        assertEquals(expectedArrayListValues, actualValues, "ArrayList values don't match");
        assertEquals(expectedCapacityAfterPop.intValue(), testList.size(),
                "Expected List capacity after pop should equal to " + expectedCapacityAfterPop);
    }

    @DisplayName("Test PushFront and PopBack List Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testPushFrontAndPopBackListOperationsWithMultipleValues() {
        final Integer expectedInitialCapacity = 4;
        final Integer expectedCapacityAfterPop = 0;

        for (int i = 0; i < expectedInitialCapacity; i++) {
            testList.pushFront(i);
        }

        List<Integer> expectedArrayListValues = IntStream.range(0, expectedInitialCapacity)
                .boxed().collect(Collectors.toList());
        List<Integer> actualValues = new ArrayList<>();

        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);

        for (int i = 0; i < expectedInitialCapacity; i++) {
            actualValues.add(testList.popBack());
        }

        assertEquals(expectedArrayListValues, actualValues, "ArrayList values don't match");
        assertEquals(expectedCapacityAfterPop.intValue(), testList.size(),
                "Expected List capacity after pop should equal to " + expectedCapacityAfterPop);
    }

    @DisplayName("Test PushBack and PopFront List Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testPushBackAndPopFrontListOperationsWithMultipleValues() {
        final Integer expectedInitialCapacity = 4;
        final Integer expectedCapacityAfterPop = 0;

        for (int i = 0; i < expectedInitialCapacity; i++) {
            testList.pushBack(i);
        }

        List<Integer> expectedArrayListValues = IntStream.range(0, expectedInitialCapacity)
                .boxed().collect(Collectors.toList());
        List<Integer> actualValues = new ArrayList<>();

        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);

        for (int i = 0; i < expectedInitialCapacity; i++) {
            actualValues.add(testList.popFront());
        }

        assertEquals(expectedArrayListValues, actualValues, "ArrayList values don't match");
        assertEquals(expectedCapacityAfterPop.intValue(), testList.size(),
                "Expected List capacity after pop should equal to " + expectedCapacityAfterPop);
    }

    @DisplayName("Test PushBack and PopBack List Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testPushBackAndPopBackListOperationsWithMultipleValues() {
        final Integer expectedInitialCapacity = 4;
        final Integer expectedCapacityAfterPop = 0;

        for (int i = 0; i < expectedInitialCapacity; i++) {
            testList.pushBack(i);
        }

        List<Integer> expectedArrayListValues = IntStream.range(0, expectedInitialCapacity)
                .boxed().collect(Collectors.toList());
        Collections.reverse(expectedArrayListValues);
        List<Integer> actualValues = new ArrayList<>();

        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);

        for (int i = 0; i < expectedInitialCapacity; i++) {
            actualValues.add(testList.popBack());
        }

        assertEquals(expectedArrayListValues, actualValues, "ArrayList values don't match");
        assertEquals(expectedCapacityAfterPop.intValue(), testList.size(),
                "Expected List capacity after pop should equal to " + expectedCapacityAfterPop);
    }

    @DisplayName("Test front method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testFrontMethod() {
        final Integer expectedInitialCapacity = 4;
        final Integer expectedFrontElement = 0;

        for (int i = 0; i < expectedInitialCapacity; i++) {
            testList.pushBack(i);
        }

        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);
        assertEquals(expectedFrontElement, testList.front(),
                "Expected list front element should be equal to " + expectedFrontElement);

    }

    @DisplayName("Test back method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testBackMethod() {
        final Integer expectedInitialCapacity = 4;
        final Integer expectedBackElement = 3;

        for (int i = 0; i < expectedInitialCapacity; i++) {
            testList.pushBack(i);
        }

        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);
        assertEquals(expectedBackElement, testList.back(),
                "Expected list front element should be equal to " + expectedBackElement);
    }

    @DisplayName("Test ValueAt method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testValueAt() {
        final Integer expectedInitialCapacity = 4;
        final Integer expectedBackElement = 3;

        for (int i = 0; i < expectedInitialCapacity; i++) {
            testList.pushBack(i);
        }

        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);
        assertEquals(expectedBackElement, testList.valueAt(expectedInitialCapacity - 1),
                "Expected list front element should be equal to " + expectedBackElement);
    }

    @DisplayName("Test Insert method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testInsert() {
        final Integer index = 1;
        final Integer expectedInitialCapacity = 4;
        final Integer expectedCapacityAfterInsert = expectedInitialCapacity + index;
        final Integer valueToBeInserted = 6;

        for (int i = 0; i < expectedInitialCapacity; i++) {
            testList.pushBack(i);
        }

        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);

        testList.insert(index, valueToBeInserted);

        assertEquals(testList.valueAt(index), valueToBeInserted, "Value in array list at index " + index + " don't match");
        assertEquals(expectedCapacityAfterInsert.intValue(), testList.size(),
                "Expected List capacity after insert should equal to " + expectedCapacityAfterInsert);
    }

    @DisplayName("Test Erase method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testErase() {
        final Integer index = 1;
        final Integer expectedInitialCapacity = 4;
        final Integer expectedCapacityAfterInsert = expectedInitialCapacity - index;
        final Integer expectedValueAtIndex = 2;

        for (int i = 0; i < expectedInitialCapacity; i++) {
            testList.pushBack(i);
        }

        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);

        testList.erase(index);

        assertEquals(expectedValueAtIndex, testList.valueAt(index), "Value in array list at index " + index + " don't match");
        assertEquals(expectedCapacityAfterInsert.intValue(), testList.size(),
                "Expected List capacity after insert should equal to " + expectedCapacityAfterInsert);
    }

    @DisplayName("Test valueNFromEnd method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testValueNFromEnd() {
        final Integer index = 1;
        final Integer expectedInitialCapacity = 4;
        final Integer expectedCapacityAfterInsert = expectedInitialCapacity - index;
        final Integer expectedValueAtIndex = 2;

        for (int i = 0; i < expectedInitialCapacity; i++) {
            testList.pushBack(i);
        }

        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);

        assertEquals(expectedValueAtIndex, testList.valueNFromEnd(index), "Value in array list at index " + index + " don't match");
        assertEquals(expectedCapacityAfterInsert.intValue(), testList.size(),
                "Expected List capacity after insert should equal to " + expectedCapacityAfterInsert);
    }

    @DisplayName("Test LinkedList reverse operation pop front")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testReverse() {
        final Integer expectedInitialCapacity = 4;
        final Integer expectedCapacityAfterPop = 0;

        for (int i = 0; i < expectedInitialCapacity; i++) {
            testList.pushBack(i);
        }

        List<Integer> expectedArrayListValues = IntStream.range(0, expectedInitialCapacity)
                .boxed().collect(Collectors.toList());
        Collections.reverse(expectedArrayListValues);
        List<Integer> actualValues = new ArrayList<>();

        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);

        testList.reverse();

        for (int i = 0; i < expectedInitialCapacity; i++) {
            actualValues.add(testList.popFront());
        }

        assertEquals(expectedArrayListValues, actualValues, "ArrayList values don't match");
        assertEquals(expectedCapacityAfterPop.intValue(), testList.size(),
                "Expected List capacity after pop should equal to " + expectedCapacityAfterPop);
    }

    @DisplayName("Test LinkedList reverse operation pop back")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testReversePopBack() {
        final Integer expectedInitialCapacity = 4;
        final Integer expectedCapacityAfterPop = 0;

        for (int i = 0; i < expectedInitialCapacity; i++) {
            testList.pushBack(i);
        }

        List<Integer> expectedArrayListValues = IntStream.range(0, expectedInitialCapacity)
                .boxed().collect(Collectors.toList());
        List<Integer> actualValues = new ArrayList<>();

        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);

        testList.reverse();

        for (int i = 0; i < expectedInitialCapacity; i++) {
            actualValues.add(testList.popBack());
        }

        assertEquals(expectedArrayListValues, actualValues, "ArrayList values don't match");
        assertEquals(expectedCapacityAfterPop.intValue(), testList.size(),
                "Expected List capacity after pop should equal to " + expectedCapacityAfterPop);
    }

    @DisplayName("Test LinkedList remove value operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testRemoveValue() {
        final Integer index = 1;
        final Integer valueToRemove = 1;
        final Integer expectedInitialCapacity = 4;
        final Integer expectedCapacityAfterInsert = expectedInitialCapacity - index;
        final Integer expectedValueAtIndex = 2;

        for (int i = 0; i < expectedInitialCapacity; i++) {
            testList.pushBack(i);
        }

        assertEquals(expectedInitialCapacity.intValue(), testList.size(),
                "List capacity should equal to " + expectedInitialCapacity);

        testList.removeValue(valueToRemove);

        assertEquals(expectedValueAtIndex, testList.valueAt(index), "Value in array list at index " + index + " don't match");
        assertEquals(expectedCapacityAfterInsert.intValue(), testList.size(),
                "Expected List capacity after insert should equal to " + expectedCapacityAfterInsert);
    }
}
