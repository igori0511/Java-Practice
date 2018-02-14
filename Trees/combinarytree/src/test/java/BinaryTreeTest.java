import exception.TreeEmptyException;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BinaryTreeTest {

    @Rule
    private final int NUMBER_OF_TEST_REPETITIONS = 1;
    private BinaryTree binaryTree;

    @BeforeEach
    void init() {
        binaryTree = new BinaryTree();
    }

    @Test
    @DisplayName("Test find with empty tree")
    void testFindWithEmptyTree() {
        final Integer expectedFinalResult = 5;
        Executable closureContainingCodeToTest = () -> binaryTree.find(expectedFinalResult);
        Assertions.assertThrows(TreeEmptyException.class, closureContainingCodeToTest);
    }

    @Test
    @DisplayName("Test the insert method with one value")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testTreeInsert() {
        final Integer valueToBeInserted = 5;
        final Integer expectedFinalResult = 5;
        final Integer expectedNodeCount = 1;

        binaryTree.insert(valueToBeInserted);
        Integer valueFromTree = binaryTree.find(expectedFinalResult);

        assertEquals("Inserted value doesn't match the expected value", expectedFinalResult, valueFromTree);
        assertEquals("Binary tree doesn't have expected node count", expectedNodeCount, binaryTree.getNodeCount());
    }

    @Test
    @DisplayName("Tree Find method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testFindMethod() {

        final Integer expectedFinalResult = 5;
        final Integer expectedNodeCount = 10;

        final int numberOfItemsToInsert = 10;

        for (int i = 0; i < numberOfItemsToInsert; i++) {
            binaryTree.insert(i);
        }

        assertEquals("Inserted value doesn't match the expected value", expectedFinalResult, binaryTree.find(expectedFinalResult));
        assertEquals("Binary tree doesn't have expected node count", expectedNodeCount, binaryTree.getNodeCount());
    }

    @Test
    @DisplayName("Tree Find method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testFindOnRandomInserts() {
        commonRandomInit();
    }


    @Test
    @DisplayName("print method")
    void testPrintMethod() {
        commonRandomInit();
        binaryTree.printValues();
    }

    @Test
    @DisplayName("delete Tree method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testDeleteTree() {
        final Integer expectedFinalResult = 3;
        commonRandomInit();
        binaryTree.deleteTree();
        Executable closureContainingCodeToTest = () -> binaryTree.find(expectedFinalResult);
        Assertions.assertThrows(TreeEmptyException.class, closureContainingCodeToTest);
    }

    @Test
    @DisplayName("isInTree Tree method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testIsInTree() {
        final Integer expectedFinalResult = 3;
        commonRandomInit();
        assertEquals("Inserted value doesn't match the expected value", true, binaryTree.isInTree(expectedFinalResult));
    }

    @Test
    @DisplayName("getHeight Tree method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testGetHeight() {
        final Integer expectedHeight = 4;
        commonRandomInit();
        assertEquals("Inserted value doesn't match the expected value", expectedHeight, binaryTree.getHeight());
    }

    @Test
    @DisplayName("getMin Tree method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testGetMin() {
        final Integer expectedMin = 1;
        commonRandomInit();
        assertEquals("Inserted value doesn't match the expected value", expectedMin, binaryTree.getMin());
    }

    @Test
    @DisplayName("getMax Tree method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testGetMax() {
        final Integer expectedMax = 6;
        commonRandomInit();
        assertEquals("Inserted value doesn't match the expected value", expectedMax, binaryTree.getMax());
    }

    @Test
    @DisplayName("isBinaryTree Tree method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testIsBinaryTree() {
        commonRandomInit();
        assertEquals("Inserted value doesn't match the expected value", true, binaryTree.isBinarySearchTree());
    }

    @Test
    @DisplayName("deleteValue Tree method")
    @RepeatedTest(NUMBER_OF_TEST_REPETITIONS)
    void testDeleteValue() {
        final Integer expectedFinalResult = 6;
        commonRandomInit();
        binaryTree.deleteValue(6);
        assertNotEquals("Inserted value match the expected value", expectedFinalResult, binaryTree.find(expectedFinalResult));
    }

    private void commonRandomInit() {
        final Integer expectedFinalResult = 3;
        final Integer expectedNodeCount = 5;

        binaryTree.insert(5);
        binaryTree.insert(1);
        binaryTree.insert(6);
        binaryTree.insert(4);
        binaryTree.insert(3);

        assertEquals("Inserted value doesn't match the expected value", expectedFinalResult, binaryTree.find(expectedFinalResult));
        assertEquals("Binary tree doesn't have expected node count", expectedNodeCount, binaryTree.getNodeCount());
    }
}
