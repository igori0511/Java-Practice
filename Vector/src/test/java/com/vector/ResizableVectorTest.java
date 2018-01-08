package com.vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResizableVectorTest {

    private ResizableVector<Integer> testVector;
    private final int NUMBER_OF_TEST_REPETITIONS = 1000;

    @BeforeEach
    void init() {
        testVector = new ResizableVector<Integer>();
    }

    @DisplayName("Test Initial Vector Capacity")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    @Test
    void testInitialCapacity() {
        final int expectedInitialCapacity = 2;
        assertEquals(expectedInitialCapacity, testVector.capacity());
    }

    @DisplayName("Test Initial Size")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    @Test
    void testInitialSize() {
        final int expectedInitialSize = 0;
        assertEquals(expectedInitialSize, testVector.size());
    }

    @DisplayName("Test Vector Empty")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    @Test
    void testVectorEmpty() {
        assertTrue(testVector.size() == 0, "Vector size should be equal to zero");
    }

    @DisplayName("Test Push Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    @Test
    void testPushOperation() {
        final int expectedValue = 5;
        final int expectedSize = 1;
        final int expectedCapacity = 2;

        testVector.push(expectedValue);
        assertEquals((Object) testVector.at(0), expectedValue, "Value at index zero should be equal to" + expectedValue);
        assertEquals(testVector.size(), expectedSize, "Expected size should be equal to " + expectedSize);
        assertEquals(testVector.capacity(), expectedCapacity, "Expected capacity should be equal to " + expectedCapacity);
    }

    @DisplayName("Test pop Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    @Test
    void testPopOperation() {
        final int expectedValue = 5;
        final int expectedSize = 0;
        final int expectedCapacity = 1;

        testVector.push(expectedValue);

        assertEquals((Object) testVector.pop(), expectedValue, "Value at index zero should be equal to" + expectedValue);
        assertEquals(testVector.size(), expectedSize, "Expected size should be equal to " + expectedSize);
        assertEquals(testVector.capacity(), expectedCapacity, "Expected capacity should be equal to " + expectedCapacity);
    }

    @DisplayName("Test insert Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    @Test
    void testInsertOperation() {
        final int expectedValue = 5;
        final int expectedSize = 1;
        final int expectedCapacity = 1;

        testVector.insert(0, expectedValue);
        assertEquals(testVector.size(), expectedSize, "Expected size should be equal to " + expectedSize);
        assertEquals((Object) testVector.pop(), expectedValue, "Value at index zero should be equal to" + expectedValue);
        assertEquals(testVector.capacity(), expectedCapacity, "Expected capacity should be equal to " + expectedCapacity);
    }

    @DisplayName("Test prepend Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    @Test
    void testPrependOperation() {
        final int expectedValue = 5;
        final int expectedSize = 1;
        final int expectedCapacity = 1;

        testVector.prepend(expectedValue);
        assertEquals(testVector.size(), expectedSize, "Expected size should be equal to " + expectedSize);
        assertEquals((Object) testVector.pop(), expectedValue, "Value at index zero should be equal to" + expectedValue);
        assertEquals(testVector.capacity(), expectedCapacity, "Expected capacity should be equal to " + expectedCapacity);
    }

    @DisplayName("Test Delete Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    @Test
    void testDeleteOperation() {
        final int expectedValue = 5;
        final int expectedSize = 0;
        final int expectedCapacity = 1;
        final int targetDeleteIndex = 0;

        testVector.prepend(expectedValue);
        testVector.delete(targetDeleteIndex);
        assertEquals(testVector.size(), expectedSize, "Expected size should be equal to " + expectedSize);
        assertEquals(testVector.capacity(), expectedCapacity, "Expected capacity should be equal to " + expectedCapacity);
    }

    @DisplayName("Test Remove Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    @Test
    void testRemoveOperation() {
        final int expectedValue = 5;
        final int expectedSize = 0;
        final int expectedCapacity = 1;

        testVector.push(expectedValue);
        testVector.remove(expectedValue);
        assertEquals(testVector.size(), expectedSize, "Expected size should be equal to " + expectedSize);
        assertEquals(testVector.capacity(), expectedCapacity, "Expected capacity should be equal to " + expectedCapacity);
    }

    @DisplayName("Test Find Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    @Test
    void testFindOperation() {
        final int expectedValue = 5;
        final int expectedSize = 1;
        final int expectedCapacity = 2;
        final int expectedIndex = 0;

        testVector.push(expectedValue);
        assertEquals(testVector.find(expectedValue), expectedIndex, "Expected index should be equal to " + expectedIndex);
        assertEquals(testVector.size(), expectedSize, "Expected size should be equal to " + expectedSize);
        assertEquals(testVector.capacity(), expectedCapacity, "Expected capacity should be equal to " + expectedCapacity);
    }

    @DisplayName("Test Resize Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    @Test
    void testResizeOperation() {

        final int numberOfRepetitiveResizes = 20;

        for (int j = 1; j <= numberOfRepetitiveResizes; j++) {
            final int expectedCapacity = (int) Math.pow(2, j + 1);
            final int expectedSize = expectedCapacity - 1 == 3 ? expectedCapacity - 1 : (expectedCapacity - 1) - testVector.size();

            for (int i = 0; i < expectedSize; i++) {
                testVector.push(i);
            }

            System.out.println(String.format("Iteration = %d, Number of items in Vector = %d, Current Capacity %d", j,
                    expectedCapacity - 1, expectedCapacity));

            assertEquals(expectedCapacity - 1, testVector.size(), "Expected size should be equal to " + expectedSize);
            assertEquals(expectedCapacity, testVector.capacity(), "Expected capacity should be equal to " + expectedCapacity);
        }
        System.out.println();
    }

    @DisplayName("Test Shrink Operation")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    @Test
    void testShrinkOperation() {

        final int numberOfRepetitiveResizes = 20;

        for (int j = 1; j <= numberOfRepetitiveResizes; j++) {
            final int expectedCapacity = (int) Math.pow(2, j + 1);
            final int expectedGrowSize = expectedCapacity - 1 == 3 ? expectedCapacity - 1 : (expectedCapacity - 1) - testVector.size();
            final int expectedShrinkSize = (expectedCapacity - 1) - (expectedCapacity / 4);
            final int expectedShrinkVectorSize = expectedCapacity - expectedShrinkSize - 1;
            final int expectedCapacityAfterShrink = expectedCapacity / 2;

            // grow vector
            for (int i = 0; i < expectedGrowSize; i++) {
                testVector.push(i);
            }

            // shrink the vector
            for (int i = 0; i < expectedShrinkSize; i++) {
                testVector.pop();
            }

            System.out.println(String.format("Iteration = %d, Expected Shrink Size = %d, Expected Vector Size %d, Expected vector capacity %d", j,
                    expectedShrinkSize, expectedShrinkVectorSize, expectedCapacityAfterShrink, expectedCapacityAfterShrink));
            System.out.println(String.format("Iteration = %d, Number of items in Vector = %d, Current Capacity %d\n", j,
                    expectedCapacity - 1, expectedCapacity));

            assertEquals(expectedShrinkVectorSize, testVector.size(), "Expected size should be equal to " + expectedCapacity / 4);
            assertEquals(expectedCapacityAfterShrink, testVector.capacity(), "Expected capacity should be equal to " + expectedCapacityAfterShrink);
        }
        System.out.println();
    }

    @AfterEach
    void tearDown() {
        testVector = null;
    }
}
